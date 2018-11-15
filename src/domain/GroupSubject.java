
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class GroupSubject {
    
    /** Atributtes **/
    private final Subject subject;
    private final Group group;
    private final subGroup subGroup;
    private final boolean theory;
    private final boolean lab;
    private final boolean problems;
    private final int nMat;
    
    /** Constructor **/
    public GroupSubject() {
        this.subject = null;
        this.group = null;
        this.subGroup = null;
        this.nMat = 0;
        this.theory = false;
        this.lab = false;
        this.problems = false;
    }
    
    public GroupSubject(Subject subject, Group group, int nMat, boolean theory, boolean lab, boolean problems) {
        this.subject = subject;
        this.group = group;
        this.subGroup = null;
        this.nMat = nMat;
        this.theory = theory;
        this.lab = lab;
        this.problems = problems;
    }
    
    public GroupSubject(Subject subject, Group group, subGroup subGroup, int nMat, boolean theory, boolean lab, boolean problems) {
        this.subject = subject;
        this.group = group;
        this.subGroup = subGroup;
        this.nMat = nMat;
        this.theory = theory;
        this.lab = lab;
        this.problems = problems;
    }

    public subGroup getSubGroup() {
        return subGroup;
    }

    public boolean isBanned() {
        if (nMat != -1) return false;
        return true;
    }
    
    public boolean issubGroup() {
        return this.subGroup != null;
    }
    
    public Subject getSubject() {
        return subject;
    }

    public Group getGroup() {
        return group;
    }
    
    public subGroup getsubGroup() {
        return subGroup;
    }
    
    public int getnMat() {
        return nMat;
    }
    
    public boolean theoryGroup() {
        return theory;
    }
    
    public boolean labGroup() {
        return lab;
    }
    
    public boolean problemsGroup() {
        return problems;
    }
    
    /*public void save() throws IOException {
        String file = "state.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("GroupSubject");
        bw.write(subject.getName());
        bw.write(group.getNum());
        bw.write(nMat);
        bw.close();
    }*/

    /*public void FillTime(Classroom Class) {
        Timetable t = Class.getTimetable();
        for(int i = tIni; i < tEnd; i++) {
            t.add(day, i, subject
        }
    }*/
}
