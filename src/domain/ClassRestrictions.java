
package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ClassRestrictions {
    private boolean banned;
    private boolean out;
    private List<String> bannedSubjects;
    private List<Integer> bannedGroups;

    public ClassRestrictions() {
        this.banned = false;
        this.out = false;
        this.bannedSubjects = new ArrayList<>();
        this.bannedGroups = new ArrayList<>();
    }
    
    public boolean isBanned() {
        return banned;
    }
    
    public boolean isOut() {
        return out;
    }

    public List<String> getBannedSubjects() {
        return bannedSubjects;
    }

    public List<Integer> getBannedClassrooms() {
        return bannedGroups;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }
    
    public void setOut(boolean out) {
        this.out = out;
    }

    public void setBannedSubjects(List<String> bannedSubjects) {
        this.bannedSubjects = bannedSubjects;
    }

    public void setBannedClassrooms(List<Integer> bannedGroups) {
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
        System.out.println(bannedSubjects.get(0));
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
