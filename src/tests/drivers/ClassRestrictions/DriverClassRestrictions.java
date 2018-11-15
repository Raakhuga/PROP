
package tests.drivers.ClassRestrictions;

import domain.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class DriverClassRestrictions {
    private static ClassRestrictions a = new ClassRestrictions();
    private static ClassRestrictions b = new ClassRestrictions();
    private static ClassRestrictions c = new ClassRestrictions();
    
    
    public static List<String> bansubjects = new ArrayList<>();
    
    public static List<Integer> bannedgroups = new ArrayList<>();
    
    
    public static void main(String[] args) throws Exception{
        bansubjects.add("M1");
        bansubjects.add("F");
        bansubjects.add("FM");
        
        bannedgroups.add(11);
        bannedgroups.add(13);
        bannedgroups.add(10);
        
        a.setBanned(true);
        a.banSubject("M1");
        a.banSubject("F");
        a.banSubject("FM");
        a.banGroup(11);
        a.banGroup(13);
        a.banGroup(10);
       
        boolean correct = true;
        
        Iterator<String> it1 = bansubjects.iterator();
        Iterator<Integer> it2 = bannedgroups.iterator();
        
        while(it1.hasNext()) {
            correct = a.subjectBanned(it1.next());
        }
        
        
        while(it2.hasNext()) {
            correct = a.groupBanned(it2.next());
        }
        
        if (a.getBanned() && correct)
            System.out.println("Correct");
        driverGR();
        System.out.println("Driver ha acabat amb exit");
    }
    
    private static void driverGR(){
        
        Scanner in = new Scanner(System.in);
        String state, s;
        int g;
        System.out.println("Insert the boolean state of banned");
        state = in.next();
        boolean correct = false;
        while(!correct) {
            if (state.equals("true")){
                b.setBanned(true);
                correct = true;
            }
            else if (state.equals("false")) {
                b.setBanned(false);
                correct = true;
            }
            else {
                System.out.println("Incorrect argument, try it again");
                state = in.next();
            }
        }
        System.out.println("Insert the number of banned groups");
        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            System.out.println("Insert the id of the banned Group n: " + i);
            g = in.nextInt();
            b.banGroup(g);
        }
        System.out.println("Insert the number of banned Subjects");
        n = in.nextInt();
        for(int i = 0; i < n; i++) {
            System.out.println("Insert the name of the banned Subject n: " + i);
            s = in.next();
            b.banSubject(s);
        }
        System.out.println("The bolean state of Banned is: " + b.getBanned());
        Iterator<Integer> it = b.getGroups().iterator(); 
        while(it.hasNext()) System.out.println("The classroom: " + it.next() + " is banned");
        Iterator<String> it2 = b.getBansubjects().iterator(); 
        while(it2.hasNext()) System.out.println("The subject: " + it2.next() + " is banned");
        
        
    }
}
