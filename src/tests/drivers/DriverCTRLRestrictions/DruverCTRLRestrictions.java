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
        Classroom classrooms[];
        classrooms = new Classroom[3];
        classrooms[0] = new Classroom(100, "A6001", 5, 8, 20, true, false, false);
        classrooms[1] = new Classroom(100, "A6002", 5, 8, 20, false, true, false);
        classrooms[2] = new Classroom(100, "A6003", 5, 8, 20, false, false, true);
        int hIni, hEnd = 0;
        System.out.println("Tria el tipus de classroom:");
        System.out.println("0: Teoria");
        System.out.println("1: Lab");
        System.out.println("2: Problemes");
        int i = in.nextInt();
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
            classrooms[i].getTimetable().banTime(dia, hIni, hEnd);
            boolean ban = classrooms[i].getTimetable().getRestrictions()[dia][hIni].getBanned();
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
            classrooms[i].getTimetable().banGroup(dia, hIni, hEnd, group);
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
            classrooms[i].getTimetable().banSubject(dia, hIni, hEnd, name);
            System.out.println("Vols bloquejar alguna hora mes d'aquesta classe per alguna assignatura determinada? SI/NO");
            again = in.next();
        }
        System.out.println("Introdueix el numero del Grup");
        int id = in.nextInt();
        Group group = new Group(id, 5, 8, 20, 50);
        System.out.println("Introdueix el nom de la assignatura");
        String name = in.next();
        Subject s = new Subject(name, 0, 0);
        GroupSubject gs = new GroupSubject(s, group, 50, true, false , false);
        System.out.println("Introdueix el dia que vols situar aquest GroupSubject");
        int day = in.nextInt();
        System.out.println("Introdueix la hora que vols situar aquest GroupSubject");
        hEnd = in.nextInt();
        if (cR.classroomRestrictions(day, hEnd - classrooms[i].getTimetable().gethIni(), classrooms[i], gs)) 
           System.out.println("S'ha ficat amb exit aquest GroupSubject en la franja d'horari indicada");
        
        else System.out.println("No es possible situar aquest GroupSubject en aquesta franja d'horari");
        
    }
  
}
