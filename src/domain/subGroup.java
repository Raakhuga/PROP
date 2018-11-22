
package domain;


public class subGroup extends Group {
    private final int num;
    private GroupTimetable subtimetable;
    
    public subGroup(Group group, int num, int enrolled) {
        super(group, enrolled);
        this.num = num;
        this.subtimetable = new GroupTimetable(super.getdIni(), super.getdEnd(), super.gethIni(), super.gethEnd());
    }
    
    public boolean isSubGroup() {
        return true;
    }
    
    public int getNum(){
        return num;
    }
    
    //posible error
    public boolean isEmpty(int day, int hour) {
        if(super.isEmpty(day, hour)) return subtimetable.isEmpty(day, hour);
        return false;
    }
    
    public boolean isSuperEmpty(int day, int hour) {
        return super.isEmpty(day, hour);
    }
    
    public boolean isBanned(int day, int hour) {
        return subtimetable.isBanned(day, hour);
    }
    
    public boolean isSubjectBanned(int day, int hour, String name) {
        return subtimetable.isSubjectBanned(day, hour, name);
    }
    
    public boolean isClassroomBanned(int day, int hour, String ref) {
        return subtimetable.isClassroomBanned(day, hour, ref);
    }
}
