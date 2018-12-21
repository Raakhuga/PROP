
package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Group {
    private  int enrolled;
    private  int num;
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
    
    public boolean isOut(int day, int hour) {
        return timetable.isOut(day, hour);
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
    
    public void setAddedRestrictions(List<String> addedRestrictions) {
        this.addedRestrictions = addedRestrictions;
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
    
    public boolean ban(int dIni, int dEnd, int hIni, int hEnd) {
        String restr = "Bloquejar_franja " + "dia_inicial: " + dIni + " dia_final: " + dEnd + " hora_inicial: " + hIni + " hora_final: " + hEnd;
        if (!addedRestrictions.contains(restr)){
            for(int i = dIni; i <= dEnd; i++) 
                for (int j = hIni; j < hEnd; j++) timetable.ban(i, j);
            addedRestrictions.add(restr);
            return true;
        }
        return false;
    }
    
    public void unban(int dIni, int dEnd, int hIni, int hEnd) {
        for(int i = dIni; i <= dEnd; i++) 
            for (int j = hIni; j < hEnd; j++) timetable.unban(i, j);
    }
    
    public boolean banSubject(int dIni, int dEnd, int hIni, int hEnd, String subject) {
        String restr = "Bloquejar_assignatura " + subject + " dia_inicial: " + dIni + " dia_final: " + dEnd + " hora_inicial: " + hIni + " hora_final: " + hEnd;
        if (!addedRestrictions.contains(restr)) {
            for(int i = dIni; i <= dEnd; i++) 
                for (int j = hIni; j < hEnd; j++) timetable.banSubject(i, j, subject);
            addedRestrictions.add(restr);
            return true; 
        }
        return false;
    }
    
    public void unbanSubject(int dIni, int dEnd, int hIni, int hEnd, String subject) {
        for(int i = dIni; i <= dEnd; i++) 
            for (int j = hIni; j < hEnd; j++) timetable.unbanSubject(i, j, subject);
    }
    
    public boolean banClassroom(int dIni, int dEnd, int hIni, int hEnd, String ref) {
        String restr = "Bloquejar_aula " + ref + " dia_inicial: " + dIni + " dia_final: " + dEnd + " hora_inicial: " + hIni + " hora_final: " + hEnd;
        if (!addedRestrictions.contains(restr)) {
            for(int i = dIni; i <= dEnd; i++) 
                for (int j = hIni; j < hEnd; j++) timetable.banClassroom(i, j, ref);
            addedRestrictions.add(restr);
            return true;
        }
        return false;
    }
    
    public void unbanClassroom(int dIni, int dEnd, int hIni, int hEnd, String ref) {
        for(int i = dIni; i <= dEnd; i++) 
            for (int j = hIni; j < hEnd; j++) timetable.unbanClassroom(i, j, ref);
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
        String aux;
        switch (word) {
            case "Bloquejar_franja":
                {
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    int dIni = Integer.parseInt(restriction.substring(It+1, NIt));
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    int dEnd = Integer.parseInt(restriction.substring(It+1, NIt));
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    int hIni = Integer.parseInt(restriction.substring(It+1, NIt));
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    It = NIt;
                    NIt = restriction.length();
                    int hEnd = Integer.parseInt(restriction.substring(It+1, NIt));
                    unban(dIni, dEnd, hIni, hEnd);
                    break;
                }
            case "Bloquejar_assignatura":
                {
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    String subject = restriction.substring(It+1, NIt);
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    int dIni = Integer.parseInt(restriction.substring(It+1, NIt));
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    int dEnd = Integer.parseInt(restriction.substring(It+1, NIt));
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    int hIni = Integer.parseInt(restriction.substring(It+1, NIt));
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    It = NIt;
                    NIt = restriction.length();
                    int hEnd = Integer.parseInt(restriction.substring(It+1, NIt));
                    unbanSubject(dIni, dEnd, hIni, hEnd, subject);
                    break;
                }
            case "Bloquejar_aula":
                {
                   It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    String ref = restriction.substring(It+1, NIt);
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    int dIni = Integer.parseInt(restriction.substring(It+1, NIt));
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    int dEnd = Integer.parseInt(restriction.substring(It+1, NIt));
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    int hIni = Integer.parseInt(restriction.substring(It+1, NIt));
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    It = NIt;
                    NIt = restriction.length();
                    int hEnd = Integer.parseInt(restriction.substring(It+1, NIt));
                    unbanClassroom(dIni, dEnd, hIni, hEnd, ref);
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
        String sgps = "Num: " + num + " Enrolled: " + enrolled + " First_day: " + getdIni() + " Last_day: " + getdEnd() + " First_hour: " + gethIni() + " Last_hour: " + gethEnd() + " Num_Restrictions: " +  addedRestrictions.size() + "\n" + "          Restrictions:";
        while(Rit.hasNext()) {
            String Ract = Rit.next();
            String R = "\n" + "            " + Ract;
            sgps = sgps + R;
        }
        sgps = sgps + "\n" + "          Num_subGroups: " + subGroups.size() + "\n" + "          Subgroups:";
        while(SGit.hasNext()) {
            subGroup SGact = SGit.next();
            String sgp = "\n" + "            " + SGact.saveGroup();
            sgps = sgps + sgp;
        }
        return sgps;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setEnrolled(int enrolled) {
        this.enrolled = enrolled;
    }


    public void removesubGroup(subGroup s) {
        subGroups.remove(s);
    }
    
        public void setdIni(int dIni) {
        timetable.setdIni(dIni);
    }

    public void setdEnd(int dEnd) {
        timetable.setdEnd(dEnd);
    }

    public void sethIni(int hIni) {
        timetable.sethIni(hIni);
    }

    public void sethEnd(int hEnd) {
        timetable.sethEnd(hEnd);
    }
}
