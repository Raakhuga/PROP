
package domain;


public class Restrictions {
    
    /** Attributes **/
    public Classroom[] classrooms;
    public Timetable classTimetable;
    public Timetable groupTimetable;
    public GroupSubject GSNew;
    public StudyProgram SP;
    public boolean[] rBase;
    
    
    /** Constructor **/
    public Restrictions(Classroom[] classes, Timetable classTimetable, Timetable groupTimetable, GroupSubject GSNew) {
        this.classrooms = classrooms;
        this.classTimetable = classTimetable;
        this.groupTimetable = groupTimetable;
        this.GSNew = GSNew;
        for (int i = 0; i < 4; i++) rBase[i] = true;
    }
    
    public boolean base(int day, int hour) {
        //aula no disponible
        if(classTimetable.getGroupSubject(day, hour).isBanned() && rBase[0]) return false;
        //se solapan dos assignaturas del mismo nivel
        else if (sameLevel(day, hour)) return false;
        else if (classTimetable.);
        return true;
    }
    
    private boolean sameLevel(int day, int hour){
        /*return (classTimetable.getGroupSubject(day, hour).getnMat() > 0 && 
                classTimetable.getGroupSubject(day, hour).getSubject().getLevel() == 
                GSNew.getSubject().getLevel());*/
        boolean overlap = false;
        if (GSNew.getTeoria()) {
            return groupTimetable.getGroupSubject(day, hour).getSubject().getLevel() == GSNew.getSubject().getLevel();
        }
        else {
            for(int i = 0; i< classrooms.length; i++) {
                GroupSubject GSact = classrooms[i].getTimetable().getGroupSubject(day, hour);
            }
        }
    }
    
    
    //hay case de laboratorio antes que de teoria
    private boolean LabAfterTheroy() {
        if (GSNew.getLab()){
            boolean teoria = false;
            int days = groupTimetable.getnDays();
            int hours = groupTimetable.gethEnd() - groupTimetable.gethIni();
            for (int i = 0; i < days; i++) {
                for (int j = 0; j < hours; j++) 
                    if(groupTimetable.getGroupSubject(i, j).getSubject() == GSNew.getSubject()) 
                        teoria = groupTimetable.getGroupSubject(i,j).getTeoria();
            }
            if (!teoria ) return false;
        }
        return true;
    }
    
    private void banDay(int dia) {
        if (classTimetable.getRestrictions(4)){
            classTimetable.timeBanned(dia, groupTimetable.gethIni(), groupTimetable.gethEnd());
        }
    }
    private void ban
    
    public add(){}
            
    public modify() {}
            
    public delete() {}
}
