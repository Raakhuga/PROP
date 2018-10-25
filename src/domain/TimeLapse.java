
package domain;


public class TimeLapse {
    
    /** Atributtes **/
    private final int tIni;
    private final int tEnd;
    private final String day;
    private final Classroom classroom;
    private final Group group;
    
    /** Constructor **/
    public TimeLapse(int tIni, int tEnd, String day, Classroom classroom, Group group) {
        this.tIni = tIni;
        this.tEnd = tEnd;
        this.day = day;
        this.classroom = classroom;
        this.group = group;
    }
}
