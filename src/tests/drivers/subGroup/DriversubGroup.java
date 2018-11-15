
package tests.drivers.subGroup;

import domain.*;
import java.util.Scanner;

public class DriversubGroup {
    
    private static subGroup sg = new subGroup(0, 0, 0, 0, 0);
    
    public static void main(String[] args) throws Exception{
        System.out.println("Aquest és el driver de subgroup, anem a crear un subgrup");
        driverConstructora();
        System.out.println("Ara que està creat el subgrup, escull que vols fer:");
        llistat_funcionalitats();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n != -1){
            switch(n){
                    case 1:
                        driverSetSubject(sg);
                        break;
                    case 2:
                        driverGetTimetable(sg);
                        break;
                    case 3:
                        driverSetType(sg);
                        break;
                    case 4:
                        driverRemoveSubject(sg);
                        break;
            }
            System.out.println("Escull una altre funcionalitat:");
            llistat_funcionalitats();
            n = in.nextInt();
        }
        System.out.println("Driver ha acabat amb exit");
    }
    
    private static void llistat_funcionalitats(){
        System.out.println("-1: Sortir");
        System.out.println("1: Assignar una assignatura a una franja horària determinada");
        System.out.println("2: Consultar l'assignatura que hi ha assignada a una franja horària determinada");
        System.out.println("3: Assignar el tipus de la classe de l'assignatura");
        System.out.println("4: Treure una assignatura d'una franja horària determinada");
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
        sg = new subGroup(num, days, hIni, hEnd, nMats);
        System.out.println("S'ha creat el subgrup " +sg.getsNum()+" amb "+sg.getnMat()+" matriculats");
        System.out.println();
    }
    
    private static void driverSetSubject(subGroup sg){
        System.out.println("Anem a provar el driver de setSubject");
        Scanner in = new Scanner(System.in);
        System.out.println("Escriu el nom de l'assignatura");
        String name = in.next();
        System.out.println("Escriu a quin nivell pertany l'assignatura");
        int lvl = in.nextInt();
        System.out.println("Escriu quantes hores de classe fa l'assignatura (per setmana)");
        int hours = in.nextInt();
        Subject s = new Subject(name, lvl, hours);
        System.out.println("S'ha creat l'assignatura "+s.getName()+" que es del "+s.getLevel()+" nivell i fa "+s.getHours()+" hores a la setmana");
        System.out.println("Escriu el dia on la vols afegir, ha de ser un valor entre 0 i "+(sg.getnDays()-1));
        int day = in.nextInt();
        while (day < 0 || day >= sg.getnDays()){
            System.out.println("Valor invàlid, escriu un entre 0 i "+(sg.getnDays()-1));
            day = in.nextInt();
        }
        System.out.println("Escriu l'hora on la vols afegir, ha de ser un valor entre "+sg.gethIni()+" i "+(sg.gethEnd()-1));
        int hour = in.nextInt();
        while (hour < sg.gethIni() || hour >= sg.gethEnd()){
            System.out.println("Valor invàlid, escriu un entre "+sg.gethIni()+" i "+(sg.gethEnd()-1));
            hour = in.nextInt();
        }
        hour -= sg.gethIni();
        sg.setSubject(day, hour, s);
        if (sg.getTimetable()[day][hour] != null) System.out.println("S'ha afegit l'assignatura "+sg.getTimetable()[day][hour].getName());
        else System.out.println("Hi ha hagut un problema al afegir l'assignatura");
        System.out.println();
    }
    
    private static void driverGetTimetable(subGroup sg){
        System.out.println("Anem a provar el driver de getTimetable");
        Scanner in = new Scanner(System.in);
        System.out.println("Escriu el dia que vols consultar, ha de ser un valor entre 0 i "+(sg.getnDays()-1));
        int day = in.nextInt();
        while (day < 0 || day >= sg.getnDays()){
            System.out.println("Valor invàlid, escriu un entre 0 i "+(sg.getnDays()-1));
            day = in.nextInt();
        }
        System.out.println("Escriu l'hora que vols consultar, ha de ser un valor entre "+sg.gethIni()+" i "+(sg.gethEnd()-1));
        int hour = in.nextInt();
        while (hour < sg.gethIni() || hour >= sg.gethEnd()){
            System.out.println("Valor invàlid, escriu un entre "+sg.gethIni()+" i "+(sg.gethEnd()-1));
            hour = in.nextInt();
        }
        hour -= sg.gethIni();
        System.out.println("L'assignatura que ha consultat es: "+sg.getTimetable()[day][hour].getName());
        System.out.println();
    }
    
    private static void driverSetType(subGroup sg){
        System.out.println("Anem a provar el driver de setType");
        Scanner in = new Scanner(System.in);
        System.out.println("Escriu el dia on vols definir el tipus de la classe, ha de ser un valor entre 0 i "+(sg.getnDays()-1));
        int day = in.nextInt();
        while (day < 0 || day >= sg.getnDays()){
            System.out.println("Valor invàlid, escriu un entre 0 i "+(sg.getnDays()-1));
            day = in.nextInt();
        }
        System.out.println("Escriu l'hora on vols definir el tipus de la classe, ha de ser un valor entre "+sg.gethIni()+" i "+(sg.gethEnd()-1));
        int hour = in.nextInt();
        while (hour < sg.gethIni() || hour >= sg.gethEnd()){
            System.out.println("Valor invàlid, escriu un entre "+sg.gethIni()+" i "+(sg.gethEnd()-1));
            hour = in.nextInt();
        }
        hour -= sg.gethIni();
        System.out.println("Escriu el tipus de la classe que vols definir");
        String type = in.next();
        sg.setType(day, hour, type);
        if (sg.getType(day, hour) != null) System.out.println("S'ha afegit el tipus "+sg.getType(day, hour));
        else System.out.println("Hi ha hagut un problema al afegir l'assignatura");
        System.out.println();
    }
    
    private static void driverRemoveSubject(subGroup sg){
        System.out.println("Anem a provar el driver de removeSubject");
        Scanner in = new Scanner(System.in);
        System.out.println("Escriu el dia d'on vols treure l'assignatura, ha de ser un valor entre 0 i "+(sg.getnDays()-1));
        int day = in.nextInt();
        while (day < 0 || day >= sg.getnDays()){
            System.out.println("Valor invàlid, escriu un entre 0 i "+(sg.getnDays()-1));
            day = in.nextInt();
        }
        System.out.println("Escriu l'hora d'on vols treure l'assignatura, ha de ser un valor entre "+sg.gethIni()+" i "+(sg.gethEnd()-1));
        int hour = in.nextInt();
        while (hour < sg.gethIni() || hour >= sg.gethEnd()){
            System.out.println("Valor invàlid, escriu un entre "+sg.gethIni()+" i "+(sg.gethEnd()-1));
            hour = in.nextInt();
        }
        hour -= sg.gethIni();
        sg.removeSubject(day, hour);
        if (sg.getTimetable()[day][hour] != null) System.out.println("L'assignatura que ha consultat es: "+sg.getTimetable()[day][hour].getName());
        else System.out.println("S'ha tret l'assignatura satisfactòriament");
        System.out.println();
    }
    
}
