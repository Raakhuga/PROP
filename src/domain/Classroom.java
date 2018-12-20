
package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Classroom {
    private final static int THEORY = 0;
    private final static int LABORATORY = 1;
    private final static int PROBLEMS = 2;
    
    private String ref;

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    private ClassroomTimetable timetable;
    private List<String> addedRestrictions;
    private int capacity;
    private boolean type[];
    
    public Classroom(String ref, int capacity, int dIni, int dEnd, int hIni, int hEnd) {
        this.ref = ref;
        this.timetable = new ClassroomTimetable(dIni, dEnd, hIni, hEnd);
        this.addedRestrictions = new ArrayList<>();
        this.capacity = capacity;
        this.type = new boolean[3];
        this.type[THEORY] = false;
        this.type[LABORATORY] = false;
        this.type[PROBLEMS] = false;
    }
    
    public boolean isOut(int day, int hour) {
        return timetable.isOut(day, hour);
    }

    public String getRef() {
        return ref;
    }

    public ClassroomTimetable getTimetable() {
        return timetable;
    }

    public boolean[] getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
    
    public List<String> getRestrictions(){
        return addedRestrictions;
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
    
    public void setTimetable(ClassroomTimetable timetable) {
        this.timetable = timetable;
    }

    public void setType(boolean[] type) {
        this.type = type;
    }
    
    public void setTheory(){
        type[THEORY] = true;
    }
    
    public void setLaboratory(){
        type[LABORATORY] = true;
    }
    
    public void setProblems(){
        type[PROBLEMS] = true;
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
    
    public void unsetTheory(){
        type[THEORY] = false;
    }
    
    public void unsetLaboratory(){
        type[LABORATORY] = false;
    }
    
    public void unsetProblems(){
        type[PROBLEMS] = false;
    }
    
    public boolean isTheory() {
        return type[THEORY];
    }
    
    public boolean isLaboratory() {
        return type[LABORATORY];
    }
    
    public boolean isProblems() {
        return type[PROBLEMS];
    }
    
    public boolean isEmpty(int day, int hour) {
        return timetable.isEmpty(day, hour);
    }

    public void ban(int dIni, int dEnd, int hIni, int hEnd) {
        for(int i = dIni; i <= dEnd; i++) 
            for (int j = hIni; j < hEnd; j++) timetable.ban(i, j);
        addedRestrictions.add("Bloquejar_franja " + "dia_inicial: " + dIni + " dia_final: " + dEnd + " hora_inicial: " + hIni + " hora_final: " + hEnd);
    }
    
    public void unban(int dIni, int dEnd, int hIni, int hEnd) {
        for(int i = dIni; i <= dEnd; i++) 
            for (int j = hIni; j < hEnd; j++) timetable.unban(i, j);
        //addedRestrictions.add("Desbloquejar_franja " + "dia_inicial: " + dIni + " dia_final: " + dEnd + " hora_inicial: " + hIni + " hora_final: " + hEnd);
    }
    
    public void banSubject(int dIni, int dEnd, int hIni, int hEnd, String subject) {
        for(int i = dIni; i <= dEnd; i++) 
            for (int j = hIni; j < hEnd; j++) timetable.banSubject(i, j, subject);
        addedRestrictions.add("Bloquejar_assignatura " + subject + " dia_inicial: " + dIni + " dia_final: " + dEnd + " hora_inicial: " + hIni + " hora_final: " + hEnd);
    }
    
    public void unbanSubject(int dIni, int dEnd, int hIni, int hEnd, String subject) {
        for(int i = dIni; i <= dEnd; i++) 
            for (int j = hIni; j < hEnd; j++) timetable.unbanSubject(i, j, subject);
        //addedRestrictions.add("Desbloquejar_assignatura " + subject + " dia_inicial: " + dIni + " dia_final: " + dEnd + " hora_inicial: " + hIni + " hora_final: " + hEnd);
    }
    
    public void banGroup(int dIni, int dEnd, int hIni, int hEnd, int num) {
        for(int i = dIni; i <= dEnd; i++) 
            for (int j = hIni; j < hEnd; j++) timetable.banGroup(i, j, num);
        addedRestrictions.add("Bloquejar_grup " + num + " dia_inicial: " + dIni + " dia_final: " + dEnd + " hora_inicial: " + hIni + " hora_final: " + hEnd);
    }
    
    public void unbanGroup(int dIni, int dEnd, int hIni, int hEnd, int num) {
        for(int i = dIni; i <= dEnd; i++) 
            for (int j = hIni; j < hEnd; j++) timetable.unbanGroup(i, j, num);
        //addedRestrictions.add("Desbloquejar_grup " + num + " dia_inicial: " + dIni + " dia_final: " + dEnd + " hora_inicial: " + hIni + " hora_final: " + hEnd);
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
            /*case "Desbloquejar_franja":
                {
                    int dIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int dEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    ban(dIni, dEnd, hIni, hEnd);
                    break;
                }*/
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
            /*case "Desbloquejar_assignatura":
                {
                    String subject = getNextString(It, NIt, restriction);
                    int dIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int dEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    banSubject(dIni, dEnd, hIni, hEnd, subject);
                    break;
                }*/
            case "Bloquejar_grup":
                {
                    It = NIt;
                    NIt = restriction.indexOf(" ",It+1);
                    int num = Integer.parseInt(restriction.substring(It+1, NIt));
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
                    unbanGroup(dIni, dEnd, hIni, hEnd, num);
                    break;
                }
            /*case "Desbloquejar_grup":
                {
                    int num = Integer.parseInt(getNextString(It, NIt, restriction));
                    int dIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int dEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hIni = Integer.parseInt(getNextString(It, NIt, restriction));
                    int hEnd = Integer.parseInt(getNextString(It, NIt, restriction));
                    banGroup(dIni, dEnd, hIni, hEnd, num);
                    break;
                }*/
            default:
                break;
        }
        addedRestrictions.remove(id);
    }
    
    public void addToClassTimetable(GroupSubject GS, int day, int hour) {
        timetable.addGroupSubject(GS, day, hour);
    }
    
    public void removeFromClassTimetable(int day, int hour) {
        timetable.removeGroupSubject(day, hour);
    }
    
    public String saveClassroom(){
        String croom = "Capacity: " + capacity + " Reference: " + ref + " First_day: " + getdIni() + " Last_day: " + getdEnd() + " First_hour: " + gethIni() + " Last_hour: " + gethEnd() + " Theory: " + type[THEORY] + " Laboratory: " + type[LABORATORY] + " Problems: " + type[PROBLEMS] + " Num_Restrictions: " + addedRestrictions.size() + "\n" + "  " + "Restrictions:"; 
        Iterator<String> Rit = addedRestrictions.iterator();
        while(Rit.hasNext()) {
            String Ract = Rit.next();
            String R = "\n" + "    " + Ract;
            croom = croom + R;
        }
        return croom;
    }
}
