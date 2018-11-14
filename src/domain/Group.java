
package domain;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Group {
    
    /** Atributtes **/
    public int num;
    public Subject[][] groupTimetable;
    public Restrictions[][] groupRestrictions;
    private List<subGroup> subGroups;
    private int nMat;
    
    /** Constructor **/
    public Group(int num, int nDays, int hIni, int hEnd, int nMat){
        this.num = num;
        groupTimetable = new Subject[nDays][hEnd-hIni];
        groupRestrictions = new Restrictions[nDays][hEnd-hIni];
        subGroups = new ArrayList<>();
        this.nMat = nMat;
    }
    
    public Group(int num, Timetable groupTimetable){
        this.num = num;
        groupTimetable = groupTimetable;
    }

    public int getNum() {
        return num;
    }
    
    public Subject[][] getTimetable() {
        return groupTimetable;
    }
    
    public List<subGroup> getsubGroups() {
        return subGroups;
    }
    
    public int getnMat() {
        return nMat;
    }
    
    public void setTimetable(Subject[][] groupTimetable) {
        this.groupTimetable = groupTimetable;
    } 
    
    public void setSubject(int day, int hour, Subject subject){
        groupTimetable[day][hour] = subject;
    }
    
    public void removeSubject(int day, int hour){
        groupTimetable[day][hour] = null;
    }
    
    public void addSubGroup(subGroup subGroup) {
        subGroups.add(subGroup);
    }
    
    public void removeSubGroup(subGroup subGroup) {
        subGroups.add(subGroup);
    }
    
    public void save() throws IOException {
        String file = "state.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("Group");
        bw.write(num);
        bw.close(); 
    }
}
