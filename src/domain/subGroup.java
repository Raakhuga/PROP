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
