/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;
import domain.TimetableGenerator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author raakhuga
 */
public class PersistanceCtrl {
    public void save(TimetableGenerator TG){
        String state;
        state = TG.saveClassrooms();
        state = state + TG.saveStudyPrograms();
        try {
            File file = new  File("./state.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(state);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
