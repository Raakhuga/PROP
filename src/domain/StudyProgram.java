
package domain;


public class StudyProgram {
    
    /** Atributtes **/
    private String name;
    private Level[] levels;
    private int nLevels;
    
    /** Constructor **/
    public StudyProgram(String name, int nLevels){
        this.name = name;
        levels = new Level[nLevels];
        this.nLevels = nLevels;
    }

    public String getName() {
        return name;
    }

    public Level[] getLevels() {
        return levels;
    }

    public int getnLevels() {
        return nLevels;
    }
    
}
