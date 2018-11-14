
package domain;


public class subGroup {
    private int Num;
    private Timetable subGroupTimetable;
    private int nMat;
    
    
    public subGroup(int num, int nDays, int hIni, int hEnd, int nMat) {
        this.subGroupTimetable = new Timetable(nDays, hIni, hEnd);
        this.Num = Num;
        this.nMat = nMat;
    }
    
    public Timetable getTimetable() {
        return subGroupTimetable;
    }
    
    public int getnMat() {
        return nMat;
    }
    
    public void addSubject() {}
    
    public int getsNum() {
        return Num;
    }
}
