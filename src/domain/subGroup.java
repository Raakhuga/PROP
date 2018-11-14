
package domain;


public class subGroup {
    private int Num;
    private Subject[][] subGroupTimetable;
    private int nMat;
    
    
    public subGroup(int num, int nDays, int hIni, int hEnd, int nMat) {
        this.subGroupTimetable = new Subject[nDays][hEnd-hIni];
        this.Num = Num;
        this.nMat = nMat;
    }
    
    public Subject[][] getTimetable() {
        return subGroupTimetable;
    }
    
    public void setSubject(int day, int hour, Subject subject){
        subGroupTimetable[day][hour] = subject;
    }
    
    public void removeSubject(int day, int hour){
        subGroupTimetable[day][hour] = null;
    }
    
    public int getnMat() {
        return nMat;
    }
    
    public void addSubject() {}
    
    public int getsNum() {
        return Num;
    }
}
