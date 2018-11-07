
package domain;

public class Timetable {
    
    /** Atributtes **/
    private TimeLapse[][] timetable;
    private final int nDays;
    //private final int nHours;
    private final int hIni;
    private final int hEnd;
    
    /** Constructor **/
    public Timetable(int nDays, int hIni, int hEnd){
        timetable = new TimeLapse[nDays][hEnd-hIni];
        this.nDays = nDays;
        this.hIni = hIni;
        this.hEnd = hEnd;
        //this.nHours = nHours;
    }

    public TimeLapse[][] getTimetable() {
        return timetable;
    }

    public int getnDays() {
        return nDays;
    }

    /*public int getnHours() {
        return nHours;
    }*/
    
    public int gethIni() {
        return hIni;
    }
    
    public int gethEnd() {
        return hEnd;
    }
    
    public void fill(int day, int hIni, int hEnd, TimeLapse lapse) {
        for (int i = hIni; i < hEnd; i++) timetable[day][i] = lapse;
    }
    
    public void timeBanned(int day, int hIni, int hEnd) {
        TimeLapse banned = new TimeLapse();
        for (int i = hIni; i < hEnd; i++) timetable[day][i] = banned;
    }
    
}
