
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

    public void setCtrlRestrictions(CTRLRestrictions ctrlRestrictions) {
        this.ctrlRestrictions = ctrlRestrictions;
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
        Iterator<StudyProgram> it = programs.iterator();
        while(it.hasNext()) generateAllGroups(it.next());
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
                                problem.add(new GroupSubject(Sact, Gact, SGact, SGact.getnMat(), false, true, false));
                            for(int j = 0; j < Sact.getProblemsH(); j++)
                                problem.add(new GroupSubject(Sact, Gact, SGact, SGact.getnMat(), false, false, true));
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
    
    /*
    public boolean generate(List<Classroom> classrooms, List<GroupSubject> gs_list){
        Iterator<Classroom> it1 = classrooms.iterator();
        Iterator<GroupSubject> it2 = gs_list.iterator();
        return i_generate(classrooms, gs_list, 0, 0);
    }
    
    public boolean i_generate(List<Classroom> classrooms, List<GroupSubject> gs_list, int pos_classroom, int pos_gs){
        boolean fin = false;
        if (pos_gs < gs_list.size()){
            GroupSubject gs = gs_list.get(pos_gs);
            if (pos_classroom < classrooms.size()){
                Classroom classroom = classrooms.get(pos_classroom);
                // Recorremos los días del horario
                for(int i = 0; i < classroom.getTimetable().getnDays(); ++i){
                    // Recorremos las horas de un día
                    for(int j = classroom.getTimetable().gethIni(); j < classroom.getTimetable().gethEnd(); ++j){
                        // Comprobamos restricciones de la clase
                        if(ctrlRestrictions.classroomRestrictions(i, classroom.getTimetable().gethIni(), classroom.getTimetable().gethEnd(), classroom, gs)){
                            // Comprobamos restricciones de los grupos
                            if(ctrlRestrictions.groupRestrictions(i, classroom.getTimetable().gethIni(), classroom.getTimetable().gethEnd(), classroom, classroom.getTimetable(), gs)){
                                // Comprobamos restricciones de las asignaturas
                                if(ctrlRestrictions.subjectRestrictions(i, classroom.getTimetable().gethIni(), classroom.getTimetable().gethEnd(), classroom.getTimetable(), gs)){
                                    // No ha habido ninguna restricción, se puede asignar ese grupo-asignatura a la franja horaria dia=i, hora=j
                                    classroom.getTimetable().setGStoTimetable(gs, i, j);
                                    
                                    if (gs.isSubGroup()) gs.getSubGroup().setSubject(i, j, gs.getSubject());
                                    else gs.getGroup().setSubject(i, j, gs.getSubject());

                                    // Llamamos de nuevo a la función con el siguiente grupo-asignatura, desde el dia=i, hora=j
                                    fin = i_generate(classrooms, gs_list, pos_classroom, pos_gs+1);
                                    
                                    if (fin) return true;
                                    
                                    classroom.getTimetable().removeHourOfTimetable(i, j);

                                    if (gs.isSubGroup()) gs.getSubGroup().removeSubject(i, j);
                                    else gs.getGroup().removeSubject(i, j);
                                }
                            }
                        }
                        // No se puede poner en esa clase, llamamos de nuevo a la función con la siguiente clase (si la hay) pero mismo grupo-asignatura
                        else {
                            if (pos_classroom+1 < classrooms.size()) i_generate(classrooms, gs_list, pos_classroom+1, pos_gs);
                        }
                    }
                }
                // Hemos llenado el horario de una clase, cambiamos a la siguiente clase (si la hay)
                if (pos_classroom+1 < classrooms.size()) i_generate(classrooms, gs_list, pos_classroom+1, pos_gs);
            }
            // Hay al menos un grupo-asignatura disponible pero no hay ninguna clase a la que se le pueda asignar
            return false;
        }
        return true;
    }*/
    
    /*public void load(String file) throws FileNotFoundException, IOException{
        String s;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        TimetableGenerator TTG;
        if ((s = br.readLine())!=null) {
            
            TTG.addClassroom(0, s, 0, 0, 0, true, true, true);
            
        }
        br.close();
    }*/
}
