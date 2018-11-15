
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Level {
    
    /** Atributtes **/
    private int iden;
    private List<Subject> subjects;
    private List<Group> groups;
    
    /** Constructor **/
    public Level(int iden){
        this.iden = iden;
        this.subjects = new ArrayList<Subject>();
        this.groups = new ArrayList<Group>();
    }

    public int getIden() {
        return iden;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<Group> getGroups() {
        return groups;
    }
    
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
    
    public void addGro(Group group) {
        this.groups.add(group);
    }
    
    public void addGroup(int id, int nStudentsGroup, int nMaxStudentsSubgroups) {
        int nDays, hIni, hEnd, nSubGroups, remaining;
        Scanner in = new Scanner(System.in);
        System.out.println ("Insert the number of available days for the Group: " + id);
        nDays = in.nextInt();
        System.out.println ("Insert the fisrt available hour and the last one of the Group: " + id);
        hIni = in.nextInt();
        hEnd = in.nextInt();
        Group actualGroup = new Group(id, nDays, hIni, hEnd, nStudentsGroup);
        nSubGroups = nStudentsGroup / nMaxStudentsSubgroups;
        if (nStudentsGroup % nMaxStudentsSubgroups != 0) nSubGroups++;
        //añadir subrupos
        int i = 1;
        for(remaining = nStudentsGroup; remaining > nMaxStudentsSubgroups; remaining -= nMaxStudentsSubgroups){
            actualGroup.addSubGroup(new subGroup(id+i, nDays, hIni, hEnd, nMaxStudentsSubgroups));
            i++;
        }
        if (remaining > 0) actualGroup.addSubGroup(new subGroup(id+i, nDays, hIni, hEnd, remaining)); 
        groups.add(actualGroup);
    }
    
    public void fillLevel(boolean manual) {
        System.out.println ("Insert the number of Subjects of the Level: " + iden);
        Scanner in = new Scanner(System.in);
        int nSubjects, hours;
        nSubjects = in.nextInt();
        String name;
        List<Subject> subjects = new ArrayList<Subject>();
        Subject act;
        for(int j = 0; j < nSubjects; j++) {
            System.out.println ("Insert the name of the Subject num: " + j + " of the Level: " + iden);
            name = in.next();
            System.out.println ("Insert the number of hours of the Subject: " + name + " of the Level: " + iden);
            hours = in.nextInt();
            act = new Subject(name, iden, hours);
            if(manual) act.manualFillHours();
            subjects.add(act);
        }
        setSubjects(subjects);
    }
    
    /*public void save() throws IOException {
        String file = "state.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("Level");
        bw.write(iden);
        Iterator<Subject> it = subjects.iterator();
        while(it.hasNext()) it.next().save();
        bw.close();  
    }*/
}
