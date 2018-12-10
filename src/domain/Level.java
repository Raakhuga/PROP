
package domain;

import java.util.ArrayList;
import java.util.List;

public class Level {
    
    /** Atributtes **/
    private final int iden;
    private List<Subject> subjects;
    
    /** Constructor **/
    public Level(int iden){
        this.iden = iden;
        this.subjects = new ArrayList<>();
    }

    public int getIden() {
        return iden;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
    
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    
    public void addSubject(String name) {
        subjects.add(new Subject(name, iden));
    }
}
