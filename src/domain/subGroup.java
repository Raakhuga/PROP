
package domain;


public class subGroup extends Group {
    private final int num;
    private GroupTimetable subtimetable;
    
    public subGroup(GroupTimetable timetable, int numGroup, int num, int enrolled) {
        super(timetable, numGroup, enrolled);
        this.num = num;
        this.subtimetable = new GroupTimetable(super.getdIni(), super.getdEnd(), super.gethIni(), super.gethEnd());
    }
    
    public boolean isSubGroup() {
        return true;
    }
    
    public int getNum(){
        return num;
    }
}
