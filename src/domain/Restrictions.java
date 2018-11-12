/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author hasee
 */
public class Restrictions {
    private boolean banned;
    private Set<String> bansubjects;
    private Set<String> banclassrooms;
    private Set<Integer> groups;
    
    public Restrictions() {
        banned = false;
        bansubjects = new HashSet<String>();
        banclassrooms = new HashSet<String>();
        groups = new HashSet<Integer>();
    }
    
    public void setBanned(boolean banned) {
        this.banned = banned;
    }
    
    public void banClassroom(String ref){
        banclassrooms.add(ref);
    }
    
    public void banGroup(int num) {
        groups.add(num);
    }
    
    public void banSubject(String name) {
        bansubjects.add(name);
    }
    
    public void unbanClassroom(String ref){
        banclassrooms.remove(ref);
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
    
    public boolean classroomBanned(String ref) {
        return banclassrooms.contains(ref);
    }
    
    public boolean groupBanned(int num) {
        return groups.contains(num);
    }
    
    public boolean getBanned() {
        return banned;
    }
}
