/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Raakhuga
 */
public class Restrictions {
    public Timetable actual;
    public Timetable tNew;
    public StudyProgram SP;
    public boolean[] rBase;
    
    
    
    public Restrictions(Timetable actual, Timetable tNew) {
        this.actual = actual;
        this.tNew = tNew;
        for (int i = 0; i < 4; i++) rBase[i] = true;
    }
    
    public boolean base(int day, int hour) {
        //aula no disponible
        if(actual.getGroupSubject(day, hour).isBanned() && rBase[0]) return false;
        //no hay teoria antes de lab
        else if (tNew.getGroupSubject(day, hour).getLab() && rBase[1]){
            boolean teoria = false;
            int days = actual.getnDays();
            int hours = actual.gethEnd() - actual.gethIni();
            for (int i = 0; i < day; i++) {
                for (int j = 0; j < hours; j++) 
                    teoria = actual.getGroupSubject(i,j).getTeoria();
            }
            if (!teoria ) return false;
        }
        //se solapan dos assignaturas del mismo nivel
        else if (actual.getGroupSubject(day, hour).getnMat() > 0 && 
                actual.getGroupSubject(day, hour).getSubject().getLevel() == 
                tNew.getGroupSubject(day, hour).getSubject().getLevel()) return false;
        else if (actual.);
        return true;
    }
    
    public add(){}
            
    public modify() {}
            
    public delete() {}
}
