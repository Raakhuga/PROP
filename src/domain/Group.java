
package domain;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Group {
    
    /** Atributtes **/
    public int num;
    
    /** Constructor **/
    public Group(int num){
        this.num = num;
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
