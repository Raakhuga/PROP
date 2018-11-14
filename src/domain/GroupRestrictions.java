
package domain;

import java.util.HashSet;
import java.util.Set;


public class GroupRestrictions {
    private boolean banned;
    private Set<String> bansubjects;
    private Set<String> banclassrooms;
    
    public GroupRestrictions() {
        banned = false;
        bansubjects = new HashSet<String>();
        banclassrooms = new HashSet<String>();
    }
    
    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public void banClassroom(String ref){
        banclassrooms.add(ref);
    }

    public void banSubject(String name) {
        bansubjects.add(name);
    }
    
    public void unbanClassroom(String ref){
        banclassrooms.remove(ref);
    }
     
    public void unbanSubject(String name) {
        bansubjects.remove(name);
    }
   
    public boolean subjectBanned(String name) {
        return bansubjects.contains(name);
    }
    
    public boolean classroomBanned(String ref) {
        return banclassrooms.contains(ref);
    }

    public boolean getBanned() {
        return banned;
    }
}
