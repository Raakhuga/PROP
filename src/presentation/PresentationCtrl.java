package presentation;

import domain.Classroom;
import domain.StudyProgram;
import domain.TimetableGenerator;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import persistance.PersistanceCtrl;

public class PresentationCtrl {
    private TimetableGenerator DomainCtrl;
    private PersistanceCtrl persistancectrl;
    Dimension dim;
    
    //frames
    private MainMenu mainmenu = null;
    private ClassroomMenu classroommenu = null;
    private AddClassroom addclassroom = null;
    private ModifyClassroom modifyclassroom = null;
    private SaveLoadMenu saveloadmenu = null;
    private SelectClassroom selectclassroom = null;
    private ClassroomTimetable classroomtimetable = null;
    
    
    public PresentationCtrl(){
        DomainCtrl = new TimetableGenerator();
        TimetableGenerator aux = new TimetableGenerator();
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainmenu = new MainMenu(this);
        centerFrame(mainmenu);
        mainmenu.setVisible(true);
    }
    
    private void centerFrame(JFrame aux) {
        aux.setLocation(dim.width/2-aux.getSize().width/2, dim.height/2-aux.getSize().height/2);
    }
    //sync
    public void SwitchFromMMtoCM(){
        if(classroommenu == null)
            classroommenu = new ClassroomMenu(this);
        mainmenu.setVisible(false);
        mainmenu.setEnabled(false);
        classroommenu.setEnabled(true);
        centerFrame(classroommenu);
        classroommenu.setVisible(true);
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
        centerFrame(classroomtimetable);
        classroomtimetable.setVisible(true);
    }
    
    public void SwitchFromCTTtoSC(){
        classroomtimetable.setEnabled(false);
        classroomtimetable.setVisible(false);
        selectclassroom.setEnabled(true);
        centerFrame(selectclassroom);
        selectclassroom.setVisible(true);
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
    
    //domain methods
    public void generate() {
        DomainCtrl.generateAllGS();
        DomainCtrl.generateTimetable();
    }
    
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
    
    public void load(String path) {
        //DomainCtrl.loadState(path);
        DomainCtrl.loadState(path);
    }
    
    public void save(String path) {
        DomainCtrl.saveState(path);
    }
}
