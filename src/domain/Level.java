
package domain;


public class Level {
    
    /** Atributtes **/
    private int num;
    private Subject[] subjects;
    
    /** Constructor **/
    public Level(int num){
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public Subject[] getSubjects() {
        return subjects;
    }
    
    
}
