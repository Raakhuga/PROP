
package tests.drivers.GroupRestrictions;

import domain.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class DriverGroupRestrictions {
    private static GroupRestrictions a = new GroupRestrictions();
    private static GroupRestrictions b = new GroupRestrictions();
    private static GroupRestrictions c = new GroupRestrictions();
    
    
    public static List<String> bansubjects = new ArrayList<>();
    
    public static List<String> bannedclassrooms = new ArrayList<>();
    
    
    public static void main(String[] args) throws Exception{
        bansubjects.add("M1");
        bansubjects.add("F");
        bansubjects.add("FM");
        
        bannedclassrooms.add("A5101");
        bannedclassrooms.add("A5E01");
        bannedclassrooms.add("A6E02");
        
        a.setBanned(true);
        a.banSubject("M1");
        a.banSubject("F");
        a.banSubject("FM");
        a.banClassroom("A5101");
        a.banClassroom("A5E01");
        a.banClassroom("A6E02");
       
        boolean correct = true;
        
        Iterator<String> it1 = bansubjects.iterator();
        Iterator<String> it2 = bannedclassrooms.iterator();
        
        while(it1.hasNext()) {
            correct = a.subjectBanned(it1.next());
        }
        
        
        while(it2.hasNext()) {
            correct = a.classroomBanned(it2.next());
        }
        
        if (a.getBanned() && correct)
            System.out.println("Correct");
        System.out.println("Aquest es el driver de GroupRestrictions");
        int prova = 0;
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
                    driverGR();
                    break;
            default:
            }
        }
        System.out.println("Driver ha acabat amb exit");        
    }
    
    private static void llistatfunctions() {
		System.out.println("-1: Sortir del driver");
		System.out.println("1: Constructora");
                System.out.println("2: driverGR");
	}
    
    private static void driverGR() throws FileNotFoundException{
        
        System.out.println("Anem a provar les estructures de la classe GroupRestrictions");
        Scanner in = new Scanner(System.in);
        String state, c, s;
        System.out.println("Insert the boolean state of banned");
        state = in.next();
        boolean correct = false;
        while(!correct) {
            if (state.equals("true")){
                b.setBanned(true);
                correct = true;
            }
            else if (state.equals("false")) {
                b.setBanned(false);
                correct = true;
            }
            else {
                System.out.println("Incorrect argument, try it again");
                state = in.next();
            }
        }
        System.out.println("Insert the number of banned classrooms");
        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            System.out.println("Insert the reference of the banned Classroom n: " + i);
            c = in.next();
            b.banClassroom(c);
        }
        System.out.println("Insert the number of banned Subjects");
        n = in.nextInt();
        for(int i = 0; i < n; i++) {
            System.out.println("Insert the name of the banned Subject n: " + i);
            s = in.next();
            b.banSubject(s);
        }
        System.out.println("The bolean state of Banned is: " + b.getBanned());
        Iterator<String> it = b.getBanclassrooms().iterator(); 
        while(it.hasNext()) System.out.println("The classroom: " + it.next() + " is banned");
        Iterator<String> it2 = b.getBansubjects().iterator(); 
        while(it2.hasNext()) System.out.println("The subject: " + it2.next() + " is banned");
        System.out.println("El driver ha acabat amb exit");
        System.out.println("Sortint del driver");
    }

    private static void driverConstructora() {
        System.out.println("Anem a provar el driver de la constructora");
        Scanner in = new Scanner(System.in);
        GroupRestrictions GR = new GroupRestrictions();
        System.out.println("Classe GroupRestrictions creada sense cap excepció");
	System.out.println("Sortint del driver de Constructora");
        System.out.println();
    }
}
