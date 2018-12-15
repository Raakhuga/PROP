package presentation;

import domain.TimetableGenerator;
import domain.Level;
import domain.Subject;
import domain.StudyProgram;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;

public class PresentationCtrl {
    private TimetableGenerator DomainCtrl;
    
    //frames
    private MainMenu mainmenu = null;
    private StateGen stategen = null;
    private StudyProgramMenu spmenu = null;
    private AddStudyProgram addsp = null;
    private ModifyStudyProgram modsp = null;
    private LevelMenu lvlmenu = null;
    private SubjectsMenu subjmenu = null;
    private AddSubject addsubj = null;
    private ModifySubject modsubj = null;
    
    public PresentationCtrl(){
        DomainCtrl = new TimetableGenerator();
        mainmenu = new MainMenu(this);
        mainmenu.setVisible(true);
        spmenu = new StudyProgramMenu(this);
        spmenu.setVisible(true);
    }
    
    //sync
    public void SwitchFromMMtoSG(){
        if(stategen == null)
            stategen = new StateGen(this);
        mainmenu.setVisible(false);
        mainmenu.setEnabled(false);
        stategen.setEnabled(true);
        stategen.setVisible(true);
    }
    
    public void SwitchFromSGtoMM(){
        mainmenu.setVisible(false);
        mainmenu.setEnabled(false);
        stategen.setEnabled(true);
        stategen.setVisible(true);
    }
    
    // StudyProgram menu to Level menu
    public void SwitchFromSPMtoLM(){
        if(lvlmenu == null)
            lvlmenu = new LevelMenu(this);
        spmenu.setVisible(false);
        spmenu.setEnabled(false);
        lvlmenu.setEnabled(true);
        lvlmenu.setVisible(true);
    }
    
    public void SwitchFromLMtoSPM(){
        lvlmenu.setVisible(false);
        lvlmenu.setEnabled(false);
        spmenu.setEnabled(true);
        spmenu.setVisible(true);
    }
    
    public void SwitchFromSPMtoASP(){
        if(addsp == null)
            addsp = new AddStudyProgram(this);
        spmenu.setVisible(false);
        spmenu.setEnabled(false);
        addsp.setEnabled(true);
        addsp.setVisible(true);
    }
    
    public void SwitchFromASPtoSPM(){
        addsp.setVisible(false);
        addsp.setEnabled(false);
        spmenu.setEnabled(true);
        spmenu.setVisible(true);
    }
    
    public void SwitchFromSPMtoMSP(StudyProgram sp){
        if(modsp == null)
            modsp = new ModifyStudyProgram(this);
        modsp.setStudyProgram(sp);
        spmenu.setVisible(false);
        spmenu.setEnabled(false);
        modsp.setEnabled(true);
        modsp.setVisible(true);
    }
    
    public void SwitchFromMSPtoSPM(){
        modsp.setVisible(false);
        modsp.setEnabled(false);
        spmenu.setEnabled(true);
        spmenu.setVisible(true);
    }
    
    // Subjects Menu to Add Subject
    public void SwitchFromSMtoAS(Level lvl){
        if(addsubj == null)
            addsubj = new AddSubject(this, lvl);
        subjmenu.setVisible(false);
        subjmenu.setEnabled(false);
        addsubj.setEnabled(true);
        addsubj.setVisible(true);
    }
    
    public void SwitchFromAStoSM(){
        addsubj.setVisible(false);
        addsubj.setEnabled(false);
        subjmenu.setEnabled(true);
        subjmenu.setVisible(true);
    }
    
    // Subjects Menu to Modify Subject
    public void SwitchFromSMtoMS(){
        if(modsubj == null)
            modsubj = new ModifySubject(this);
        subjmenu.setVisible(false);
        subjmenu.setEnabled(false);
        modsubj.setEnabled(true);
        modsubj.setVisible(true);
    }
    
    public void SwitchFromMStoSM(){
        modsubj.setVisible(false);
        modsubj.setEnabled(false);
        subjmenu.setEnabled(true);
        subjmenu.setVisible(true);
    }
    
    public List<StudyProgram> getPrograms() {
        return DomainCtrl.getPrograms();
    }
    
    public DefaultListModel<String> getStudyProgramsName(){
        List<StudyProgram> studyprograms = DomainCtrl.getPrograms();
        Iterator<StudyProgram> SPit = studyprograms.iterator();
        DefaultListModel<String> names = new DefaultListModel<>();
        while(SPit.hasNext()) {
            names.addElement(SPit.next().getName());
        }
        if(names.size() == 0) names.addElement("No hi ha cap pla d'estudis al sistema");
        return names;
    }
    
    public StudyProgram addStudyProgram(String name) {
        return DomainCtrl.addStudyProgram(name);
    }
    
    public void setNameStudyProgram(StudyProgram sp, String name){
        DomainCtrl.setNameStudyProgram(sp, name);
    }
    
    public DefaultListModel<String> getSubjectsName(Level lvl){
        List<Subject> subjects = lvl.getSubjects();
        Iterator<Subject> Sit = subjects.iterator();
        DefaultListModel<String> names = new DefaultListModel<>();
        while(Sit.hasNext()) {
            names.addElement(Sit.next().getName());
        }
        if(names.size() == 0) names.addElement("No hi ha cap assignatura al sistema en aquest nivell");
        return names;
    }
    
    /*private void removeSubject(int id) {
        DomainCtrl.removeSubject(id);
    }*/
    
    //domain methods
    public void setnMaxStudentsGroup(int nMaxStudentsGroup) {
        DomainCtrl.setnMaxStudentsGroup(nMaxStudentsGroup);
    }
    
    public void setnMaxStudentsSubgroup(int nMaxStudentsSubgroup) {
        DomainCtrl.setnMaxStudentsSubgroup(nMaxStudentsSubgroup);
    }
}
