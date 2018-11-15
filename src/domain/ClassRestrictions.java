
package domain;

import java.util.HashSet;
import java.util.Set;


public class ClassRestrictions {
    private boolean free;
    private boolean banned;
    private Set<String> bansubjects;
    private Set<Integer> groups;
    
    public ClassRestrictions() {
        banned = false;
        free = true;
        bansubjects = new HashSet<String>();
        groups = new HashSet<Integer>();
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Set<String> getBansubjects() {
        return bansubjects;
    }

    public Set<Integer> getGroups() {
        return groups;
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
