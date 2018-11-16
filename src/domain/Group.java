
package domain;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Group {
    
    /** Atributtes **/
    public int num;
    private GroupRestrictions GroupRestrictions[][];
    private Subject GroupTimetable[][];
    private String type[][];
    private int nDays;
    private int hEnd;
    private int hIni;
    private List<subGroup> subGroups;
    private int nMat;
    
    /** Constructor **/
    public Group(int num, int nDays, int hIni, int hEnd, int nMat){
        this.num = num;
        this.GroupRestrictions = new GroupRestrictions[nDays][hEnd-hIni];
        this.GroupTimetable = new Subject[nDays][hEnd-hIni];
        this.type = new String[nDays][hEnd-hIni];
        this.nDays = nDays;
        this.hIni = hIni;
        this.hEnd = hEnd;
        subGroups = new ArrayList<subGroup>();
        this.nMat = nMat;
    }

    public int getNum() {
        return num;
    }

    public int getnDays() {
        return nDays;
    }
    public void banSubject(int day, int hIni, int hEnd, String name) {
       if (hourOk(day, hIni, hEnd)) for (int i = hIni; i < hEnd; i++) GroupRestrictions[day][i].banSubject(name);   
    }
     public void UnbanSubject(int day, int hIni, int hEnd, String name) {
        if (hourOk(day, hIni, hEnd)) for (int i = hIni; i < hEnd; i++) GroupRestrictions[day][i].unbanSubject(name);   
    }
    public void banClassroom(int day, int hIni, int hEnd, String name) {
       if (hourOk(day, hIni, hEnd)) for (int i = hIni; i < hEnd; i++) GroupRestrictions[day][i].banClassroom(name);   
    }
    public void unbanClassroom(int day, int hIni, int hEnd, String name) {
        if (hourOk(day, hIni, hEnd)) for (int i = hIni; i < hEnd; i++) GroupRestrictions[day][i].unbanClassroom(name);   
    }
     public void unbanTime(int day, int hIni, int hEnd) {
        if (hourOk(day, hIni, hEnd)) for (int i = hIni; i < hEnd; i++) GroupRestrictions[day][i].setBanned(false);
    }
     public void banTime(int day, int hIni, int hEnd) {
       if (hourOk(day, hIni, hEnd)) for (int i = hIni; i < hEnd; i++) GroupRestrictions[day][i].setBanned(true);
    }
     private boolean hourOk(int day, int hIni, int hEnd) {
        return (0 <= day && day < nDays) && (hIni < hEnd && hIni >= this.hIni && hEnd <= this.hEnd);
    }
    public boolean isBanned(int day, int hour) {
        return GroupRestrictions[day][hour].getBanned();
    }
    
    public boolean subjectBanned(int day, int hour, String name) {
        return GroupRestrictions[day][hour].subjectBanned(name);
    }
    
    public boolean classroomBanned(int day, int hour, String name) {
        return GroupRestrictions[day][hour].classroomBanned(name);
    }
    
    public Subject[][] getTimetable() {
        return GroupTimetable;
    }

    public int gethEnd() {
        return hEnd;
    }

    public int gethIni() {
        return hIni;
    }

    public List<subGroup> getsubGroups() {
        return subGroups;
    }
    
    public int getnMat() {
        return nMat;
    }
    
    public String getType(int day, int hour) {
        return this.type[day][hour];
    }
    
    public void setType(int day, int hour, String type) {
        this.type[day][hour] = type;
    }

    public void setTimetable(Subject[][] groupTimetable) {
        this.GroupTimetable = groupTimetable;
    } 
    
    public void removeSubject(int day, int hour){
        GroupTimetable[day][hour] = null;
    }
    
    public void addSubGroup(subGroup subGroup) {
        subGroups.add(subGroup);
    }
    
    public subGroup getSpecifiedSubGroup(int num){
        for(int i = 0; i < subGroups.size(); ++i){
            if (subGroups.get(i).getsNum() == num) return subGroups.get(i);
        }
        return null;
    }
    
    public void removeSubGroup(subGroup subGroup) {
        subGroups.remove(subGroup);
    }
    
    public GroupRestrictions[][] getRestrictions() {
        return GroupRestrictions;
    }
    
    public void setSubject(int day, int hour, Subject subject) {
        GroupTimetable[day][hour] = subject;
    }
    
    public Subject getSubject (int day, int hour) {
        return GroupTimetable[day][hour];
    }
    
    public GroupRestrictions getRestriction(int day, int hour) {
        return GroupRestrictions[day][hour];
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
