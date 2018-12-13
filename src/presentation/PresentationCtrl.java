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

public class PresentationCtrl {
    private TimetableGenerator DomainCtrl;
    Dimension dim;
    
    //frames
    private MainMenu mainmenu = null;
    private StateGen stategen = null;
    private AddClassroom addclassroom = null;
    private ModifyClassroom modifyclassroom = null;
    
    public PresentationCtrl(){
        DomainCtrl = new TimetableGenerator();
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainmenu = new MainMenu(this);
        centerFrame(mainmenu);
        mainmenu.setVisible(true);
    }
    
    private void centerFrame(JFrame aux) {
        aux.setLocation(dim.width/2-aux.getSize().width/2, dim.height/2-aux.getSize().height/2);
    }
    //sync
    public void SwitchFromMMtoSG(){
        if(stategen == null)
            stategen = new StateGen(this);
        mainmenu.setVisible(false);
        mainmenu.setEnabled(false);
        stategen.setEnabled(true);
        centerFrame(stategen);
        stategen.setVisible(true);
    }
    
    public void SwitchFromSGtoMM(){
        stategen.setVisible(false);
        stategen.setEnabled(false);
        mainmenu.setEnabled(true);
        centerFrame(mainmenu);
        mainmenu.setVisible(true);
    }
    
    public void SwitchFromSGtoAC(){
        if(addclassroom == null)
            addclassroom = new AddClassroom(this);
        stategen.setEnabled(false);
        addclassroom.setEnabled(true);
        centerFrame(addclassroom);
        addclassroom.setVisible(true);
    }
    
    public void SwitchFromACtoSG(){
        addclassroom.setVisible(false);
        addclassroom.setEnabled(false);
        stategen.setEnabled(true);
        centerFrame(stategen);
        stategen.setVisible(true);
    }
    
    public void SwitchFromSGtoMC(Classroom classroom){
        if(modifyclassroom == null)
            modifyclassroom = new ModifyClassroom(this);
        modifyclassroom.setClassroom(classroom);
        stategen.setEnabled(false);
        modifyclassroom.setEnabled(true);
        centerFrame(modifyclassroom);
        modifyclassroom.setVisible(true);
    }
    
    public void SwitchFromMCtoSG(){
        modifyclassroom.setVisible(false);
        modifyclassroom.setEnabled(false);
        stategen.setEnabled(true);
        centerFrame(stategen);
        stategen.setVisible(true);
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
    
    public List<StudyProgram> getPrograms() {
        return DomainCtrl.getPrograms();
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
}
