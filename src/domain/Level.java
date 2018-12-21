
package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Level {
    
    /** Atributtes **/
    private int iden;
    private List<Subject> subjects;
    
    /** Constructor **/
    public Level(int iden){
        this.iden = iden;
        this.subjects = new ArrayList<>();
    }

    public int getIden() {
        return iden;
    }

    public void setIden(int iden) {
        this.iden = iden;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
    
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    
    public Subject addSubject(String name) {
        Subject subject = new Subject(name);
        subjects.add(subject);
        return subject;
    }
    
    public void removeSubject(Subject s){
        subjects.remove(s);
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
        String subs = "  Iden: " + iden + " Num_subjects: " + subjects.size() + "\n" + "      " + "Subjects:";
        while(Sit.hasNext()) {
            Subject Sact = Sit.next();
            String sub = "\n" + "        " + Sact.saveSubject();
            subs = subs + sub;
        }
        return subs;
    }
}
