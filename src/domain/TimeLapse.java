
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

    public int gettIni() {
        return tIni;
    }

    public int gettEnd() {
        return tEnd;
    }

    public String getDay() {
        return day;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public Group getGroup() {
        return group;
    }
    
    
}
