
package domain;

import java.util.List;


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
        for(int i = 0; i < 3; i++) type[i] = false;
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
    
    public int getEnrolled() {
        return group.getEnrolled();
    }
    
    public int getdIni() {
        return group.getdIni();
    }
    
    public int gethIni() {
        return group.gethIni();
    }
    
    public int getdEnd() {
        return group.getdEnd();
    }
    
    public int gethEnd() {
        return group.gethEnd();
    }
    
    public List<subGroup> getSubGroups() {
        return group.getSubGroups();
    }

    public boolean isEmpty() {
        return empty;
    }
    
    public boolean isGroupEmpty(int day, int hour) {
        return group.isEmpty(day,hour);
    }
    
    public boolean isSubjectBanned(int day, int hour, String name) {
        return group.isSubjectBanned(day, hour, name);
    }
    
    public boolean isClassroomBanned(int day, int hour, String ref) {
        return group.isClassroomBanned(day, hour, ref);
    }
    
    public boolean isBanned(int day, int hour) {
        return group.isBanned(day, hour);
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
        
    public void setTheory(){
        type[THEORY] = true;
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
