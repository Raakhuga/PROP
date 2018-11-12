
package domain;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class StudyProgram {
    
    /** Atributtes **/
    private String name;
    private Level levels[];
    private int nLevels;
    
    /** Constructor **/
    public StudyProgram(String name, int nLevels){
        this.name = name;
        this.levels = new Level[nLevels];
        this.nLevels = nLevels;
    }

    public String getName() {
        return name;
    }

    public Level[] getLevels() {
        return levels;
    }

    public int getnLevels() {
        return nLevels;
    }
    
    public void addLevels(Subject AllSubjects[][]) {
        for(int i = 0; i < nLevels; i++) {
            levels[i] = new Level(i);
            int size = AllSubjects[i].length;
            Subject subjects[] = new Subject[size];
            for(int j = 0; j < size; j++)
                subjects[j] = AllSubjects[j][i];
            levels[i].setSubjects(subjects);
        }
    }
    
    public void save() throws IOException {
        String file = "state.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("StudyProgram");
        bw.write(name);
        for (int i = 0; i < levels.length; i++) levels[i].save();
        bw.write(nLevels);
        bw.close(); 
    }  
    
}
