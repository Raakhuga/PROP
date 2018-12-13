package presentation;

import domain.Classroom;
import domain.StudyProgram;
import domain.TimetableGenerator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;

public class PresentationCtrl {
    private TimetableGenerator DomainCtrl;
    
    //frames
    private MainMenu mainmenu = null;
    private StateGen stategen = null;
    private AddClassroom addclassroom = null;
    
    public PresentationCtrl(){
        DomainCtrl = new TimetableGenerator();
        mainmenu = new MainMenu(this);
        mainmenu.setVisible(true);
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
        stategen.setVisible(false);
        stategen.setEnabled(false);
        mainmenu.setEnabled(true);
        mainmenu.setVisible(true);
    }
    
    public void SwitchFromSGtoAC(){
        if(addclassroom == null)
            addclassroom = new AddClassroom(this);
        stategen.setEnabled(false);
        addclassroom.setEnabled(true);
        addclassroom.setVisible(true);
    }
    
    public void SwitchFromACtoSG(){
        addclassroom.setVisible(false);
        addclassroom.setEnabled(false);
        stategen.setEnabled(true);
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
}
