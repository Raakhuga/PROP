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
public class TimeLapse {
    private final int tIni;
    private final int tEnd;
    private final String day;
    private final Classroom classroom;
    private final Group group;
    
    public TimeLapse(int tIni, int tEnd, String day, Classroom classroom, Group group) {
        this.tIni = tIni;
        this.tEnd = tEnd;
        this.day = day;
        this.classroom = classroom;
        this.group = group;
    }
}
