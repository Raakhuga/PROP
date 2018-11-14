
package tests.drivers.subGroup;

import domain.*;
import java.util.Scanner;

public class DriversubGroup {
    
    //private static subGroup prova = new subGroup(11, 7, 8, 20, 20);
    
    public static void main(String[] args) throws Exception{
        System.out.println("Aquest es el driver de subgroup");
        driverConstructora();
        /*driverGetTimetable();
        driverRemoveSubject();*/
        System.out.println("Driver ha acabat amb exit");
    }
    
    private static void driverConstructora(){
        System.out.println("Anem a provar el driver de la constructora");
        Scanner in = new Scanner(System.in);
        System.out.println("Escriu el numero del subgrup");
        int num = in.nextInt();
        System.out.println("Escriu quants dies te la setmana lectiva");
        int days = in.nextInt();
        System.out.println("Escriu hora inicial del dia lectiu");
        int hIni = in.nextInt();
        System.out.println("Escriu hora final del dia lectiu");
        int hEnd = in.nextInt();
        System.out.println("Escriu la quantitat d'estudiants matriculats a aquest subgrup");
        int nMats = in.nextInt();
        subGroup sg = new subGroup(num, days, hIni, hEnd, nMats);
        System.out.println("S'ha creat el subgrup " +sg.getsNum()+" amb "+sg.getnMat()+" matriculats");
        System.out.println();
        driverSetSubject(sg);
    }
    
    private static void driverSetSubject(subGroup sg){
        System.out.println("Anem a provar el driver de setSubject");
        Scanner in = new Scanner(System.in);
        System.out.println("Escriu el nom de l'assignatura");
        String name = in.next();
        System.out.println("Escriu a quin nivell ")
        Subject s = new Subject("prop", 3, 1);
        System.out.println("Emplena l'horari del subgrup amb l'assignatura "+s.getName()+" que s'acaba de crear");
        sg.setSubject(0, 1, s);
        if (sg.getTimetable()[0][1] != null) System.out.println("S'ha emplenat l'horari");
        else System.out.println("Hi ha hagut un problema a l'emplenar l'horari");
        System.out.println();
    }
    
    private static void driverGetTimetable(){
        System.out.println("Anem a provar el driver de getTimetable");
        System.out.println("L'assignatura de primera hora del primer dia es: "+prova.getTimetable()[0][1].getName());
        System.out.println();
    }
    
    private static void driverRemoveSubject(){
        System.out.println("Anem a provar el driver de removeSubject");
        prova.removeSubject(0, 1);
        if (prova.getTimetable()[0][1] != null) System.out.println("L'assignatura de primera hora del primer dia es: "+prova.getTimetable()[0][1].getName());
        else System.out.println("S'ha tret l'assignatura satisfactòriament");
        Subject s = new Subject("par", 3, 1);
        prova.setSubject(1, 1, s);
        System.out.println("S'ha afegit una assignatura a l'horari");
        System.out.println("L'assignatura de primera hora del segon dia es: "+prova.getTimetable()[1][1].getName());
        System.out.println();
    }
    
}
