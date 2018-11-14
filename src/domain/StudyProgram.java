
package domain;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class StudyProgram {
    
    /** Atributtes **/
    private String name;
    private Map<Integer, Level> levels;
    private int nLevels;
    
    /** Constructor **/
    public StudyProgram(String name){
        this.name = name;
        this.levels = new HashMap<Integer, Level>();
        this.nLevels = 0;
    }

    public String getName() {
        return name;
    }


    public Map<Integer, Level> getLevels() {
        return levels;
    }

    public int getnLevels() {
        return nLevels;
    }
    
    public void addLevels(boolean manual) {
        nLevels++;
        Integer val = new Integer(nLevels);
        Level act = new Level(nLevels);
        act.fillLevel(manual);
        levels.put(val, act);
    }
    
    public void removeLevel(int id) {
        nLevels--;
        levels.remove(id);
    }
    
    /*public void fillLevel(boolean manual) {
        Iterator<> it = levels.iterator();
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
                if(manual)subjects[j].manualFillHours();
            }
            act.setSubjects(subjects);
            it.remove();
            levels.add(act);
        }
    }*/
    
    /*public void save() throws IOException {
        String file = "state.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("StudyProgram");
        bw.write(name);
        Iterator<Level> it = levels.values().iterator();
        while(it.hasNext()) it.next().save();
        bw.write(nLevels);
        bw.close(); 
    }  */
}
