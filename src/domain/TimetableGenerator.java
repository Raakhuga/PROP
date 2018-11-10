
package domain;


public class TimetableGenerator {
    public Classroom[] classrooms;
    public StudyProgram[] programs;
    public Group[] groups;
        
    public TimetableGenerator(Classroom[] classes, StudyProgram[] programs, Group[] groups) {
        this.classrooms = classes;
        this.programs = programs;
        this.groups = groups;
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
    
    public void generate() {
        if (res.base) add;
        else error;
    }
    
}
