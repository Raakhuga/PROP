
package domain;

import java.util.ArrayList;
import java.util.List;


public class StudyProgram {
    
    /** Atributtes **/
    private String name;
    private List<Level> levels;
    private int nLevels;
    
    /** Constructor **/
    public StudyProgram(String name){
        this.name = name;
        this.levels = new ArrayList<>();
        this.nLevels = 0;
    }

    public String getName() {
        return name;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public int getnLevels() {
        return nLevels;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public void setnLevels(int nLevels) {
        this.nLevels = nLevels;
    }

    public void addLevel() {
        nLevels++;
        levels.add(new Level(nLevels));
    }
    
}
