
package domain;

import java.util.HashSet;
import java.util.Set;


public class ClassRestrictions {
    private boolean banned;
    private Set<String> bansubjects;
    private Set<Integer> groups;
    
    public ClassRestrictions() {
        banned = false;
        groups = new HashSet<Integer>();
    }
    
    public void setBanned(boolean banned) {
        this.banned = banned;
    }
    
    public void banGroup(int num) {
        groups.add(num);
    }
    
    public void banSubject(String name) {
        bansubjects.add(name);
    }

    public void unbanGroup(int num) {
        groups.remove(num);
    }
    
    public void unbanSubject(String name) {
        bansubjects.remove(name);
    }
   
    public boolean subjectBanned(String name) {
        return bansubjects.contains(name);
    }
    
    public boolean groupBanned(int num) {
        return groups.contains(num);
    }
    
    public boolean getBanned() {
        return banned;
    }
}
