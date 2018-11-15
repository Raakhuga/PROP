/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.drivers.DriverCTRLRestrictions;

import domain.*;
import java.util.Scanner;

/**
 *
 * @author hasee
 */
public class DruverCTRLRestrictions {
      public static void main(String[] args) throws Exception{
        System.out.println("Aquest es el driver de CTRLRestrictions");
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
                    driverclassRestrictions();
                case 3:
                    
            default:
            }
        }
        System.out.println("Driver ha acabat amb exit");
    }
    
      private static void llistatfunctions() {
		System.out.println("-1: Sortir del driver");
		System.out.println("1: Constructora");
                System.out.println("2: classroomRestrictions");
                System.out.println("3: removeLevel");
	}

    private static void driverConstructora() {
        System.out.println("Anem a provar el driver de la constructora");
        Scanner in = new Scanner(System.in);
        System.out.println("Introdueix el nom del studyProgram");
        String name = in.next();
        CTRLRestrictions cr = new CTRLRestrictions();
       
        System.out.println("Classe CTRLRestrictions creada sense cap excepció");
	System.out.println("Sortint del driver de Constructora");
        System.out.println();
    }

    private static void driverclassRestrictions() {
        System.out.println("Anem a provar el driver de classroomRestrictions");
        Scanner in = new Scanner(System.in);
        CTRLRestrictions cR = new CTRLRestrictions();
        /*System.out.println("Cream una classe classRestrictions, necessitem una classe i un GroupSubject, introdueix les informacions necessaries per cridar la funcio:");
        System.out.println("Insert the reference of the Classroom");
        String ref = in.next();
        System.out.println("Insert the capacity of the Classroom");
        int capacity = in.nextInt();
        System.out.println("Insert the number of availabe days for the Classroom");
        int nDays = in.nextInt();
        System.out.println("Insert the first available hour and the last one of the Classroom");
        int hIni = in.nextInt();
        int hEnd = in.nextInt();
        System.out.println("Insert the type of the Classroom");
        String type = in.next();
        Boolean theory, lab, problems;
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
        Classroom classroom = new Classroom(capacity, ref, nDays, hIni, hEnd, theory, lab, problems);*/
        ClassroomStub classroomS = new ClassroomStub();
        int hIni, hEnd = 0;
        System.out.println("Tria el tipus de classroom:");
        System.out.println("0: Teoria");
        System.out.println("1: Lab");
        System.out.println("2: Problemes");
        int i = in.nextInt();
        Classroom classroom = classroomS.getClassroomiesim(i);
        System.out.println("Vols bloquejar alguna hora d'aquesta classe? SI/NO");
        String again = in.next();
        while (again.equals("SI")) {
            cR.enableRestriction(0);
            int dia = 0;
            System.out.println("Indica el dia");
            dia = in.nextInt();
            System.out.println("Indica la hora inicial");
            hIni = in.nextInt();
            System.out.println("Indica la hora final");
            hEnd = in.nextInt();
            classroom.getTimetable().banTime(dia, hIni, hEnd);
            boolean ban = classroom.getTimetable().getRestrictions()[dia][hIni].getBanned();
            System.out.println("boolean =" + ban);
            System.out.println("Vols bloquejar alguna hora mes d'aquesta classe? SI/NO");
            again = in.next();
        }
        System.out.println("Vols bloquejar alguna hora d'aquesta classe per algun grup determinat? SI/NO");
        again = in.next();
        while (again.equals("SI")) {
            cR.enableRestriction(2);
            System.out.println("Indica el dia");
            int dia = in.nextInt();
            System.out.println("Indica la hora inicial");
            hIni = in.nextInt();
            System.out.println("Indica la hora final");
            hEnd = in.nextInt();
            System.out.println("Indica el numero del grup");
            int group = in.nextInt();
            classroom.getTimetable().banGroup(dia, hIni, hEnd, group);
            System.out.println("Vols bloquejar alguna hora mes d'aquesta classe per algun grup determinat? SI/NO");
            again = in.next();
        }
        System.out.println("Vols bloquejar alguna hora d'aquesta classe per alguna assignatura determinada? SI/NO");
        again = in.next();
        while (again.equals("SI")) {
            cR.enableRestriction(1);
            int dia = 0;
            System.out.println("Indica el dia");
            dia = in.nextInt();
            System.out.println("Indica la hora inicial");
            hIni = in.nextInt();
            System.out.println("Indica la hora final");
            hEnd = in.nextInt();
            System.out.println("Indica el nom de la assignatura");
            String name = in.next();
            classroom.getTimetable().banSubject(dia, hIni, hEnd, name);
            System.out.println("Vols bloquejar alguna hora mes d'aquesta classe per alguna assignatura determinada? SI/NO");
            again = in.next();
        }
        System.out.println("Introdueix el numero del Grup");
        int id = in.nextInt();
        System.out.println ("Introdueix el numero de dies valides per aquest grup: " + id);
        int nDays = in.nextInt();
        System.out.println ("Introdueix la hora inicial i final per aquest grup: " + id);
        hIni = in.nextInt();
        hEnd = in.nextInt();
        System.out.println("Introdueix el numero d'estudiants que te aquest grup:" + id);
        int nStudentsGroup = in.nextInt();
        Group group = new Group(id, nDays, hIni, hEnd, nStudentsGroup);
        System.out.println("Introdueix el nom de la assignatura");
        String name = in.next();
        Subject s = new Subject(name, 0, 0);
        GroupSubject gs = new GroupSubject(s, group, 50, true, false , false);
        System.out.println("Introdueix el dia que vols situar aquest GroupSubject");
        int day = in.nextInt();
        System.out.println("Introdueix la hora que vols situar aquest GroupSubject");
        hIni = in.nextInt();
        if (cR.classroomRestrictions(day, hIni, classroom, gs)) 
           System.out.println("S'ha ficat amb exit aquest GroupSubject en la franja d'horari indicada");
        
        else System.out.println("No es possible situar aquest GroupSubject en aquesta franja d'horari");
        
    }
  
}
