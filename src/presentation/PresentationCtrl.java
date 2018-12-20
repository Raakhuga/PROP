package presentation;

import domain.Classroom;
import domain.Group;
import domain.GroupSubject;
import domain.StudyProgram;
import domain.TimetableGenerator;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import persistance.PersistanceCtrl;
import domain.Level;
import domain.Subject;
import domain.StudyProgram;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;

public class PresentationCtrl {
    private TimetableGenerator DomainCtrl;
    private PersistanceCtrl persistancectrl;
    Dimension dim;
    private boolean first;
    
    /** FRAMES **/
    private MainMenu mainmenu = null;
    private ClassroomMenu classroommenu = null;
    private AddClassroom addclassroom = null;
    private ModifyClassroom modifyclassroom = null;
    private SaveLoadMenu saveloadmenu = null;
    private SelectClassroom selectclassroom = null;
    private ClassroomTimetable classroomtimetable = null;
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
    
    
    public PresentationCtrl(){
        DomainCtrl = new TimetableGenerator();
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        first = true;
        mainmenu = new MainMenu(this);
        centerFrame(mainmenu);
        mainmenu.setVisible(true);
        /*spmenu = new StudyProgramMenu(this);
        spmenu.setVisible(true);*/
    }
    
    private void centerFrame(JFrame aux) {
        aux.setLocation(dim.width/2-aux.getSize().width/2, dim.height/2-aux.getSize().height/2);
    }
    //sync
    /*
    public void SwitchFromMMtoCM(){
        if(classroommenu == null)
            classroommenu = new ClassroomMenu(this);
    }*/
    /** SYNCRONIZATION **/
    // Main menu to State generator
    /*
    public void SwitchFromMMtoSG(){
        if(stategen == null)
            stategen = new StateGen(this);
        mainmenu.setVisible(false);
        mainmenu.setEnabled(false);
        classroommenu.setEnabled(true);
        centerFrame(classroommenu);
        classroommenu.setVisible(true);
    }*/
    
    public void SwitchFromMMtoSLM(){
        if(saveloadmenu == null)
            saveloadmenu = new SaveLoadMenu(this);
        mainmenu.setVisible(false);
        mainmenu.setEnabled(false);
        saveloadmenu.setEnabled(true);
        centerFrame(saveloadmenu);
        saveloadmenu.setVisible(true);
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
    
    public void SwitchFromSLMtoMM(){
        saveloadmenu.setVisible(false);
        saveloadmenu.setEnabled(false);
        mainmenu.setEnabled(true);
        centerFrame(mainmenu);
        mainmenu.setVisible(true);
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
    
    public void SwitchFromCMtoAC(){
        if(addclassroom == null)
            addclassroom = new AddClassroom(this);
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
    
    public void SwitchFromCMtoMC(Classroom classroom){
        if(modifyclassroom == null)
            modifyclassroom = new ModifyClassroom(this);
        modifyclassroom.setClassroom(classroom);
        classroommenu.setEnabled(false);
        modifyclassroom.setEnabled(true);
        centerFrame(modifyclassroom);
        modifyclassroom.setVisible(true);
    }
    
    public void SwitchFromMCtoCM(){
        modifyclassroom.setVisible(false);
        modifyclassroom.setEnabled(false);
        classroommenu.setEnabled(true);
        centerFrame(classroommenu);
        classroommenu.setVisible(true);
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
    
    public void SwitchFromCTTtoSC(){
        classroomtimetable.setEnabled(false);
        classroomtimetable.setVisible(false);
        selectclassroom.setEnabled(true);
        centerFrame(selectclassroom);
        selectclassroom.setVisible(true);
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
    public void SwitchFromSPMtoASP(){
        if(addsp == null)
            addsp = new AddStudyProgram(this);
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
    public void SwitchFromSPMtoMSP(StudyProgram sp){
        if(modsp == null)
            modsp = new ModifyStudyProgram(this);
        modsp.setStudyProgram(sp);
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
        centerFrame(spmenu);
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
    public void SwitchFromLMtoAL(StudyProgram sp){
        if(addlvl == null)
            addlvl = new AddLevel(this);
        addlvl.setStudyProgram(sp);
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
    public void SwitchFromLMtoML(Level lvl){
        if(modlvl == null)
            modlvl = new ModifyLevel(this);
        modlvl.setLevel(lvl);
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
    
    // Subject menu to Add Subject
    public void SwitchFromSMtoAS(Level lvl){
        if(addsubj == null)
            addsubj = new AddSubject(this);
        addsubj.setLevel(lvl);
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
    public void SwitchFromSMtoMS(Subject s){
        if(modsubj == null)
            modsubj = new ModifySubject(this);
        modsubj.setSubject(s);
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
    
    //presentation methods
    
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
    
    public void setFirst(boolean first) {
        this.first = first;
    }
    
    public boolean getFirst() {
        return first;
    }
    
    //domain methods
    public boolean generate() {
        this.save("./aux.state");
        DomainCtrl = new TimetableGenerator();
        this.load("./aux.state");
        DomainCtrl.generateAllGS();
        File file = new File("./aux.state");
        file.delete();
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
    
    public Classroom addClassroom(int capacity, String ref, int dIni, int dEnd, int hIni, int hEnd) {
        return DomainCtrl.addClassroom(capacity, ref, dIni, dEnd, hIni, hEnd);
    }
    
    public void removeClassroom(int id) {
        DomainCtrl.removeClassroom(id);
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
    
    public void removeState() {
        DomainCtrl = new TimetableGenerator();
    }
    
    public void load(String path) {
        //DomainCtrl.loadState(path);
        DomainCtrl.loadState(path);
        first = false;
    }
    
    public void save(String path) {
        DomainCtrl.saveState(path);
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
    
    public void fixTimetables(Level level) {
        DomainCtrl.fixTimetables(level);
    }
}
