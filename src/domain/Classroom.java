
package domain;


public class Classroom {
    
    /** Atributtes **/
    private int capacity;
    private String ref;
    private Timetable timetable;
      
    /** Constructor **/
    public Classroom(int capacity, String ref, int nDays, int hIni, int hEnd){
        this.capacity = capacity;
        this.ref = ref;
        this.timetable = new Timetable(nDays, hIni, hEnd);
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
