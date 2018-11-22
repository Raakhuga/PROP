
package domain;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Group {
    
    /** Atributtes **/
    private final int enrolled;
    private GroupTimetable timetable;
    
    /** Constructor **/
    public Group(int dIni, int dEnd, int hIni, int hEnd, int enrolled) {
        this.enrolled = enrolled;
        this.timetable = new GroupTimetable(dIni, dEnd, hIni, hEnd);
    }
    
    public Group(GroupTimetable timetable, int enrolled) {
        this.timetable = timetable;
        this.enrolled = enrolled;
    }

    
    public int getdIni() {
        return timetable.getdIni();
    }

    public int getdEnd() {
        return timetable.getdEnd();
    }

    public int gethIni() {
        return timetable.gethIni();
    }

    public int gethEnd() {
        return timetable.gethEnd();
    }

    public int getEnrolled() {
        return enrolled;
    }
    
    public GroupTimetable getTimetable() {
        return timetable;
    }

    public void setTimetable(GroupTimetable timetable) {
        this.timetable = timetable;
    }
    
    public boolean isSubGroup() {
        return false;
    }
}
