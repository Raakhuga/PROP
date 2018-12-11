/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author raakhuga
 */
abstract class Timetable {
    private final int dIni;
    private final int dEnd;
    private final int hIni;
    private final int hEnd;

    public Timetable(int dIni, int dEnd, int hIni, int hEnd) {
        this.dIni = dIni;
        this.dEnd = dEnd;
        this.hIni = hIni;
        this.hEnd = hEnd;
    }

    public int getdIni() {
        return dIni;
    }

    public int getdEnd() {
        return dEnd;
    }

    public int gethIni() {
        return hIni;
    }

    public int gethEnd() {
        return hEnd;
    }
    
}
