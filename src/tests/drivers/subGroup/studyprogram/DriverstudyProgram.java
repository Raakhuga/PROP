/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.drivers.subGroup.studyprogram;

import domain.*;
import static java.time.Clock.system;
import java.util.Scanner;

/**
 *
 * @author hasee
 */
public class DriverstudyProgram {
      public static void main(String[] args) throws Exception{
        System.out.println("Aquest es el driver de StudyProgram");
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
                    driveraddLevels();
                case 3:
                    driverremoveLevel();
            default:
            }
        }
        System.out.println("Driver ha acabat amb exit");
    }
    private static void driverremoveLevel() {
        System.out.println("Anem a provar el driver de removeLevel");
        Scanner in = new Scanner(System.in);
        System.out.println("Introdueix el nom del studyProgram");
        String name = in.next();
        StudyProgram studyprogram = new StudyProgram(name);
        System.out.println("S'ha creat el StudyProgram amb el nom " + name + " i 0 nivell inicialment");
        System.out.println("Introdueix el numero de level que te aquest StudyProgram");
        int levels = in.nextInt();
        for (int i = 0; i < levels; ++i) studyprogram.addLevels(true);
        System.out.println("Ara el StudyProgram te " + studyprogram.getnLevels() + " levels");
        System.out.println("Escull el level que vosl borrar");
        levels = in.nextInt();
        studyprogram.removeLevel(levels);
        System.out.println("Ara queda " + studyprogram.getnLevels() + " levels");
        System.out.println("Funcion removeLevel acabat sense cap excepció");
	System.out.println("Sortint del driver de removeLevel");
        System.out.println();
    }
    
    private static void driverConstructora() {
        System.out.println("Anem a provar el driver de la constructora");
        Scanner in = new Scanner(System.in);
        System.out.println("Introdueix el nom del studyProgram");
        String name = in.next();
        StudyProgram studyprogram = new StudyProgram(name);
        
        System.out.println("Classe studyProgram creada sense cap excepció");
	System.out.println("Sortint del driver de Constructora");
        System.out.println();

    }
    private static void driveraddLevels() {
        System.out.println("Anem a provar el driver de addLevels");
        Scanner in = new Scanner(System.in);
        System.out.println("Introdueix el nom del studyProgram");
        String name = in.next();
        StudyProgram studyprogram = new StudyProgram(name);
        System.out.println("S'ha creat el StudyProgram amb el nom " + name + " i 0 nivell inicialment");
        System.out.println("Crida la funcio addLevels");
        studyprogram.addLevels(true);
        System.out.println("StudyProgram " + name + "ara te " + studyprogram.getnLevels() + " levels");
        System.out.println("Funcion addLevels acabat sense cap excepció");
	System.out.println("Sortint del driver de addLevels");
        System.out.println();
        
    }
    
    private static void llistatfunctions() {
		System.out.println("-1: Sortir del driver");
		System.out.println("1: Constructora");
                System.out.println("2: addLevels");
                System.out.println("3: removeLevel");
	}
    
}
