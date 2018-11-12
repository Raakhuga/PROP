
package domain;


public class CTRLRestrictions {
    
    /** Attributes **/
    /*public Classroom classroom;
    public Timetable classTimetable;
    public Timetable groupTimetable;
    public GroupSubject GSNew;
    public int hours;
    public StudyProgram SP;*/
    public boolean[] rBase;
    private boolean[] rExtra;
    private final static int NUM_RESTR_EXTRA = 7;
    private final static int NUM_RESTR_BASE = 7;
    
    
    /** Constructor **/
    public CTRLRestrictions(/*Classroom classroom, Timetable classTimetable, Timetable groupTimetable, GroupSubject GSNew, int hours, StudyProgram SP*/) {
        /*this.classroom = classroom;
        this.classTimetable = classTimetable;
        this.groupTimetable = groupTimetable;
        this.GSNew = GSNew;
        this.hours = hours;
        this.SP = SP;*/
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
    
    public boolean classroomRestrictions(int day, int hIni, int hEnd, Classroom classroom, GroupSubject GSNew){
        //El aula no esta disponible en dicho lapso de tiempo
        if (!hourOk(classroom.getTimetable(), day, hIni, hEnd)) return false;
        //El aula es demasiado pequeña
        else if (classroomTooSmall(classroom, GSNew) && rExtra[0]) return false;
        return true;
    }
    
    public boolean subjectRestrictions(int day, int hIni, int hEnd, Timetable groupTimetable, GroupSubject GSNew) {
        if (sameLevel(day, hIni, hEnd, groupTimetable, GSNew) && rExtra[1]) return false;
        return true;
    }
    
    public boolean groupRestrictions(int day, int hIni, int hEnd, Timetable groupTimetable, GroupSubject GSNew) {
        if (!hourOk(groupTimetable, day, hIni, hEnd)) return false;
        else if (LabAfterTheory(day, hIni, groupTimetable, GSNew) && rExtra[2]) return false;
        return true;
    }
    
    private boolean classroomTooSmall(Classroom classroom, GroupSubject GSNew) {
        return classroom.getCapacity() < GSNew.getnMat();
    }
    
    private boolean sameLevel(int day, int hIni, int hEnd, Timetable groupTimetable, GroupSubject GSNew){
        /*return (classTimetable.getGroupSubject(day, hour).getnMat() > 0 && 
                classTimetable.getGroupSubject(day, hour).getSubject().getLevel() == 
                GSNew.getSubject().getLevel());*/
        boolean sLevel = false;
        for (int i = hIni; i < hEnd; i++) 
            sLevel = groupTimetable.getGroupSubject(day, i).getSubject().getLevel() == GSNew.getSubject().getLevel();
        return sLevel;
    }
    
    
    //hay case de laboratorio antes que de teoria
    private boolean LabAfterTheory(int day, int hour, Timetable groupTimetable, GroupSubject GSNew) {
        if (GSNew.getLab()){
            int h = groupTimetable.gethEnd() - groupTimetable.gethIni();
            for (int i = 0; i < day; i++) {
                if (i < day) {
                    for (int j = 0; j < h; j++) {
                        GroupSubject act = groupTimetable.getGroupSubject(i, j);
                        if(act.getSubject() == GSNew.getSubject() && act.getTheory()) return true;
                    }
                }
                else {
                    for (int j = 0; j < hour; j++) {
                        GroupSubject act = groupTimetable.getGroupSubject(i, j);
                        if(act.getSubject() == GSNew.getSubject() && act.getTheory()) return true;
                    }
                    return false;
                }
            }
        }
    }
    
    private void banDay(int day, Timetable classTimetable) {
        classTimetable.timeBanned(day, classTimetable.gethIni(), classTimetable.gethEnd());
    }
    private void banHours (int hIni, int hEnd, Timetable classTimetable) {
        for(int i = 0; i < classTimetable.getnDays(); ++i) classTimetable.timeBanned(i, hIni, hEnd);
    }
    
    private boolean hourOk(Timetable TB, int day, int hIni, int hEnd) {
        return (0 <= day && day > TB.getnDays()) && (hIni < hEnd && hIni >= TB.gethIni() && hEnd <= TB.gethEnd());
    }
    
    public add(){}
            
    public modify() {}
            
    public delete() {}
}
