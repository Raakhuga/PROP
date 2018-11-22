
package domain;

public class GroupTimetable extends Timetable{
    private ClassSubject CS[][];
    private GroupRestrictions restrictions[][];

    public GroupTimetable(int dIni, int dEnd, int hIni, int hEnd) {
        super(dIni, dEnd, hIni, hEnd);
        this.CS = new ClassSubject[7][24];
        this.restrictions = new GroupRestrictions[7][24];
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
    
    
    
}
