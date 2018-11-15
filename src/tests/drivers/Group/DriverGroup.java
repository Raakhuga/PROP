
package tests.drivers.Group;

import domain.*;
import java.util.Scanner;

public class DriverGroup {
    
    private static Group g = new Group(0, 0, 0, 0, 0);
    
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
                        driverSetSubject(g);
                        break;
                    case 2:
                        driverGetTimetable(g);
                        break;
                    case 3:
                        driverSetType(g);
                        break;
                    case 4:
                        driverRemoveSubject(g);
                        break;
                    case 5:
                        driverAddSubGroup(g);
                        break;
                    case 6: 
                        driverGetSpecifiedSubGroup(g);
                        break;
                    case 7:
                        driverRemoveSubGroup(g);
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
        System.out.println("5: Afegir subgrup");
        System.out.println("6: Consultar subgrup");
        System.out.println("7: Eliminar subgrup");
    }
    
    private static void driverConstructora(){
        System.out.println("Anem a provar el driver de la constructora");
        Scanner in = new Scanner(System.in);
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
        Group g = new Group(num, days, hIni, hEnd, nMats);
        System.out.println("S'ha creat el grup " +g.getNum()+" amb "+g.getnMat()+" matriculats");
        System.out.println();
    }
    
    private static void driverSetSubject(Group g){
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
        System.out.println("Escriu el dia on la vols afegir, ha de ser un valor entre 0 i "+(g.getnDays()-1));
        int day = in.nextInt();
        while (day < 0 || day >= g.getnDays()){
            System.out.println("Valor invàlid, escriu un entre 0 i "+(g.getnDays()-1));
            day = in.nextInt();
        }
        System.out.println("Escriu l'hora on la vols afegir, ha de ser un valor entre "+g.gethIni()+" i "+(g.gethEnd()-1));
        int hour = in.nextInt();
        while (hour < g.gethIni() || hour >= g.gethEnd()){
            System.out.println("Valor invàlid, escriu un entre "+g.gethIni()+" i "+(g.gethEnd()-1));
            hour = in.nextInt();
        }
        hour -= g.gethIni();
        g.setSubject(day, hour, s);
        if (g.getTimetable()[day][hour] != null) System.out.println("S'ha afegit l'assignatura "+g.getTimetable()[day][hour].getName());
        else System.out.println("Hi ha hagut un problema al afegir l'assignatura");
        System.out.println();
    }
    
    private static void driverGetTimetable(Group g){
        System.out.println("Anem a provar el driver de getTimetable");
        Scanner in = new Scanner(System.in);
        System.out.println("Escriu el dia que vols consultar, ha de ser un valor entre 0 i "+(g.getnDays()-1));
        int day = in.nextInt();
        while (day < 0 || day >= g.getnDays()){
            System.out.println("Valor invàlid, escriu un entre 0 i "+(g.getnDays()-1));
            day = in.nextInt();
        }
        System.out.println("Escriu l'hora que vols consultar, ha de ser un valor entre "+g.gethIni()+" i "+(g.gethEnd()-1));
        int hour = in.nextInt();
        while (hour < g.gethIni() || hour >= g.gethEnd()){
            System.out.println("Valor invàlid, escriu un entre "+g.gethIni()+" i "+(g.gethEnd()-1));
            hour = in.nextInt();
        }
        hour -= g.gethIni();
        System.out.println("L'assignatura que ha consultat es: "+g.getTimetable()[day][hour].getName());
        System.out.println();
    }
    
    private static void driverSetType(Group g){
        System.out.println("Anem a provar el driver de setType");
        Scanner in = new Scanner(System.in);
        System.out.println("Escriu el dia on vols definir el tipus de la classe, ha de ser un valor entre 0 i "+(g.getnDays()-1));
        int day = in.nextInt();
        while (day < 0 || day >= g.getnDays()){
            System.out.println("Valor invàlid, escriu un entre 0 i "+(g.getnDays()-1));
            day = in.nextInt();
        }
        System.out.println("Escriu l'hora on vols definir el tipus de la classe, ha de ser un valor entre "+g.gethIni()+" i "+(g.gethEnd()-1));
        int hour = in.nextInt();
        while (hour < g.gethIni() || hour >= g.gethEnd()){
            System.out.println("Valor invàlid, escriu un entre "+g.gethIni()+" i "+(g.gethEnd()-1));
            hour = in.nextInt();
        }
        hour -= g.gethIni();
        System.out.println("Escriu el tipus de la classe que vols definir");
        String type = in.next();
        g.setType(day, hour, type);
        if (g.getType(day, hour) != null) System.out.println("S'ha afegit el tipus "+g.getType(day, hour));
        else System.out.println("Hi ha hagut un problema al afegir l'assignatura");
        System.out.println();
    }
    
    private static void driverRemoveSubject(Group g){
        System.out.println("Anem a provar el driver de removeSubject");
        Scanner in = new Scanner(System.in);
        System.out.println("Escriu el dia d'on vols treure l'assignatura, ha de ser un valor entre 0 i "+(g.getnDays()-1));
        int day = in.nextInt();
        while (day < 0 || day >= g.getnDays()){
            System.out.println("Valor invàlid, escriu un entre 0 i "+(g.getnDays()-1));
            day = in.nextInt();
        }
        System.out.println("Escriu l'hora d'on vols treure l'assignatura, ha de ser un valor entre "+g.gethIni()+" i "+(g.gethEnd()-1));
        int hour = in.nextInt();
        while (hour < g.gethIni() || hour >= g.gethEnd()){
            System.out.println("Valor invàlid, escriu un entre "+g.gethIni()+" i "+(g.gethEnd()-1));
            hour = in.nextInt();
        }
        hour -= g.gethIni();
        g.removeSubject(day, hour);
        if (g.getTimetable()[0][1] != null) System.out.println("L'assignatura que ha consultat es: "+g.getTimetable()[day][hour].getName());
        else System.out.println("S'ha tret l'assignatura satisfactòriament");
        System.out.println();
    }
    
    private static void driverAddSubGroup(Group g){
        System.out.println("Anem a provar el driver de addSubGroup");
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
        g.addSubGroup(sg);
        if (!g.getsubGroups().isEmpty()) System.out.println("S'ha afegit correctament el subgrup "+g.getsubGroups().get(0).getsNum());
        else System.out.println("No s'ha pogut afegir correctamente el subgrup");
        System.out.println();
    }
    
    private static void driverGetSpecifiedSubGroup(Group g){
        System.out.println("Anem a provar el driver de getSpecifiedSubGroup");
        Scanner in = new Scanner(System.in);
        System.out.println("Escriu el numero del subgrup que vols seleccionar");
        int num = in.nextInt();
        subGroup sg = g.getSpecifiedSubGroup(num);
        while (sg == null) {
            System.out.println("Escriu el numero del subgrup que vols seleccionar, que estigui a la llista");
            num = in.nextInt();
            sg = g.getSpecifiedSubGroup(num);
        }
        System.out.println("S'ha seleccionat el subgrup amb numero "+sg.getsNum());
        System.out.println();
        
    }
    
    private static void driverRemoveSubGroup(Group g){
        System.out.println("Anem a provar el driver de removeSubGroup");
        Scanner in = new Scanner(System.in);
        System.out.println("Escriu el numero del subgrup que vols treure de la llista");
        int num = in.nextInt();
        subGroup sg = g.getSpecifiedSubGroup(num);
        while(!g.getsubGroups().contains(sg)){
            System.out.println("El grup seleccionat no es pot treure perque no esta a la llista, seleccioni un altre subgrup");
            num = in.nextInt();
            sg = g.getSpecifiedSubGroup(num);
        }
        g.removeSubGroup(sg);
        System.out.println("S'ha tret el subgrup satisfactoriament");
        System.out.println();
    }
}
