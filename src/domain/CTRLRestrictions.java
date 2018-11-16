
package domain;


public class CTRLRestrictions {
    
    /** Attributes **/
    /*public Classroom classroom;
    public Timetable classTimetable;
    public Timetable groupTimetable;
    public GroupSubject GSNew;
    public int hours;
    public StudyProgram SP;*/
    private final static int NUM_RESTR_EXTRA = 4;
    private final static int NUM_RESTR_BASE = 3;
    public boolean rBase[];
    private boolean rExtra[];
    
    
    /** Constructor **/
    public CTRLRestrictions(/*Classroom classroom, Timetable classTimetable, Timetable groupTimetable, GroupSubject GSNew, int hours, StudyProgram SP*/) {
        /*this.classroom = classroom;
        this.classTimetable = classTimetable;
        this.groupTimetable = groupTimetable;
        this.GSNew = GSNew;
        this.hours = hours;
        this.SP = SP;*/
        rBase = new boolean[NUM_RESTR_BASE];
        rExtra = new boolean[NUM_RESTR_EXTRA];
        for (int i = 0; i < NUM_RESTR_BASE; i++) rBase[i] = true;
        for (int i = 0; i < NUM_RESTR_EXTRA; i++) rExtra[i] = false;
    }
    
    
    /*
    public boolean base(int day, int hour) {
        //aula no disponible
        if(classTimetable.getGroupSubject(day, hour).isBanned() && rBase[0]) return false;
        //se solapan dos assignaturas del mismo nivel
        else if (sameLevel(day, hour)) return false;
        else if (classTimetable.);
        return true;
    }*/
    public void enableRestriction(int i) {
        rExtra[i] = true;
    }
    public void disableRestriction(int i) {
        rExtra[i] = false;
    }
    
    public boolean classroomRestrictions(int day, int hour, Classroom classroom, GroupSubject GSNew){
        //System.out.println("Ha entrado en la funcion classroomRestrictions");
        if(classroom.getTimetable().getRestrictions()[day][hour].isFree()){
            //El aula no esta disponible en dicho lapso de tiempo
            if (!hourOk(classroom.getTimetable(), day, hour) && rBase[0]) return false;
            //El aula tiene horas bloqueadas en dicho lapso
            else if (isBanned(day, hour, classroom.getTimetable()) && rExtra[0]) return false;
            //El aula tiene bloqueado al grupo en dicha franja horaria
            else if (groupBanned(day, hour, classroom.getTimetable(), GSNew.getNumGroup()) && rExtra[2]) return false;
            //La materia esta bloqueada en dicha franja horaria
            else if (subjectBanned(day, hour, classroom.getTimetable(), GSNew.getNameSubject()) && rExtra[1]) return false;
            
            //El aula es demasiado pequeña
            else if (classroomTooSmall(classroom, GSNew) && rBase[1]) return false;
            //El tipus de aula no es la mateixa amb el de GroupSubject
            else if (!((GSNew.labGroup() && classroom.isForLab() || GSNew.problemsGroup() && classroom.isForProblems() || GSNew.theoryGroup() && classroom.isForTheory()) && rBase[2])) return false;
            System.out.println("Ha acabado las classroomRestrictions");
            return true;
        }
        System.out.println("Ha acabado las classroomRestrictions");
        return false;
    }
    
    /*public boolean subjectRestrictions(int day, int hIni, int hEnd, Timetable groupTimetable, GroupSubject GSNew) {
        //La materia esta bloqueada en dicha franja horaria
        if (subjectBanned(day, hIni, hEnd, groupTimetable, GSNew.getSubject().getName()) && rExtra[1]) return false;
        //Hay solapamiento de dos asignaturas de un mismo nivel
        if (sameLevel(day, hIni, hEnd, groupTimetable, GSNew) && rBase[1]) return false;
        return true;
    }*/
    
