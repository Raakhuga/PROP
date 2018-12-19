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
    
    /** FRAMES **/
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
        /*spmenu = new StudyProgramMenu(this);
        spmenu.setVisible(true);*/
    }
    
    /** SYNCRONIZATION **/
    // Main menu to State generator
    public void SwitchFromMMtoSG(){
        if(stategen == null)
            stategen = new StateGen(this);
        mainmenu.setVisible(false);
        mainmenu.setEnabled(false);
        stategen.setEnabled(true);
        stategen.setVisible(true);
    }
    
    // State generator to Main menu
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
    
    // Level menu to StudyProgram menu
    public void SwitchFromLMtoSPM(){
        lvlmenu.setVisible(false);
        lvlmenu.setEnabled(false);
        spmenu.setEnabled(true);
        spmenu.setVisible(true);
    }
    
    // StudyProgram menu to Add StudyProgram
    public void SwitchFromSPMtoASP(){
        if(addsp == null)
            addsp = new AddStudyProgram(this);
        spmenu.setVisible(false);
        spmenu.setEnabled(false);
        addsp.setEnabled(true);
        addsp.setVisible(true);
    }
    
    // Add StudyProgram to StudyProgram menu
    public void SwitchFromASPtoSPM(){
        addsp.setVisible(false);
        addsp.setEnabled(false);
        spmenu.setEnabled(true);
        spmenu.setVisible(true);
    }
    
    // StudyProgram menu to Modify StudyProgram
    public void SwitchFromSPMtoMSP(StudyProgram sp){
        if(modsp == null)
            modsp = new ModifyStudyProgram(this);
        modsp.setStudyProgram(sp);
        spmenu.setVisible(false);
        spmenu.setEnabled(false);
        modsp.setEnabled(true);
        modsp.setVisible(true);
    }
    
    // Modify StudyProgram to StudyProgram menu
    public void SwitchFromMSPtoSPM(){
        modsp.setVisible(false);
        modsp.setEnabled(false);
        spmenu.setEnabled(true);
        spmenu.setVisible(true);
    }
    
    // StudyProgram menu to Delete StudyProgram
    public void SwitchFromSPMtoDSP(StudyProgram sp){
        if(delsp == null)
            delsp = new DeleteStudyProgram(this);
        delsp.setStudyProgram(sp);
        spmenu.setVisible(false);
        spmenu.setEnabled(false);
        delsp.setEnabled(true);
        delsp.setVisible(true);
    }
    
    // Delete StudyProgram to StudyProgram menu
    public void SwitchFromDSPtoSPM(){
        delsp.setVisible(false);
        delsp.setEnabled(false);
        spmenu.setEnabled(true);
        spmenu.setVisible(true);
    }
    
    // Level menu to Subject menu
    public void SwitchFromLMtoSM(Level lvl){
        if(subjmenu == null)
            subjmenu = new SubjectsMenu(this);
        subjmenu.setLevel(lvl);
        lvlmenu.setVisible(false);
        lvlmenu.setEnabled(false);
        subjmenu.setEnabled(true);
        subjmenu.setVisible(true);
    }
    
    // Subject menu to Level menu
    public void SwitchFromSMtoLM(){
        subjmenu.setVisible(false);
        subjmenu.setEnabled(false);
        lvlmenu.setEnabled(true);
        lvlmenu.setVisible(true);
    }
    
    // Level menu to Add Level
    public void SwitchFromLMtoAL(StudyProgram sp){
        if(addlvl == null)
            addlvl = new AddLevel(this);
        addlvl.setStudyProgram(sp);
        lvlmenu.setVisible(false);
        lvlmenu.setEnabled(false);
        addlvl.setEnabled(true);
        addlvl.setVisible(true);
    }
    
    // Add Level to Level menu
    public void SwitchFromALtoLM(){
        addlvl.setVisible(false);
        addlvl.setEnabled(false);
        lvlmenu.setEnabled(true);
        lvlmenu.setVisible(true);
    }
    
    // Level menu to Modify Level
    public void SwitchFromLMtoML(Level lvl){
        if(modlvl == null)
            modlvl = new ModifyLevel(this);
        modlvl.setLevel(lvl);
        lvlmenu.setVisible(false);
        lvlmenu.setEnabled(false);
        modlvl.setEnabled(true);
        modlvl.setVisible(true);
    }
    
    // Modify Level to Level menu
    public void SwitchFromMLtoLM(){
        modlvl.setVisible(false);
        modlvl.setEnabled(false);
        lvlmenu.setEnabled(true);
        lvlmenu.setVisible(true);
    }
    
    // Level menu to Delete Level
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
    
    // Delete Level to Level menu
    public void SwitchFromDLtoLM(){
        dellvl.setVisible(false);
        dellvl.setEnabled(false);
        lvlmenu.setEnabled(true);
        lvlmenu.setVisible(true);
    }
    
    // Subject menu to Add Subject
    public void SwitchFromSMtoAS(Level lvl){
        if(addsubj == null)
            addsubj = new AddSubject(this);
        addsubj.setLevel(lvl);
        subjmenu.setVisible(false);
        subjmenu.setEnabled(false);
        addsubj.setEnabled(true);
        addsubj.setVisible(true);
    }
    
    // Add Subject to Subject menu
    public void SwitchFromAStoSM(){
        addsubj.setVisible(false);
        addsubj.setEnabled(false);
        subjmenu.setEnabled(true);
        subjmenu.setVisible(true);
    }
    
    // Subject menu to Modify Subject
    public void SwitchFromSMtoMS(Subject s){
        if(modsubj == null)
            modsubj = new ModifySubject(this);
        modsubj.setSubject(s);
        subjmenu.setVisible(false);
        subjmenu.setEnabled(false);
        modsubj.setEnabled(true);
        modsubj.setVisible(true);
    }
    
    // Modify Subject to Subject menu
    public void SwitchFromMStoSM(){
        modsubj.setVisible(false);
        modsubj.setEnabled(false);
        subjmenu.setEnabled(true);
        subjmenu.setVisible(true);
    }
    
    // Subject menu to Delete Subject
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
    
    // Delete Subject to Subject menu
    public void SwitchFromDStoSM(){
        delsubj.setVisible(false);
        delsubj.setEnabled(false);
        subjmenu.setEnabled(true);
        subjmenu.setVisible(true);
    }
    
    /** PRESENTATION METHODS **/
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
    
    /** DOMAIN METHODS **/
    public void setnMaxStudentsGroup(int nMaxStudentsGroup) {
        DomainCtrl.setnMaxStudentsGroup(nMaxStudentsGroup);
    }
    
    public void setnMaxStudentsSubgroup(int nMaxStudentsSubgroup) {
        DomainCtrl.setnMaxStudentsSubgroup(nMaxStudentsSubgroup);
    }
    
    public List<StudyProgram> getPrograms() {
        return DomainCtrl.getPrograms();
    }
    
    public List<Level> getLevels(StudyProgram sp){
        return DomainCtrl.getLevels(sp);
    }
    
    public List<Subject> getSubjects(Level lvl){
        return DomainCtrl.getSubjects(lvl);
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
        DomainCtrl.deleteLevel(sp, lvl);
    }
    
    public void deleteSubject(Level lvl, Subject subj){
        DomainCtrl.deleteSubject(lvl, subj);
    }
    
    public void setNameStudyProgram(StudyProgram sp, String name){
        DomainCtrl.setNameStudyProgram(sp, name);
    }

    public void setIdenLevel(Level lvl, int iden){
        DomainCtrl.setIdenLevel(lvl, iden);
    }
    
    public void setNameSubject(Subject s, String name){
        DomainCtrl.setNameSubject(s, name);
    }
    
    public void setHoursTheory(Subject s, int hours){
        DomainCtrl.setHoursTheory(s, hours);
    }
    
    public void setHoursLab(Subject s, int hours){
        DomainCtrl.setHoursLab(s, hours);
    }
    
    public void setHoursProb(Subject s, int hours){
        DomainCtrl.setHoursProb(s, hours);
    }
}
