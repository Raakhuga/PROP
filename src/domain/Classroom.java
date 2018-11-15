
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Classroom {
    
    /** Atributtes **/
    private String ref;
    private int capacity;
    private Timetable timetable;
    private final boolean theory;
    private final boolean lab;
    private final boolean problems;
      
    /** Constructor **/
    public Classroom(int capacity, String ref, int nDays, int hIni, int hEnd, boolean theory, boolean lab, boolean problems){
        this.capacity = capacity;
        this.ref = ref;
        this.timetable = new Timetable(nDays, hIni, hEnd);
        this.theory = theory;
        this.lab = lab;
        this.problems = problems;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRef() {
        return ref;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }
    
    public boolean isForTheory(){
        return theory;
    }
    
    public boolean isForLab(){
        return lab;
    }
    
    public boolean isForProblems(){
        return problems;
    }
    
    public int getnDaysFromTimetable(){
        return timetable.getnDays();
    }
    
    public int gethEndFromTimetable(){
        return timetable.gethEnd();
    }
    
    public int gethIniFromTimetable(){
        return timetable.gethIni();
    }
    
    public void setGStoTimetable(GroupSubject gs, int i, int j){
        timetable.setGStoTimetable(gs, i, j);
    }
    
    public void removeHourOfTimetable(int i,int j){
        timetable.removeHourOfTimetable(i, j);
    }
    
    /*public void save() throws IOException {
        String file = "state.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("Class");
        bw.write(ref);
        bw.write(capacity);
        timetable.save();
        bw.close();
    }*/
}
