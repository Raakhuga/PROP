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
    private DeleteStudyProgram delsp = null;
    private LevelMenu lvlmenu = null;
    private AddLevel addlvl = null;
    private ModifyLevel modlvl = null;
    private DeleteLevel dellvl = null;
    private SubjectsMenu subjmenu = null;
    private AddSubject addsubj = null;
    private ModifySubject modsubj = null;
    private DeleteSubject delsubj = null;
    
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
    public void SwitchFromSPMtoLM(StudyProgram sp){
        if(lvlmenu == null)
            lvlmenu = new LevelMenu(this);
        lvlmenu.setStudyProgram(sp);
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
    
    public void SwitchFromSPMtoDSP(StudyProgram sp){
        if(delsp == null)
            delsp = new DeleteStudyProgram(this);
        delsp.setStudyProgram(sp);
        spmenu.setVisible(false);
        spmenu.setEnabled(false);
        delsp.setEnabled(true);
        delsp.setVisible(true);
    }
    
    public void SwitchFromDSPtoSPM(){
        delsp.setVisible(false);
        delsp.setEnabled(false);
        spmenu.setEnabled(true);
        spmenu.setVisible(true);
    }
    
    // Level menu to Subjects menu
    public void SwitchFromLMtoSM(Level lvl){
        if(subjmenu == null)
            subjmenu = new SubjectsMenu(this);
        subjmenu.setLevel(lvl);
        lvlmenu.setVisible(false);
        lvlmenu.setEnabled(false);
        subjmenu.setEnabled(true);
        subjmenu.setVisible(true);
    }
    
    public void SwitchFromSMtoLM(){
        subjmenu.setVisible(false);
        subjmenu.setEnabled(false);
        lvlmenu.setEnabled(true);
        lvlmenu.setVisible(true);
    }
    
    // Level menu to add level
    public void SwitchFromLMtoAL(StudyProgram sp){
        if(addlvl == null)
            addlvl = new AddLevel(this);
        addlvl.setStudyProgram(sp);
        lvlmenu.setVisible(false);
        lvlmenu.setEnabled(false);
        addlvl.setEnabled(true);
        addlvl.setVisible(true);
    }
    
    public void SwitchFromALtoLM(){
        addlvl.setVisible(false);
        addlvl.setEnabled(false);
        lvlmenu.setEnabled(true);
        lvlmenu.setVisible(true);
    }
    
    public void SwitchFromLMtoML(Level lvl){
        if(modlvl == null)
            modlvl = new ModifyLevel(this);
        modlvl.setLevel(lvl);
        lvlmenu.setVisible(false);
        lvlmenu.setEnabled(false);
        modlvl.setEnabled(true);
        modlvl.setVisible(true);
    }
    
    public void SwitchFromMLtoLM(){
        modlvl.setVisible(false);
        modlvl.setEnabled(false);
        lvlmenu.setEnabled(true);
        lvlmenu.setVisible(true);
    }
    
    public void SwitchFromLMtoDL(StudyProgram sp, Level lvl){
        if(dellvl == null)
            dellvl = new DeleteLevel(this);
        dellvl.setStudyProgram(sp);
        dellvl.setLevel(lvl);
        lvlmenu.setVisible(false);
        lvlmenu.setEnabled(false);
        dellvl.setEnabled(true);
        dellvl.setVisible(true);
    }
    
    public void SwitchFromDLtoLM(){
        dellvl.setVisible(false);
        dellvl.setEnabled(false);
        lvlmenu.setEnabled(true);
        lvlmenu.setVisible(true);
    }
    
    // Subjects Menu to Add Subject
    public void SwitchFromSMtoAS(Level lvl){
        if(addsubj == null)
            addsubj = new AddSubject(this);
        addsubj.setLevel(lvl);
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
    
    public void SwitchFromSMtoDS(Level lvl, Subject s){
        if(delsubj == null)
            delsubj = new DeleteSubject(this);
        delsubj.setLevel(lvl);
        delsubj.setSubject(s);
        subjmenu.setVisible(false);
        subjmenu.setEnabled(false);
        delsubj.setEnabled(true);
        delsubj.setVisible(true);
    }
    
    public void SwitchFromDStoSM(){
        delsubj.setVisible(false);
        delsubj.setEnabled(false);
        subjmenu.setEnabled(true);
        subjmenu.setVisible(true);
    }
    
    public List<StudyProgram> getPrograms() {
        return DomainCtrl.getPrograms();
    }
    
    public List<Level> getLevels(StudyProgram sp){
        return DomainCtrl.getLevels(sp);
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
    
    public DefaultListModel<String> getLevelsIden(StudyProgram sp){
        List<Level> levels = DomainCtrl.getLevels(sp);
        Iterator<Level> Lit = levels.iterator();
        DefaultListModel<String> idens = new DefaultListModel<>();
        while(Lit.hasNext()) {
            idens.addElement(String.valueOf(Lit.next().getIden()));
        }
        if(idens.size() == 0) idens.addElement("No hi ha cap nivell al sistema en aquest pla d'estudis");
        return idens;
    }
    
    public DefaultListModel<String> getSubjectsName(Level lvl){
        List<Subject> subjects = DomainCtrl.getSubjects(lvl);
        Iterator<Subject> Sit = subjects.iterator();
        DefaultListModel<String> names = new DefaultListModel<>();
        while(Sit.hasNext()) {
            names.addElement(Sit.next().getName());
        }
        if(names.size() == 0) names.addElement("No hi ha cap assignatura al sistema en aquest nivell");
        return names;
    }
    
    public StudyProgram addStudyProgram(String name) {
        return DomainCtrl.addStudyProgram(name);
    }
    
    public Level addLevel(int iden, StudyProgram sp){
        return DomainCtrl.addLevel(iden, sp);
    }
    
    public Subject addSubject(String name, Level lvl, int theory, int lab, int prob){
        Subject s = DomainCtrl.addSubject(lvl, name);
        s.fillTheoryH(theory);
        s.fillLaboratoryH(lab);
        s.fillProblemsH(prob);
        return s;
    }
    
    public void deleteStudyProgram(StudyProgram sp){
        DomainCtrl.deleteStudyProgram(sp);
    }
    
    public void deleteLevel(StudyProgram sp, Level lvl){
        sp.removeLevel(lvl);
    }
    
    public void deleteSubject(Level lvl, Subject subj){
        lvl.removeSubject(subj);
    }
    
    public void setNameStudyProgram(StudyProgram sp, String name){
        DomainCtrl.setNameStudyProgram(sp, name);
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
