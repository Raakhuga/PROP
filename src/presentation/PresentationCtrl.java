package presentation;

import domain.ClassSubject;
import domain.Classroom;
import domain.Group;
import domain.GroupSubject;
import domain.Level;
import domain.Group;
import domain.GroupSubject;
import domain.StudyProgram;
import domain.Subject;
import domain.TimetableGenerator;
import domain.subGroup;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.ListModel;
import persistance.PersistanceCtrl;
import persistance.PersistanceCtrl;
import domain.Level;
import domain.Subject;
import domain.StudyProgram;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;

public class PresentationCtrl {
    private TimetableGenerator DomainCtrl;
    Dimension dim;
    private boolean first;
    
    /** FRAMES **/
    private MainMenu mainmenu = null;
    private ClassroomMenu classroommenu = null;
    private AddClassroom addclassroom = null;
    private ModifyClassroom modifyclassroom = null;
    private SaveLoadMenu saveloadmenu = null;
    private GroupMenu groupmenu = null;
    private SelectClassroom selectclassroom = null;
    private ClassroomTimetable classroomtimetable = null;
    private ModifyGroup modifygroup = null;
    private AddGroup addgroup = null;
    private subGroupMenu subgroupmenu = null;
    private ModifysubGroup modifysubgroup = null;
    private AddsubGroup addsubgroup = null;
    private RestrictionMenu restrictionmenu = null;
    private AddClassroomResMenu addcRmenu = null;
    private GroupTimetable grouptimetable = null;
    private firstTime firstime = null;
    private SelectionMenu selectionmenu = null;
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
    private autoGenerateMenu agmenu = null;
    private DeleteClassroom deleteclassroom = null;
    private DeleteGroup deletegroup = null;
    private DeletesubGroup deletesubgroup = null;
    private AddGroupResMenu addgroupresmenu = null;
    private AddsubGroupResMenu addsubgroupresmenu = null;
    private ViewState viewstate = null;
    private ModifyClassroomTimetable mctimetable = null;
    private ModifySelectClassroom msclassroom = null;
    
    
    public PresentationCtrl(){
        DomainCtrl = new TimetableGenerator();
        TimetableGenerator aux = new TimetableGenerator();
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        first = true;
        mainmenu = new MainMenu(this);
        centerFrame(mainmenu);
        mainmenu.setVisible(true);
    }
    
    private void centerFrame(JFrame aux) {
        aux.setLocation(dim.width/2-aux.getSize().width/2, dim.height/2-aux.getSize().height/2);
        aux.setResizable(false);
    }
    
