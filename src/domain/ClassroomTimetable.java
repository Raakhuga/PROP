
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ClassroomTimetable extends Timetable {
    private GroupSubject GS[][];
    private GroupRestrictions restrictions[][];

    public ClassroomTimetable(int dIni, int dEnd, int hIni, int hEnd) {
        super(dIni, dEnd, hIni, hEnd);
        this.GS = new GroupSubject[7][24];
        this.restrictions = new GroupRestrictions[7][24];
        initialize();
    }
    
    private void initialize(){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++){
                restrictions[i][j] = new GroupRestrictions();
                if (i < super.getdIni()) restrictions[i][j].ban();
                if (j < super.gethIni() || j >= super.gethEnd()) restrictions[i][j].ban();
                GS[i][j] = new GroupSubject();
            }
        }
    }
    
}
