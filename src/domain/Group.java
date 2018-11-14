
package domain;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Group {
    
    /** Atributtes **/
    public int num;
    public Timetable groupTimetable;
    private List<subGroup> subGroups;
    private int nMat;
    
    /** Constructor **/
    public Group(int num, int nDays, int hIni, int hEnd, int nMat){
        this.num = num;
        groupTimetable = new Timetable(nDays, hIni, hEnd);
        subGroups = new ArrayList<subGroup>();
        this.nMat = nMat;
    }
    
    public Group(int num, Timetable groupTimetable){
        this.num = num;
        groupTimetable = groupTimetable;
    }

    public int getNum() {
        return num;
    }
    
    public Timetable getTimetable() {
        return groupTimetable;
    }
    
    public List<subGroup> getsubGroups() {
        return subGroups;
    }
    
    public int getnMat() {
        return nMat;
    }
    
    public void setTimetable(Timetable groupTimetable) {
        this.groupTimetable = groupTimetable;
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
