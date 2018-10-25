
package domain;


public class Classroom {
    
    /** Atributtes **/
    private int capacity;
    private String ref;
    private Timetable timetable;
      
    /** Constructor **/
    public Classroom(int capacity, String ref){
        this.capacity = capacity;
        this.ref = ref; 
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
