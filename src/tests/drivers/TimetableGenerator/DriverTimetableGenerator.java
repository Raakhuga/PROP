
package tests.drivers.TimetableGenerator;
import domain.*;
import persistance.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DriverTimetableGenerator {
    
    public static TimetableGenerator p;
    
    public static void initTimetable() {
        System.out.println("Introdueixi el nombre maxim d'estudiants que pot tenir un grup");
        Scanner in = new Scanner(System.in);
        int maxStudents = in.nextInt();
        System.out.println("Introdueixi el nombre maxim d'estudiants que pot tenir un subgrup");
        int submaxStudents = in.nextInt();
        p = new TimetableGenerator(maxStudents, submaxStudents);
    }
    
    public static void addGroups(int nEst, Subject Sact){
        int remaining, i = 1;
        for(remaining = nEst; remaining > p.getnMaxStudentsGroup(); remaining -= p.getnMaxStudentsGroup()){
            if(remaining >= nEst/2) p.addGroup(Sact, 0, 5, 8, 14, i*10, p.getnMaxStudentsGroup()); //matins
            else p.addGroup(Sact, 0, 5, 14, 20, i*10, p.getnMaxStudentsGroup()); //tarda
            i++;
        }
        if (remaining > 0) p.addGroup(Sact, 0, 5, 14, 20, i*10, remaining);
        Iterator<Group> GIT = Sact.getGroups().iterator();
        while(GIT.hasNext()) {
            Group Gact = GIT.next();
            int subremaining, j = 1;
            for (subremaining = p.getnMaxStudentsGroup(); subremaining > p.getnMaxStudentsSubgroup(); subremaining -= p.getnMaxStudentsSubgroup()) {
            p.addSubGroup(Gact, Gact.getNum()+j, p.getnMaxStudentsSubgroup());
            j++;
            }
            if(subremaining > 0) p.addSubGroup(Gact, Gact.getNum()+j, subremaining);
        }
    }
    
    public static void load() {
        System.out.println("Introdueixi el nombre de plans d'estudis desitjat");
        Scanner in = new Scanner(System.in);
        int nPlans = in.nextInt();
        for (int i = 0; i < nPlans; i++) {
            System.out.println("Introdueixi el nom del pla d'estudis numero: " + i);
            p.addStudyProgram(in.next());
        }
        Iterator<StudyProgram> PIT = p.getPrograms().iterator();
        while(PIT.hasNext()) {
            StudyProgram SPact = PIT.next();
            System.out.println("Introdueixi el numero de nivells del pla d'estudis: " + SPact.getName());
            int nLevels = in.nextInt();
            for (int i = 0; i < nLevels; i++) {
                p.addLevel(SPact, i);
            }
            Iterator<Level> LIT = SPact.getLevels().iterator();
            while(LIT.hasNext()) {
                Level Lact = LIT.next();
                System.out.println("Introdueixi el numero de assignaturas que te el nivell: " + Lact.getIden() + 
                        " del pla d'estudis: " + SPact.getName());
                int nSubjects = in.nextInt();
                for (int i = 0; i < nSubjects; i++) {
                    System.out.println("Introdueixi el nom de la assignatura numero: " + (i+1) + 
                            " del nivell: " + Lact.getIden() + " del pla d'estudis: " + SPact.getName());
                    p.addSubject(Lact, in.next());
                }
                Iterator<Subject> SIT = Lact.getSubjects().iterator();
                while(SIT.hasNext()) {
                    Subject Sact = SIT.next();
                    System.out.println("Introdueixi el numero d'hores de Teoria de la materia: " + Sact.getName());
                    Sact.fillTheoryH(in.nextInt());
                    System.out.println("Introdueixi el numero d'hores de Problemes de la materia: " + Sact.getName());
                    Sact.fillProblemsH(in.nextInt());
                    System.out.println("Introdueixi el numero d'hores de Laboratori de la materia: " + Sact.getName());
                    Sact.fillLaboratoryH(in.nextInt());
                    System.out.println("Introdueixi el numero d'estudiants que cursaran la materia: "
                            + "" + Sact.getName() + " del nivell: " + Sact.getLevel() + " del pla d'estudis: " + 
                            SPact.getName());
                    int nEst = in.nextInt();
                    int remaining, i = 1;
                    for(remaining = nEst; remaining > p.getnMaxStudentsGroup(); remaining -= p.getnMaxStudentsGroup()){
                        if(remaining >= nEst/2) p.addGroup(Sact, 0, 5, 8, 14, i*10, p.getnMaxStudentsGroup()); //matins
                        else p.addGroup(Sact, 0, 5, 14, 20, i*10, p.getnMaxStudentsGroup()); //tarda
                        i++;
                    }
                    if (remaining > 0) p.addGroup(Sact, 0, 5, 14, 20, i*10, remaining);
                    Iterator<Group> GIT = Sact.getGroups().iterator();
                    while(GIT.hasNext()) {
                        Group Gact = GIT.next();
                        int subremaining, j = 1;
                        for (subremaining = p.getnMaxStudentsGroup(); subremaining > p.getnMaxStudentsSubgroup(); subremaining -= p.getnMaxStudentsSubgroup()) {
                            p.addSubGroup(Gact, Gact.getNum()+j, p.getnMaxStudentsSubgroup());
                            j++;
                        }
                        if(subremaining > 0) p.addSubGroup(Gact, Gact.getNum()+j, subremaining);
                    }
                }
            }
        }
        System.out.println("Introdueixi el numero d'aules disponibles");
        int nClasses = in.nextInt();
        for (int i = 0; i < nClasses; i++) {
            System.out.println("Introdueixi la referencia de l'aula numero: " + i+1);
            String ref = in.next();
            System.out.println("Introdueixi la capacitat de l'aula: " + ref);
            int capacity = in.nextInt();
            System.out.println("Introdueixi el primer dia disponible de l'aula: " + ref);
            int dIni = in.nextInt();
            System.out.println("Introdueixi el darrer dia disponible de l'aula: " + ref);
            int dEnd = in.nextInt();
            System.out.println("Introdueixi la primera hora disponible de l'aula: " + ref);
            int hIni = in.nextInt();
            System.out.println("Introdueixi la darrera hora disponible de l'aula: " + ref);
            int hEnd = in.nextInt();
            p.addClassroom(capacity, ref, dIni, dEnd, hIni, hEnd);
        }
    }
    
    public static void load1() {
        p.addStudyProgram("FIB"); //Pla d'estudis
        List<StudyProgram> PIT = p.getPrograms();
        StudyProgram SPact = PIT.get(0);
        p.addLevel(SPact,1);
        List<Level> LIT = SPact.getLevels();
        Level Lact = LIT.get(0);
        p.addSubject(Lact, "FM");
        p.addSubject(Lact, "F");
        p.addSubject(Lact, "IC");
        p.addSubject(Lact, "PRO");
        List<Subject> SIT = Lact.getSubjects();
        
        SIT.get(0).fillTheoryH(3);
        SIT.get(0).fillProblemsH(2);
        SIT.get(0).fillLaboratoryH(0);
        p.generateGroups(SIT.get(0),300,0,4);
        
        SIT.get(1).fillTheoryH(3);
        SIT.get(1).fillProblemsH(0);
        SIT.get(1).fillLaboratoryH(2);
        p.generateGroups(SIT.get(1),300,0,4);
        
        SIT.get(2).fillTheoryH(3);
        SIT.get(2).fillProblemsH(0);
        SIT.get(2).fillLaboratoryH(2);
        p.generateGroups(SIT.get(2),300,0,4);

        SIT.get(3).fillTheoryH(2);
        SIT.get(3).fillProblemsH(0);
        SIT.get(3).fillLaboratoryH(3);
        p.generateGroups(SIT.get(3),300,0,4);
        p.fixTimetables(Lact);
        
        p.addLevel(SPact,2);
        Lact = LIT.get(1);
        p.addSubject(Lact, "PRO2");
        p.addSubject(Lact, "M1");
        p.addSubject(Lact, "M2");
        p.addSubject(Lact, "EC");
        SIT = Lact.getSubjects();
        
        SIT.get(0).fillTheoryH(2);
        SIT.get(0).fillProblemsH(0);
        SIT.get(0).fillLaboratoryH(3);
        p.generateGroups(SIT.get(0),100,0,4);
        
        SIT.get(1).fillTheoryH(3);
        SIT.get(1).fillProblemsH(2);
        SIT.get(1).fillLaboratoryH(0);
        p.generateGroups(SIT.get(1),100,0,4);
        
        SIT.get(2).fillTheoryH(3);
        SIT.get(2).fillProblemsH(2);
        SIT.get(2).fillLaboratoryH(0);
        p.generateGroups(SIT.get(2),100,0,4);

        SIT.get(3).fillTheoryH(3);
        SIT.get(3).fillProblemsH(0);
        SIT.get(3).fillLaboratoryH(2);
        p.generateGroups(SIT.get(3),100,0,4);
        p.fixTimetables(Lact);
        
        p.addClassroom(80, "A1", 0, 4, 8, 20);
        p.addClassroom(80, "A2", 0, 4, 8, 20);
        p.addClassroom(20, "A3", 0, 4, 8, 20);
        p.addClassroom(20, "A4", 0, 4, 8, 20);
        p.addClassroom(80, "A5", 0, 4, 8, 20);
        p.addClassroom(80, "A6", 0, 4, 8, 20);
        p.addClassroom(20, "A7", 0, 4, 8, 20);
        p.addClassroom(20, "A8", 0, 4, 8, 20);
        p.addClassroom(80, "A9", 0, 4, 8, 20);
        p.addClassroom(80, "A10", 0, 4, 8, 20);
        p.addClassroom(20, "A11", 0, 4, 8, 20);
        p.addClassroom(20, "A12", 0, 4, 8, 20);
        p.addClassroom(80, "A13", 0, 4, 8, 20);
        p.addClassroom(80, "A14", 0, 4, 8, 20);
        p.addClassroom(20, "A15", 0, 4, 8, 20);
        p.addClassroom(20, "A16", 0, 4, 8, 20);
        
        List<Classroom> classes = p.getClassrooms();
        
        classes.get(0).setTheory();
        classes.get(1).setTheory();
        classes.get(2).setProblems();
        classes.get(3).setTheory();
        classes.get(4).setTheory();
        classes.get(5).setTheory();
        classes.get(6).setProblems();
        classes.get(7).setLaboratory();
        classes.get(8).setTheory();
        classes.get(9).setTheory();
        classes.get(10).setProblems();
        classes.get(11).setLaboratory();
        classes.get(12).setTheory();
        classes.get(13).setTheory();
        classes.get(14).setProblems();
        classes.get(15).setLaboratory();
        
        GroupSubject GS = new GroupSubject(SIT.get(2), SIT.get(2).getGroups().get(0));
        GS.setTheory();
        CTRLRestrictions ctrlRestrictions = new CTRLRestrictions(p);
        ClassSubject CS = new ClassSubject(classes.get(0), SIT.get(2));
        /*
        if (ctrlRestrictions.classroomRestrictions(3, 10, classes.get(0), GS)) {
            System.out.println("primero");
            if (ctrlRestrictions.groupRestrictions(3, 10, classes.get(0), GS)) {
                System.out.println("segundo");
            }
        }
        p.addToTimetable(classes.get(0), SIT.get(2).getGroups().get(0), GS, CS, 3, 10);
        if (ctrlRestrictions.classroomRestrictions(3, 10, classes.get(0), GS)) {
            System.out.println("primero");
            if (ctrlRestrictions.groupRestrictions(3, 10, classes.get(0), GS)) {
                System.out.println("segundo");
            }
        }
        p.removeFromTimetable(classes.get(0), SIT.get(2).getGroups().get(0), 3, 10);
        if (ctrlRestrictions.classroomRestrictions(3, 10, classes.get(0), GS)) {
            System.out.println("primero");
            if (ctrlRestrictions.groupRestrictions(3, 10, classes.get(0), GS)) {
                System.out.println("segundo");
            }
        }*/
        
        p.ban(classes.get(0), 2, 3, 8, 20);
        p.removeRestriction(classes.get(0), 0);
        p.banGroup(classes.get(0), 3, 4, 8, 20, 10);
        p.removeRestriction(classes.get(0), 0);
    }
    
    public static void printClassTimetable() {
        Iterator<Classroom> CIT = p.getClassrooms().iterator();
        while(CIT.hasNext()) {
            Classroom Cact = CIT.next();
            ClassroomTimetable Tact = Cact.getTimetable();
            System.out.println("Horari de l'aula: " + Cact.getRef());
            System.out.println("");
            for(int i = 2*Tact.gethIni() - 1; i < 2*Tact.gethEnd(); i++) {
                for (int j = Tact.getdIni() - 1 ; j < Tact.getdEnd(); j++) {
                    if (j == Tact.getdIni() - 1) System.out.print((i/2));
                    if (j != Tact.getdIni() - 1) System.out.print("\t");
                    if (i == 2*Tact.gethIni() -1) {
                        if (j == 0) System.out.print("Dl");
                        else if (j == 1) System.out.print("Dt");
                        else if (j == 2) System.out.print("Dc");
                        else if (j == 3) System.out.print("Dj");
                        else if (j == 4) System.out.print("Dv");
                        else if (j == 5) System.out.print("Ds");
                        else if (j == 6) System.out.print("Dg");
                    }
                    if ((i > 2*Tact.gethIni()-1) && (j > Tact.getdIni()-1)){
                        GroupSubject GSact = Tact.getGroupSubject(j, i/2);
                        if (i%2 == 0) {
                            if(GSact.isEmpty()) System.out.print("Buit");
                            else System.out.print(GSact.getNameSubject());
                        }
                        else {
                            if(GSact.isEmpty()) System.out.print("Buit");
                            else System.out.print(GSact.getNumGroup());
                        }
                    }
                    if (j+1 == Tact.getdEnd()) System.out.println("");
                }
            }
        }
    }
    
    public static void printGS() {
        System.out.println();
        System.out.println("Ara s'expossara el problema");
        System.out.println();
        Iterator<GroupSubject> GSIT = p.getProblem().iterator();
        while(GSIT.hasNext()) {
            GroupSubject GSact = GSIT.next();
            System.out.println("Grup: " + GSact.getNumGroup() + " Assignatura: " + GSact.getNameSubject() + " Empty: " + GSact.isEmpty());
        }
    }
    
    public static void main(String[] args) throws Exception{
        initTimetable();
        //p = new TimetableGenerator();
        PersistanceCtrl PC = new PersistanceCtrl();
        load1();
        //p = new TimetableGenerator(0, 0);
        //TimetableGenerator TG = new TimetableGenerator(0, 0);
        //PC.load(p, "src/tests/drivers/asdfasdf/NstatePersist.state");
        //PC.load(p, "C:/Users/Raakhuga/Documents/NetBeansProjects/PROP/state.state");
        //p = TG;
        
        
        
        p.generateAllGS();
        
        PC.save(p, "src/tests/drivers/asdfasdf/NstatePersist.state");
        //printGS();
        p.generateTimetable();
        printClassTimetable();
    }
}
