
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Classroom {
    
    /** Atributtes **/
    private int capacity;
    private String ref;
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
    
    public void save() throws IOException {
        String file = "state.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("Class");
        bw.write(ref);
        bw.write(capacity);
        timetable.save();
        bw.close();
    }
}
