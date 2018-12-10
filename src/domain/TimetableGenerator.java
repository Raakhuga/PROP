
package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class TimetableGenerator {            
    private List<Classroom> classrooms;
    private List<StudyProgram> programs;
    private List<GroupSubject> problem;
    private final int nMaxStudentsGroup;
    private final int nMaxStudentsSubgroup;
    private CTRLRestrictions ctrlRestrictions;
        
    public TimetableGenerator(int nMaxStudentsGroup, int nMaxStudentsSubgroup) {
        this.classrooms = new ArrayList<>();
        this.programs = new ArrayList<>();
        this.problem = new ArrayList<>();
        this.ctrlRestrictions = new CTRLRestrictions();
        this.nMaxStudentsGroup = nMaxStudentsGroup;
        this.nMaxStudentsSubgroup = nMaxStudentsSubgroup;
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
        if(g.isSubGroup()){
            subGroup aux = (subGroup)g;
            aux.addToGroupTimetable(CS, day, hour);
        }
        else g.addToGroupTimetable(CS, day, hour);
    }
    
    public void removeFromTimetable(Classroom c, Group g, int day, int hour) {
        c.removeFromClassTimetable(day, hour);
        g.removeFromGroupTimetable(day, hour);
    }
    
    public void generateTimetable() {
        if (classrooms.size() > 0) {
            Classroom aux = classrooms.get(0);
            if(i_generateTimetable(0, 0)) System.out.println("S'ha generat l'horari correctament");
            else System.out.println("No es pot generar l'horari");
        }
    }
    
    public boolean i_generateTimetable(int pos_classroom, int pos_problem) {
        if (pos_problem >= problem.size()) return false;
        if (pos_classroom >= classrooms.size()) return false;
        GroupSubject GS = problem.get(pos_problem);
        Classroom classroom = classrooms.get(pos_classroom);
        for (int i = classroom.getdIni(); i < classroom.getdEnd(); i++) {
            for (int j = classroom.gethIni(); j < classroom.gethEnd(); j++) {
                if (ctrlRestrictions.classroomRestrictions(i, j, classroom, GS)) {
                    if (ctrlRestrictions.groupRestrictions(i, j, classroom, GS)) {
                        addToTimetable(classroom, GS.getGroup(), GS, new ClassSubject(classroom, GS.getSubject()), i, j);
                        if(pos_problem+1 < problem.size()) {
                            return i_generateTimetable(0, pos_problem+1);
                        }
                        removeFromTimetable(classroom, GS.getGroup(), i, j);
                    }
                }
            }
        }
        if (pos_problem +1 < problem.size()) 
            if(pos_classroom+1 < classrooms.size()) i_generateTimetable(pos_classroom+1, pos_problem);
            else return false;
        return true;
    }
    
    public String saveClassrooms() {
        Iterator<Classroom> Cit = classrooms.iterator();
        String classrooms = "Classrooms:\n";
        while(Cit.hasNext()) {
            Classroom Cact = Cit.next();
            String classroom = (Cact.saveClassroom() + "\n");
            classrooms = classrooms + classroom;
        }
        return classrooms;
    }
    
    public String saveStudyPrograms() {
        Iterator<StudyProgram> SPit = programs.iterator();
        String studyprograms = "";
        while(SPit.hasNext()) {
            StudyProgram SPact = SPit.next();
            
            String studyprogram = SPact.getName() + "\n";
            studyprogram = studyprogram + "Levels\n";
            studyprogram = studyprogram + SPact.getnLevels() + "\n";
            studyprogram = studyprogram + SPact.saveLevels() + "\n";
            studyprograms = studyprograms + studyprogram;
        }
        return studyprograms;
    }
}
