
package domain;

public class ClassSubject {
    private Classroom classroom;
    private Subject subject;
    private boolean empty;

    public ClassSubject(Classroom classroom, Subject subject) {
        this.classroom = classroom;
        this.subject = subject;
        this.empty = false;
    }

    public ClassSubject() {
        this.empty = true;
    }
    
    public Classroom getClassroom() {
        return classroom;
    }

    public Subject getSubject() {
        return subject;
    }
    
    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

}
