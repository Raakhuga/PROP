
package tests.drivers.GroupRestrictions;

import domain.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;



public class DriverGroupRestrictions {
    private static GroupRestrictions a = new GroupRestrictions();
    private static GroupRestrictions b = new GroupRestrictions();
    private static GroupRestrictions c = new GroupRestrictions();
    
    
    public static final String[] subjects = new String[] { "M1", "F", "FM" };
    public static final Set<String> bansubjects = new HashSet<>(Arrays.asList(subjects));
    
    public static final String[] classrooms = new String[] { "A5101", "A5E01" ,"A6E02" };
    public static final Set<String> bannedclassrooms = new HashSet<>(Arrays.asList(classrooms));
    
    
    public static void main(String[] args) throws Exception{
        
        a.setBanned(true);
        a.banSubject("M1");
        a.banSubject("F");
        a.banSubject("FM");
        a.banClassroom("A5101");
        a.banClassroom("A5E01");
        a.banClassroom("A6E02");
        if (a.getBanned() && a.getBansubjects() == bansubjects && a.getBanclassrooms() == bannedclassrooms)
            System.out.println("Correct");
        driverGR();
        System.out.println("Driver ha acabat amb exit");
    }
    
    private static void driverGR(){
        
        Scanner in = new Scanner(System.in);
        String state, c, s;
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
        System.out.println("Insert the number of banned classrooms");
        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            System.out.println("Insert the reference of the banned Classroom n: " + i);
            c = in.next();
            b.banClassroom(c);
        }
        System.out.println("Insert the number of banned Subjects");
        n = in.nextInt();
        for(int i = 0; i < n; i++) {
            System.out.println("Insert the name of the banned Subject n: " + i);
            s = in.next();
            b.banSubject(s);
        }
        System.out.println("The bolean state of Banned is: " + b.getBanned());
        Iterator<String> it = b.getBanclassrooms().iterator(); 
        while(it.hasNext()) System.out.println("The classroom: " + it.next() + " is banned");
        Iterator<String> it2 = b.getBansubjects().iterator(); 
        while(it2.hasNext()) System.out.println("The subject: " + it2.next() + " is banned");
        
        
    }
}
