
package domain;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Group {
    
    /** Atributtes **/
    private final int dIni;
    private final int dEnd;
    private final int hIni;
    private final int hEnd;
    private final int enrolled;
    private GroupRestrictions restrictions[][];
    //private Timetable timetable[][];
    
    /** Constructor **/
    public Group(int dIni, int dEnd, int hIni, int hEnd, int enrolled) {
        this.dIni = dIni;
        this.dEnd = dEnd;
        this.hIni = hIni;
        this.hEnd = hEnd;
        this.enrolled = enrolled;
        restrictions = new GroupRestrictions[7][24];
        //timetable = new Timetable[7][24];
        initializeRestrictions();
    }

    private void initializeRestrictions(){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++){
                restrictions[i][j] = new GroupRestrictions();
                if (i < dIni) restrictions[i][j].ban();
                if (j < hIni || j >= hEnd) restrictions[i][j].ban();
            }
        }
    }
    
    private void initializeTimetable() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++) {
                timetable[i][j] = new ClassroomTimetable(dIni, dEnd, hIni, hEnd)
            }
        }   
    }
    
    public int getdIni() {
        return dIni;
    }

    public int getdEnd() {
        return dEnd;
    }

    public int gethIni() {
        return hIni;
    }

    public int gethEnd() {
        return hEnd;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public GroupRestrictions[][] getRestrictions() {
        return restrictions;
    }

    public ClassroomTimetable[][] getTimetable() {
        return timetable;
    }

    public void setRestrictions(GroupRestrictions[][] restrictions) {
        this.restrictions = restrictions;
    }

    public void setTimetable(ClassroomTimetable[][] timetable) {
        this.timetable = timetable;
    }
    
    public boolean isSubGroup() {
        return false;
    }
}
