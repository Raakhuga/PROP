
package domain;


public class subGroup extends Group {
    private GroupTimetable subtimetable;
    
    public subGroup(GroupTimetable timetable, int enrolled) {
        super(timetable, enrolled);
        this.subtimetable = new GroupTimetable(super.getdIni(), super.getdEnd(), super.gethIni(), super.gethEnd());
    }
    
}
