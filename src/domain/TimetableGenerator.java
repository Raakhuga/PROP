
package domain;

import java.util.ArrayList;
import java.util.List;


public class TimetableGenerator {
    public List<Classroom> classrooms;
    public List<StudyProgram> programs;
    public List<Group> groups;
        
    public TimetableGenerator() {
        this.classrooms = new ArrayList<Classroom>();
        this.programs = new ArrayList<StudyProgram>();
        this.groups = new ArrayList<Group>();
    }
    
    public void load() {
        
    }        
    
    public void save() {
    
    }
    
    public void modify() {
        /*
        subGroup sub = new subGroup(10, 11, new Timetable(5, 8, 20));
        Level level = new Level(3);
        Subject subject = new Subject("Mates", level);
        GroupSubject gsnew = new GroupSubject(subject, sub, 20, false, true, false);*/
    }
    
    public void addClassroom(int capacity, String ref, int nDays, int hIni, int hEnd, boolean theory, boolean lab, boolean problems) {
        classrooms.add(new Classroom(capacity, ref, nDays, hIni, hEnd, theory, lab, problems));
    }
    
    public void addStudyProgram(String name, int nLevels){
        programs.add(new StudyProgram(name, nLevels));
    }
    
    public void addGroup(int num, int nDays, int hIni, int hEnd) {
        groups.add(new Group(num, nDays, hIni, hEnd));
    }
    
    public void addSubject() {}
    
    public void generate() {
        /*if (res.base) add;
        else error;*/
    }
    
}
