
package domain;

import java.util.Iterator;


public class CTRLRestrictions {
    private final static int NUM_RESTR_EXTRA = 5;
    private final static int NUM_RESTR_BASE = 4;
    private boolean rBase[];
    private boolean rExtra[];
    private TimetableGenerator TG;
    
   
    public CTRLRestrictions(TimetableGenerator TG) {
        rBase = new boolean[NUM_RESTR_BASE];
        rExtra = new boolean[NUM_RESTR_EXTRA];
        for (int i = 0; i < NUM_RESTR_BASE; i++) rBase[i] = true;
        for (int i = 0; i < NUM_RESTR_EXTRA; i++) rExtra[i] = false;
        this.TG = TG;
    }
    
    public void enableRestriction(int i) {
        rExtra[i] = true;
    }
    public void disableRestriction(int i) {
        rExtra[i] = false;
    }
    
    public boolean classroomRestrictions(int day, int hour, Classroom classroom, GroupSubject GSNew){
        if(classroom.getTimetable().isEmpty(day,hour)){           
            //El aula tiene horas bloqueadas en dicho lapso
            if (isBanned(day, hour, classroom.getTimetable()) && rExtra[0]) return false;
            //El aula tiene bloqueado al grupo en dicha franja horaria
            else if (groupBanned(day, hour, classroom.getTimetable(), GSNew.getNumGroup()) && rExtra[2]) return false;
            //La materia esta bloqueada en dicha franja horaria
            else if (subjectBanned(day, hour, classroom.getTimetable(), GSNew.getNameSubject()) && rExtra[1]) return false;
            //El aula es demasiado pequeña
            else if (classroomTooSmall(classroom, GSNew) && rBase[1]) return false;
            //El tipus de aula no es la mateixa amb el de GroupSubject
            else if (notSameType(classroom, GSNew) && rBase[2]) return false;
            else if (outOfRange(day, hour, classroom, GSNew) && rBase[3]) return false;
            return true;
        }
        return false;
    }
    
    public boolean groupRestrictions(int day, int hour, Classroom classroom, GroupSubject GSNew) {
        if(GSNew.isGroupEmpty(day,hour)){         
            //El grupo tiene horas bloqueadas en dicho lapso
            if (isBanned(day, hour, GSNew) && rExtra[0]) return false;
            //El grupo no puede ir a esa clase en dicha franja horaria
            else if (classroomBanned(day, hour, GSNew, classroom.getRef()) && rExtra[3]) return false;
            //La materia esta bloqueada en dicha franja horaria
            else if (subjectBanned(day, hour, GSNew, GSNew.getNameSubject()) && rExtra[1]) return false;
            //Hay solapamiento de dos asignaturas de un mismo nivel
            else if (sameLevel(day, hour, GSNew) && rBase[1]) return false;
            //Hay clase de Lab antes que la de teoria
            else if (LabBeforeTheory(day, hour, GSNew) && rExtra[4]) return false;
            else if (outOfRange(day, hour, classroom, GSNew) && rBase[3]) return false;
            return true;
        }
        return false;
    }
    
    private boolean outOfRange(int day, int hour, Classroom classroom, GroupSubject GSNew) {
        if (classroom.isOut(day, hour)) return true;
        if (GSNew.getGroup().isOut(day, hour)) return true;
        return false;
    }
    
    
    private boolean classroomTooSmall(Classroom classroom, GroupSubject GSNew) {
        /*if (GSNew.isSubGroup()) return classroom.getCapacity() < GSNew.getSubGroup().getnMat();
        return classroom.getCapacity() < GSNew.getnMat();*/
        return classroom.getCapacity() < GSNew.getEnrolled();
    }
    
