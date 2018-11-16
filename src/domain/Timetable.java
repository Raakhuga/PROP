
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Timetable {
    
    /** Atributtes **/
    private GroupSubject timetable[][];
    public ClassRestrictions restrictions[][];
    private final int nDays;
    private final int hIni;
    private final int hEnd;
    
    /** Constructor **/
    public Timetable(int nDays, int hIni, int hEnd){
        timetable = new GroupSubject[nDays][hEnd-hIni];
        restrictions = new ClassRestrictions[nDays][hEnd-hIni];
        this.nDays = nDays;
        this.hIni = hIni;
        this.hEnd = hEnd;
        initializeClassRestrictions();
        initializeGroupSubjects();
    }
    
    private void initializeClassRestrictions(){
        ClassRestrictions cr = new ClassRestrictions();
        for(int i = 0; i < nDays; i++)
            for(int j = 0; j < (hEnd-hIni); j++)
                restrictions[i][j] = cr;
    }
    
    private void initializeGroupSubjects(){
        GroupSubject gs = new GroupSubject();
        for(int i = 0; i < nDays; i++)
            for(int j = 0; j < (hEnd-hIni); j++)
                timetable[i][j] = gs;
    }

    public GroupSubject[][] getTimetable() {
        return timetable;
    }
    
    public void restartTimetable() {
        GroupSubject GS = new GroupSubject();
        for(int i = 0; i < nDays; i++) 
            for(int j = 0; j < hEnd-hIni; j++) {
                timetable[i][j] = GS;
                restrictions[i][j].setFree(true);
            }
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
    
    public ClassRestrictions[][] getRestrictions() {
        return restrictions;
    }
    
    /*public int fill(int day, int hIni, int hEnd, GroupSubject lapse) {
        for (int i = hIni; i < hEnd; i++){
            if (!restrictions[day][i].getBanned()) timetable[day][i] = lapse;
            else return -1;
        }
        return 0;
    }*/
    
    public void banGroup(int day, int hIni, int hEnd, int group) {
        if (hourOk(day, hIni, hEnd)) for (int i = hIni; i < hEnd; i++) restrictions[day][i].banGroup(group);   
    }
     public void banSubject(int day, int hIni, int hEnd, String name) {
         boolean hourOK2 = hourOk(day, hIni, hEnd);
        System.out.println("hourOk123123213 = " + hourOK2);
        if (hourOk(day, hIni, hEnd)) for (int i = hIni; i < hEnd; i++) restrictions[day][i].banSubject(name);   
    }
     
    public void UnbanGroup(int day, int hIni, int hEnd, int group) {
        if (hourOk(day, hIni, hEnd)) for (int i = hIni; i < hEnd; i++) restrictions[day][i].unbanGroup(group);   
    }
    public void UnbanSubject(int day, int hIni, int hEnd, String name) {
        if (hourOk(day, hIni, hEnd)) for (int i = hIni; i < hEnd; i++) restrictions[day][i].unbanSubject(name);   
    }
    public void setGStoTimetable(GroupSubject gs, int day, int hour){
        timetable[day][hour] = gs;
        restrictions[day][hour].setFree(false);
    }
    
    public void removeHourOfTimetable(int day, int hour){
        timetable[day][hour] = null;
    }
    
    public void banTime(int day, int hIni, int hEnd) {
        boolean hourOK2 = hourOk(day, hIni, hEnd);
        System.out.println("hourOk = " + hourOK2);
        if (hourOk(day, hIni, hEnd)) for (int i = hIni; i < hEnd; i++) restrictions[day][i].setBanned(true);
    }
    
    public void unbanTime(int day, int hIni, int hEnd) {
        if (hourOk(day, hIni, hEnd)) for (int i = hIni; i < hEnd; i++) restrictions[day][i].setBanned(false);
    }
    
    private boolean hourOk(int day, int hIni, int hEnd) {
        return (0 <= day && day < nDays) && (hIni < hEnd && hIni >= this.hIni && hEnd <= this.hEnd);
    }
    
    public boolean isBanned(int day, int hour) {
        /*System.out.println("Day: "+day+" hour: "+hour);
        System.out.println("nDays: "+getnDays()+" ultima franja: "+(gethEnd()-gethIni()));*/
        return restrictions[day][hour].getBanned();
    }
    
    public boolean subjectBanned(int day, int hour, String name) {
        return restrictions[day][hour].subjectBanned(name);
    }
    
    public boolean groupBanned(int day, int hour, int num) {
        return restrictions[day][hour].groupBanned(num);
    }
    
    /*public void load() throws IOException{
        String s;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        if ((s = br.readLine())!=null) 
        while((s = br.readLine())!=null) {
            ;
        }
        br.close();
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
    }*/
}
