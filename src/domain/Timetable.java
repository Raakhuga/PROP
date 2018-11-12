
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Timetable {
    
    /** Atributtes **/
    private GroupSubject[][] timetable;
    public Restrictions restrictions[][];
    private final int nDays;
    private final int hIni;
    private final int hEnd;
    
    /** Constructor **/
    public Timetable(int nDays, int hIni, int hEnd){
        timetable = new GroupSubject[nDays][hEnd-hIni];
        restrictions = new Restrictions[nDays][hEnd-hIni];
        this.nDays = nDays;
        this.hIni = hIni;
        this.hEnd = hEnd;
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
    
    public int gethIni() {
        return hIni;
    }
    
    public int gethEnd() {
        return hEnd;
    }
    
    public Restrictions[][] getRestrictions() {
        return restrictions;
    }
    
    public int fill(int day, int hIni, int hEnd, GroupSubject lapse) {
        for (int i = hIni; i < hEnd; i++){
            if (!restrictions[day][i].getBanned()) timetable[day][i] = lapse;
            else return -1;
        }
        return 0;
    }
    
    public void timeBanned(int day, int hIni, int hEnd) {
        if (hourOk(day, hIni, hEnd)) for (int i = hIni; i < hEnd; i++) restrictions[day][i].setBanned(true);
    }
    
    public void unbanTime(int day, int hIni, int hEnd) {
        if (hourOk(day, hIni, hEnd)) for (int i = hIni; i < hEnd; i++) restrictions[day][i].setBanned(false);
    }
    
    private boolean hourOk(int day, int hIni, int hEnd) {
        return (0 <= day && day > nDays) && (hIni < hEnd && hIni >= this.hIni && hEnd <= this.hEnd);
    }
    
    public boolean isBanned(int day, int hIni, int hEnd) {
        if (hourOk(day, hIni, hEnd)) 
            for(int i = hIni; i < hEnd; i++) 
                if(restrictions[day][i].getBanned()) return true;
        return false;
    }
    
    public boolean subjectBanned(int day, int hIni, int hEnd, String name) {
        if (hourOk(day, hIni, hEnd))
            for(int i = hIni; i < hEnd; i++)
                if(restrictions[day][i].subjectBanned(name)) return true;
        return false;
    }
    
    public boolean groupBanned(int day, int hIni, int hEnd, int num) {
        if (hourOk(day, hIni, hEnd))
            for(int i = hIni; i < hEnd; i++)
                if(restrictions[day][i].groupBanned(num)) return true;
        return false;
    }
    
    public boolean classroomBanned(int day, int hIni, int hEnd, String ref) {
        if (hourOk(day, hIni, hEnd))
            for(int i = hIni; i < hEnd; i++)
                if(restrictions[day][i].classroomBanned(ref)) return true;
        return false;
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
