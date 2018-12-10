
package domain;
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
    
    public Group(Group group, int enrolled) {
        this.num = group.getNum();
        this.timetable = group.getTimetable();
        this.enrolled = enrolled;
        this.subGroups = group.getSubGroups();
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
    
    public List<subGroup> getSubGroups() {
        return subGroups;
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
    
    public boolean isEmpty(int day, int hour) {
        return timetable.isEmpty(day, hour);
    }
    
    public boolean isBanned(int day, int hour) {
        return timetable.isBanned(day, hour);
    }
    
    public boolean isSubjectBanned(int day, int hour, String name) {
        return timetable.isSubjectBanned(day, hour, name);
    }
    
    public boolean isClassroomBanned(int day, int hour, String ref) {
        return timetable.isClassroomBanned(day, hour, ref);
    }
    
    public void addSubGroup(subGroup subGroup) {
        subGroups.add(subGroup);
    }
    
    public void addToGroupTimetable(ClassSubject CS, int day, int hour) {
        timetable.addClassSubject(CS, day, hour);
    }
    
    public void removeFromGroupTimetable(int day, int hour) {
        timetable.removeClassSubject(day, hour);
    }
}
