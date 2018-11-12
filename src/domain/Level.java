
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
    
    public void save() throws IOException {
        String file = "state.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("Level");
        bw.write(iden);
        for (int i = 0; i < subjects.length; i++) subjects[i].save();
        bw.close();  
    }
}
