
package tests.drivers.GroupSubject;

import domain.*;
import java.util.Scanner;

public class driverGroupSubject {
    
    public static void main(String[] args) throws Exception{
        System.out.println("Aquest es el driver de groupSubject");
        System.out.println("Aquesta relació pot ser entre grup-assignatura o bé entre subgrup-assignatura, escull quina vols seleccionar:");
        System.out.println("1- Grup-Subject");
        System.out.println("2- Subgrup-Subject");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        switch(n){
                case 1:
                    driverConstructoraGroupSubject();
                    break;
                case 2:
                    driverConstructorasubGroupSubject();
                    break;
        }
        System.out.println("Driver ha acabat amb exit");
    }
    
    private static void driverConstructoraGroupSubject(){
        System.out.println("Anem a provar el driver de la constructora del GroupSubject");
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
        Group g = new Group(num, days, hIni, hEnd, nMats);
        System.out.println("El grup de l'assignatura es de tipus teoria?");
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
        System.out.println("S'ha creat correctament el group-subject");
        System.out.println();
    }
    
    private static void driverConstructorasubGroupSubject(){
        System.out.println("Anem a provar el driver de la constructora del subGroupSubject");
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
        Group g = new Group(num, days, hIni, hEnd, nMats);
        System.out.println("Escriu el numero del subgrup");
        num = in.nextInt();
        System.out.println("Escriu quants dies te la setmana lectiva");
        days = in.nextInt();
        System.out.println("Escriu hora inicial del dia lectiu");
        hIni = in.nextInt();
        System.out.println("Escriu hora final del dia lectiu");
        hEnd = in.nextInt();
        System.out.println("Escriu la quantitat d'estudiants matriculats a aquest subgrup");
        nMats = in.nextInt();
        subGroup sg = new subGroup(num, days, hIni, hEnd, nMats);
        System.out.println("El subgrup de l'assignatura es de tipus teoria?");
        boolean teoria = false;
        boolean lab = false;
        boolean problems = false;
        String str = in.next();
        if (str.equals("false")){
            System.out.println("El subgrup de l'assignatura es de tipus lab?");
            str = in.next();
            if (str.equals("false")){
                System.out.println("El subgrup de l'assignatura es de tipus problems?");
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
        GroupSubject gs = new GroupSubject(s, g, sg, nMats, teoria, lab, problems);
        System.out.println("S'ha creat correctament el subgroup-subject");
        System.out.println();
    }
}
