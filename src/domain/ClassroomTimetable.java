
package domain;


public class ClassroomTimetable extends Timetable {
    private GroupSubject GS[][];
    private ClassRestrictions restrictions[][];

    public ClassroomTimetable(int dIni, int dEnd, int hIni, int hEnd) {
        super(dIni, dEnd, hIni, hEnd);
        this.GS = new GroupSubject[7][24];
        this.restrictions = new ClassRestrictions[7][24];
        initialize();
    }
    
    private void initialize(){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++){
                restrictions[i][j] = new ClassRestrictions();
                if (i < super.getdIni() || i > super.getdEnd()) restrictions[i][j].setOut(true);
                if (j < super.gethIni() || j >= super.gethEnd()) restrictions[i][j].setOut(true);
                GS[i][j] = new GroupSubject();
            }
        }
    }

    public GroupSubject[][] getGS() {
        return GS;
    }

    public ClassRestrictions[][] getRestrictions() {
        return restrictions;
    }
    
    public GroupSubject getGroupSubject(int day, int hour) {
        return GS[day][hour];
    }
    
    public boolean isOut(int day, int hour) {
        return restrictions[day][hour].isOut();
    }

    public void setGS(GroupSubject[][] GS) {
        this.GS = GS;
    }

    public void setRestrictions(ClassRestrictions[][] restrictions) {
        this.restrictions = restrictions;
    }
    
    public boolean isEmpty(int day, int hour) {
        return GS[day][hour].isEmpty();
    }
    
    public boolean isBanned(int day, int hour) {
        return restrictions[day][hour].isBanned();
    }
    
    public boolean isSubjectBanned(int day, int hour, String name) {
        return restrictions[day][hour].isSubjectBanned(name);
    }
    
    public boolean isGroupBanned(int day, int hour, int num) {
        return restrictions[day][hour].isGroupBanned(num);
    }
    
    public void ban(int day, int hour) {
        restrictions[day][hour].ban();
    }
    
    public void unban(int day, int hour) {
        restrictions[day][hour].unban();
    }
    
    public void banSubject(int day, int hour, String subject) {
        restrictions[day][hour].banSubject(subject);
    }
    
    public void unbanSubject(int day, int hour, String subject) {
        restrictions[day][hour].unbanSubject(subject);
    }
    
    public void banGroup(int day, int hour, int num) {
        restrictions[day][hour].banGroup(num);
    }
    
    public void unbanGroup(int day, int hour, int num) {
        restrictions[day][hour].unbanGroup(num);
    }
    
    public void addGroupSubject(GroupSubject GS, int day, int hour) {
        this.GS[day][hour] = GS;
    }
    
    public void removeGroupSubject(int day, int hour) {
        this.GS[day][hour] = new GroupSubject();
    }
}
