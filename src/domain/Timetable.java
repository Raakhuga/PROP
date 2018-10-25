
package domain;

import java.util.HashMap;
import java.util.Map;

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
}
