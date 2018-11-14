
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class GroupSubject {
    
    /** Atributtes **/
    //private final int tIni;
    //private final int tEnd;
    //private final String day;
    //private final Classroom classroom;
    private final Subject subject;
    private final Group group;
    private final subGroup subGroup;
    private final boolean theory;
    private final boolean lab;
    private final boolean problems;
    private final int nMat;
    
    /** Constructor **/
    public GroupSubject() {
        //this.tIni = -1;
        //this.tEnd = -1;
        //this.day = null;
        //this.classroom = null;
        this.subject = null;
        this.group = null;
        this.subGroup = null;
        this.nMat = 0;
        this.theory = false;
        this.lab = false;
        this.problems = false;
    }
    
    /*public GroupSubject(String t) {
        if (t == "banned") {
            this.subject = null;
            this.group = null;
            this.nMat = -1;
            this.theory = false;
            this.lab = false;
            this.problems = false;
        }
    }*/
    
    public GroupSubject(Subject subject, Group group, int nMat, boolean theory, boolean lab, boolean problems) {
        //this.tIni = -1;
        //this.tEnd = -1;
        //this.day = null;
        //this.classroom = null;
        this.subject = subject;
        this.group = group;
        this.subGroup = null;
        this.nMat = nMat;
        this.theory = theory;
        this.lab = lab;
        this.problems = problems;
    }
    
    public GroupSubject(Subject subject, subGroup subGroup, int nMat, boolean theory, boolean lab, boolean problems) {
        this.subject = subject;
        this.group = null;
        this.subGroup = subGroup;
        this.nMat = nMat;
        this.theory = theory;
        this.lab = lab;
        this.problems = problems;
    }

    public boolean isBanned() {
        if (nMat != -1) return false;
        return true;
    }
    
    /*public int gettIni() {
        return tIni;
    }*/

    /*public int gettEnd() {
        return tEnd;
    }*/

    /*public String getDay() {
        return day;
    }*/

    /*public Classroom getClassroom() {
        return classroom;
    }*/
    
    public Subject getSubject() {
        return subject;
    }

    public Group getGroup() {
        return group;
    }
    
    public int getnMat() {
        return nMat;
    }
    
    public boolean getTheory() {
        return theory;
    }
    
    public boolean getLab() {
        return lab;
    }
    
    public boolean getProblems() {
        return problems;
    }
    
    public void save() throws IOException {
        String file = "state.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("GroupSubject");
        bw.write(subject.getName());
        bw.write(group.getNum());
        bw.write(nMat);
        bw.close();
    }

    /*public void FillTime(Classroom Class) {
        Timetable t = Class.getTimetable();
        for(int i = tIni; i < tEnd; i++) {
            t.add(day, i, subject
        }
    }*/
}