    private boolean sameLevel(int day, int hour, GroupSubject GSNew){
        /*return (classTimetable.getGroupSubject(day, hour).getnMat() > 0 && 
                classTimetable.getGroupSubject(day, hour).getSubject().getLevel() == 
                GSNew.getSubject().getLevel());*/
        /*subGroup sub = GSNew.getsubGroup();
        Group act = GSNew.getGroup();*/
        //System.out.println("asdfasdfasdf");
        
        /*
        int size = TG.getClassrooms().size();
        for (int i = 0; i < size; i++) {
            Classroom Cact = TG.getClassrooms().get(i);
            ClassroomTimetable Tact = Cact.getTimetable();
            if(!Tact.isEmpty(day, hour)) {
                if(Tact.getGroupSubject(day, hour).getSubject().getSP().equals(GSNew.getSubject().getSP())) {
                    if(Tact.getGroupSubject(day, hour).getSubject().getLevel() == GSNew.getSubject().getLevel()) {
                        if (GSNew.isSubGroup()) {
                            subGroup SG = (subGroup)GSNew.getGroup();
                            int num = SG.getSuperNum();
                            int subNum = SG.getNum();
                            if(Tact.getGroupSubject(day, hour).getGroup().isSubGroup()) {
                                subGroup TSG = (subGroup)Tact.getGroupSubject(day,hour).getGroup();
                                int TsubNum = TSG.getNum();
                                if (TsubNum == subNum) return true;
                            }
                            else {
                                if(Tact.getGroupSubject(day, hour).getNumGroup() == num) return true;
                            }
                        }
                        else {
                            if (Tact.getGroupSubject(day, hour).getNumGroup() >= GSNew.getNumGroup() && Tact.getGroupSubject(day, hour).getNumGroup() < GSNew.getNumGroup() + 10) return true;
                        }
                    }
                }
            }
        }*/
        
        if (GSNew.isSubGroup()) return !GSNew.isGroupEmpty(day,hour);
        else {
            Iterator<subGroup> SGit = GSNew.getSubGroups().iterator();
            while(SGit.hasNext()) {
                if(!SGit.next().isEmpty(day, hour)) return true;
            }
            return false;
        }
        
        //return sub.getSubject(day, hour) != null || act.getSubject(day, hour) != null;
        //return false;
    }
    
    
    //hay case de laboratorio antes que de teoria
    private boolean LabBeforeTheory(int day, int hour, GroupSubject GSNew) {
        if (GSNew.isLaboratory()){
            subGroup sub = (subGroup)GSNew.getGroup();
            for (int i = day; i <= sub.getdEnd(); i++) {
                if (i != day) {
                    for (int j = 0; j < sub.gethEnd(); j++) {
                        if(!sub.isSuperEmpty(i, j)) return true;
                    }
                }
                else {
                    for (int j = hour; j < sub.gethEnd(); j++) {
                        if(!sub.isSuperEmpty(i, j)) return true;
                    }
                }
            }
        }
        return false;
    }
    
    /*private boolean hourOk(ClassroomTimetable TB, int day, int hour) {
        return (0 <= day && day < TB.getnDays()) && (hour >= 0 && hour < TB.gethEnd()- TB.gethIni());
    }
    
    private boolean hourOk(GroupSubject GSNew, int day, int hour) {
        //System.out.println("HOUROK day: " + day + " nDays " + GSNew.getGroup().getnDays() + " hEnd " + GSNew.getGroup().gethEnd() + " hIni " + GSNew.getGroup().gethIni());
        return (0 <= day && day < GSNew.getGroup().getnDays()) && (hour >= 0 && hour < GSNew.getGroup().gethEnd() - GSNew.getGroup().gethIni());
    }*/
    
    private boolean isBanned(int day, int hour, ClassroomTimetable TB) {        
        return TB.isBanned(day, hour);
    }
    
    private boolean isBanned(int day, int hour, GroupSubject GSNew) {
        /*if (GSNew.issubGroup()) return GSNew.SubGroupBanned(day, hour);
        else return GSNew.GroupBanned(day, hour);*/
        return GSNew.isBanned(day, hour);
    }
    
    private boolean subjectBanned(int day, int hour, ClassroomTimetable TB, String name) {
        return TB.isSubjectBanned(day, hour, name);
    }
    
    private boolean subjectBanned(int day, int hour, GroupSubject GSNew, String name) {
        //System.out.println("Ha entrado en subjectBanned");
        /*if (GSNew.issubGroup()) return GSNew.SubGroupSubjectBanned(day, hour, name);
        else return GSNew.GroupSubjectBanned(day, hour, name);*/
        return GSNew.isSubjectBanned(day, hour, name);
    }
    
    private boolean groupBanned(int day, int hour, ClassroomTimetable TB, int num) {
        //System.out.println("Ha entrado en groupBanned");
        return TB.isGroupBanned(day, hour, num);
    }
    
    private boolean classroomBanned(int day, int hour, GroupSubject GSNew, String ref) {
        
        /*if (GSNew.issubGroup()) return GSNew.SubGroupClassroomBanned(day, hour, ref);
        else return GSNew.GroupClassroomBanned(day, hour, ref);*/
        return GSNew.isClassroomBanned(day, hour, ref);
    }
    
    private boolean notSameType(Classroom classroom, GroupSubject GSNew) {
        return !(GSNew.isLaboratory() && classroom.isLaboratory() || GSNew.isProblems() && classroom.isProblems() || GSNew.isTheory() && classroom.isTheory());
    }
    
    public void setrBase(boolean[] rBase) {
        this.rBase = rBase;
    }
    
    public void setrExtra(boolean[] rExtra) {
        this.rExtra = rExtra;
    }
    
    public void modify_base_rest(int i, boolean state) {
        rBase[i] = state;
    }
    
    public void add_rest_extra(int i) {
        rExtra[i] = true;
    }   
    
    public void remove_rest_extra(int i) {
        rExtra[i] = false;
    }
    
    public String saveRestrictions() {
        return rBase[0] + " " + rBase[1] + " " + rBase[2] + " " + rBase[3] + " " + rExtra[0] + " " + rExtra[1] + " " + rExtra[2] + " " + rExtra[3] + " " + rExtra[4];
    }
}
