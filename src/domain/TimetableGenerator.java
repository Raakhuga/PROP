
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
    
    
    /*
    public void generateAllGroups(StudyProgram SP) {
        List<Level> levels = SP.getLevels();
        Iterator<Level> it = levels.iterator();
        List<Subject> subjects;
        int nStudents, i, remaining;
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
    }*/
    
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
    
    public void generate(List<Classroom> classrooms, List<GroupSubject> gs_list){
        i_generate(classrooms, gs_list, 0, 0);
    }
    
    public void i_generate(List<Classroom> classrooms, List<GroupSubject> gs_list, int pos_classroom, int pos_gs, CTRLRestrictions ctrlRestrictions){
        if (pos_gs >= gs_list.size()) return;
        else if(pos_classroom >= classrooms.size()) return;
        else{
            GroupSubject gs = gs_list.get(pos_gs);
            if (pos_classroom < classrooms.size()){
                Classroom classroom = classrooms.get(pos_classroom);
                // Recorremos los días del horario
                for(int i = 0; i < classroom.getnDaysFromTimetable(); i++){
                    // Recorremos las horas de un día
                    for(int j = 0; j < (classroom.gethEndFromTimetable()-classroom.gethIniFromTimetable()); j++){
                        if (gs.issubGroup()) System.out.println("Iteración i: "+i+" iteración j: "+j+" de la clase: "+classroom.getRef()+" amb gs "+gs.getNameSubject()+" "+gs.getsubGroup().getsNum());
                        System.out.println("Iteración i: "+i+" iteración j: "+j+" de la clase: "+classroom.getRef()+" amb gs "+gs.getNameSubject()+" "+gs.getGroup().getNum());
                        // Comprobamos restricciones de la clase
                        if(ctrlRestrictions.classroomRestrictions(i, j, classroom, gs)){
                            // Comprobamos restricciones de los grupos
                            System.out.println("Antes ctrl restrictions");
                            if(ctrlRestrictions.groupRestrictions(i, j, classroom,  gs)){
                                // No ha habido ninguna restricción, se puede asignar ese grupo-asignatura a la franja horaria dia=i, hora=j
                                System.out.println("Pot emplenar la franja horària");
                                classroom.setGStoTimetable(gs, i, j);

                                if (gs.issubGroup()) {
                                    gs.setSubjectToGroup(i, j, gs.getSubject(), true);
                                    gs.getSubGroup().setType(i, j, gs.getType());
                                    gs.getSubGroup().setFree(i,j,false);
                                }
                                else {
                                    gs.setSubjectToGroup(i, j, gs.getSubject(), false);
                                    gs.getGroup().setType(i, j, gs.getType());
                                    gs.getGroup().setFree(i,j,false);
                                }

                                // Llamamos de nuevo a la función con el siguiente grupo-asignatura
                                i_generate(classrooms, gs_list, 0, pos_gs+1, ctrlRestrictions);

                                //if (fin) return true;

                                classroom.removeHourOfTimetable(i,j);

                                if (gs.issubGroup()) {
                                    gs.removeSubjectOfTimetableFromGroup(i, j, true);
                                    gs.getSubGroup().removeType(i, j);
                                    gs.getSubGroup().setFree(i,j,true);
                                }
                                else {
                                    gs.removeSubjectOfTimetableFromGroup(i, j, false);
                                    gs.getGroup().removeType(i, j);
                                    gs.getGroup().setFree(i,j,true);
                                }
                            }
                        }
                    }
                }
                // Hemos llenado el horario de una clase, cambiamos a la siguiente clase (si la hay)
                //System.out.println("Cambio de clase");
                if (pos_classroom+1 < classrooms.size()) i_generate(classrooms, gs_list, pos_classroom+1, pos_gs, ctrlRestrictions);
            }
        }
    }
    
    public boolean generate(List<Classroom> classrooms, List<GroupSubject> gs_list){
        return i_generate(classrooms, gs_list, 0, 0);
    }
    
    public boolean i_generate(List<Classroom> classrooms, List<GroupSubject> gs_list, int pos_classroom, int pos_gs){
        boolean fin = false;
        if (pos_gs >= gs_list.size()) return true;
        else{
            GroupSubject gs = gs_list.get(pos_gs);
            if (pos_classroom < classrooms.size()){
                Classroom classroom = classrooms.get(pos_classroom);
                // Recorremos los días del horario
                for(int i = 0; i < classroom.getnDaysFromTimetable(); i++){
                    // Recorremos las horas de un día
                    for(int j = 0; j < (classroom.gethEndFromTimetable()-classroom.gethIniFromTimetable()); j++){
                        if (gs.issubGroup()) System.out.println("Iteración i: "+i+" iteración j: "+j+" de la clase: "+classroom.getRef()+" amb gs "+gs.getNameSubject()+" "+gs.getsubGroup().getsNum());
                        else System.out.println("Iteración i: "+i+" iteración j: "+j+" de la clase: "+classroom.getRef()+" amb gs "+gs.getNameSubject()+" "+gs.getGroup().getNum());
                        // Comprobamos restricciones de la clase
                        if(ctrlRestrictions.classroomRestrictions(i, j, classroom, gs)){
                            // Comprobamos restricciones de los grupos
                            System.out.println("Antes ctrl restrictions");
                            if(ctrlRestrictions.groupRestrictions(i, j, classroom,  gs)){
                                // No ha habido ninguna restricción, se puede asignar ese grupo-asignatura a la franja horaria dia=i, hora=j
                                System.out.println("Pot emplenar la franja horària");
                                classroom.setGStoTimetable(gs, i, j);

                                if (gs.issubGroup()) {
                                    gs.setSubjectToGroup(i, j, gs.getSubject(), true);
                                    gs.getSubGroup().setType(i, j, gs.getType());
                                    gs.getSubGroup().setFree(i,j,false);
                                }
                                else {
                                    gs.setSubjectToGroup(i, j, gs.getSubject(), false);
                                    gs.getGroup().setType(i, j, gs.getType());
                                    gs.getGroup().setFree(i,j,false);
                                }

                                // Llamamos de nuevo a la función con el siguiente grupo-asignatura
                                fin = i_generate(classrooms, gs_list, 0, pos_gs+1);

                                if (fin) return true;

                                classroom.removeHourOfTimetable(i,j);

                                if (gs.issubGroup()) {
                                    gs.removeSubjectOfTimetableFromGroup(i, j, true);
                                    gs.getSubGroup().removeType(i, j);
                                    gs.getSubGroup().setFree(i,j,true);
                                }
                                else {
                                    gs.removeSubjectOfTimetableFromGroup(i, j, false);
                                    gs.getGroup().removeType(i, j);
                                    gs.getGroup().setFree(i,j,true);
                                }
                            }
                        }
                    }
                }
                // Hemos llenado el horario de una clase, cambiamos a la siguiente clase (si la hay)
                //System.out.println("Cambio de clase");
                if (pos_classroom+1 < classrooms.size()) i_generate(classrooms, gs_list, pos_classroom+1, pos_gs);
            }
            // Hay al menos un grupo-asignatura disponible pero no hay ninguna clase a la que se le pueda asignar
            //System.out.println("No hi ha cap horari disponible");
            return true;
        }
    }
    
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
