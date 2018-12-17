
package domain;

import java.util.Iterator;
import java.util.List;


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
    
    public int getSuperNum() {
        return super.getNum();
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
    
    public void addToGroupTimetable(ClassSubject CS, int day, int hour) {
        subtimetable.addClassSubject(CS, day, hour);
    }
    
    public void removeFromGroupTimetable(int day, int hour) {
        subtimetable.removeClassSubject(day, hour);
    }
     
    public String saveGroup() {
        List<String> addedR = getAddedRestrictions();
        Iterator<String> Rit = addedR.iterator();
        String sg = "Num: " + num + " Enrolled: " + getEnrolled() + " First_day: " + getdIni() + " Last_day: " + getdEnd() + " First_hour: " + gethIni() + " Last_hour: " + gethEnd() + " Num_restrictions: " + addedR.size() + "\n" + "            Restrictions:"; 
        while(Rit.hasNext()) {
            String Ract = Rit.next();
            String R = "\n" + "              " + Ract;
            sg = sg + R;
        }
        return sg;
    }
}
