
package domain;


public class Classroom {
    private int capacity;
    private String ref;
    private Timetable timetable;
      
    public Classroom(int capacity, String ref){
        this.capacity = capacity;
        this.ref = ref; 
    }
    
   /* public Timetable getTimetable() {
        return timetable;
    }*/
}
