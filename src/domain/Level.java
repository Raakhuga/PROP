
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Level {
    
    /** Atributtes **/
    private final int iden;
    private List<Subject> subjects;
    
    /** Constructor **/
    public Level(int iden){
        this.iden = iden;
        this.subjects = new ArrayList<>();
    }

    public int getIden() {
        return iden;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
    
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
