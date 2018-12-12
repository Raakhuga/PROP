
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
    
    public Subject addSubject(String name) {
        Subject subject = new Subject(name, iden);
        subjects.add(subject);
        return subject;
    }
    
    public void fillTheoryH(Subject subject, int hours) {
        subject.fillTheoryH(hours);
    }
    
    public void fillLaboratoryH(Subject subject, int hours) {
        subject.fillLaboratoryH(hours);
    }
    
    public void fillPorblemsH(Subject subject, int hours) {
        subject.fillProblemsH(hours);
    }
    
    public String saveLevel() {
        Iterator<Subject> Sit = subjects.iterator();
        String subs = "  " + iden + " " + subjects.size() + "\n" + "      " + "Subjects:";
        while(Sit.hasNext()) {
            Subject Sact = Sit.next();
            String sub = "\n" + "        " + Sact.saveSubject();
            subs = subs + sub;
        }
        return subs;
    }
}
