
package domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;


public class TimetableGenerator {
    private final static int NUM_OF_SUBGROUPS = 5;
            
    private List<Classroom> classrooms;
    private List<StudyProgram> programs;
    private List<GroupSubject> problem;
    private int nMaxStudentsGroup;
    private int nMaxStudentsSubgroup;
    private CTRLRestrictions ctrlRestrictions;
        
    public TimetableGenerator() {
        this.classrooms = new ArrayList<>();
        this.programs = new ArrayList<>();
        this.problem = new ArrayList<>();
        this.ctrlRestrictions = new CTRLRestrictions();
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public List<StudyProgram> getPrograms() {
        return programs;
    }

    public List<GroupSubject> getProblem() {
        return problem;
    }

    public int getnMaxStudentsGroup() {
        return nMaxStudentsGroup;
    }

    public int getnMaxStudentsSubgroup() {
        return nMaxStudentsSubgroup;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public void setPrograms(List<StudyProgram> programs) {
        this.programs = programs;
    }

    public void setProblem(List<GroupSubject> problem) {
        this.problem = problem;
    }

    public void setnMaxStudentsGroup(int nMaxStudentsGroup) {
        this.nMaxStudentsGroup = nMaxStudentsGroup;
    }

    public void setnMaxStudentsSubgroup(int nMaxStudentsSubgroup) {
        this.nMaxStudentsSubgroup = nMaxStudentsSubgroup;
    }
    
    public void generateAllGS() {
        Iterator<StudyProgram> SPit = programs.iterator();
        while(SPit.hasNext()) {
            StudyProgram SPact = SPit.next();
            List<Level> levels = SPact.getLevels();
            Iterator<Level> Lit = levels.iterator();
            while(Lit.hasNext()) {
                Level Lact = Lit.next();
                List<Subject> subjects = Lact.getSubjects();
                Iterator<Subject> Sit = subjects.iterator();
                while(Sit.hasNext()) {
                    Subject Sact = Sit.next();
                    List<Group> groups = Sact.getGroups();
                    Iterator<Group> Git = groups.iterator();
                    while(Git.hasNext()) {
                        Group Gact = Git.next();
                        List<subGroup> subGroups = Gact.getSubGroups();
                        Iterator<subGroup> SGit = subGroups.iterator();
                        for(int j = 0; j < Sact.getTheoryH(); j++) {
                            GroupSubject aux = new GroupSubject(Sact, Gact);
                            aux.setTheory();
                            problem.add(aux);
                        }
                        while(SGit.hasNext()) {
                            subGroup SGact = SGit.next();
                            for(int j = 0; j < Sact.getLaboratoryH(); j++) {
                                GroupSubject aux = new GroupSubject(Sact, SGact);
                                aux.setLaboratory();
                                problem.add(aux);
                            }
                            for(int j = 0; j < Sact.getProblemsH(); j++) {
                                GroupSubject aux = new GroupSubject(Sact, SGact);
                                aux.setProblems();
                                problem.add(aux);
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void addClassroom(int capacity, String ref, int dIni, int dEnd, int hIni, int hEnd) {
        classrooms.add(new Classroom(ref, capacity, dIni, dEnd, hIni, hEnd));
    }
    
    public void addStudyProgram(String name){
        programs.add(new StudyProgram(name));
    }
    
    public void addLevel(StudyProgram SP) {
        SP.addLevel();
    }
    
    public void addSubject(Level level, String name) {
        level.addSubject(name);
    }
    
    public void addGroup(Subject subject, int dIni, int dEnd, int hIni, int hEnd, int num, int enrolled) {
        subject.addGroup(new Group (dIni, dEnd, hIni, hEnd, num, enrolled));
    }
    
    public void addSubGroup(Group group, int num, int enrolled) {
        group.addSubGroup(new subGroup(group, num, enrolled));
    }
    
    public void addToTimetable(Classroom c, Group g, GroupSubject GS, ClassSubject CS, int day, int hour) {
        c.addToClassTimetable(GS, day, hour);
        g.addToGroupTimetable(CS, day, hour);
    }
    
    public void removeFromClassTimetable() {
    
    }
    
    public void removeFromGroupTimetable() {
    
    }
    
    public void removeFromTimetable() {
        
    }
}
