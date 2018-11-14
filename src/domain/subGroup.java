
package domain;


public class subGroup {
    private int Num;
    private GroupRestrictions subGroupRestrictions[][];
    private Subject subGroupTimetable[][];
    private String type[][];
    private int nDays;
    private int hEnd;
    private int hIni;
    private int nMat;
    
    
    public subGroup(int num, int nDays, int hIni, int hEnd, int nMat) {
        this.subGroupRestrictions = new GroupRestrictions[nDays][hEnd-hIni];
        this.subGroupTimetable = new Subject[nDays][hEnd-hIni];
        this.type = new String[nDays][hEnd-hIni];
        this.Num = Num;
        this.nDays = nDays;
        this.hIni = hIni;
        this.hEnd = hEnd;
        this.nMat = nMat;
    }
    
    public GroupRestrictions[][] getRestrictions() {
        return subGroupRestrictions;
    }
    
    public int getnMat() {
        return nMat;
    }

    public int getnDays() {
        return nDays;
    }

    public int gethEnd() {
        return hEnd;
    }

    public int gethIni() {
        return hIni;
    }
    
    public String getType(int day, int hour) {
        return this.type[day][hour];
    }
    
    public void setType(int day, int hour, String type) {
        this.type[day][hour] = type;
    }
    
    public void addSubject(int day, int hour, Subject subject) {
        subGroupTimetable[day][hour] = subject;
    }
    
    public Subject[][] getGroupTimetable() {
        return subGroupTimetable;
    }
    
    public Subject getSubject (int day, int hour) {
        return subGroupTimetable[day][hour];
    }
    
    public GroupRestrictions getRestriction(int day, int hour) {
        return subGroupRestrictions[day][hour];
    }
    
    public int getsNum() {
        return Num;
    }
}