    public boolean groupRestrictions(int day, int hour, Classroom classroom, GroupSubject GSNew) {
         if(classroom.getTimetable().getRestrictions()[day][hour].isFree()){
            //El grupo no puede tener clase en dicho lapso de tiempo
            if (!hourOk(GSNew, day, hour) && rBase[0]) return false;
            //El grupo tiene horas bloqueadas en dicho lapso
            else if (isBanned(day, hour, GSNew) && rExtra[0]) return false;
            //El grupo no puede ir a esa clase en dicha franja horaria
            else if (classroomBanned(day, hour, GSNew, classroom.getRef()) && rExtra[3]) return false;
            //La materia esta bloqueada en dicha franja horaria
            else if (subjectBanned(day, hour, GSNew, GSNew.getNameSubject()) && rExtra[1]) return false;
            //Hay solapamiento de dos asignaturas de un mismo nivel
            else if (sameLevel(day, hour, GSNew) && rBase[1]) return false;
            //Hay clase de Lab antes que la de teoria
            else if (LabBeforeTheory(day, hour, GSNew) && rExtra[1]) return false;
            return true;
        }
        return false;
    }
    
    private boolean classroomTooSmall(Classroom classroom, GroupSubject GSNew) {
        //System.out.println("Ha entrado en classroomTooSmall");
        return classroom.getCapacity() < GSNew.getnMat();
    }
    
    private boolean sameLevel(int day, int hour, GroupSubject GSNew){
        /*return (classTimetable.getGroupSubject(day, hour).getnMat() > 0 && 
                classTimetable.getGroupSubject(day, hour).getSubject().getLevel() == 
                GSNew.getSubject().getLevel());*/
        /*subGroup sub = GSNew.getsubGroup();
        Group act = GSNew.getGroup();*/
        if (GSNew.isSubGroup()) return GSNew.getSubGroup().getSubject(day, hour) != null;
        else return GSNew.getGroup().getSubject(day, hour) != null;
        //return sub.getSubject(day, hour) != null || act.getSubject(day, hour) != null;
    }
    
    
    //hay case de laboratorio antes que de teoria
    private boolean LabBeforeTheory(int day, int hour, GroupSubject GSNew) {
        if (GSNew.labGroup()){
            subGroup sub = GSNew.getsubGroup();
            Group act = GSNew.getGroup();
            int h = sub.gethEnd() - sub.gethIni();
            for (int i = 0; i < day; i++) {
                if (i < day) {
                    for (int j = 0; j < h; j++) {
                        if(act.getSubject(i, j) == GSNew.getSubject()) return true;
                    }
                }
                else {
                    for (int j = 0; j < hour; j++) {
                        if(act.getSubject(i, j) == GSNew.getSubject()) return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }
    private boolean hourOk(Timetable TB, int day, int hour) {
        //System.out.println("Ha entrado en hour ok");
        return (0 <= day && day < TB.getnDays()) && (hour >= TB.gethIni() && hour < TB.gethEnd());
    }
    
    private boolean hourOk(GroupSubject GSNew, int day, int hour) {
        return (0 <= day && day < GSNew.getGroup().getnDays()) && (hour >= GSNew.getGroup().gethIni() && hour < GSNew.getGroup().gethEnd());
    }
    
    private boolean isBanned(int day, int hour, Timetable TB) {
        //System.out.println("Ha entrado en isbanned");
        
        return TB.isBanned(day, hour);
    }
    
    private boolean isBanned(int day, int hour, GroupSubject GSNew) {
        if (GSNew.issubGroup()) return GSNew.SubGroupBanned(day, hour);
        else return GSNew.GroupBanned(day, hour);
    }
    
    private boolean subjectBanned(int day, int hour, Timetable TB, String name) {
        return TB.subjectBanned(day, hour, name);
    }
    
    private boolean subjectBanned(int day, int hour, GroupSubject GSNew, String name) {
        //System.out.println("Ha entrado en subjectBanned");
        if (GSNew.issubGroup()) return GSNew.SubGroupSubjectBanned(day, hour, name);
        else return GSNew.GroupSubjectBanned(day, hour, name);
    }
    
    private boolean groupBanned(int day, int hour, Timetable TB, int num) {
        //System.out.println("Ha entrado en groupBanned");
        return TB.groupBanned(day, hour, num);
    }
    
    private boolean classroomBanned(int day, int hour, GroupSubject GSNew, String ref) {
        
        if (GSNew.issubGroup()) return GSNew.SubGroupClassroomBanned(day, hour, ref);
        else return GSNew.GroupClassroomBanned(day, hour, ref);
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
}
