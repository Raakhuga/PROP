
package tests.drivers.TimetableGenerator;
import domain.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static tests.drivers.GroupRestrictions.DriverGroupRestrictions.bannedclassrooms;
import static tests.drivers.GroupRestrictions.DriverGroupRestrictions.bansubjects;

public class DriverTimetableGenerator {
    
    private static TimetableGenerator p;
    
    public void initTimetable() {
        System.out.println("Introdueixi el nombre maxim d'estudiants que pot tenir un grup");
        Scanner in = new Scanner(System.in);
        int maxStudents = in.nextInt();
        System.out.println("Introdueixi el nombre maxim d'estudiants que pot tenir un subgrup");
        int submaxStudents = in.nextInt();
        p = new TimetableGenerator(maxStudents, submaxStudents);
    }
    
    public void load() {
        System.out.println("Introdueixi el nombre de plans d'estudis desitjat");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < in.nextInt(); i++) {
            System.out.println("Introdueixi el nom del pla d'estudis numero: " + i);
            p.addStudyProgram(in.next());
        }
        Iterator<StudyProgram> PIT = p.getPrograms().iterator();
        while(PIT.hasNext()) {
            StudyProgram SPact = PIT.next();
            System.out.println("Introdueixi el numero de nivells del pla d'estudis: " + SPact.getName());
            for (int i = 0; i < in.nextInt(); i++) {
                p.addLevel(SPact);
            }
            Iterator<Level> LIT = SPact.getLevels().iterator();
            while(LIT.hasNext()) {
                Level Lact = LIT.next();
                System.out.println("Introdueixi el numero de assignaturas que te el nivell: " + Lact.getIden() + 
                        " del pla d'estudis: " + SPact.getName());
                for (int i = 0; i < in.nextInt(); i++) {
                    System.out.println("Introdueixi el nom de la assignatura numero: " + i+1 + 
                            " del nivell: " + Lact.getIden() + " del pla d'estudis: " + SPact.getName());
                    p.addSubject(Lact, in.next());
                }
                Iterator<Subject> SIT = Lact.getSubjects().iterator();
                while(SIT.hasNext()) {
                    Subject Sact = SIT.next();
                    System.out.println("Introdueixi el numero d'hores de Teoria de la materia: " + Sact.getName());
                    Sact.fillTheoryH(in.nextInt());
                    System.out.println("Introdueixi el numero d'hores de Problemes de la materia: " + Sact.getName());
                    Sact.fillPoblemsH(in.nextInt());
                    System.out.println("Introdueixi el numero d'hores de Laboratori de la materia: " + Sact.getName());
                    Sact.fillLaboratoryH(in.nextInt());
                    System.out.println("Introdueixi el numero d'estudiants que cursaran la materia: "
                            + "" + Sact.getName() + "del nivell: " + Sact.getLevel() + " del pla d'estudis: " + 
                            SPact.getName());
                    int nEst = in.nextInt();
                    int remaining, i = 1;
                    if (nEst%p.getnMaxStudentsGroup()!= 0) nGroups++;
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
        for (int i = 0; i < in.nextInt(); i++) {
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
    
}
