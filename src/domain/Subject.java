
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.util.Pair;

/** Class for the subjects **/
public class Subject {
    
    /** Atributtes **/
    private final static int THEORY = 0;
    private final static int LABORATORY = 1;
    private final static int PROBLEMS = 2;
    
    private final String name;
    private final int level;
    private int hours;
    private int nSessions[];
    
    /** Constructor **/
    public Subject(String name, int level, int hours){
        this.name = name;
        this.level = level;
        this.hours = hours;
        this.nSessions = new int[3];
    }

    /** Public methods **/
     public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
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
    
    public void manualFillHours() {
        int act, total;
        total = 0;
        System.out.println ("Insert the number of Theory hours for the Subject: " + name);
        Scanner in = new Scanner(System.in);
        act = in.nextInt();
        nSessions[THEORY] = act;
        total += act;
        System.out.println ("Insert the number of Laboratory hours for the Subject: " + name);
        act = in.nextInt();
        nSessions[LABORATORY]  = act;
        total += act;
        System.out.println ("Insert the number of Problem hours for the Subject: " + name);
        act = in.nextInt();
        nSessions[PROBLEMS] = act;
        total += act;
        if (total != hours) 
            System.out.println ("Error: The sum of the different type of hours and the total number of hours are not equal");
    }
    
    public void save() throws IOException {
        String file = "state.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("Subject");
        bw.write(name);
        bw.close();       
    }
    
}
