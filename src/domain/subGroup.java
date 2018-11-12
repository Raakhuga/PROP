
package domain;


public class subGroup extends Group {
    private int sNum;
    
    
    public subGroup(int sNum, int num, Timetable groupTimetable) {
        super(num, groupTimetable);
        this.sNum = sNum;
    }
    
    public void addSubject() {}
    
    public int getsNum() {
        return sNum;
    }
}
