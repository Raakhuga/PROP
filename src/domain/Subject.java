
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.util.Pair;

/** Class for the subjects **/
public class Subject {
    private final static int THEORY = 0;
    private final static int LABORATORY = 1;
    private final static int PROBLEMS = 2;
    
    private final String name;
    private int nSessions[];
    private final int level;
    private List<Group> groups;
    
    public Subject(String name, int level) {
        this.name = name;
        this.nSessions = new int[3];
        this.level = level;
        this.groups = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int[] getnSessions() {
        return nSessions;
    }

    public int getLevel() {
        return level;
    }

    public List<Group> getGroups() {
        return groups;
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
    
    public void fillPoblemsH(int hours) {
        nSessions[PROBLEMS] = hours;
    }
    
    public void addGroup(Group group) {
        groups.add(group);
    }
    
    public void removeGroup(Group group) {
        groups.remove(group);
    }
}
