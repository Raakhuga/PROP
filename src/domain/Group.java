
package domain;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Group {
    private final int enrolled;
    private final int num;
    private GroupTimetable timetable;
    private List<subGroup> subGroups;
    private List<String> addedRestrictions;
    
    public Group(int dIni, int dEnd, int hIni, int hEnd, int num, int enrolled) {
        this.num = num;
        this.enrolled = enrolled;
        this.timetable = new GroupTimetable(dIni, dEnd, hIni, hEnd);
        this.subGroups = new ArrayList<>();
        this.addedRestrictions = new ArrayList<>();
    }
    
    public Group(Group group, int enrolled) {
        this.num = group.getNum();
        this.timetable = group.getTimetable();
        this.enrolled = enrolled;
        this.subGroups = group.getSubGroups();
        this.addedRestrictions = new ArrayList<>();
    }

    public int getNum() {
        return num;
    }
    
    public int getdIni() {
        return timetable.getdIni();
    }

    public int getdEnd() {
        return timetable.getdEnd();
    }

    public int gethIni() {
        return timetable.gethIni();
    }

    public int gethEnd() {
        return timetable.gethEnd();
    }

    public int getEnrolled() {
        return enrolled;
    }
    
    public List<subGroup> getSubGroups() {
        return subGroups;
    }
    
    public List<String> getAddedRestrictions() {
        return addedRestrictions;
    }
    
    public GroupTimetable getTimetable() {
        return timetable;
    }

    public void setTimetable(GroupTimetable timetable) {
        this.timetable = timetable;
    }
    
    public boolean isSubGroup() {
        return false;
    }
    
    public boolean isEmpty(int day, int hour) {
        return timetable.isEmpty(day, hour);
    }
    
    public boolean isBanned(int day, int hour) {
        return timetable.isBanned(day, hour);
    }
    
    public boolean isSubjectBanned(int day, int hour, String name) {
        return timetable.isSubjectBanned(day, hour, name);
    }
    
    public boolean isClassroomBanned(int day, int hour, String ref) {
        return timetable.isClassroomBanned(day, hour, ref);
    }
    
    public void ban(int dIni, int dEnd, int hIni, int hEnd) {
        for(int i = dIni; i < dEnd; i++) 
            for (int j = hIni; j < hEnd; j++) timetable.ban(i, j);
        addedRestrictions.add("Bloquejar_franja " + " " + dIni + " " + dEnd + " " + hIni + " " + hEnd);
    }
    
    public void unban(int dIni, int dEnd, int hIni, int hEnd) {
        for(int i = dIni; i < dEnd; i++) 
            for (int j = hIni; j < hEnd; j++) timetable.unban(i, j);
        addedRestrictions.add("Desbloquejar_franja " + " " + dIni + " " + dEnd + " " + hIni + " " + hEnd);
    }
    
    public void banSubject(int dIni, int dEnd, int hIni, int hEnd, String subject) {
        for(int i = dIni; i < dEnd; i++) 
            for (int j = hIni; j < hEnd; j++) timetable.banSubject(i, j, subject);
        addedRestrictions.add("Bloquejar_assignatura " + subject + " " + dIni + " " + dEnd + " " + hIni + " " + hEnd);
    }
    
    public void unbanSubject(int dIni, int dEnd, int hIni, int hEnd, String subject) {
        for(int i = dIni; i < dEnd; i++) 
            for (int j = hIni; j < hEnd; j++) timetable.unbanSubject(i, j, subject);
        addedRestrictions.add("Desbloquejar_assignatura " + subject + " " + dIni + " " + dEnd + " " + hIni + " " + hEnd);
    }
    
    public void banClassroom(int dIni, int dEnd, int hIni, int hEnd, String ref) {
        for(int i = dIni; i < dEnd; i++) 
            for (int j = hIni; j < hEnd; j++) timetable.banClassroom(i, j, ref);
        addedRestrictions.add("Bloquejar_aula " + ref + " " + dIni + " " + dEnd + " " + hIni + " " + hEnd);
    }
    
    public void unbanClassroom(int dIni, int dEnd, int hIni, int hEnd, String ref) {
        for(int i = dIni; i < dEnd; i++) 
            for (int j = hIni; j < hEnd; j++) timetable.unbanClassroom(i, j, ref);
        addedRestrictions.add("Desbloquejar_aula " + ref + " " + dIni + " " + dEnd + " " + hIni + " " + hEnd);
    }
    
    private String getNextString(int It, int NIt, String sentence) {
        It = NIt;
        if (sentence.indexOf(" ", It+1)>=0) NIt = sentence.indexOf(" ",It+1);
        else NIt = sentence.length();
        return sentence.substring(It,NIt);
    }
    
    public void removeRestriction(int id) {
        String restriction = addedRestrictions.get(id);
        int It = 0;
        int NIt = restriction.indexOf(" ",It+1);
        String word = restriction.substring(It,NIt);
        switch (word) {
            case "Bloquejar_franja":
                {
                    int dIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int dEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    unban(dIni, dEnd, hIni, hEnd);
                    break;
                }
            case "Desbloquejar_franja":
                {
                    int dIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int dEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    ban(dIni, dEnd, hIni, hEnd);
                    break;
                }
            case "Bloquejar_assignatura":
                {
                    String subject = getNextString(It, NIt, restriction);
                    int dIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int dEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    unbanSubject(dIni, dEnd, hIni, hEnd, subject);
                    break;
                }
            case "Desbloquejar_assignatura":
                {
                    String subject = getNextString(It, NIt, restriction);
                    int dIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int dEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    banSubject(dIni, dEnd, hIni, hEnd, subject);
                    break;
                }
            case "Bloquejar_aula":
                {
                    String ref = getNextString(It, NIt, restriction);
                    int dIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int dEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    unbanClassroom(dIni, dEnd, hIni, hEnd, ref);
                    break;
                }
            case "Desbloquejar_aula":
                {
                    String ref = getNextString(It, NIt, restriction);
                    int dIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int dEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    banClassroom(dIni, dEnd, hIni, hEnd, ref);
                    break;
                }
            default:
                break;
        }
        addedRestrictions.remove(id);
    }
    
    public void addSubGroup(subGroup subGroup) {
        subGroups.add(subGroup);
    } 
    
    public void addToGroupTimetable(ClassSubject CS, int day, int hour) {
        timetable.addClassSubject(CS, day, hour);
    }
    
    public void removeFromGroupTimetable(int day, int hour) {
        timetable.removeClassSubject(day, hour);
    }
        
    public String saveGroup() {
        Iterator<subGroup> SGit = subGroups.iterator();
        Iterator<String> Rit = addedRestrictions.iterator();
        String sgps = num + " " + enrolled + " " + getdIni() + " " + getdEnd() + " " + gethIni() + " " + gethEnd() + " " +  addedRestrictions.size() + "\n" + "          Restrictions:";
        while(Rit.hasNext()) {
            String Ract = Rit.next();
            String R = "\n" + "            " + Ract;
            sgps = sgps + R;
        }
        sgps = sgps + "\n" + "          " + subGroups.size() + "\n" + "          Subgroups:";
        while(SGit.hasNext()) {
            subGroup SGact = SGit.next();
            String sgp = "\n" + "            " + SGact.saveGroup();
            sgps = sgps + sgp;
        }
        return sgps;
    }
}
