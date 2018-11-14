
package tests.drivers.subGroup;

import domain.*;

public class DriversubGroup {
    
    //private static subGroup sg = new subGroup(11, 7, 8, 20, 20);
    
    public static void main(String[] args) throws Exception{
        System.out.println("Aquest es el driver de subgroup");
        driverGetTimetable();
        System.out.println("Driver ha acabat amb exit");
    }
    
    private static void driverGetTimetable(){
        System.out.println("Anem a provar el driver de getTimetable");
        subGroup prova = new subGroup(11, 7, 8, 20, 10);
        System.out.println("S'ha creat el subgrup: " +prova.getsNum()+"amb "+prova.getnMat()+" matriculats");
        Subject s = new Subject("prop", 3, 1);
        System.out.println("Emplena l'horari del subgrup amb l'assignatura "+s.getName()+" que s'acaba de crear");
        prova.setSubject(0, 1, s);
        System.out.println("S'ha emplenat l'horari");
        System.out.println("L'assignatura de primera hora del primer dia es: "+prova.getTimetable()[0][1].getName());
    }
    
    private static void driverSetSubject(){
        subGroup prova = new subGroup(11, 7, 8, 20, 10);
        System.out.println("S'ha creat el subgrup: " +prova.getsNum()+"amb "+prova.getnMat()+" matriculats");
        Subject s = new Subject("prop", 3, 1);
        System.out.println("Emplena l'horari del subgrup amb l'assignatura "+s.getName()+" que s'acaba de crear");
        prova.setSubject(0, 1, s);
        System.out.println("S'ha emplenat l'horari");
    }
    
    
}
