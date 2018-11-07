
package domain;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/** Class for the subjects **/
public class Subject {
    
    /** Atributtes **/
    private String name;
    private Level level;
    
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
