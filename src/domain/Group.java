
package domain;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Group {
    
    /** Atributtes **/
    public int num;
    public Timetable groupTimetable;
    
    /** Constructor **/
    public Group(int num, int nDays, int hIni, int hEnd){
        this.num = num;
        groupTimetable = new Timetable(nDays, hIni, hEnd);
    }
    
    public Group(int num, Timetable groupTimetable){
        this.num = num;
        groupTimetable = groupTimetable;
    }

    public int getNum() {
        return num;
    }
    
    public void save() throws IOException {
        String file = "state.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("Group");
        bw.write(num);
        bw.close(); 
    }
}