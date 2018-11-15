
package tests.drivers.Timetable;

import domain.*;
import java.util.Scanner;

public class DriverTimetable {
    
    public static void main(String[] args) throws Exception{
        System.out.println("Aquest es el driver de timetable");
        driverConstructora();
        System.out.println("Driver ha acabat amb exit");
    }
    
    private static void driverConstructora(){
        System.out.println("Anem a provar el driver de la constructora");
        Scanner in = new Scanner(System.in);
        System.out.println("Escriu quants dies te la setmana lectiva");
        int days = in.nextInt();
        System.out.println("Escriu hora inicial del dia lectiu");
        int hIni = in.nextInt();
        System.out.println("Escriu hora final del dia lectiu");
        int hEnd = in.nextInt();
        Timetable t = new Timetable(days, hIni, hEnd);
        System.out.println("S'ha creat l'horari amb "+t.getnDays()+" columnes i "+(t.gethEnd()-t.gethIni())+" files");
        System.out.println();
        driverSetGStoTimetable(t);
    }
    
    private static void driverSetGStoTimetable(Timetable t){
        System.out.println("Anem a provar el driver de setGStoTimetable");
        Scanner in = new Scanner(System.in);
        Subject s = new Subject("prop", 3, 4);
        Group g = new Group(10, 7, 8, 20, 40);
        GroupSubject gs = new GroupSubject(s, g, 40, true, false, false);
        t.setGStoTimetable(gs, 2, 2);
        if (t.getGroupSubject(2,2) != null) System.out.println("S'ha afegit correctament el group-subject");
        else System.out.println("No s'ha afegit correctament");
        System.out.println();
        driverGetGroupSubject(t);
    }
    
    private static void driverGetGroupSubject(Timetable t){
        System.out.println("Anem a provar el driver de getGroupSubject");
        Scanner in = new Scanner(System.in);
        GroupSubject gs = t.getGroupSubject(2, 2);
        if (gs != null) System.out.println("S'ha seleccionat el group-subject amb numero "+gs.getGroup().getNum()+" i l'assignatura amb nom "+gs.getSubject().getName());
        else System.out.println("La franja horaria està buida");
        System.out.println();
        driverRemoveHourOfTimetable(t);
    }
    
    private static void driverRemoveHourOfTimetable(Timetable t){
        System.out.println("Anem a provar el driver de removeHourOfTimetable");
        Scanner in = new Scanner(System.in);
        System.out.println("Escriu el dia d'on vols treure el group-subject, ha de ser un valor entre 0 i "+(t.getnDays()-1));
        int day = in.nextInt();
        while (day < 0 || day >= t.getnDays()){
            System.out.println("Valor invàlid, escriu un entre 0 i "+(t.getnDays()-1));
            day = in.nextInt();
        }
        System.out.println("Escriu l'hora d'on vols treure l'assignatura, ha de ser un valor entre "+t.gethIni()+" i "+(t.gethEnd()-1));
        int hour = in.nextInt();
        while (hour < t.gethIni() || hour >= t.gethEnd()){
            System.out.println("Valor invàlid, escriu un entre "+t.gethIni()+" i "+(t.gethEnd()-1));
            hour = in.nextInt();
        }
        hour -= t.gethIni();
        t.removeHourOfTimetable(day,hour);
        if (t.getGroupSubject(day, hour) != null) System.out.println("No s'ha esborrat correctament");
        else System.out.println("S'ha esborrat correctament");
        System.out.println();
    }
}
