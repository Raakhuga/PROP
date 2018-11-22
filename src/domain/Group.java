
package domain;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Group {
    private final int enrolled;
    private final int num;
    private GroupTimetable timetable;
    private List<subGroup> subGroups;
    
    public Group(int dIni, int dEnd, int hIni, int hEnd, int num, int enrolled) {
        this.num = num;
        this.enrolled = enrolled;
        this.timetable = new GroupTimetable(dIni, dEnd, hIni, hEnd);
        this.subGroups = new ArrayList<>();
    }
    
    public Group(GroupTimetable timetable, int num, int enrolled) {
        this.num = num;
        this.timetable = timetable;
        this.enrolled = enrolled;
    }

    public int getNum() {
        return num;
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
