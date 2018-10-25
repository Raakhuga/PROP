
package domain;


public class Group {
    
    /** Atributtes **/
    private int num;
    private int nEst;
    
    /** Constructor **/
    public Group(int num, int nEst){
        this.num = num;
        this.nEst = nEst;
    }

    public int getNum() {
        return num;
    }

    public int getnEst() {
        return nEst;
    }
}
