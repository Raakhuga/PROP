/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author raakhuga
 */
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
