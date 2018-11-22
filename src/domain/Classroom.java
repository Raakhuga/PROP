
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Classroom {
    private final static int THEORY = 0;
    private final static int LABORATORY = 1;
    private final static int PROBLEMS = 2;
    
    private String ref;
    private ClassroomTimetable timetable;
    private int capacity;
    private boolean type[];
    
    public Classroom(String ref, int capacity, int dIni, int dEnd, int hIni, int hEnd) {
        this.ref = ref;
        this.timetable = new ClassroomTimetable(dIni, dEnd, hIni, hEnd);
        this.capacity = capacity;
        this.type = new boolean[3];
        this.type[THEORY] = false;
        this.type[LABORATORY] = false;
        this.type[PROBLEMS] = false;
    }

    public String getRef() {
        return ref;
    }

    public ClassroomTimetable getTimetable() {
        return timetable;
    }

    public boolean[] getType() {
        return type;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setTimetable(ClassroomTimetable timetable) {
        this.timetable = timetable;
    }

    public void setType(boolean[] type) {
        this.type = type;
    }
    
    public void setTheory(){
        type[THEORY] = true;
    }
    
    public void setLaboratory(){
        type[LABORATORY] = true;
    }
    
    public void setProblems(){
        type[PROBLEMS] = true;
    }
    
    public void unsetTheory(){
        type[THEORY] = false;
    }
    
    public void unsetLaboratory(){
        type[LABORATORY] = false;
    }
    
    public void unsetProblems(){
        type[PROBLEMS] = false;
    }
    
    public boolean isTheory() {
        return type[THEORY];
    }
    
    public boolean isLaboratory() {
        return type[LABORATORY];
    }
    
    public boolean isProblems() {
        return type[PROBLEMS];
    }
    
    public boolean isEmpty(int day, int hour) {
        return timetable.isEmpty(day, hour);
    }
}
