/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;
import domain.TimetableGenerator;
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
        System.out.print(state);
    }
    
    
}
