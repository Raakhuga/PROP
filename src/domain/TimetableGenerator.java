
package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class TimetableGenerator {
    private final static int NUM_OF_SUBGROUPS = 5;
            
    public List<Classroom> classrooms;
    public List<StudyProgram> programs;
    public List<Group> groups;
    public List<GroupSubject> problem;
    public int nMaxStudentsGroup;
    public int nMaxStudentsSubgroup;
        
    public TimetableGenerator() {
        this.classrooms = new ArrayList<Classroom>();
        this.programs = new ArrayList<StudyProgram>();
        this.groups = new ArrayList<Group>();
    }
    
    public void manualLoad() {
        Scanner in = new Scanner(System.in);
        String ref, type, name;
        int nClassrooms, nSP, nGroups, capacity, nDays, hIni, hEnd, nLevels, id;
        boolean theory, lab, problems;
        System.out.println ("Insert the number of maximum Students that a Group can have");
        nMaxStudentsGroup = in.nextInt();
        System.out.println ("Insert the number of maximum Students that a SubGroup can have");
        nMaxStudentsSubgroup = in.nextInt();
        System.out.println ("Insert the number of available Classrooms");
        nClassrooms = in.nextInt();
        for(int i = 0; i < nClassrooms; i++) {
            System.out.println("Insert the reference of the Classroom number: " + i);
            ref = in.next();
            System.out.println("Insert the capacity of the Classroom number: " + i);
            capacity = in.nextInt();
            System.out.println("Insert the number of availabe days for the Classroom number: " + i);
            nDays = in.nextInt();
            System.out.println("Insert the first available hour and the last one of the Classroom number: " + i);
            hIni = in.nextInt();
            hEnd = in.nextInt();
            System.out.println("Insert the type of the Classroom number: " + i);
            type = in.next();
            if(type == "theory" ||type == "Theory") {
                theory = true;
                lab = false; 
                problems = false;
            }
            else if (type == "laboratory" || type == "Laboratory" || type == "lab" || type == "Lab") {
                theory = false;
                lab = true; 
                problems = false;
            }
            else {
                theory = false;
                lab = false; 
                problems = true;
            }
            addClassroom(capacity, ref, nDays, hIni, hEnd, theory, lab, problems);
        }
        System.out.println ("Insert the number of available StudyPrograms");
        nSP = in.nextInt();
        for(int i = 0; i < nSP; i++) {
            System.out.println ("Insert the name of the StudyProgam number: " + i);
            name = in.next();
            System.out.println ("Insert the number of Levels of the StudyProgram number: " + i);
            nLevels = in.nextInt();
            addStudyProgram(name, nLevels, true);
        }
        /*System.out.println ("Insert the number of available Groups");
        nGroups = in.nextInt();
        for(int i = 0; i < nGroups; i++) {
            System.out.println ("Insert the identifier of the Group number: " + i);
            id = in.nextInt();
            System.out.println ("Insert the number of available days for the Group: " + id);
            nDays = in.nextInt();
            System.out.println ("Insert the fisrt available hour and the last one of the Group: " + i);
            hIni = in.nextInt();
            hEnd = in.nextInt();
            addGroup(id, nDays, hIni, hEnd);
        }*/       
    }
    
    public void generateAllGroups(StudyProgram SP) {
        Map<Integer,Level> levels = SP.getLevels();
        Iterator<Level> it = levels.values().iterator();
        List<Subject> subjects;
        int nGroups, nSubGroups, nStudents, i, remaining;
        Subject sact;
        Scanner in = new Scanner(System.in);
        while(it.hasNext()) {
            Level act = it.next();
            subjects = act.getSubjects();
            Iterator<Subject> it2 = subjects.iterator();
            i = 1;
            while(it2.hasNext()){
                sact = it2.next();
                System.out.println("Insert the number of Students that will course the Subject: " + sact.getName());
                nStudents = in.nextInt();
                nGroups = nStudents/nMaxStudentsGroup;
                if (nStudents%nMaxStudentsGroup != 0) nGroups++;
                for(remaining = nStudents; remaining > nMaxStudentsGroup; remaining -= nMaxStudentsGroup){
                    act.addGroup(i*10, nMaxStudentsGroup, nMaxStudentsSubgroup);
                }
                if (remaining > 0) act.addGroup(i*10, remaining, nMaxStudentsSubgroup);
                i++;
            }
        }
    }
    
    public void generateAllGS() {
        Iterator<StudyProgram> SPit = programs.iterator();
        while(SPit.hasNext()) {
            StudyProgram SPact = SPit.next();
            Map<Integer, Level> levels = SPact.getLevels();
            int SPsize = levels.size();
            for(int i = 0; i < SPsize; i++) {
                List<Group> groups = levels.get(i).getGroups();
                Iterator<Group> Git = groups.iterator();
                while(Git.hasNext()) {
                    Group Gact = Git.next();
                    List<Subject> subjects = levels.get(i).getSubjects();
                    Iterator<Subject> Sit = subjects.iterator();
                    while(Sit.hasNext()) {
                        Subject Sact = Sit.next();
                        List<subGroup> subGroups = Gact.getsubGroups();
                        Iterator<subGroup> SGit = subGroups.iterator();
                        for(int j = 0; j < Sact.getTheoryH(); j++) 
                            problem.add(new GroupSubject(Sact, Gact, Gact.getnMat(), true, false, false));
                        while(SGit.hasNext()) {
                            subGroup SGact = SGit.next();
                            for(int j = 0; j < Sact.getLaboratoryH(); j++)
                                problem.add(new GroupSubject(Sact, SGact, SGact.getnMat(), false, true, false));
                            for(int j = 0; j < Sact.getProblemsH(); j++)
                                problem.add(new GroupSubject(Sact, SGact, SGact.getnMat(), false, false, true));
                        }
                    }
                }
            }
        }
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
    
    public void addStudyProgram(String name, int nLevels, boolean manual){
        StudyProgram aux = new StudyProgram(name);
        for (int i = 0; i < nLevels; i++) aux.addLevels(manual);
        programs.add(aux);
    }
    
    /*public void addGroup(int num, int nDays, int hIni, int hEnd) {
        Group aux = new Group(num, nDays, hIni, hEnd); 
        groups.add(aux);
        for(int i = 1; i <= NUM_OF_SUBGROUPS; i++) groups.add(new subGroup(num+i, num, aux.getTimetable()));
    }*/
    
    public void addSubject() {}
    
    public void generate() {
        /*if (res.base) add;
        else error;*/
    }
    
}
