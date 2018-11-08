
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
    private Pair<String, Integer> nSessions;
    
    /** Constructor **/
    public Subject(String name, Level level){
        this.name = name;
        this.level = level;
    }

    /** Public methods **/
     public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
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
