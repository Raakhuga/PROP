
package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import persistance.PersistanceCtrl;


public class TimetableGenerator {            
    private List<Classroom> classrooms;
    private List<StudyProgram> programs;
    private List<GroupSubject> problem;
    private List<String> addedRestrictions;
    private int nMaxStudentsGroup;
    private int nMaxStudentsSubgroup;
    private CTRLRestrictions ctrlRestrictions;
    private PersistanceCtrl persistancectrl;
        
    public TimetableGenerator(int nMaxStudentsGroup, int nMaxStudentsSubgroup) {
        this.classrooms = new ArrayList<>();
        this.programs = new ArrayList<>();
        this.problem = new ArrayList<>();
        this.addedRestrictions = new ArrayList<>();
        this.ctrlRestrictions = new CTRLRestrictions(this);
        this.nMaxStudentsGroup = nMaxStudentsGroup;
        this.nMaxStudentsSubgroup = nMaxStudentsSubgroup;
        this.persistancectrl = new PersistanceCtrl();
    }
    
    public TimetableGenerator() {
        this.classrooms = new ArrayList<>();
        this.programs = new ArrayList<>();
        this.problem = new ArrayList<>();
        this.addedRestrictions = new ArrayList<>();
        this.ctrlRestrictions = new CTRLRestrictions(this);
        this.nMaxStudentsGroup = -1;
        this.nMaxStudentsSubgroup = -1;
        this.persistancectrl = new PersistanceCtrl();
    }
    
    public void setnMaxStudentsGroup(int nMaxStudentsGroup) {
        this.nMaxStudentsGroup = nMaxStudentsGroup;
    }
    
