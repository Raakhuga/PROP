
package domain;

/** Class for the subjects **/
public class Subject {
    
    /** Atributtes **/
    private String name;
    private Level level;
    
    /** Constructor **/
    public Subject(String name, Level level){
        this.name = name;
        this.level = level;
    }

    /** Public methods **/
    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }
       
}
