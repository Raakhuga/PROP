
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class GroupSubject {
    private final static int THEORY = 0;
    private final static int LABORATORY = 1;
    private final static int PROBLEMS = 2;
    
    private Subject subject;
    private Group group;
    private boolean empty;
    private boolean type[];
    
    public GroupSubject(Subject subject, Group group) {
        this.subject = subject;
        this.group = group;
        this.empty = false;
        this.type = new boolean[3];
    }
    
    public GroupSubject() {
        this.empty = true;
    }

    public Subject getSubject() {
        return subject;
    }

    public Group getGroup() {
        return group;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
    
    public void setLaboratory(){
        type[LABORATORY] = true;
    }
    
    public void setProblems(){
        type[PROBLEMS] = true;
    }
    
    public void unsetTheory(){
        type[THEORY] = false;
    }
    
    public void unsetLaboratory(){
        type[LABORATORY] = false;
    }
    
    public void unsetProblems(){
        type[PROBLEMS] = false;
    }
    
    public boolean isTheory() {
        return type[THEORY];
    }
    
    public boolean isLaboratory() {
        return type[LABORATORY];
    }
    
    public boolean isProblems() {
        return type[PROBLEMS];
    }
    
    public int getNumGroup() {
        return group.getNum();
    }
    
    public String getNameSubject() {
        return subject.getName();
    }
    
    public boolean isSubGroup(){
        return group.isSubGroup();
    }
}
