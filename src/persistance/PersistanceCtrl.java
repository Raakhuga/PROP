/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;
import domain.Classroom;
import domain.Group;
import domain.Level;
import domain.StudyProgram;
import domain.Subject;
import domain.TimetableGenerator;
import domain.subGroup;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
/**
 *
 * @author raakhuga
 */
public class PersistanceCtrl {
    public void save(TimetableGenerator TG, String path){
        String state;
        state = TG.saveSizes();
        state = state + TG.saveClassrooms();
        state = state + TG.saveStudyPrograms();
        state = state + TG.saveRestrictions();
        
        //System.out.print(state);
        try {
            File file = new  File(path);
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
    
    private void addRestClassroom(Classroom c, Scanner input) {
        String type = input.next();
        switch (type) {
            case "Bloquejar_franja":
                {
                    int dIni = input.nextInt();
                    int dEnd = input.nextInt();
                    int hIni = input.nextInt();
                    int hEnd = input.nextInt();
                    c.ban(dIni, dEnd, hIni, hEnd);
                    break;
                }
            case "Desbloquejar_franja":
                {
                    int dIni = input.nextInt();
                    int dEnd = input.nextInt();
                    int hIni = input.nextInt();
                    int hEnd = input.nextInt();
                    c.unban(dIni, dEnd, hIni, hEnd);
                    break;
                }
            case "Bloquejar_assignatura":
                {
                    String subject = input.next();
                    int dIni = input.nextInt();
                    int dEnd = input.nextInt();
                    int hIni = input.nextInt();
                    int hEnd = input.nextInt();
                    c.banSubject(dIni, dEnd, hIni, hEnd, subject);
                    break;
                }
            case "Desbloquejar_assignatura":
                {
                    String subject = input.next();
                    int dIni = input.nextInt();
                    int dEnd = input.nextInt();
                    int hIni = input.nextInt();
                    int hEnd = input.nextInt();
                    c.unbanSubject(dIni, dEnd, hIni, hEnd, subject);
                    break;
                }
            case "Bloquejar_grup":
                {
                    int num = input.nextInt();
                    int dIni = input.nextInt();
                    int dEnd = input.nextInt();
                    int hIni = input.nextInt();
                    int hEnd = input.nextInt();
                    c.banGroup(dIni, dEnd, hIni, hEnd, num);
                    break;
                }
            case "Desbloquejar_grup":
                {
                    int num = input.nextInt();
                    int dIni = input.nextInt();
                    int dEnd = input.nextInt();
                    int hIni = input.nextInt();
                    int hEnd = input.nextInt();
                    c.unbanGroup(dIni, dEnd, hIni, hEnd, num);
                    break;
                }
            default:
                break;
        }
    }
    
    private void addRestGroup(Group group, Scanner input) {
        String type = input.next();
        switch (type) {
            case "Bloquejar_franja":
                {
                    int dIni = input.nextInt();
                    int dEnd = input.nextInt();
                    int hIni = input.nextInt();
                    int hEnd = input.nextInt();
                    group.ban(dIni, dEnd, hIni, hEnd);
                    break;
                }
            case "Desbloquejar_franja":
                {
                    int dIni = input.nextInt();
                    int dEnd = input.nextInt();
                    int hIni = input.nextInt();
                    int hEnd = input.nextInt();
                    group.unban(dIni, dEnd, hIni, hEnd);
                    break;
                }
            case "Bloquejar_assignatura":
                {
                    String sub = input.next();
                    int dIni = input.nextInt();
                    int dEnd = input.nextInt();
                    int hIni = input.nextInt();
                    int hEnd = input.nextInt();
                    group.banSubject(dIni, dEnd, hIni, hEnd, sub);
                    break;
                }
            case "Desbloquejar_assignatura":
                {
                    String sub = input.next();
                    int dIni = input.nextInt();
                    int dEnd = input.nextInt();
                    int hIni = input.nextInt();
                    int hEnd = input.nextInt();
                    group.unbanSubject(dIni, dEnd, hIni, hEnd, sub);
                    break;
                }
            case "Bloquejar_aula":
                {
                    String ref = input.next();
                    int dIni = input.nextInt();
                    int dEnd = input.nextInt();
                    int hIni = input.nextInt();
                    int hEnd = input.nextInt();
                    group.banClassroom(dIni, dEnd, hIni, hEnd, ref);
                    break;
                }
            case "Desbloquejar_aula":
                {
                    String ref = input.next();
                    int dIni = input.nextInt();
                    int dEnd = input.nextInt();
                    int hIni = input.nextInt();
                    int hEnd = input.nextInt();
                    group.unbanClassroom(dIni, dEnd, hIni, hEnd, ref);
                    break;
                }
            default:
                break;
        }
    }
    
    public void load(TimetableGenerator TG, String path) {
        File file = new File(path);
        Scanner input;
        System.out.print("asdfa");
        try {
            input = new Scanner(file);
            String aux;
            if (input.hasNext()) {
                aux = input.next();
                int nMaxStudentsGroup = input.nextInt();
                aux = input.next();
                int nMaxStudentsSubGroup = input.nextInt();
                
                //TG = new TimetableGenerator(nMaxStudentsGroup, nMaxStudentsSubGroup);
                
                TG.setnMaxStudentsGroup(nMaxStudentsGroup);
                TG.setnMaxStudentsSubgroup(nMaxStudentsSubGroup);
                
                
                int numOfClassrooms = input.nextInt();
                aux = input.next();
                System.out.println(aux+ " " + numOfClassrooms);

                for(int i = 0; i < numOfClassrooms; i++) {
                    int capacity = input.nextInt();
                    String ref = input.next();
                    int dIni = input.nextInt();
                    int dEnd = input.nextInt();
                    int hIni = input.nextInt();
                    int hEnd = input.nextInt();
                    //System.out.print(dIni + " " + dEnd + " " + hIni + " " + hEnd + " " + ref);
                    Classroom c = TG.addClassroom(capacity, ref, dIni, dEnd, hIni, hEnd);
                    
                    if(input.nextBoolean()) c.setTheory();
                    if(input.nextBoolean()) c.setLaboratory();
                    if(input.nextBoolean()) c.setProblems();
                    int numOfRestricctions = input.nextInt();
                    aux = input.next();
                    for(int j = 0; j < numOfRestricctions; j++) {
                        addRestClassroom(c, input);
                    }
                }

                int numSP = input.nextInt();
                aux = input.next();
                for (int i = 0; i < numSP; i++) {
                    String name = input.next();
                    StudyProgram SP = TG.addStudyProgram(name);
                    int numLevels = input.nextInt();
                    aux = input.next();
                    for (int j = 0; j < numLevels; j++) {
                        int iden = input.nextInt();
                        Level level = TG.addLevel(SP);
                        int numSubjects = input.nextInt();
                        aux = input.next();
                        for (int k = 0; k < numSubjects; k++) {
                            name = input.next();
                            Subject subject = TG.addSubject(level, name);
                            subject.fillTheoryH(input.nextInt());
                            subject.fillLaboratoryH(input.nextInt());
                            subject.fillProblemsH(input.nextInt());
                            aux = input.next();
                            int numGroups = input.nextInt();
                            aux = input.next();
                            for (int l = 0; l < numGroups; l++) {
                                int num = input.nextInt();
                                int enrolled = input.nextInt();
                                int dIni = input.nextInt();
                                int dEnd = input.nextInt();
                                int hIni = input.nextInt();
                                int hEnd = input.nextInt();
                                int numRestrictions = input.nextInt();
                                Group group = TG.addGroup(subject, dIni, dEnd, hIni, hEnd, num, enrolled);
                                aux = input.next();
                                for (int m = 0; m < numRestrictions; m++) {
                                    addRestGroup(group, input);                            
                                }
                                int numSubgroups = input.nextInt();
                                aux = input.next();
                                for (int m = 0; m < numSubgroups; m++) {
                                    num = input.nextInt();
                                    enrolled = input.nextInt();
                                    dIni = input.nextInt();
                                    dEnd = input.nextInt();
                                    hIni = input.nextInt();
                                    hEnd = input.nextInt();
                                    numRestrictions = input.nextInt();
                                    subGroup subgroup = TG.addSubGroup(group, num, enrolled);
                                    aux = input.next();
                                    for (int n = 0; n < numRestrictions; n++) {                                        
                                        addRestGroup(subgroup, input); 
                                    }
                                }
                            }
                        }
                    }
                }
                aux = input.next();
                boolean rBase[] = new boolean[3];
                rBase[0] = input.nextBoolean();
                rBase[1] = input.nextBoolean();
                rBase[2] = input.nextBoolean();
                boolean rExtra[] = new boolean[5];
                rExtra[0] = input.nextBoolean();
                rExtra[1] = input.nextBoolean();
                rExtra[2] = input.nextBoolean();
                rExtra[3] = input.nextBoolean();
                rExtra[4] = input.nextBoolean();
                TG.setrBase(rBase);
                TG.setrExtra(rExtra);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersistanceCtrl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
