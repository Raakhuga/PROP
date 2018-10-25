
package domain;


public class TimeLapse {
    
    /** Atributtes **/
    private final int tIni;
    private final int tEnd;
    private final String day;
    //private final Classroom classroom;
    private final Subject subject;
    private final Group group;
    
    /** Constructor **/
    public TimeLapse() {
        this.tIni = -1;
        this.tEnd = -1;
        this.day = null;
        //this.classroom = null;
        this.subject = null;
        this.group = null;
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

    /*public Classroom getClassroom() {
        return classroom;
    }*/

    public Group getGroup() {
        return group;
    }
}
