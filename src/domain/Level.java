
package domain;

import java.util.ArrayList;
import java.util.Iterator;
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
    
    public String saveLevel() {
        Iterator<Subject> Sit = subjects.iterator();
        String subs = "  " + iden + " " + subjects.size() + "\n" + "      " + "Subjects:" + "\n";
        while(Sit.hasNext()) {
            Subject Sact = Sit.next();
            String sub = "        " + Sact.saveSubject() + "\n";
            subs = subs + sub;
        }
        return subs;
    }
}
