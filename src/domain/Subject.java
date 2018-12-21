
package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Class for the subjects **/
public class Subject {
    private final static int THEORY = 0;
    private final static int LABORATORY = 1;
    private final static int PROBLEMS = 2;
    
    private String name;
    private int nSessions[];
    private List<Group> groups;
    
    public Subject(String name) {
        this.name = name;
        this.nSessions = new int[3];
        this.groups = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int[] getnSessions() {
        return nSessions;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setnSessions(int[] nSessions) {
        this.nSessions = nSessions;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
    
    public void fillTheoryH(int hours) {
        nSessions[THEORY] = hours;
    }
    
    public void fillLaboratoryH(int hours) {
        nSessions[LABORATORY] = hours;
    }
    
    public void fillProblemsH(int hours) {
        nSessions[PROBLEMS] = hours;
    }
    
    public int getTheoryH() {
        return nSessions[THEORY];
    }
    
    public int getLaboratoryH() {
        return nSessions[LABORATORY];
    }
    
    public int getProblemsH() {
        return nSessions[PROBLEMS];
    }
    
    public void addGroup(Group group) {
        groups.add(group);
    }
    
    public void removeGroup(Group group) {
        groups.remove(group);
    }
    
    public String saveSubject() {
        Iterator<Group> Git = groups.iterator();
        String gps = "Name: " + name + " Num_sessions_theory: " + nSessions[THEORY] + " Num_sessions_laboratory: " + nSessions[LABORATORY] + " Num_sessions_problems: " + nSessions[PROBLEMS] + " Num_groups: " + groups.size() + "\n" + "        Groups:";
        while (Git.hasNext()) {
            Group Gact = Git.next();
            String gp = "\n" + "          " + Gact.saveGroup();
            gps = gps + gp;
        }
        return gps;
    }
}
