
package tests.drivers.Level;
import domain.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class DriverLevel {
    private static Level a = new Level(1);
    
    private void fillLevel(Level level) {
        System.out.println ("Insert the number of Subjects of the Level: " + level.getIden());
        Scanner in = new Scanner(System.in);
        int nSubjects, hours;
        nSubjects = in.nextInt();
        String name;
        List<Subject> subjects = new ArrayList<Subject>();
        Subject act;
        for(int j = 0; j < nSubjects; j++) {
            System.out.println ("Insert the name of the Subject num: " + j + " of the Level: " + level.getIden());
            name = in.next();
            System.out.println ("Insert the number of hours of the Subject: " + name + " of the Level: " + level.getIden());
            hours = in.nextInt();
            act = new Subject(name, level.getIden(), hours);
            act.manualFillHours();
            subjects.add(act);
        }
        level.setSubjects(subjects);
    }
    
    public static void main(String[] args) throws Exception{
        a.fillLevel(true);
        
        a.addGroup(10, 80, 10);
        
        a.addGroup(20, 56, 10);
        
        Iterator<Subject> Sit = a.getSubjects().iterator();
        int theory, lab, problems;
        while(Sit.hasNext()) {
            Subject act = Sit.next();
            theory = act.getTheoryH();
            lab = act.getLaboratoryH();
            problems = act.getProblemsH();
            System.out.println ("The Level " + a.getIden() + " has the Subject " + act.getName() + " wich has " + theory + 
                    "h of Theory " + lab + "h of Laboratory and " + problems + "h of problems and a total of " 
                    + act.getHours() + "h");
        }
        
        Iterator<Group> Git = a.getGroups().iterator();
        while(Git.hasNext()) {
            Group act = Git.next();
            Iterator<subGroup> SGit = act.getsubGroups().iterator();
            System.out.println ("The Level " + a.getIden() + " has the Group " + act.getNum() + " wich has " 
                    + act.getnDays() + " abailavle days, starts at " + act.gethIni() + ", ends at " +
                    act.gethEnd() + " and has " + act.getnMat() + " Students");
            while(SGit.hasNext()){
                subGroup SGact = SGit.next();
                System.out.println ("The Level " + a.getIden() + " has the subGroup " + SGact.getsNum() + " wich has " 
                        + SGact.getnDays() + " abailavle days, starts at " + SGact.gethIni() + ", ends at " +
                        SGact.gethEnd() + " and has " + SGact.getnMat() + " Students");
            }
        }
    }
}
