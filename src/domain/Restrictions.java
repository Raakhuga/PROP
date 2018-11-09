
package domain;


public class Restrictions {
    
    /** Attributes **/
    public Timetable actual;
    public Timetable tNew;
    public StudyProgram SP;
    public boolean[] rBase;
    
    
    /** Constructor **/
    public Restrictions(Timetable actual, Timetable tNew) {
        this.actual = actual;
        this.tNew = tNew;
        for (int i = 0; i < 4; i++) rBase[i] = true;
    }
    
    public boolean base(int day, int hour) {
        //aula no disponible
        if(actual.getGroupSubject(day, hour).isBanned() && rBase[0]) return false;
        //no hay teoria antes de lab
        else if (tNew.getGroupSubject(day, hour).getLab() && rBase[1]){
            boolean teoria = false;
            int days = actual.getnDays();
            int hours = actual.gethEnd() - actual.gethIni();
            for (int i = 0; i < day; i++) {
                for (int j = 0; j < hours; j++) 
                    teoria = actual.getGroupSubject(i,j).getTeoria();
            }
            if (!teoria ) return false;
        }
        //se solapan dos assignaturas del mismo nivel
        else if (sameLevel(day, hour)) return false;
        else if (actual.);
        return true;
    }
    
    private boolean sameLevel(int day, int hour){
        return (actual.getGroupSubject(day, hour).getnMat() > 0 && 
                actual.getGroupSubject(day, hour).getSubject().getLevel() == 
                tNew.getGroupSubject(day, hour).getSubject().getLevel());
    }
    
    public add(){}
            
    public modify() {}
            
    public delete() {}
}
