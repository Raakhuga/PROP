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
                    groupRestrictions();
            default:
            }
        }
        System.out.println("Driver ha acabat amb exit");
    }
    
      private static void llistatfunctions() {
		System.out.println("-1: Sortir del driver");
		System.out.println("1: Constructora");
                System.out.println("2: classroomRestrictions");
                System.out.println("3: groupRestrictions");
	}
      
    private static void groupRestrictions() {
        System.out.println("Anem a provar el driver de groupRestrictions");
        Scanner in = new Scanner(System.in);
        CTRLRestrictions cR = new CTRLRestrictions();
        System.out.println("Indica el numero del grup");
        int num = in.nextInt();
        Group group = new Group(num, 5, 8, 20, 50);
        Classroom classroom = new Classroom(100, "A6001", 5, 8, 20, true, true, true);
        Classroom classroom2 = new Classroom(100, "A6002", 5, 8, 20, true, true, true);
        System.out.println("Tenim 2 aules disponibles A6001 i A6002");
        int hIni, hEnd = 0;
        System.out.println("Es pot tenir classe de lab abans de teoria? SI/NO");
        String res = in.next();
        if (res.equals("NO")) cR.enableRestriction(4);
        System.out.println("Vols bloquejar alguna hora d'aquest grup per algun dia? SI/NO");
        String again = in.next();
        while (again.equals("SI")) {
            cR.enableRestriction(0);
            int dia = 0;
            System.out.println("Indica el dia");
            dia = in.nextInt()-1;
            System.out.println("Indica la hora inicial");
            hIni = in.nextInt()-8;
            System.out.println("Indica la hora final");
            hEnd = in.nextInt()-8;
            group.banTime(dia, hIni, hEnd);
            System.out.println("Vols bloquejar alguna hora mes d'aquest grup per algun dia? SI/NO");
            again = in.next();
        }
        System.out.println("Vols bloquejar alguna hora d'aquest grup per alguna assignatura determinada? SI/NO");
        again = in.next();
        while (again.equals("SI")) {
            cR.enableRestriction(1);
            int dia = 0;
            System.out.println("Indica el dia");
            dia = in.nextInt()-1;
            System.out.println("Indica la hora inicial");
            hIni = in.nextInt()-8;
            System.out.println("Indica la hora final");
            hEnd = in.nextInt()-8;
            System.out.println("Indica el nom de la assignatura");
            String name = in.next();
            group.banSubject(dia, hIni, hEnd, name);
            System.out.println("Vols bloquejar alguna hora mes d'aquest grup per alguna assignatura determinada? SI/NO");
            again = in.next();
        }
        System.out.println("Vols bloquejar alguna hora d'aquest grup per alguna classe determinada? SI/NO");
        again = in.next();
        while (again.equals("SI")) {
            cR.enableRestriction(3);
            int dia = 0;
            System.out.println("Indica el dia");
            dia = in.nextInt()-1;
            System.out.println("Indica la hora inicial");
            hIni = in.nextInt()-8;
            System.out.println("Indica la hora final");
            hEnd = in.nextInt()-8;
            System.out.println("Indica el nom de la assignatura");
            String name = in.next();
            group.banClassroom(dia, hIni, hEnd, name);
            System.out.println("Vols bloquejar alguna hora mes d'aquest grup per alguna classe determinada? SI/NO");
            again = in.next();
        }
        again = "SI";
        while (again.equals("SI")) {
            System.out.println("Indica el dia que te classe aquest grup");
            int dia = in.nextInt()-1;
            System.out.println("Indica la hora inicial");
            hIni = in.nextInt()-8;
            System.out.println("Indica la hora final");
            hEnd = in.nextInt()-8;
            System.out.println("Indica el nom de la assignatura");
            String name = in.next();
            Subject s = new Subject(name, 0, 0);
            System.out.println("Indica si la assignatura que vols afegir es de: teoria/lab/problem");
            String type = in.next();
            GroupSubject gs;
            if (type.equals("teoria")) gs = new GroupSubject(s, group, 50, true, false, false);
            else if (type.equals("lab")) {
                System.out.println("Introdueix el numero del subgrup");
                int sub = in.nextInt();
                subGroup su = new subGroup(sub,5, 8, 20, 50 );
                gs = new GroupSubject(s, group, su, 50, false, true , false);
            
            }
            else gs = new GroupSubject(s,group, 50, false, false, true);
            System.out.println("Indica en quina aules vols situar: A6001/A6002");
            String aula = in.next();
            if(aula.equals("A6001")) {
                if(cR.groupRestrictions(dia, hIni, classroom, gs)) {
                    group.setFree(dia, hIni, hEnd, false);
                    System.out.println("S'ha ficat amb exit aquest GroupSubject en la franja d'horari indicada");
                }
                else System.out.println("No es possible situar aquest GroupSubject en aquesta franja d'horari");
            }
            else {
                if(cR.groupRestrictions(dia, hIni, classroom2, gs)) {
                    group.getRestrictions()[dia][hIni].setFree(false);
                    System.out.println("S'ha ficat amb exit aquest GroupSubject en la franja d'horari indicada");
                }
                else System.out.println("No es possible situar aquest GroupSubject en aquesta franja d'horari");
            }
            //else System.out.println("No es possible situar aquest GroupSubject en aquesta franja d'horari");
            System.out.println("Vols tornar a ficar un nou grouSubject? SI/NO");
            again = in.next();
        }
        System.out.println("Funcio classRestriction sense cap excepció");
	System.out.println("Sortint del driver de classRestriction");
        
        
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
            dia = in.nextInt()-1;
            System.out.println("Indica la hora inicial");
            hIni = in.nextInt()-8;
            System.out.println("Indica la hora final");
            hEnd = in.nextInt()-8;
            classrooms[i].getTimetable().banTime(dia, hIni, hEnd);
            System.out.println("Vols bloquejar alguna hora mes d'aquesta classe? SI/NO");
            again = in.next();
        }
        System.out.println("Vols bloquejar alguna hora d'aquesta classe per algun grup determinat? SI/NO");
        again = in.next();
        while (again.equals("SI")) {
            cR.enableRestriction(2);
            System.out.println("Indica el dia");
            int dia = in.nextInt()-1;
            System.out.println("Indica la hora inicial");
            hIni = in.nextInt()-8;
            System.out.println("Indica la hora final");
            hEnd = in.nextInt()-8;
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
            dia = in.nextInt()-1;
            System.out.println("Indica la hora inicial");
            hIni = in.nextInt()-8;
            System.out.println("Indica la hora final");
            hEnd = in.nextInt()-8;
            System.out.println("Indica el nom de la assignatura");
            String name = in.next();
            classrooms[i].getTimetable().banSubject(dia, hIni, hEnd, name);
            System.out.println("Vols bloquejar alguna hora mes d'aquesta classe per alguna assignatura determinada? SI/NO");
            again = in.next();
        }
        again = "SI";
        while (again.equals("SI")) {
            System.out.println("Introdueix el numero del Grup");        
            int id = in.nextInt();
            Group group = new Group(id, 5, 8, 20, 50);
            System.out.println("Introdueix el nom de la assignatura");
            String name = in.next();
            Subject s = new Subject(name, 0, 0);
            System.out.println("Tria si la assignatura que vols afegir es de: teoria/lab/problemes");
            String type = in.next();
            GroupSubject gs;
            if (type.equals("teoria")) gs = new GroupSubject(s, group, 50, true, false, false);
            else if (type.equals("lab")) {
                System.out.println("Introdueix el numero del subgrup");
                int sub = in.nextInt();
                subGroup su = new subGroup(sub,5, 8, 20, 50 );
                gs = new GroupSubject(s, group, su, 50, false, true , false);
            
            }
            else gs = new GroupSubject(s, group, 50, false, false , true);
            System.out.println("Tipus： " + gs.getType() + "Tipus Aula: " + (classrooms[i].isForTheory() && gs.theoryGroup()));
            System.out.println("Introdueix el dia que vols situar aquest GroupSubject");
            int day = in.nextInt()-1;
            System.out.println("Introdueix la hora que vols situar aquest GroupSubject");
            hIni = in.nextInt()-8;
            if (cR.classroomRestrictions(day, hIni, classrooms[i], gs)){ 
               classrooms[i].getTimetable().setFree(day, hIni, hEnd, true);
               System.out.println("S'ha ficat amb exit aquest GroupSubject en la franja d'horari indicada");
            }

            else System.out.println("No es possible situar aquest GroupSubject en aquesta franja d'horari");
            System.out.println("Vols tornar a ficar un nou grouSubject? SI/NO");
            again = in.next();
        }
        System.out.println("Funcio classRestriction sense cap excepció");
	System.out.println("Sortint del driver de classRestriction");
    }
  
}
