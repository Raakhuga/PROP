
package tests.drivers.Timetable;

import domain.*;
import java.util.Scanner;

public class DriverTimetable {
    
    private static ClassroomTimetable t = new ClassroomTimetable(0, 0, 1);
    
    public static void main(String[] args) throws Exception{
        System.out.println("Aquest és el driver de group, anem a crear un grup");
        driverConstructora();
        System.out.println("Ara que està creat el grup, escull que vols fer:");
        llistat_funcionalitats();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n != -1){
            switch(n){
                    case 1:
                        driverSetGStoTimetable(t);
                        break;
                    case 2:
                        driverGetGroupSubject(t);
                        break;
                    case 3:
                        driverRemoveHourOfTimetable(t);
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
        System.out.println("1: Assignar un grup-assignatura a una franja horària determinada");
        System.out.println("2: Consultar el grup-assignatura que hi ha assignat a una franja horària determinada");
        System.out.println("3: Treure un grup-assignatura d'una franja horària determinat");
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
        ClassroomTimetable t = new ClassroomTimetable(days, hIni, hEnd);
        System.out.println("S'ha creat l'horari amb "+t.getnDays()+" columnes i "+(t.gethEnd()-t.gethIni())+" files");
        System.out.println();
    }
    
    private static void driverSetGStoTimetable(ClassroomTimetable t){
        System.out.println("Anem a provar el driver de setGStoTimetable");
        Scanner in = new Scanner(System.in);
        System.out.println("Escriu el nom de l'assignatura");
        String name = in.next();
        System.out.println("Escriu a quin nivell pertany l'assignatura");
        int lvl = in.nextInt();
        System.out.println("Escriu quantes hores de classe fa l'assignatura (per setmana)");
        int hours = in.nextInt();
        Subject s = new Subject(name, lvl, hours);
        System.out.println("Escriu el numero del grup");
        int num = in.nextInt();
        System.out.println("Escriu quants dies te la setmana lectiva");
        int days = in.nextInt();
        System.out.println("Escriu hora inicial del dia lectiu");
        int hIni = in.nextInt();
        System.out.println("Escriu hora final del dia lectiu");
        int hEnd = in.nextInt();
        System.out.println("Escriu la quantitat d'estudiants matriculats a aquest grup");
        int nMats = in.nextInt();
        Group g = new Group(num, days, hIni, hEnd, nMats);System.out.println("El grup de l'assignatura es de tipus teoria?");
        boolean teoria = false;
        boolean lab = false;
        boolean problems = false;
        String str = in.next();
        if (str.equals("false")){
            System.out.println("El grup de l'assignatura es de tipus lab?");
            str = in.next();
            if (str.equals("false")){
                System.out.println("El grup de l'assignatura es de tipus problems?");
                str = in.next();
                if (str.equals("true")) problems = true;
            }
            else{
                lab = true;
            }
        }
        else {
            teoria = true;
        }
        GroupSubject gs = new GroupSubject(s, g, nMats, teoria, lab, problems);
        System.out.println("Escriu el dia on vols afegir el grup-assignatura, ha de ser un valor entre 0 i "+(t.getnDays()-1));
        int day = in.nextInt();
        while (day < 0 || day >= t.getnDays()){
            System.out.println("Valor invàlid, escriu un entre 0 i "+(t.getnDays()-1));
            day = in.nextInt();
        }
        System.out.println("Escriu l'hora on vols afegir el grup-assignatura, ha de ser un valor entre "+t.gethIni()+" i "+(t.gethEnd()-1));
        int hour = in.nextInt();
        while (hour < t.gethIni() || hour >= t.gethEnd()){
            System.out.println("Valor invàlid, escriu un entre "+t.gethIni()+" i "+(t.gethEnd()-1));
            hour = in.nextInt();
        }
        hour -= t.gethIni();
        t.setGStoTimetable(gs, day, hour);
        if (t.getGroupSubject(day,hour) != null) System.out.println("S'ha afegit correctament el grup-assignatura");
        else System.out.println("No s'ha afegit correctament");
        System.out.println();
    }
    
    private static void driverGetGroupSubject(ClassroomTimetable t){
        System.out.println("Anem a provar el driver de getGroupSubject");
        Scanner in = new Scanner(System.in);
        GroupSubject gs = t.getGroupSubject(2, 2);
        if (gs != null) System.out.println("S'ha seleccionat el group-subject amb numero "+gs.getGroup().getNum()+" i l'assignatura amb nom "+gs.getSubject().getName());
        else System.out.println("La franja horaria està buida");
        System.out.println();
    }
    
    private static void driverRemoveHourOfTimetable(ClassroomTimetable t){
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
