
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.util.Pair;

/** Class for the subjects **/
public class Subject {
    
    /** Atributtes **/
    private final String name;
    private final Level level;
    private int hours;
    private Pair<String, Integer>[] sessions;
    
    /** Constructor **/
    public Subject(String name, Level level, int hours, int nSesTheory, int nSesLab, int nSesProblems){
        this.name = name;
        this.level = level;
        this.hours = hours;
        sessions[0] = new Pair<>("Theory", nSesTheory);
        sessions[1] = new Pair<>("Lab", nSesLab);
        sessions[2] = new Pair<>("Problems", nSesProblems);
    }

    /** Public methods **/
     public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }

    public int getHours() {
        return hours;
    }

    public Pair<String, Integer>[] getSessions() {
        return sessions;
    }
    
    
    public void save() throws IOException {
        String file = "state.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("Subject");
        bw.write(name);
        bw.write(level.getIden());
        bw.write(hours);
        for (int i = 0; i < sessions.length; ++i){
            bw.write(sessions[i].getKey());
            bw.write(sessions[i].getValue());
        }
        bw.close();       
    }
    
}
