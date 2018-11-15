
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
    
    public int getNumGroup() {
        return group.getNum();
    }
    
    public String getNameSubject() {
        return subject.getName();
    }
    
    public String getType() {
        String type = "";
        if (theory) type = "theroy";
        else if (lab) type = "laboratory";
        else if (problems) type = "problems";
        return type;
    }
    
    public boolean isSubGroup() {
        return subGroup != null;
    }

    public boolean SubGroupBanned(int day, int hour) {
        return subGroup.isBanned(day, hour);
    }
    
    public boolean GroupBanned(int day, int hour) {
        return group.isBanned(day, hour);
    }
    
    public boolean SubGroupSubjectBanned(int day, int hour, String name) {
        return subGroup.subjectBanned(day, hour, name);
    }
    
    public boolean GroupSubjectBanned(int day, int hour, String name) {
        return group.subjectBanned(day, hour, name);
    }
    
    public boolean SubGroupClassroomBanned(int day, int hour, String name) {
        return subGroup.classroomBanned(day, hour, name);
    }
    
    
    public boolean GroupClassroomBanned(int day, int hour, String name) {
        return group.classroomBanned(day, hour, name);
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
    
    public void setSubjectToGroup(int i, int j, Subject s, boolean issubGroup){
        if (issubGroup) this.subGroup.setSubject(i, j, s);
        else this.group.setSubject(i, j, s);
    }
    
    public void removeSubjectOfTimetableFromGroup(int i, int j, boolean issubGroup){
        if (issubGroup) this.subGroup.removeSubject(i, j);
        else this.group.removeSubject(i, j);
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
