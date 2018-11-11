/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hasee
 */
public class Restrictions {
    public boolean banned;
    public List<String> bansubjects;
    public List<Integer> groups;
    public List<String> banclassrooms;
    
    public Restrictions() {
        banned = false;
        bansubjects = new ArrayList<String>();
        groups = new ArrayList<Integer>();
        banclassrooms = new ArrayList<String>();
    }
    
    public void setBanned(boolean banned) {
        this.banned = banned;
    }
    
    public void addClassroom(String ref){
        banclassrooms.add(ref);
    }
    public void addGroup(int num) {
        groups.add(num);
    }
    public void addSubject(String name) {
        bansubjects.add(name);
    }
     public void deleteClassroom(String ref){
        banclassrooms.remove(ref);
    }
    public void deleteGroup(int num) {
        groups.remove(num);
    }
    public void deleteSubject(String name) {
        bansubjects.remove(name);
    }
}
