
package domain;


public class Classroom {
    private final static int THEORY = 0;
    private final static int LABORATORY = 1;
    private final static int PROBLEMS = 2;
    
    private final String ref;
    private ClassroomTimetable timetable;
    private final int capacity;
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

    public int getCapacity() {
        return capacity;
    }
    
    public int getdIni() {
        return timetable.getdIni();
    }

    public int getdEnd() {
        return timetable.getdEnd();
    }
    
    public int gethIni() {
        return timetable.gethIni();
    }
    
    public int gethEnd() {
        return timetable.gethEnd();
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
    
    public void addToClassTimetable(GroupSubject GS, int day, int hour) {
        timetable.addGroupSubject(GS, day, hour);
    }
    
    public void removeFromClassTimetable(int day, int hour) {
        timetable.removeGroupSubject(day, hour);
    }
    
    public String saveClassroom(){
        return capacity + " " + ref + " " + getdIni() + " " + getdEnd() + " " + gethIni() + " " + gethEnd() + " " + type[THEORY] + " " + type[LABORATORY] + " " + type[PROBLEMS];
    }
}
