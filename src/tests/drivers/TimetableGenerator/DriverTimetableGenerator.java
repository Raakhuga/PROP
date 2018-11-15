
package tests.drivers.TimetableGenerator;
import domain.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static tests.drivers.GroupRestrictions.DriverGroupRestrictions.bannedclassrooms;
import static tests.drivers.GroupRestrictions.DriverGroupRestrictions.bansubjects;

public class DriverTimetableGenerator {
    
    private static TimetableGenerator p = new TimetableGenerator();
    
    
    public static void addClassroom(TimetableGenerator TG, int capacity, String ref, int nDays, int hIni, int hEnd, boolean theory, boolean lab, boolean problems) {
        TG.getClassrooms().add(new Classroom(capacity, ref, nDays, hIni, hEnd, theory, lab, problems));
    }
    
    public static void addStudyProgram(TimetableGenerator TG, String name, int nLevels, boolean manual){
        StudyProgram aux = new StudyProgram(name);
        for (int i = 0; i < nLevels; i++) aux.addLevels(manual);
        TG.getPrograms().add(aux);
    }
    
    public static void generateAllGS(TimetableGenerator TG) {
        Iterator<StudyProgram> SPit = TG.getPrograms().iterator();
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
                            TG.getProblem().add(new GroupSubject(Sact, Gact, Gact.getnMat(), true, false, false));
                        while(SGit.hasNext()) {
                            subGroup SGact = SGit.next();
                            for(int j = 0; j < Sact.getLaboratoryH(); j++)
                                TG.getProblem().add(new GroupSubject(Sact, Gact, SGact, SGact.getnMat(), false, true, false));
                            for(int j = 0; j < Sact.getProblemsH(); j++)
                                TG.getProblem().add(new GroupSubject(Sact, Gact, SGact, SGact.getnMat(), false, false, true));
                        }
                    }
                }
            }
        }
    }
    
    public static void addGroup(Level level, int id, int nStudentsGroup, int nMaxStudentsSubgroups) {
        int nDays, hIni, hEnd, nSubGroups, remaining;
        Scanner in = new Scanner(System.in);
        System.out.println ("Insert the number of available days for the Group: " + id);
        nDays = in.nextInt();
        System.out.println ("Insert the fisrt available hour and the last one of the Group: " + id);
        hIni = in.nextInt();
        hEnd = in.nextInt();
        Group actualGroup = new Group(id, nDays, hIni, hEnd, nStudentsGroup);
        nSubGroups = nStudentsGroup / nMaxStudentsSubgroups;
        if (nStudentsGroup % nMaxStudentsSubgroups != 0) nSubGroups++;
        //añadir subrupos
        int i = 1;
        for(remaining = nStudentsGroup; remaining > nMaxStudentsSubgroups; remaining -= nMaxStudentsSubgroups){
            actualGroup.addSubGroup(new subGroup(id+i, nDays, hIni, hEnd, nMaxStudentsSubgroups));
            i++;
        }
        if (remaining > 0) actualGroup.addSubGroup(new subGroup(id+i, nDays, hIni, hEnd, remaining)); 
        level.getGroups().add(actualGroup);
    }
    
    public static void generateAllGroups(StudyProgram SP, int nMaxStudentsGroup, int nMaxStudentsSubgroup) {
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
                    addGroup(act, i*10, nMaxStudentsGroup, nMaxStudentsSubgroup);
                }
                if (remaining > 0) addGroup(act, i*10, remaining, nMaxStudentsSubgroup);
                i++;
            }
        }
    }
    
    public static void manualLoad(TimetableGenerator TG) {
        Scanner in = new Scanner(System.in);
        String ref, type, name;
        int nClassrooms, nSP, nGroups, capacity, nDays, hIni, hEnd, nLevels, id;
        boolean theory, lab, problems;
        System.out.println ("Insert the number of maximum Students that a Group can have");
        TG.setnMaxStudentsGroup(in.nextInt());
        System.out.println ("Insert the number of maximum Students that a SubGroup can have");
        TG.setnMaxStudentsSubgroup(in.nextInt());
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
            addClassroom(TG, capacity, ref, nDays, hIni, hEnd, theory, lab, problems);
        }
        System.out.println ("Insert the number of available StudyPrograms");
        nSP = in.nextInt();
        for(int i = 0; i < nSP; i++) {
            System.out.println ("Insert the name of the StudyProgam number: " + i);
            name = in.next();
            System.out.println ("Insert the number of Levels of the StudyProgram number: " + i);
            nLevels = in.nextInt();
            addStudyProgram(TG, name, nLevels, true);
        }
        Iterator<StudyProgram> it = TG.getPrograms().iterator();
        while(it.hasNext()) generateAllGroups(it.next(), TG.getnMaxStudentsGroup(), TG.getnMaxStudentsSubgroup());
    }
    
    
    public static void main(String[] args) throws Exception{
        manualLoad(p);
        driverGR();
        
    }
    
    private static void driverGR(){
        
        
    }
}
