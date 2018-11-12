
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
        if (!hourOk(classroom.getTimetable(), day, hIni, hEnd) && rBase[0]) return false;
        //El aula tiene horas bloqueadas en dicho lapso
        else if (isBanned(day, hIni, hEnd, classroom.getTimetable()) && rExtra[0]) return false;
        //El aula tiene bloqueado al grupo en dicha franja horaria
        else if (groupBanned(day, hIni, hEnd, classroom.getTimetable(), GSNew.getGroup().getNum()) && rExtra[2]) return false;
        //El aula es demasiado pequeña
        else if (classroomTooSmall(classroom, GSNew) && rBase[1]) return false;
        return true;
    }
    
    public boolean subjectRestrictions(int day, int hIni, int hEnd, Timetable groupTimetable, GroupSubject GSNew) {
        //La materia esta bloqueada en dicha franja horaria
        if (subjectBanned(day, hIni, hEnd, groupTimetable, GSNew.getSubject().getName()) && rExtra[1]) return false;
        //Hay solapamiento de dos asignaturas de un mismo nivel
        if (sameLevel(day, hIni, hEnd, groupTimetable, GSNew) && rBase[1]) return false;
        return true;
    }
    
    public boolean groupRestrictions(int day, int hIni, int hEnd, Classroom classroom, Timetable groupTimetable, GroupSubject GSNew) {
        //El grupo no puede tener clase en dicho lapso de tiempo
        if (!hourOk(groupTimetable, day, hIni, hEnd) && rBase[0]) return false;
        //El grupo tiene horas bloqueadas en dicho lapso
        else if (isBanned(day, hIni, hEnd, groupTimetable) && rExtra[0]) return false;
        //El grupo no puede ir a esa clase en dicha franja horaria
        else if (classroomBanned(day, hIni, hEnd, groupTimetable, classroom.getRef()) && rExtra[3]) return false;
        //Hay clase de Lab antes que la de teoria
        else if (LabBeforeTheory(day, hIni, groupTimetable, GSNew) && rExtra[1]) return false;
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
    private boolean LabBeforeTheory(int day, int hour, Timetable groupTimetable, GroupSubject GSNew) {
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
    
    private boolean isBanned(int day, int hIni, int hEnd, Timetable TB) {
        return TB.isBanned(day, hIni, hEnd);
    }
    
    private boolean subjectBanned(int day, int hIni, int hEnd, Timetable TB, String name) {
        return TB.subjectBanned(day, hIni, hEnd, name);
    }
    
    private boolean groupBanned(int day, int hIni, int hEnd, Timetable TB, int num) {
        return TB.groupBanned(day, hIni, hEnd, num);
    }
    
    private boolean classroomBanned(int day, int hIni, int hEnd, Timetable TB, String ref) {
        return TB.classroomBanned(day, hIni, hEnd, ref);
    }
    
    public void add_rest_extra(int i) {
        rExtra[i] = true;
    }   
    
    public void remove_rest_extra(int i) {
        rExtra[i] = false;
    }
}