    public boolean isInt(String text) {
        try {
            Integer.parseInt(text);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    /** SYNCRONIZATION **/    
    public void SwitchFromMMtoVS() {
        if(viewstate == null)
            viewstate = new ViewState(this);
        mainmenu.setVisible(false);
        mainmenu.setEnabled(false);
        viewstate.setEnabled(true);
        centerFrame(viewstate);
        viewstate.setVisible(true);
    }
    
    public void SwitchFromVStoMM() {
        viewstate.setVisible(false);
        viewstate.setEnabled(false);
        mainmenu.setEnabled(true);
        mainmenu.setVisible(true);
    }
    
    public void SwitchFromMMtoSLM(){
        if(saveloadmenu == null)
            saveloadmenu = new SaveLoadMenu(this);
        mainmenu.setVisible(false);
        mainmenu.setEnabled(false);
        saveloadmenu.setEnabled(true);
        centerFrame(saveloadmenu);
        saveloadmenu.setVisible(true);
    }
    
    public void SwitchFromMMtoRM() {
        if(restrictionmenu == null)
            restrictionmenu = new RestrictionMenu(this);
        mainmenu.setVisible(false);
        mainmenu.setEnabled(false);
        restrictionmenu.setEnabled(true);
        centerFrame(restrictionmenu);
        restrictionmenu.setVisible(true);
    }
    
    
    
    public void SwitchFromSLMtoMM(){
        saveloadmenu.setVisible(false);
        saveloadmenu.setEnabled(false);
        mainmenu.setEnabled(true);
        centerFrame(mainmenu);
        mainmenu.setVisible(true);
    }
    
    public void SwitchFromMMtoFT(){
        if(firstime == null)
            firstime = new firstTime(this);
        mainmenu.setVisible(false);
        mainmenu.setEnabled(false);
        firstime.setEnabled(true);
        centerFrame(firstime);
        firstime.setVisible(true);
    }
    
    public void SwitchFromMMtoSM(){
        if(selectionmenu == null)
            selectionmenu = new SelectionMenu(this);
        mainmenu.setVisible(false);
        mainmenu.setEnabled(false);
        selectionmenu.setEnabled(true);
        centerFrame(selectionmenu);
        selectionmenu.setVisible(true);
    }
    
    public void SwitchFromFTtoMM(){
        firstime.setVisible(false);
        firstime.setEnabled(false);
        mainmenu.setEnabled(true);
        centerFrame(mainmenu);
        mainmenu.setVisible(true);
    }
    
    public void SwitchFromFTtoSM(){
        if(selectionmenu == null)
            selectionmenu = new SelectionMenu(this);
        firstime.setVisible(false);
        firstime.setEnabled(false);
        selectionmenu.setEnabled(true);
        centerFrame(selectionmenu);
        selectionmenu.setVisible(true);
    }
    

    public void SwitchFromCMtoMM(){
        classroommenu.setVisible(false);
        classroommenu.setEnabled(false);
        mainmenu.setEnabled(true);
        centerFrame(mainmenu);
        mainmenu.setVisible(true);
    }
    
    public void SwitchFromMMtoSC(){
        if(selectclassroom == null)
            selectclassroom = new SelectClassroom(this);
        mainmenu.setVisible(false);
        mainmenu.setEnabled(false);
        selectclassroom.setEnabled(true);
        centerFrame(selectclassroom);
        selectclassroom.setVisible(true);
    }
    
    public void SwitchFromSCtoMM(){
        selectclassroom.setVisible(false);
        selectclassroom.setEnabled(false);
        mainmenu.setEnabled(true);
        centerFrame(mainmenu);
        mainmenu.setVisible(true);
    }
    
    public void SwitchFromCMtoAC(DefaultListModel<String> classrooms){
        if(addclassroom == null)
            addclassroom = new AddClassroom(this);
        addclassroom.setList(classrooms);
        classroommenu.setEnabled(false);
        addclassroom.setEnabled(true);
        centerFrame(addclassroom);
        addclassroom.setVisible(true);
    }
    
    public void SwitchFromACtoCM(){
        addclassroom.setVisible(false);
        addclassroom.setEnabled(false);
        classroommenu.setEnabled(true);
        centerFrame(classroommenu);
        classroommenu.setVisible(true);
    }
    
    public void SwitchFromMCtoCM(){
        modifyclassroom.setVisible(false);
        modifyclassroom.setEnabled(false);
        classroommenu.setEnabled(true);
        centerFrame(classroommenu);
        classroommenu.setVisible(true);
    }
    
    public void SwitchFromCMtoMC(Classroom classroom, DefaultListModel<String> classrooms){
        if(modifyclassroom == null)
            modifyclassroom = new ModifyClassroom(this);
        modifyclassroom.setClassroom(classroom);
        modifyclassroom.setList(classrooms);
        classroommenu.setEnabled(false);
        modifyclassroom.setEnabled(true);
        centerFrame(modifyclassroom);
        modifyclassroom.setVisible(true);
    }
    
    //Group Switches
    public void SwitchFromMGtoGM() {
        modifygroup.setVisible(false);
        modifygroup.setEnabled(false);
        groupmenu.setEnabled(true);
        centerFrame(groupmenu);
        groupmenu.setVisible(true);
    }
    
    public void SwitchFromGMtosGM(Group g, Level lvl) {
        if (subgroupmenu == null)
            subgroupmenu = new subGroupMenu(this);
        subgroupmenu.setGroup(g);
        subgroupmenu.setLevel(lvl);
        groupmenu.setEnabled(false);
        groupmenu.setVisible(false);
        subgroupmenu.setEnabled(true);
        centerFrame(subgroupmenu);
        subgroupmenu.setVisible(true);
    }
    
    public void SwitchFromSMtoAG(Subject s, Level lvl) {
        if (agmenu == null)
            agmenu = new autoGenerateMenu(this);
        agmenu.setSubject(s);
        agmenu.setLevel(lvl);
        subjmenu.setEnabled(false);
        subjmenu.setVisible(false);
        agmenu.setEnabled(true);
        centerFrame(agmenu);
        agmenu.setVisible(true);
    }
    
    public void SwitchFromAGtoSM() {
        agmenu.setVisible(false);
        agmenu.setEnabled(false);
        subjmenu.setEnabled(true);
        subjmenu.setVisible(true);
    }
    
    public void SwitchFromGMtoMM() {
        groupmenu.setVisible(false);
        groupmenu.setEnabled(false);
        mainmenu.setEnabled(true);
        mainmenu.setVisible(true);
    }
    
    public void SwitchFromGMtoSM() {
        groupmenu.setVisible(false);
        groupmenu.setEnabled(false);
        subjmenu.setEnabled(true);
        subjmenu.setVisible(true);
    }
    
    public void SwitchFromsGMtoMM() {
        subgroupmenu.setVisible(false);
        subgroupmenu.setEnabled(false);
        mainmenu.setEnabled(true);
        mainmenu.setVisible(true);
    }
    
    public void SwitchFromsGMtoGM(){
        subgroupmenu.setVisible(false);
        subgroupmenu.setEnabled(false);
        groupmenu.setEnabled(true);
        groupmenu.setVisible(true);
    }
     
    public void SwitchFromGMtoMG(Group g) {
        if (modifygroup == null) 
           modifygroup = new ModifyGroup(this);
        modifygroup.setGroup(g);
        groupmenu.setEnabled(false);
        groupmenu.setVisible(false);
        modifygroup.setEnabled(true);
        centerFrame(modifygroup);
        modifygroup.setVisible(true); 
    }
    
    public void SwitchFromGMtoAG(Subject sub) {
        if(addgroup == null)
            addgroup = new AddGroup(this);
        addgroup.setSubject(sub);
        groupmenu.setEnabled(false);
        groupmenu.setVisible(false);
        addgroup.setEnabled(true);
        centerFrame(addgroup);
        addgroup.setVisible(true);
    }
    public void SwitchFromSCtoCTT(Classroom classroom){
        classroomtimetable = new ClassroomTimetable(this);
        classroomtimetable.setClassroom(classroom);
        selectclassroom.setEnabled(false);
        selectclassroom.setVisible(false);
        classroomtimetable.setEnabled(true);
        classroomtimetable.setVisible(true);
        centerFrame(classroomtimetable);
    }
    
    public void SwitchFromAGtoGM() {
        addgroup.setVisible(false);
        addgroup.setEnabled(false);
        groupmenu.setEnabled(true);
        centerFrame(groupmenu);
        groupmenu.setVisible(true);
    }
    
    public void SwitchFromCTTtoSC(){
        classroomtimetable.setEnabled(false);
        classroomtimetable.setVisible(false);
        selectclassroom.setEnabled(true);
        centerFrame(selectclassroom);
        selectclassroom.setVisible(true);
    }
    //End of group switches
    
    //subGroup switches
    public void SwitchFromssGMtoMsG(subGroup sG) {
         if (modifysubgroup == null) 
           modifysubgroup = new ModifysubGroup(this);
        modifysubgroup.setsubGroup(sG);
        subgroupmenu.setEnabled(false);
        subgroupmenu.setVisible(false);
        modifysubgroup.setEnabled(true);
        centerFrame(modifysubgroup);
        modifysubgroup.setVisible(true); 
    }
    
    public void SwitchFromCTTtoGTT(Group group){
        grouptimetable = new GroupTimetable(this);
        grouptimetable.setGroup(group);
        classroomtimetable.setEnabled(false);
        classroomtimetable.setVisible(false);
        grouptimetable.setEnabled(true);
        grouptimetable.setVisible(true);
        centerFrame(grouptimetable);
    }
    public void SwitchFromMsGtosGM() {
        modifysubgroup.setEnabled(false);
        modifysubgroup.setVisible(false);
        subgroupmenu.setEnabled(true);
        centerFrame(subgroupmenu);
        subgroupmenu.setVisible(true); 
    }
    
    public void SwitchFromsGMtoAsG(Group g) {
        if(addsubgroup == null)
            addsubgroup = new AddsubGroup(this, g);
        subgroupmenu.setEnabled(false);
        subgroupmenu.setVisible(false);
        addsubgroup.setEnabled(true);
        centerFrame(addsubgroup);
        addsubgroup.setVisible(true);
    }
    
    public void SwitchFromAsGtosGM() {
        addsubgroup.setVisible(false);
        addsubgroup.setEnabled(false);
        subgroupmenu.setEnabled(true);
        centerFrame(subgroupmenu);
        subgroupmenu.setVisible(true);
    }
   
    //end of subgroup switches
   
    //Restriccions switches    
    public void SwitchFromRMtoACR(Classroom clas) {
        if (addcRmenu == null)
            addcRmenu = new AddClassroomResMenu (this);
        addcRmenu.setClass(clas);
        restrictionmenu.setVisible(false);
        restrictionmenu.setEnabled(false);
        addcRmenu.setEnabled(true);
        centerFrame(addcRmenu);
        addcRmenu.setVisible(true);
    }

    public void SwitchFromRMtoAGR(Group g) {
        if (addgroupresmenu == null)
            addgroupresmenu = new AddGroupResMenu(this);
        addgroupresmenu.setGroup(g);
        addgroupresmenu.setEnabled(true);
        centerFrame(addgroupresmenu);
        restrictionmenu.setEnabled(false);
        restrictionmenu.setVisible(false);
        addgroupresmenu.setVisible(true);
    }  
    
    public void SwitchFromRMtoAsGR(subGroup sG) {
          if (addsubgroupresmenu == null)
            addsubgroupresmenu = new AddsubGroupResMenu(this);
        addsubgroupresmenu.setsubGroup(sG);
        addsubgroupresmenu.setEnabled(true);
        centerFrame(addsubgroupresmenu);
        restrictionmenu.setEnabled(false);
        restrictionmenu.setVisible(false);
        addsubgroupresmenu.setVisible(true);
    }
    //end of restriccions switches
    
    
    
    //presentation methods
    
    public void SwitchFromGTTtoCTT(){
        grouptimetable.setEnabled(false);
        grouptimetable.setVisible(false);
        classroomtimetable.setEnabled(true);
        classroomtimetable.setVisible(true);
        centerFrame(classroomtimetable);
    }
    
    public void SwitchFromGTTtoCTT(Classroom classroom){
        classroomtimetable = new ClassroomTimetable(this);
        classroomtimetable.setClassroom(classroom);
        grouptimetable.setEnabled(false);
        grouptimetable.setVisible(false);
        classroomtimetable.setEnabled(true);
        classroomtimetable.setVisible(true);
        centerFrame(classroomtimetable);
    }
    
    public void SwitchFromSMtoCM(){
        if(classroommenu == null)
            classroommenu = new ClassroomMenu(this);
        selectionmenu.setVisible(false);
        selectionmenu.setEnabled(false);
        classroommenu.setEnabled(true);
        centerFrame(classroommenu);
        classroommenu.setVisible(true);
    }
    
    public void SwitchFromCMtoSM(){
        classroommenu.setVisible(false);
        classroommenu.setEnabled(false);
        selectionmenu.setEnabled(true);
        centerFrame(selectionmenu);
        selectionmenu.setVisible(true);
    }
    
    public void SwitchFromSMtoMM() {
        selectionmenu.setVisible(false);
        selectionmenu.setEnabled(false);
        mainmenu.setEnabled(true);
        centerFrame(mainmenu);
        mainmenu.setVisible(true);
    }
    
    public void SwitchFromSMtoSPM() {
        if(spmenu == null)
            spmenu = new StudyProgramMenu(this);
        selectionmenu.setVisible(false);
        selectionmenu.setEnabled(false);
        spmenu.setEnabled(true);
        centerFrame(spmenu);
        spmenu.setVisible(true);
    }
    
    public void SwitchFromSPMtoSM() {
        spmenu.setVisible(false);
        spmenu.setEnabled(false);
        selectionmenu.setEnabled(true);
        centerFrame(selectionmenu);
        selectionmenu.setVisible(true);
    }
    
    public void SwitchFromSPMtoMM() {
        spmenu.setVisible(false);
        spmenu.setEnabled(false);
        mainmenu.setEnabled(true);
        centerFrame(mainmenu);
        mainmenu.setVisible(true);
    }
    
    // StudyProgram menu to Level menu
    public void SwitchFromSPMtoLM(StudyProgram sp){
        if(lvlmenu == null)
            lvlmenu = new LevelMenu(this);
        lvlmenu.setStudyProgram(sp);
        spmenu.setVisible(false);
        spmenu.setEnabled(false);
        lvlmenu.setEnabled(true);
        centerFrame(lvlmenu);
        lvlmenu.setVisible(true);
    }
    
    // Level menu to StudyProgram menu
    public void SwitchFromLMtoSPM(){
        lvlmenu.setVisible(false);
        lvlmenu.setEnabled(false);
        spmenu.setEnabled(true);
        centerFrame(spmenu);
        spmenu.setVisible(true);
    }
    
    // StudyProgram menu to Add StudyProgram
    public void SwitchFromSPMtoASP(DefaultListModel<String> studyprograms){
        if(addsp == null)
            addsp = new AddStudyProgram(this);
        addsp.setList(studyprograms);
        spmenu.setVisible(false);
        spmenu.setEnabled(false);
        addsp.setEnabled(true);
        centerFrame(addsp);
        addsp.setVisible(true);
    }
    
    // Add StudyProgram to StudyProgram menu
    public void SwitchFromASPtoSPM(){
        addsp.setVisible(false);
        addsp.setEnabled(false);
        spmenu.setEnabled(true);
        centerFrame(spmenu);
        spmenu.setVisible(true);
    }
    
    // StudyProgram menu to Modify StudyProgram
    public void SwitchFromSPMtoMSP(StudyProgram sp, DefaultListModel<String> studyprograms){
        if(modsp == null)
            modsp = new ModifyStudyProgram(this);
        modsp.setStudyProgram(sp);
        modsp.setList(studyprograms);
        spmenu.setVisible(false);
        spmenu.setEnabled(false);
        modsp.setEnabled(true);
        centerFrame(modsp);
        modsp.setVisible(true);
    }
    
    // Modify StudyProgram to StudyProgram menu
    public void SwitchFromMSPtoSPM(){
        modsp.setVisible(false);
        modsp.setEnabled(false);
        spmenu.setEnabled(true);
        centerFrame(spmenu);
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
        centerFrame(delsp);
        delsp.setVisible(true);
    }
    
    // Delete StudyProgram to StudyProgram menu
    public void SwitchFromDSPtoSPM(){
        delsp.setVisible(false);
        delsp.setEnabled(false);
        spmenu.setEnabled(true);
        centerFrame(spmenu);
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
        centerFrame(subjmenu);
        subjmenu.setVisible(true);
    }
    
    // Subject menu to Level menu
    public void SwitchFromSMtoLM(){
        subjmenu.setVisible(false);
        subjmenu.setEnabled(false);
        lvlmenu.setEnabled(true);
        centerFrame(lvlmenu);
        lvlmenu.setVisible(true);
    }
    
    // Level menu to Add Level
    public void SwitchFromLMtoAL(StudyProgram sp, DefaultListModel<String> levels){
        if(addlvl == null)
            addlvl = new AddLevel(this);
        addlvl.setStudyProgram(sp);
        addlvl.setList(levels);
        lvlmenu.setVisible(false);
        lvlmenu.setEnabled(false);
        addlvl.setEnabled(true);
        centerFrame(addlvl);
        addlvl.setVisible(true);
    }
    
    // Add Level to Level menu
    public void SwitchFromALtoLM(){
        addlvl.setVisible(false);
        addlvl.setEnabled(false);
        lvlmenu.setEnabled(true);
        centerFrame(lvlmenu);
        lvlmenu.setVisible(true);
    }
    
    // Level menu to Modify Level
    public void SwitchFromLMtoML(Level lvl, DefaultListModel<String> levels){
        if(modlvl == null)
            modlvl = new ModifyLevel(this);
        modlvl.setLevel(lvl);
        modlvl.setList(levels);
        lvlmenu.setVisible(false);
        lvlmenu.setEnabled(false);
        modlvl.setEnabled(true);
        centerFrame(modlvl);
        modlvl.setVisible(true);
    }
    
    // Modify Level to Level menu
    public void SwitchFromMLtoLM(){
        modlvl.setVisible(false);
        modlvl.setEnabled(false);
        lvlmenu.setEnabled(true);
        centerFrame(lvlmenu);
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
        centerFrame(dellvl);
        dellvl.setVisible(true);
    }
    
    // Delete Level to Level menu
    public void SwitchFromDLtoLM(){
        dellvl.setVisible(false);
        dellvl.setEnabled(false);
        lvlmenu.setEnabled(true);
        centerFrame(lvlmenu);
        lvlmenu.setVisible(true);
    }
    
    // Subject menu to Group menu
    public void SwitchFromSMtoGM(Subject s, Level l){
        if(groupmenu == null)
            groupmenu = new GroupMenu(this);
        groupmenu.setSubj(s);
        groupmenu.setLevel(l);
        subjmenu.setVisible(false);
        subjmenu.setEnabled(false);
        groupmenu.setEnabled(true);
        centerFrame(groupmenu);
        groupmenu.setVisible(true);
    }
    
    // Subject menu to Add Subject
    public void SwitchFromSMtoAS(Level lvl, DefaultListModel<String> subjects){
        if(addsubj == null)
            addsubj = new AddSubject(this);
        addsubj.setLevel(lvl);
        addsubj.setList(subjects);
        subjmenu.setVisible(false);
        subjmenu.setEnabled(false);
        addsubj.setEnabled(true);
        centerFrame(addsubj);
        addsubj.setVisible(true);
    }
    
    // Add Subject to Subject menu
    public void SwitchFromAStoSM(){
        addsubj.setVisible(false);
        addsubj.setEnabled(false);
        subjmenu.setEnabled(true);
        centerFrame(subjmenu);
        subjmenu.setVisible(true);
    }
    
    // Subject menu to Modify Subject
    public void SwitchFromSMtoMS(Subject s, DefaultListModel<String> subjects){
        if(modsubj == null)
            modsubj = new ModifySubject(this);
        modsubj.setSubject(s);
        modsubj.setList(subjects);
        subjmenu.setVisible(false);
        subjmenu.setEnabled(false);
        modsubj.setEnabled(true);
        centerFrame(modsubj);
        modsubj.setVisible(true);
    }
    
    // Modify Subject to Subject menu
    public void SwitchFromMStoSM(){
        modsubj.setVisible(false);
        modsubj.setEnabled(false);
        subjmenu.setEnabled(true);
        centerFrame(subjmenu);
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
        centerFrame(delsubj);
        delsubj.setVisible(true);
    }
    
    // Delete Subject to Subject menu
    public void SwitchFromDStoSM(){
        delsubj.setVisible(false);
        delsubj.setEnabled(false);
        subjmenu.setEnabled(true);
        centerFrame(subjmenu);
        subjmenu.setVisible(true);
    }
    
    public void SwitchFromSjMtoMM() {
        subjmenu.setVisible(false);
        subjmenu.setEnabled(false);
        mainmenu.setEnabled(true);
        centerFrame(mainmenu);
        mainmenu.setVisible(true);
    }
    
    public void SwitchFromLMtoMM() {
        lvlmenu.setVisible(false);
        lvlmenu.setEnabled(false);
        mainmenu.setEnabled(true);
        centerFrame(mainmenu);
        mainmenu.setVisible(true);
    }
    
    public void SwitchFromDCtoCM() {
        deleteclassroom.setVisible(false);
        deleteclassroom.setEnabled(false);
        classroommenu.setEnabled(true);
        classroommenu.setVisible(true);
    }
    
    public void SwitchFromCMtoDC(int id) {
        if(deleteclassroom == null)
            deleteclassroom = new DeleteClassroom(this);
        deleteclassroom.setId(id);
        classroommenu.setVisible(false);
        classroommenu.setEnabled(false);
        deleteclassroom.setEnabled(true);
        centerFrame(deleteclassroom);
        deleteclassroom.setVisible(true);
    }
    
    public void SwitchFromDGtoGM() {
        deletegroup.setVisible(false);
        deletegroup.setEnabled(false);
        groupmenu.setEnabled(true);
        groupmenu.setVisible(true);
    }
    
    public void SwitchFromGMtoDG(int id, Subject s) {
        if(deletegroup == null)
            deletegroup = new DeleteGroup(this);
        deletegroup.setId(id);
        deletegroup.setGroup(this.getGroup(s).get(id));
        deletegroup.setSubject(s);
        groupmenu.setVisible(false);
        groupmenu.setEnabled(false);
        deletegroup.setEnabled(true);
        centerFrame(deletegroup);
        deletegroup.setVisible(true);
    }
    
    public void SwitchFromDsGtosGM() {
        deletesubgroup.setVisible(false);
        deletesubgroup.setEnabled(false);
        subgroupmenu.setEnabled(true);
        subgroupmenu.setVisible(true);
    }
    
    public void SwitchFromsGMtoDsG(int id, Group g) {
        if(deletesubgroup == null)
            deletesubgroup = new DeletesubGroup(this);
        deletesubgroup.setId(id);
        deletesubgroup.setGroup(g);
        subgroupmenu.setVisible(false);
        subgroupmenu.setEnabled(false);
        deletesubgroup.setEnabled(true);
        centerFrame(deletesubgroup);
        deletesubgroup.setVisible(true);
    }
    
     public void SwitchFromAClassResMtoRM() {
         restrictionmenu.setEnabled(true);
         addcRmenu.setEnabled(false);
         addcRmenu.setVisible(false);
         centerFrame(restrictionmenu);
         restrictionmenu.setVisible(true);
         
    }
     
    public void SwitchFromAsubGroupResMtoRM() {
        addsubgroupresmenu.setVisible(false);
        addsubgroupresmenu.setEnabled(false);
        restrictionmenu.setEnabled(true);
        centerFrame(restrictionmenu);
        restrictionmenu.setVisible(true);
    }
      public void SwitchFromAGroupResMtoRM() {
        addgroupresmenu.setVisible(false);
        addgroupresmenu.setEnabled(false);
        restrictionmenu.setEnabled(true);
        centerFrame(restrictionmenu);
        restrictionmenu.setVisible(true);
      }
    
    public void SwitchFromMCTtoMSC(GroupSubject GS, int day, int hour, Classroom c) {
        if(msclassroom == null)
            msclassroom = new ModifySelectClassroom(this);
        msclassroom.setGroupSubject(GS);
        msclassroom.setCorig(c);
        msclassroom.setDorig(day); 
        msclassroom.setHorig(hour);
        mctimetable.setVisible(false);
        mctimetable.setEnabled(false);
        msclassroom.setEnabled(true);
        centerFrame(msclassroom);
        msclassroom.setVisible(true);
    }
    
    public void SwitchFromMSCtoMCT(Classroom cdest, Classroom corig, GroupSubject GS, int dorig, int horig) {
        mctimetable = new ModifyClassroomTimetable(this);
        mctimetable.setGroupSubject(GS);
        mctimetable.setClassroom(cdest);
        mctimetable.setCorig(corig);
        mctimetable.setDorig(dorig);
        mctimetable.setHorig(horig);
        msclassroom.setVisible(false);
        msclassroom.setEnabled(false);
        mctimetable.setEnabled(true);
        centerFrame(mctimetable);
        mctimetable.setVisible(true);
    }
    
    public void SwitchFromMSCtoMCT(Classroom c) {
        mctimetable = new ModifyClassroomTimetable(this);
        msclassroom.setVisible(false);
        msclassroom.setEnabled(false);
        mctimetable.setClassroom(c);
        mctimetable.setEnabled(true);
        centerFrame(mctimetable);
        mctimetable.setVisible(true);
    }
    
    public void SwitchFromCTTtoMCT(Classroom c) {
        mctimetable = new ModifyClassroomTimetable(this);
        mctimetable.setClassroom(c);
        classroomtimetable.setVisible(false);
        classroomtimetable.setEnabled(false);
        mctimetable.setEnabled(true);
        centerFrame(mctimetable);
        mctimetable.setVisible(true);
    }
    
    public void SwitchFromMCTtoSC() {
        mctimetable.setVisible(false);
        mctimetable.setEnabled(false);
        selectclassroom.setEnabled(true);
        centerFrame(selectclassroom);
        selectclassroom.setVisible(true);
    }
    
    public void SwitchFromMCTtoMSC() {
        mctimetable.setVisible(false);
        mctimetable.setEnabled(false);
        msclassroom.setEnabled(true);
        centerFrame(msclassroom);
        msclassroom.setVisible(true);
    }
    
    public void SwitchFromRMtoMM() {
        restrictionmenu.setEnabled(false);
        restrictionmenu.setVisible(false);
        mainmenu.setEnabled(true);
        centerFrame(mainmenu);
        mainmenu.setVisible(true);
    }
    //presentation methods
    
    public boolean groupRestrictions(Classroom c, GroupSubject GS, int day, int hour) {
        return DomainCtrl.groupRestrictions(day, hour, c, GS);
    }
    
    public boolean classroomRestrictions(Classroom c, GroupSubject GS, int day, int hour) {
        return DomainCtrl.classroomRestrictions(day, hour, c, GS);
    }
    
    public void swapGS(Classroom corig, int dorig, int horig, GroupSubject orig, Classroom cdest, int ddest, int hdest, GroupSubject dest) {
        ClassSubject csorig;
        ClassSubject csdest;
        if(!orig.isEmpty()) csorig = new ClassSubject(corig, orig.getSubject());
        else csorig = new ClassSubject();
        if(!dest.isEmpty())csdest = new ClassSubject(cdest, dest.getSubject());
        else csdest = new ClassSubject();
        if(!dest.isEmpty()) corig.addToClassTimetable(dest, dorig, horig);
        else corig.removeFromClassTimetable(dorig, horig);
        if(!orig.isEmpty()) cdest.addToClassTimetable(orig, ddest, hdest);
        else cdest.removeFromClassTimetable(ddest, hdest);
        if(!dest.isEmpty())dest.getGroup().addToGroupTimetable(csorig, ddest, hdest);
        if(!orig.isEmpty())orig.getGroup().addToGroupTimetable(csdest, dorig, horig);
    }
    
    public DefaultListModel<String> getClassroomsRefs() {
        List<Classroom> classrooms = DomainCtrl.getClassrooms();
        Iterator<Classroom> Cit = classrooms.iterator();
        DefaultListModel<String> refs = new DefaultListModel<>();
        while(Cit.hasNext()) {
            refs.addElement(Cit.next().getRef());
        }
        if(refs.size() == 0) refs.addElement("No hi ha cap aula al sistema");
        return refs;
    }
    
    public DefaultListModel<String> getClassroomsRefsType() {
        List<Classroom> classrooms = DomainCtrl.getClassrooms();
        Iterator<Classroom> Cit = classrooms.iterator();
        DefaultListModel<String> refs = new DefaultListModel<>();
        while(Cit.hasNext()) {
            Classroom Cact = Cit.next();
            refs.addElement(Cact.getRef() + " " + Cact.getTypes());
        }
        if(refs.size() == 0) refs.addElement("No hi ha cap aula al sistema");
        return refs;
    }
    
    public DefaultListModel<String> getProgramsNames() {
        List<StudyProgram> programs = DomainCtrl.getPrograms();
        Iterator<StudyProgram> Pit = programs.iterator();
        DefaultListModel<String> names = new DefaultListModel<>();
        while(Pit.hasNext()) {
            names.addElement(Pit.next().getName());
        }
        if(names.size() == 0) names.addElement("No hi ha cap pla d'estudis al sistema");
        return names;
    }
    
    public DefaultListModel<String> getGroupsRefs(Subject sub) {
      List<Group> groupList = DomainCtrl.getGroupsRefs(sub);
      Iterator<Group> Git = groupList.iterator();
      DefaultListModel<String> refs = new DefaultListModel<>();
      while(Git.hasNext()) {
          refs.addElement(Git.next().getNum()+"");
      }
      if(refs.size() == 0) refs.addElement("No hi ha cap grup al sistema");
      return refs;
    }
     public DefaultListModel<String> getsubGroupsRefs(Group g) {
      List<subGroup> subgroupList = DomainCtrl.getsubGroup(g);
      Iterator<subGroup> it = subgroupList.iterator();
      DefaultListModel<String> refs = new DefaultListModel<>();
      while(it.hasNext()) {
          refs.addElement(it.next().getNum()+"");
      }
      if(refs.size() == 0) refs.addElement("No hi ha cap subgrup al sistema");
      return refs;
    }
    
    //domain methods
    
    public void setnMaxStudentsGroup(int nMaxStudentsGroup) {
        DomainCtrl.setnMaxStudentsGroup(nMaxStudentsGroup);
    }
    
    public void setnMaxStudentsSubgroup(int nMaxStudentsSubgroup) {
        DomainCtrl.setnMaxStudentsSubgroup(nMaxStudentsSubgroup);
    }
    
    public List<Classroom> getClassrooms() {
        return DomainCtrl.getClassrooms();
    }

    public List<StudyProgram> getPrograms() {
        return DomainCtrl.getPrograms();
    }
    
    public void setFirst(boolean first) {
        this.first = first;
    }
    
    public boolean getFirst() {
        return first;
    }
    
    //domain methods
    public boolean generate() {
        DomainCtrl.deleteAllGS();
        DomainCtrl.generateAllGS();
        DomainCtrl.resetTimetables();
        return DomainCtrl.generateTimetable();
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
    

        
    public Classroom addClassroom(int capacity, String ref, int dIni, int dEnd, int hIni, int hEnd) {
        return DomainCtrl.addClassroom(capacity, ref, dIni, dEnd, hIni, hEnd);
    }
    
    public void addGroup(Subject sub, int num, int dIni, int dEnd, int hIni, int hEnd, int enrolled) {
        DomainCtrl.addGroup(sub, dIni, dEnd, hIni, hEnd, num, enrolled);
    }
    
   public void addsubGroup(Group g, int num, int enrolled) {
        DomainCtrl.addSubGroup(g, num, enrolled);
    }
    
    public void removeClassroom(int id) {
        DomainCtrl.removeClassroom(id);
    }
    
    public void removeGroup(Group group, Subject sub) {
        DomainCtrl.removeGroup(group, sub);
    }
    
    public void setCapacity(Classroom c, int capacity) {
        DomainCtrl.setCapacity(c, capacity);
    }
    
    public void setRef(Classroom c, String ref) {
        DomainCtrl.setRef(c, ref);
    }
    
    public void setdIni(Classroom c, int dIni) {
        DomainCtrl.setdIni(c, dIni);
    }
    
    public void setdEnd(Classroom c, int dEnd) {
        DomainCtrl.setdEnd(c, dEnd);
    }
    
    public void sethIni(Classroom c, int hIni) {
        DomainCtrl.sethIni(c, hIni);
    }
    
    public void sethEnd(Classroom c, int hEnd) {
        DomainCtrl.sethEnd(c, hEnd);
    }
    
    public void setTheory(Classroom c, boolean state) {
        DomainCtrl.setTheory(c, state);
    }
    
    public void setLaboratory(Classroom c, boolean state) {
        DomainCtrl.setLaboratory(c, state);
    }
    
    public void setProblems(Classroom c, boolean state) {
        DomainCtrl.setProblems(c, state);
    }
    
    public boolean isTheory(Classroom c) {
        return DomainCtrl.isTheory(c);
    }
    
    public boolean isLaboratory(Classroom c) {
        return DomainCtrl.isLaboratory(c);
    }
    
    public boolean isProblems(Classroom c) {
        return DomainCtrl.isProblems(c);
    }
    
    public void load(String path) {
        //DomainCtrl.loadState(path);
        first = false;
        DomainCtrl.loadState(path);
    }
    
    public void save(String path) {
        DomainCtrl.saveState(path);
    }

    public List<Group> getGroup(Subject mSub) {
        return DomainCtrl.getGroupsRefs(mSub);
    }

    public void setNum(Group g, int num) {
        DomainCtrl.setNum(g, num);
    }

    public void setdIni(Group g, int dIni) {
        DomainCtrl.setdIni(g, dIni);
    }

    public void setdEnd(Group g, int dEnd) {
        DomainCtrl.setdEnd(g, dEnd);

    }

    public void sethIni(Group g, int hIni) {
        DomainCtrl.sethIni(g, hIni);

    }

    public void sethEnd(Group g, int hEnd) {
        DomainCtrl.sethEnd(g, hEnd);

    }
    

    public void setEnrolled(Group g, int enrolled) {
        DomainCtrl.setEnrolled(g, enrolled);
    }   

    public void removeSubGroup(subGroup s, Group g) {
        DomainCtrl.removeSubGroup(s, g);
    }

    public List<subGroup> getsubGroup(Group g) {
        return DomainCtrl.getsubGroup(g);
    }

    public DefaultListModel<String> getRestrictions(Classroom c) {
      List<String> resList = DomainCtrl.getRestrictions(c);
      Iterator<String> it = resList.iterator();
      DefaultListModel<String> refs = new DefaultListModel<>();
      while(it.hasNext()) {
          refs.addElement(it.next());
      }
      if(refs.size() == 0) refs.addElement("No hi ha cap restricció al sistema");
      return refs;
    }
    
    public DefaultListModel<String> getRestrictions(Group g) {
      List<String> resList = DomainCtrl.getRestrictions(g);
      Iterator<String> it = resList.iterator();
      DefaultListModel<String> refs = new DefaultListModel<>();
      while(it.hasNext()) {
          refs.addElement(it.next());
      }
      if(refs.size() == 0) refs.addElement("No hi ha cap restricció al sistema");
      return refs;
    }
    

    public List<StudyProgram> getSP() {
        return DomainCtrl.getPrograms();
    }

    public DefaultListModel<String> getLevel(StudyProgram sp) {
        List<Level> lvlList = DomainCtrl.getLevel(sp);
        Iterator<Level> it = lvlList.iterator();
        DefaultListModel<String> refs = new DefaultListModel<>();
        while(it.hasNext()) {
            refs.addElement(Integer.toString(it.next().getIden()));
        }
        if(refs.size() == 0) refs.addElement("No hi ha cap nivell al sistema");
        return refs;
    }
    
    public List<Level> getLevels(StudyProgram sp) {
        return DomainCtrl.getLevel(sp);
    }

    public DefaultListModel<String> getSubject(Level lvl) {
         List<Subject> lvlList = DomainCtrl.getSubject(lvl);
        Iterator<Subject> it = lvlList.iterator();
        DefaultListModel<String> refs = new DefaultListModel<>();
        while(it.hasNext()) {
            refs.addElement(it.next().getName());
        }
        if(refs.size() == 0) refs.addElement("No hi ha cap assignatura al sistema");
        return refs;
    }

    public List<Subject> getSubjects(Level lvl) {
        return DomainCtrl.getSubject(lvl);
    }


    
    public void removeState() {
        DomainCtrl = new TimetableGenerator();
    }
       
    public StudyProgram addStudyProgram(String name) {
        return DomainCtrl.addStudyProgram(name);
    }
    
    public Level addLevel(int iden, StudyProgram sp){
        return DomainCtrl.addLevel(sp, iden);
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
    
    public int getnMaxStudentsGroup() {
        return DomainCtrl.getnMaxStudentsGroup();
    }
    
    public void fixTimetables(Level level) {
        DomainCtrl.fixTimetables(level);
    }
    
    public void generateGroups(Subject s, int enrolled, int dIni, int dEnd) {
        DomainCtrl.generateGroups(s, enrolled, dIni, dEnd);
    }

    public boolean addResClass(Classroom clas, int dIni, int dEnd, int hIni, int hEnd, String name) {
        return DomainCtrl.banSubject(clas,dIni, dEnd, hIni, hEnd, name);
    }
    public boolean addResClass(Classroom clas, int dIni, int dEnd, int hIni, int hEnd, int num) {
        return DomainCtrl.banGroup(clas, dIni, dEnd, hIni, hEnd, num);
    }

    public boolean subjectscontain(String name) {
        return DomainCtrl.containSubject(name);
    }

    public boolean addResClass(Classroom clas, int dIni, int dEnd, int hIni, int hEnd) {
        return DomainCtrl.ban(clas, dIni, dEnd, hIni, hEnd);
    }

    public boolean addGroupRes(Group group, int dIni, int dEnd, int hIni, int hEnd, String name) {
        return DomainCtrl.banClassroom(group, dIni, dEnd, hIni, hEnd, name);
    }

    public boolean classcontain(String name) {
        return DomainCtrl.containClass(name);
    }

    public boolean addGroupRes(Group group, int dIni, int dEnd, int hIni, int hEnd) {
        return DomainCtrl.ban(group, dIni, dEnd, hIni, hEnd);
    }

    public boolean addsubGroupRes(subGroup subgroup, int dIni, int dEnd, int hIni, int hEnd) {
        return DomainCtrl.ban(subgroup, dIni, dEnd, hIni, hEnd);
    }

    public boolean addsubGroupRes(subGroup subgroup, int dIni, int dEnd, int hIni, int hEnd, String name) {
        return DomainCtrl.banClassroom(subgroup, dIni, dEnd, hIni, hEnd, name);
    }

    public void removeRestriction(Classroom clas, int selectedIndex) {
        DomainCtrl.removeRestriction(clas, selectedIndex);
    }

    public void removeRestriction(Group g, int selectedIndex) {
        DomainCtrl.removeRestriction(g, selectedIndex);
    }

    public void activeRes(int i) {
        DomainCtrl.activeRes(i);
    }

    public void disactiveRes(int i) {
        DomainCtrl.disableRes(i);
    }
    
    public boolean rExtra(int id) {
        return DomainCtrl.rExtra(id);
    }
}
