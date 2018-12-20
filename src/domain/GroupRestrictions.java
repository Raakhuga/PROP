
package domain;

import java.util.HashSet;
import java.util.Set;


public class GroupRestrictions {
    private boolean banned;
    private boolean out;
    private Set<String> bannedSubjects;
    private Set<String> bannedClassrooms;

    public GroupRestrictions() {
        this.banned = false;
        this.out = false;
        this.bannedSubjects = new HashSet<>();
        this.bannedClassrooms = new HashSet<>();
    }
    
    public boolean isBanned() {
        return banned;
    }
    
    public void setOut(boolean out){
        this.out = out;
    }
    
    public boolean isOut() {
        return out;
    }

    public Set<String> getBannedSubjects() {
        return bannedSubjects;
    }

    public Set<String> getBannedClassrooms() {
        return bannedClassrooms;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public void setBannedSubjects(Set<String> bannedSubjects) {
        this.bannedSubjects = bannedSubjects;
    }

    public void setBannedClassrooms(Set<String> bannedClassrooms) {
        this.bannedClassrooms = bannedClassrooms;
    }
    
    public void ban() {
        banned = true;
    }
    
    public void unban() {
        banned = false;
    }
    
    public void banSubject(String subject) {
        bannedSubjects.add(subject);
    }
    
    public void unbanSubject(String subject) {
        bannedSubjects.remove(subject);
    }
    
    public void banClassroom(String classroom) {
        bannedClassrooms.add(classroom);
    }
    
    public void unbanClassroom(String classroom) {
        bannedClassrooms.remove(classroom);
    }
    
    public boolean isSubjectBanned(String name) {
        return bannedSubjects.contains(name);
    }
    
    public boolean isClassroomBanned(String ref) {
        return bannedClassrooms.contains(ref);
    }
}
