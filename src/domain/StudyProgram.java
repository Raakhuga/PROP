
package domain;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;


public class StudyProgram {
    
    /** Atributtes **/
    private String name;
    private Set<Level> levels;
    private int nLevels;
    
    /** Constructor **/
    public StudyProgram(String name){
        this.name = name;
        this.levels = new HashSet<Level>();
        this.nLevels = 0;
    }

    public String getName() {
        return name;
    }

    public Set<Level> getLevels() {
        return levels;
    }

    public int getnLevels() {
        return nLevels;
    }
    
    public void setLevels(Set<Level> levels) {
        this.levels = levels;
        this.nLevels = levels.size();
    }
    
    public void addLevel(Level level){
        if (!levels.contains(level)){
            levels.add(level);
            nLevels++;
        }
    }
    
    public void save() throws IOException {
        String file = "state.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("StudyProgram");
        bw.write(name);
        Iterator<Level> it = levels.iterator();
        while(it.hasNext()){
            it.next().save();
        }
        bw.write(nLevels);
        bw.close(); 
    }  
    
}
