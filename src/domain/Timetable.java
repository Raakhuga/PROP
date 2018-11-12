
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Timetable {
    
    /** Atributtes **/
    private GroupSubject[][] timetable;
    private final int nDays;
    //private final int nHours;
    private final int hIni;
    private final int hEnd;
    public boolean Restrictions[];
    
    /** Constructor **/
    public Timetable(int nDays, int hIni, int hEnd){
        timetable = new GroupSubject[nDays][hEnd-hIni];
        this.nDays = nDays;
        this.hIni = hIni;
        this.hEnd = hEnd;
        for(int i = 0; i < 5; i++) Restrictions[i] = true;
        //this.nHours = nHours;
    }

    public GroupSubject[][] getTimetable() {
        return timetable;
    }
    
    public GroupSubject getGroupSubject(int day, int hour) {
        return timetable[day][hour];
    }

    public int getnDays() {
        return nDays;
    }

    /*public int getnHours() {
        return nHours;
    }*/
    
    public int gethIni() {
        return hIni;
    }
    
    public int gethEnd() {
        return hEnd;
    }
    
    public boolean getRestrictions(int i){
        return Restrictions[i];
    }
    
    public int fill(int day, int hIni, int hEnd, GroupSubject lapse) {
        for (int i = hIni; i < hEnd; i++){
            if (timetable[day][i].getnMat() != -1) timetable[day][i] = lapse;
            else return -1;
        }
        return 0;
    }
    
    public void timeBanned(int day, int hIni, int hEnd) {
        for (int i = hIni; i < hEnd; i++) restrictions[day][i] = ;
    }
    
    public void save() throws IOException{
        String file = "state.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("Timetable");
        bw.write(nDays);
        bw.write(hIni);
        bw.write(hEnd);
        for (int i = 0; i < nDays; i++) 
            for (int j = 0; j < hEnd-hIni; j++) timetable[i][j].save();
        bw.close(); 
    }
}
