
package domain;


public class subGroup extends Group {
    private int sNum;
    private Timetable subGroupTimetable;
    
    
    public subGroup(int sNum, int num, Timetable groupTimetable) {
        super(num, groupTimetable);
        this.subGroupTimetable = new Timetable(groupTimetable.getnDays(), groupTimetable.gethIni(), groupTimetable.gethEnd());
        this.sNum = sNum;
    }
    
    public Timetable getSubTimetable() {
        return subGroupTimetable;
    }
    
    public void addSubject() {}
    
    public int getsNum() {
        return sNum;
    }
}
