
package domain;


public class Classroom {
    
    /** Atributtes **/
    private int capacity;
    private String ref;
    private Timetable timetable;
      
    /** Constructor **/
    public Classroom(int capacity, String ref, int nDays, int nHours){
        this.capacity = capacity;
        this.ref = ref;
        this.timetable = new Timetable(nDays, nHours);
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
    
}
