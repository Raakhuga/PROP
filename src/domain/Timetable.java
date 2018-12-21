
package domain;


abstract class Timetable {
    private int dIni;
    private int dEnd;
    private int hIni;
    private int hEnd;

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
    
    public void setdIni(int dIni) {
        this.dIni = dIni;
    }

    public void setdEnd(int dEnd) {
        this.dEnd = dEnd;
    }

    public void sethIni(int hIni) {
        this.hIni = hIni;
    }

    public void sethEnd(int hEnd) {
        this.hEnd = hEnd;
    }
    
}
