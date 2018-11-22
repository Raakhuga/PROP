/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author raakhuga
 */
public class GroupTimetable extends Timetable{
    private ClassSubject CS[][];
    private ClassRestrictions restrictions[][];

    public GroupTimetable(int dIni, int dEnd, int hIni, int hEnd) {
        super(dIni, dEnd, hIni, hEnd);
        this.CS = new ClassSubject[7][24];
        this.restrictions = new ClassRestrictions[7][24];
    }
    
    private void initialize(){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++){
                restrictions[i][j] = new ClassRestrictions();
                if (i < super.getdIni()) restrictions[i][j].ban();
                if (j < super.gethIni() || j >= super.gethEnd()) restrictions[i][j].ban();
                CS[i][j] = new ClassSubject();
            }
        }
    }
}
