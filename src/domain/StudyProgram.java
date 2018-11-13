
package domain;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class StudyProgram {
    
    /** Atributtes **/
    private String name;
    private Set<Level> levels;
    private int nLevels;
    
    /** Constructor **/
    public StudyProgram(String name, int nLevels){
        this.name = name;
        this.levels = new HashSet<Level>();
        this.nLevels = nLevels;
        for(int i = 0; i < nLevels; i++) this.levels.add(new Level(i));
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
    
    public void fillLevels() {
        Iterator<Level> it = levels.iterator();
        while(it.hasNext()){
            Level act = it.next();
            System.out.println ("Insert the number of Subjects of the Level: " + act.getIden());
            Scanner in = new Scanner(System.in);
            int nSubjects = in.nextInt();
            String name;
            Subject subjects[] = new Subject[nSubjects];
            for(int j = 0; j < nSubjects; j++) {
                System.out.println ("Insert the name of the Subject num: " + j + "of the Level: " + act.getIden());
                name = in.next();
                subjects[j] = new Subject(name, act);
            }
            act.setSubjects(subjects);
            it.remove();
            levels.add(act);
        }
    }
    
    public void addLevels() {
        nLevels++;
        levels.add(new Level(nLevels));
    }
    
    public void removeLevel(int id) {
        levels.remove(new Level(id));
    }
    
    public void save() throws IOException {
        String file = "state.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("StudyProgram");
        bw.write(name);
        Iterator<Level> it = levels.iterator();
        while(it.hasNext()) it.next().save();
        bw.write(nLevels);
        bw.close(); 
    }  
}
