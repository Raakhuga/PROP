
package domain;

public class GroupTimetable extends Timetable{
    private ClassSubject CS[][];
    private GroupRestrictions restrictions[][];

    public GroupTimetable(int dIni, int dEnd, int hIni, int hEnd) {
        super(dIni, dEnd, hIni, hEnd);
        this.CS = new ClassSubject[7][24];
        this.restrictions = new GroupRestrictions[7][24];
        initialize();
    }
    
    private void initialize(){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++){
                restrictions[i][j] = new GroupRestrictions();
                if (i < super.getdIni()) restrictions[i][j].ban();
                if (j < super.gethIni() || j >= super.gethEnd()) restrictions[i][j].ban();
                CS[i][j] = new ClassSubject();
            }
        }
    }

    public ClassSubject[][] getCS() {
        return CS;
    }

    public GroupRestrictions[][] getRestrictions() {
        return restrictions;
    }

    public void setCS(ClassSubject[][] CS) {
        this.CS = CS;
    }

    public void setRestrictions(GroupRestrictions[][] restrictions) {
        this.restrictions = restrictions;
    }
    
    public boolean isEmpty(int day, int hour) {
        return CS[day][hour].isEmpty();
    }
    
    public boolean isBanned(int day, int hour) {
        return restrictions[day][hour].isBanned();
    }
    
    public boolean isSubjectBanned(int day, int hour, String name) {
        return restrictions[day][hour].isSubjectBanned(name);
    }
    
    public boolean isClassroomBanned(int day, int hour, String ref) {
        return restrictions[day][hour].isClassroomBanned(ref);
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
    
    public void banClassroom(int day, int hour, String ref) {
        restrictions[day][hour].banClassroom(ref);
    }
    
    public void unbanClassroom(int day, int hour, String ref) {
        restrictions[day][hour].unbanClassroom(ref);
    }
    
    public void addClassSubject(ClassSubject CS, int day, int hour) {
        this.CS[day][hour] = CS;  
    }
    
    public void removeClassSubject(int day, int hour) {
        this.CS[day][hour] = new ClassSubject();
    }
}
