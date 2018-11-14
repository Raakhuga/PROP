
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Level {
    
    /** Atributtes **/
    private int iden;
    private Subject subjects[];
    private Group groups[];
    
    /** Constructor **/
    public Level(int iden){
        this.iden = iden;
    }

    public int getIden() {
        return iden;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject subjects[]) {
        this.subjects = subjects;
    }
    
    public void setGroups(Group groups[]) {
        this.groups = groups;
    }
    
    public void fillLevel(boolean manual) {
        System.out.println ("Insert the number of Subjects of the Level: " + iden);
        Scanner in = new Scanner(System.in);
        int nSubjects = in.nextInt();
        String name;
        Subject subjects[] = new Subject[nSubjects];
        for(int j = 0; j < nSubjects; j++) {
        System.out.println ("Insert the name of the Subject num: " + j + "of the Level: " + iden);
            name = in.next();
            subjects[j] = new Subject(name, iden);
            if(manual)subjects[j].manualFillHours();
        }
        setSubjects(subjects);
    }
    
    /*public void save() throws IOException {
        String file = "state.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("Level");
        bw.write(iden);
        for (int i = 0; i < subjects.length; i++) subjects[i].save();
        bw.close();  
    }*/
}
