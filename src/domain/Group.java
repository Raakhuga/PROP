
package domain;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


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
    
    public void save() throws IOException {
        String file = "state.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("Group");
        bw.write(num);
        bw.write(nEst);
        bw.close(); 
    }
}
