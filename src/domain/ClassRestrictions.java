
package domain;

import java.util.HashSet;
import java.util.Set;


public class ClassRestrictions {
    private boolean banned;
    private Set<String> bannedSubjects;
    private Set<Integer> bannedGroups;

    public ClassRestrictions() {
        this.banned = false;
        this.bannedSubjects = new HashSet<>();
        this.bannedGroups = new HashSet<>();
    }
    
    public boolean isBanned() {
        return banned;
    }

    public Set<String> getBannedSubjects() {
        return bannedSubjects;
    }

    public Set<Integer> getBannedClassrooms() {
        return bannedGroups;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public void setBannedSubjects(Set<String> bannedSubjects) {
        this.bannedSubjects = bannedSubjects;
    }

    public void setBannedClassrooms(Set<Integer> bannedGroups) {
        this.bannedGroups = bannedGroups;
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
    
    public void banGroup(int group) {
        bannedGroups.add(group);
    }
    
    public void unbanGroup(int group) {
        bannedGroups.remove(group);
    }
    
    public boolean isSubjectBanned(String name) {
        return bannedSubjects.contains(name);
    }
    
    public boolean isGroupBanned(int num) {
        return bannedGroups.contains(num);
    }
}
