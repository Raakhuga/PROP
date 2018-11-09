
package domain;


public class subGroup extends Group {
    private int sNum;
    
    public subGroup(int sNum, int num) {
        super(num);
        this.sNum = sNum;
    }
    
    public int getsNum() {
        return sNum;
    }
}
