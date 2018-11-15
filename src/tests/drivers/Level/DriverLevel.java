
package tests.drivers.Level;
import domain.*;
import java.util.Iterator;


public class DriverLevel {
    private static Level a = new Level(1);
    
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
