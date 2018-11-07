
package domain;


public class Level {
    
    /** Atributtes **/
    private int iden;
    private Subject[] subjects;
    
    /** Constructor **/
    public Level(int iden){
        this.iden = iden;
    }

    public int getIden() {
        return iden;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }
    
}
