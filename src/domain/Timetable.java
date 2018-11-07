
package domain;

public class Timetable {
    
    /** Atributtes **/
    private TimeLapse[][] timetable;
    private final int nDays;
    private final int nHours;
    
    /** Constructor **/
    public Timetable(int nDays, int nHours){
        timetable = new TimeLapse[nDays][nHours];
        this.nDays = nDays;
        this.nHours = nHours;
    }

    public TimeLapse[][] getTimetable() {
        return timetable;
    }

    public int getnDays() {
        return nDays;
    }

    public int getnHours() {
        return nHours;
    }
    
    public void fill(int day, int hIni, int hEnd, TimeLapse lapse){

        for (int i = hIni; i < hEnd; i++) timetable[day][i] = lapse;
    }
    
    public void timeBanned(){}
    
}
