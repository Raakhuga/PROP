
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
        List<Level> levels = SP.getLevels();
        Iterator<Level> it = levels.iterator();
        int nGroups, nStudents, i, remaining;
        Scanner in = new Scanner(System.in);
        while(it.hasNext()) {
            Level act = it.next();
            List<Subject> subjects = act.getSubjects();
            Iterator<Subject> Sit = subjects.iterator();
            while(Sit.hasNext()) {
                Subject Sact = Sit.next();
                i = 1;
                System.out.println("Insert the number of Students that will course the Subject: " + Sact.getName());
                nStudents = in.nextInt();
                nGroups = nStudents/nMaxStudentsGroup;
                if (nStudents%nMaxStudentsGroup != 0) nGroups++;
                for(remaining = nStudents; remaining > nMaxStudentsGroup; remaining -= nMaxStudentsGroup){
                    addGroup(act, i*10, nMaxStudentsGroup, nMaxStudentsSubgroup);
                    i++;
                }
                if (remaining > 0) addGroup(act, i*10, remaining, nMaxStudentsSubgroup);
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
            if(type.equals("theory") ||type.equals("Theory")) {
                theory = true;
                lab = false; 
                problems = false;
            }
            else if (type.equals("laboratory") || type.equals("Laboratory") || type.equals("lab") || type.equals("Lab")) {
                theory = false;
                lab = true; 
                problems = false;
            }
            else {
                theory = false;
                lab = false; 
                problems = true;
            }
            TG.addClassroom(capacity, ref, nDays, hIni, hEnd, theory, lab, problems);
        }
        System.out.println ("Insert the number of available StudyPrograms");
        nSP = in.nextInt();
        for(int i = 0; i < nSP; i++) {
            System.out.println ("Insert the name of the StudyProgam number: " + i);
            name = in.next();
            System.out.println ("Insert the number of Levels of the StudyProgram number: " + i);
            nLevels = in.nextInt();
            TG.addStudyProgram(name, nLevels, true);
        }
        Iterator<StudyProgram> it = TG.getPrograms().iterator();
        while(it.hasNext()) generateAllGroups(it.next(), TG.getnMaxStudentsGroup(), TG.getnMaxStudentsSubgroup());
    }

    
    private static void printGroupRestrictions (GroupRestrictions GR) {
        Iterator<String> BSit = GR.getBansubjects().iterator();
        Iterator<String> BCit = GR.getBanclassrooms().iterator();
        System.out.println("Restriccions:");
        String banned;
        if (GR.getBanned()) banned = "true";
        else banned = "false";
        System.out.println("L'atribut banned es: " + banned);
        System.out.println("Les assignatures bloquejades son: ");
        while (BSit.hasNext()) System.out.print(BSit.next() + "  ");
        System.out.println();
        System.out.println("Les aules bloquejades son: ");
        while(BCit.hasNext())System.out.println(BCit.next() + "  ");
    }
    
    private static void printSubject(Subject subject) {
        if (subject.getName() != null) System.out.println("L'assignatura " + subject.getName() + " es del nivell " + subject.getLevel() +
                " fa " + subject.getHours() + "h a la setmana i te " + subject.getTheoryH() + "h de teoria " 
                + subject.getLaboratoryH() + "h de laboratori i " + subject.getProblemsH() + "h de problemes");
    }
    
    private static void printsubGroup(subGroup subgroup) {
        if (subgroup != null){
            int Num = subgroup.getsNum();;
            int nDays = subgroup.getnDays();
            int hEnd = subgroup.gethEnd();
            int hIni = subgroup.gethIni();
            int nMat = subgroup.getnMat();
            System.out.println("El subgrup: " + Num + " te: " + nMat + " estudiants");
            for (int i = 0; i < nDays; i++){
                System.out.println("El dia: " + i);
                for (int j = 0; j < hEnd-hIni; j++) {
                    System.out.println("La hora: " + (hIni+j) + "te: ");
                    //printSubject(subgroup.getSubject(i,j));
                    //printGroupRestrictions(subgroup.getRestriction(i, j));
                    //System.out.println("El grup es del tipus: " + subgroup.getType(i, j));
                    if( subgroup.getSubject(i,j) != null){
                        printSubject(subgroup.getSubject(i,j));
                        printGroupRestrictions(subgroup.getRestriction(i, j));
                        System.out.println("El grup es del tipus: " + subgroup.getType(i, j));
                    }
                    else System.out.println("Lliure ");
                }
            }
        }
    }
    
    private static void printGroup(Group group) {
        if (group != null){
            int nDays = group.getnDays();
            int hIni = group.gethIni();
            int hEnd = group.gethEnd();
            System.out.println("El grup: " + group.getNum() + " te: " + group.getnMat() + " estudiants");
            for (int i = 0; i < nDays; i++){
                System.out.println("El dia: " + i);
                for (int j = 0; j < hEnd-hIni; j++) {
                    System.out.println("La hora: " + (hIni+j) + " te: ");
                    if( group.getSubject(i,j) != null){
                        printSubject(group.getSubject(i,j));
                        printGroupRestrictions(group.getRestriction(i, j));
                        System.out.println("El grup es del tipus: " + group.getType(i, j));
                    }
                    else System.out.println("Lliure ");
                }
            }
            Iterator<subGroup> SGit = group.getsubGroups().iterator();
            System.out.println("El grup: " + group.getNum() + "te els subgroups: ");
            while (SGit.hasNext()) printsubGroup(SGit.next());
        }
    }
    
    private static void printGroupSubject(GroupSubject GS) {
        String type = "";
        if(GS.theoryGroup()) type = "Theory";
        else if (GS.labGroup()) type = "Laboratory";
        else if (GS.problemsGroup()) type = "Problems";
        System.out.print("Materia: " + GS.getSubject().getName() + " ");
        if(GS.issubGroup()) System.out.println("Subgrup: " + GS.getSubGroup().getsNum());
        else System.out.println("Group: " + GS.getGroup().getNum());
    }
    
    private static void printTimetable(Timetable timetable) {
        int nDays = timetable.getnDays();
        int hIni = timetable.gethIni();
        int hEnd = timetable.gethEnd();
        System.out.println("HORARI");
        for (int i = 0; i < nDays; i++){
            System.out.println("El dia: " + i);
            for (int j = 0; j < hEnd-hIni; j++) {
                System.out.println("A la hora: "+ j);
                if (timetable.getGroupSubject(i, j).getSubject() != null) printGroupSubject(timetable.getGroupSubject(i, j));
                else System.out.println("Liure");
                //printGroupSubject(timetable.getGroupSubject(i ,j));
            }
        }
    }
    
    private static void printClassroom(Classroom classroom) {
        String type = "";
        if(classroom.isForTheory()) type = "Theory";
        else if (classroom.isForLab()) type = "Laboratory";
        else if (classroom.isForProblems()) type = "Problems";
        System.out.println("L'aula " + classroom.getRef() + " te una capacitat de: " + classroom.getCapacity() + " i es del tipus: " + type);
        printTimetable(classroom.getTimetable());
    }
    
    private static void printAllGS(List<GroupSubject> problem) {
        Iterator<GroupSubject> GSit = problem.iterator();
        while(GSit.hasNext()) {
            printGroupSubject(GSit.next());
        }
    }
    
    private static void print(TimetableGenerator TG) {
        List<Classroom> classes = TG.getClassrooms();
        Iterator<Classroom> Cit = classes.iterator();
        Iterator<StudyProgram> SPit = TG.getPrograms().iterator();
        while(Cit.hasNext()){
            Classroom Cact = Cit.next();
            while(SPit.hasNext()) printStudyProgram(SPit.next());
            printClassroom(Cact);           
        }
        printAllGS(TG.getProblem());
    }
    
    private static void printLevel(Level level) {
        Iterator<Subject> Sit = level.getSubjects().iterator();
        Iterator<Group> Git = level.getGroups().iterator();
        System.out.println("El nivell: " + level.getIden() + " te les seguents assignatures: ");
        while(Sit.hasNext()) printSubject(Sit.next());
        System.out.println("El nivell: " + level.getIden() + " te els grups: ");
        while(Git.hasNext()) printGroup(Git.next());
    }
    
    public static void printStudyProgram(StudyProgram SP) {
        Iterator<Level> Lit = SP.getLevels().values().iterator();
        System.out.println("El pla d'estudis: " + SP.getName() + " te els seguents nivells: ");
        while(Lit.hasNext()) {
            printLevel(Lit.next());
        }
        System.out.println("I els grups: ");
        
    }
    
    public static void main(String[] args) throws Exception{
        System.out.println("Aquest es el driver de CTRLRestrictions");
        int prova = 0;
        manualLoad(p);
        while (prova != -1) {
            System.out.println("Escull una funció per provar:");
            llistatfunctions();
            Scanner in = new Scanner(System.in);
            prova = in.nextInt();
            switch(prova) {
                case 1:
                    driverConstructora();
                     break;
                case 2:
                    drivergenerateAllGS();
                    break;
                case 3:
                    drivergenerate();
                    break;
                case 4:
                    driverprint();
                    break;
            default:
            }
        }
        System.out.println("Driver ha acabat amb exit");        
    }
    


     private static void llistatfunctions() {
		System.out.println("-1: Sortir del driver");
		System.out.println("1: Constructora");
                System.out.println("2: generateAllGS");
                System.out.println("3: generate");
                System.out.println("4: print");
	}

      private static void driverConstructora() {
        System.out.println("Anem a provar el driver de la constructora");
        Scanner in = new Scanner(System.in);
        TimetableGenerator t = new TimetableGenerator();
        System.out.println("Classe TimetableGenerador creada sense cap excepció");
	System.out.println("Sortint del driver de Constructora");
        System.out.println();
        
    }
      private static void drivergenerate() {
        System.out.println("Anem a provar el driver de generate");
        p.generateAllGS();
        System.out.println("El driver ha acabat amb exit");
        System.out.println("Sortint del driver de generate");
   }

    private static void drivergenerateAllGS() {
        System.out.println("Anem a provar el driver de generateAllGS");
        p.generateAllGS();
        System.out.println("El driver ha acabat amb exit");
        System.out.println("Sortint del driver de generateAllGS");
    }

    private static void driverprint() {
        System.out.println("Anem a provar el driver de print");
        print(p);
        System.out.println("El driver ha acabat amb exit");
        System.out.println("Sortint del driver de print");
    }
}
