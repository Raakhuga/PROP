package presentation;

import domain.Classroom;
import domain.Group;
import domain.GroupSubject;
import domain.Level;
import domain.StudyProgram;
import domain.Subject;
import domain.TimetableGenerator;
import domain.subGroup;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.ListModel;
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
    private GroupMenu groupmenu = null;
    private SelectClassroom selectclassroom = null;
    private ClassroomTimetable classroomtimetable = null;
    private GroupSubjectInfo groupsubjectinfo = null;
    private ModifyGroup modifygroup = null;
    private AddGroup addgroup = null;
    private SubGroupMenu subgroupmenu = null;
    private ModifysubGroup modifysubgroup = null;
    private AddsubGroup addsubgroup = null;
    private RestrictionMenu restrictionmenu = null;
    private AddClassroomResMenu addcRmenu = null;
    
    
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
    
    public void SwitchFromMMtoRM() {
        if(restrictionmenu == null)
            restrictionmenu = new RestrictionMenu(this);
        mainmenu.setVisible(false);
        mainmenu.setEnabled(false);
        restrictionmenu.setEnabled(true);
        centerFrame(restrictionmenu);
        restrictionmenu.setVisible(true);
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
    
    public void SwitchFromMCtoCM(){
        modifyclassroom.setVisible(false);
        modifyclassroom.setEnabled(false);
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
    
    //Group Switches
     public void SwitchFromMGtoGM() {
        modifygroup.setVisible(false);
        modifygroup.setEnabled(false);
        groupmenu.setEnabled(true);
        centerFrame(groupmenu);
        groupmenu.setVisible(true);
    }
    public void SwitchFromGMtosGM(Group g) {
        if (subgroupmenu == null)
            subgroupmenu = new SubGroupMenu(g, this);
        groupmenu.setEnabled(false);
        groupmenu.setVisible(false);
        subgroupmenu.setEnabled(true);
        centerFrame(subgroupmenu);
        subgroupmenu.setVisible(true);
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
            addgroup = new AddGroup(this, sub);
        groupmenu.setEnabled(false);
        groupmenu.setVisible(false);
        addgroup.setEnabled(true);
        centerFrame(addgroup);
        addgroup.setVisible(true);
    }
    
    public void SwitchFromAGtoGM() {
        addgroup.setVisible(false);
        addgroup.setEnabled(false);
        groupmenu.setEnabled(true);
        centerFrame(groupmenu);
        groupmenu.setVisible(true);
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
    }
    //end of restriccions switches
    
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
    
    public void SwitchFromCTTtoGSI(GroupSubject groupsubject){
        groupsubjectinfo = new GroupSubjectInfo(this);
        groupsubjectinfo.setGroupSubject(groupsubject);
        classroomtimetable.setEnabled(false);
        classroomtimetable.setVisible(false);
        groupsubjectinfo.setEnabled(true);
        centerFrame(groupsubjectinfo);
        groupsubjectinfo.setVisible(true);
    }
    
    public void SwitchFromGSItoCTT(){
        groupsubjectinfo.setEnabled(false);
        groupsubjectinfo.setVisible(false);
        classroomtimetable.setEnabled(true);
        centerFrame(classroomtimetable);
        classroomtimetable.setVisible(true);
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
    
    public DefaultListModel<String> getGroupsRefs(Subject sub) {
      List<Group> groupList = DomainCtrl.getGroupsRefs(sub);
      Iterator<Group> Git = groupList.iterator();
      DefaultListModel<String> refs = new DefaultListModel<>();
      while(Git.hasNext()) {
          refs.addElement(Integer.toString(Git.next().getNum()));
      }
      if(refs.size() == 0) refs.addElement("No hi ha cap grup al sistema");
      return refs;
    }
     public DefaultListModel<String> getsubGroupsRefs(Group g) {
      List<subGroup> subgroupList = DomainCtrl.getsubGroup(g);
      Iterator<subGroup> it = subgroupList.iterator();
      DefaultListModel<String> refs = new DefaultListModel<>();
      while(it.hasNext()) {
          refs.addElement(Integer.toString(it.next().getNum()));
      }
      if(refs.size() == 0) refs.addElement("No hi ha cap subgrup al sistema");
      return refs;
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
    
    public void addGroup(Subject sub, int num, int dIni, int dEnd, int hIni, int hEnd, int enrolled) {
        DomainCtrl.addGroup(sub, dIni, dEnd, hIni, hEnd, num, enrolled);
    }
    
   public void addsubGroup(Group g, int num, int enrolled) {
        DomainCtrl.addSubGroup(g, num, enrolled);
    }
    
    public void removeClassroom(int id) {
        DomainCtrl.removeClassroom(id);
    }
    
    public void removeGroup(int id, Subject sub) {
        DomainCtrl.removeGroup(id, sub);
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

    public List<Group> getGroup(Subject mSub) {
        return DomainCtrl.getGroups(mSub);
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

    public void removeSubGroup(int index, Group g) {
        DomainCtrl.removeSubGroup(index, g);
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
      if(refs.size() == 0) refs.addElement("No hi ha cap restriccions al sistema");
      return refs;
    }
    
    public DefaultListModel<String> getRestrictions(Group g) {
      List<String> resList = DomainCtrl.getRestrictions(g);
      Iterator<String> it = resList.iterator();
      DefaultListModel<String> refs = new DefaultListModel<>();
      while(it.hasNext()) {
          refs.addElement(it.next());
      }
      if(refs.size() == 0) refs.addElement("No hi ha cap restriccions al sistema");
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


}