    public void setnMaxStudentsSubgroup(int nMaxStudentsSubgroup) {
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
    
    public void setrBase(boolean[] rBase) {
        ctrlRestrictions.setrBase(rBase);
    }
    
    public void setrExtra(boolean[] rExtra) {
        ctrlRestrictions.setrExtra(rExtra);
    }
    
    public Classroom addClassroom(int capacity, String ref, int dIni, int dEnd, int hIni, int hEnd) {
        Classroom classroom = new Classroom(ref, capacity, dIni, dEnd, hIni, hEnd);
        classrooms.add(classroom);
        return classroom;
    }
    
    public StudyProgram addStudyProgram(String name){
        StudyProgram program = new StudyProgram(name);
        programs.add(program);
        return program;
    }
    
    public Level addLevel(StudyProgram SP) {
        return SP.addLevel();
    }
    
    public Subject addSubject(Level level, String name) {
        return level.addSubject(name);
    }
    
    public Group addGroup(Subject subject, int dIni, int dEnd, int hIni, int hEnd, int num, int enrolled) {
        Group group = new Group (dIni, dEnd, hIni, hEnd, num, enrolled); 
        subject.addGroup(group);
        return group;
    }
    
    public subGroup addSubGroup(Group group, int num, int enrolled) {
        subGroup sgroup = new subGroup(group, num, enrolled);
        group.addSubGroup(sgroup);
        return sgroup;
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
    
    public void ban(Group g, int dIni, int dEnd, int hIni, int hEnd) {
        g.ban(dIni, dEnd, hIni, hEnd);
    }
    
    public void ban(Classroom c, int dIni, int dEnd, int hIni, int hEnd) {
        c.ban(dIni, dEnd, hIni, hEnd);
    }
    
    public void unban(Group g, int dIni, int dEnd, int hIni, int hEnd) {
        g.unban(dIni, dEnd, hIni, hEnd);
    }
    
    public void unban(Classroom c, int dIni, int dEnd, int hIni, int hEnd) {
        c.unban(dIni, dEnd, hIni, hEnd);
    }
    
    public void banSubject(Group g, int dIni, int dEnd, int hIni, int hEnd, String subject) {
        g.banSubject(dIni, dEnd, hIni, hEnd, subject);
    }
    
    public void banSubject(Classroom c, int dIni, int dEnd, int hIni, int hEnd, String subject) {
        c.banSubject(dIni, dEnd, hIni, hEnd, subject);
    }
    
    public void unbanSubject(Group g, int dIni, int dEnd, int hIni, int hEnd, String subject) {
        g.unbanSubject(dIni, dEnd, hIni, hEnd, subject);
    }
    
    public void unbanSubject(Classroom c, int dIni, int dEnd, int hIni, int hEnd, String subject) {
        c.unbanSubject(dIni, dEnd, hIni, hEnd, subject);
    }
    
    public void banClassroom(Group g, int dIni, int dEnd, int hIni, int hEnd, String ref) {
        g.banClassroom(dIni, dEnd, hIni, hEnd, ref);
    }

    public void unbanClassroom(Group g, int dIni, int dEnd, int hIni, int hEnd, String ref) {
        g.unbanClassroom(dIni, dEnd, hIni, hEnd, ref);
    }
    
    public void banGroup(Classroom c, int dIni, int dEnd, int hIni, int hEnd, int num) {
        c.banGroup(dIni, dEnd, hIni, hEnd, num);
    }
    
    public void unbanGroup(Classroom c, int dIni, int dEnd, int hIni, int hEnd, int num) {
        c.unbanGroup(dIni, dEnd, hIni, hEnd, num);
    }
    
    public void setCapacity(Classroom c, int capacity) {
        c.setCapacity(capacity);
    }
    
    public void setRef(Classroom c, String ref) {
        c.setRef(ref);
    }
    
    public void setdIni(Classroom c, int dIni) {
        c.setdIni(dIni);
    }
    
    public void setdEnd(Classroom c, int dEni) {
        c.setdEnd(dEni);
    }
    
    public void sethIni(Classroom c, int hIni) {
        c.sethIni(hIni);
    }
    
    public void sethEnd(Classroom c, int hEnd) {
        c.sethEnd(hEnd);
    }
    
    public void removeClassroom(int id) {
        classrooms.remove(classrooms.get(id));
    }
    
    public void setTheory(Classroom c, boolean state) {
        if(state) c.setTheory();
    }
    public void setLaboratory(Classroom c, boolean state) {
        if(state) c.setLaboratory();
    }
    public void setProblems(Classroom c, boolean state) {
        if(state) c.setProblems();
    }
    
    public boolean isTheory(Classroom c) {
        return c.isTheory();
    }
    
    public boolean isLaboratory(Classroom c) {
        return c.isLaboratory();
    }
    
    public boolean isProblems(Classroom c) {
        return c.isProblems();
    }
    
    public void generateTimetable() {
        if (classrooms.size() > 0) {
            Classroom aux = classrooms.get(0);
            if(i_generateTimetable(0, 0)) System.out.println("S'ha generat l'horari correctament");
            else System.out.println("No es pot generar l'horari");
        }
    }
    
    public boolean i_generateTimetable(int pos_classroom, int pos_problem) {
        if (pos_problem >= problem.size()) return true;
        if (pos_classroom >= classrooms.size()) return false;
        GroupSubject GS = problem.get(pos_problem);
        Classroom classroom = classrooms.get(pos_classroom);
        for (int i = classroom.getdIni(); i < classroom.getdEnd(); i++) {
            for (int j = classroom.gethIni(); j < classroom.gethEnd(); j++) {
                if (ctrlRestrictions.classroomRestrictions(i, j, classroom, GS)) {
                    if (ctrlRestrictions.groupRestrictions(i, j, classroom, GS)) {
                        addToTimetable(classroom, GS.getGroup(), GS, new ClassSubject(classroom, GS.getSubject()), i, j);
                        if (!i_generateTimetable(0, pos_problem+1)) {
                            removeFromTimetable(classroom, GS.getGroup(), i, j);
                            return false;
                        }
                        else return true;
                    }
                }
            }
        }
        return i_generateTimetable(pos_classroom+1, pos_problem);
    }
    
    public String saveClassrooms() {
        Iterator<Classroom> Cit = classrooms.iterator();
        String classes = classrooms.size() + "\n" + "Classrooms:";
        while(Cit.hasNext()) {
            Classroom Cact = Cit.next();
            String classroom = "\n" + "  " + Cact.saveClassroom();
            classes = classes + classroom;
        }
        return classes + "\n";
    }
    
    public String saveStudyPrograms() {
        Iterator<StudyProgram> SPit = programs.iterator();
        String studyprograms = programs.size() + "\n" + "StudyPrograms:";
        while(SPit.hasNext()) {
            StudyProgram SPact = SPit.next();
            String studyprogram = "\n" + "  " + SPact.getName();
            studyprogram = studyprogram + "\n" + "  " + SPact.saveLevels();
            studyprograms = studyprograms + studyprogram;
        }
        return studyprograms + "\n";
    }
    
    public String saveRestrictions() {
        return "Restrictions:\n" + "  " + ctrlRestrictions.saveRestrictions() + "\n";
    }
    
    public String saveSizes() {
        return "Max_num_of_students_in_a_group: " + nMaxStudentsGroup + "\n" + "Max_num_of_students_in_a_subgroup: " + nMaxStudentsSubgroup + "\n";
    }
    
    public void loadState(String path) {
        persistancectrl.load(this, path);
    }
    
    public void saveState(String path) {
        persistancectrl.save(this, path);
    }
}
