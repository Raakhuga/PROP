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
                
                aux = input.next();
                int numOfClassrooms = input.nextInt();
                aux = input.next();
                //System.out.println(aux+ " " + numOfClassrooms);

                for(int i = 0; i < numOfClassrooms; i++) {
                    aux = input.next();
                    int capacity = input.nextInt();
                    aux = input.next();
                    String ref = input.next();
                    aux = input.next();
                    int dIni = input.nextInt();
                    aux = input.next();
                    int dEnd = input.nextInt();
                    aux = input.next();
                    int hIni = input.nextInt();
                    aux = input.next();
                    int hEnd = input.nextInt();
                    //System.out.print(dIni + " " + dEnd + " " + hIni + " " + hEnd + " " + ref);
                    Classroom c = TG.addClassroom(capacity, ref, dIni, dEnd, hIni, hEnd);
                    aux = input.next();
                    if(input.nextBoolean()) c.setTheory();
                    aux = input.next();
                    if(input.nextBoolean()) c.setLaboratory();
                    aux = input.next();
                    if(input.nextBoolean()) c.setProblems();
                    aux = input.next();
                    int numOfRestricctions = input.nextInt();
                    aux = input.next();
                    for(int j = 0; j < numOfRestricctions; j++) {
                        addRestClassroom(c, input);
                    }
                }
                
                aux = input.next();
                int numSP = input.nextInt();
                aux = input.next();
                for (int i = 0; i < numSP; i++) {
                    aux = input.next();
                    String name = input.next();
                    StudyProgram SP = TG.addStudyProgram(name);
                    int numLevels = input.nextInt();
                    aux = input.next();
                    for (int j = 0; j < numLevels; j++) {
                        aux = input.next();
                        int iden = input.nextInt();
                        Level level = TG.addLevel(SP);
                        aux = input.next();
                        int numSubjects = input.nextInt();
                        aux = input.next();
                        for (int k = 0; k < numSubjects; k++) {
                            aux = input.next();
                            name = input.next();
                            Subject subject = TG.addSubject(level, name);
                            aux = input.next();
                            subject.fillTheoryH(input.nextInt());
                            aux = input.next();
                            subject.fillLaboratoryH(input.nextInt());
                            aux = input.next();
                            subject.fillProblemsH(input.nextInt());
                            aux = input.next();
                            aux = input.next();
                            aux = input.next();
                            aux = input.next();
                            aux = input.next();
                            int numGroups = input.nextInt();
                            aux = input.next();
                            for (int l = 0; l < numGroups; l++) {
                                aux = input.next();
                                int num = input.nextInt();
                                aux = input.next();
                                int enrolled = input.nextInt();
                                aux = input.next();
                                int dIni = input.nextInt();
                                aux = input.next();
                                int dEnd = input.nextInt();
                                aux = input.next();
                                int hIni = input.nextInt();
                                aux = input.next();
                                int hEnd = input.nextInt();
                                aux = input.next();
                                int numRestrictions = input.nextInt();
                                Group group = TG.addGroup(subject, dIni, dEnd, hIni, hEnd, num, enrolled);
                                aux = input.next();
                                aux = input.next();
                                for (int m = 0; m < numRestrictions; m++) {
                                    addRestGroup(group, input);                            
                                }
                                int numSubgroups = input.nextInt();
                                aux = input.next();
                                for (int m = 0; m < numSubgroups; m++) {
                                    aux = input.next();
                                    num = input.nextInt();
                                    aux = input.next();
                                    enrolled = input.nextInt();
                                    aux = input.next();
                                    dIni = input.nextInt();
                                    aux = input.next();
                                    dEnd = input.nextInt();
                                    aux = input.next();
                                    hIni = input.nextInt();
                                    aux = input.next();
                                    hEnd = input.nextInt();
                                    aux = input.next();
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
