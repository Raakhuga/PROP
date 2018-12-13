package presentation;

import domain.TimetableGenerator;

public class PresentationCtrl {
    private TimetableGenerator DomainCtrl;
    
    //frames
    private MainMenu mainmenu = null;
    private StateGen stategen = null;
    private SubjectsMenu subjmenu = null;
    private AddSubject addsubj = null;
    private ModifySubject modsubj = null;
    private EraseSubject erasesubj = null;
    
    public PresentationCtrl(){
        DomainCtrl = new TimetableGenerator();
        mainmenu = new MainMenu(this);
        mainmenu.setVisible(true);
        subjmenu = new SubjectsMenu(this);
        subjmenu.setVisible(true);
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
    
    // Subjects Menu to Add Subject
    public void SwitchFromSMtoAS(){
        if(addsubj == null)
            addsubj = new AddSubject(this);
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
    
    // Subjects Menu to Erase Subject
    public void SwitchFromSMtoES(){
        if(erasesubj == null)
            erasesubj = new EraseSubject(this);
        subjmenu.setVisible(false);
        subjmenu.setEnabled(false);
        erasesubj.setEnabled(true);
        erasesubj.setVisible(true);
    }
    
    public void SwitchFromEStoSM(){
        erasesubj.setVisible(false);
        erasesubj.setEnabled(false);
        subjmenu.setEnabled(true);
        subjmenu.setVisible(true);
    }
    
    //domain methods
    public void setnMaxStudentsGroup(int nMaxStudentsGroup) {
        DomainCtrl.setnMaxStudentsGroup(nMaxStudentsGroup);
    }
    
    public void setnMaxStudentsSubgroup(int nMaxStudentsSubgroup) {
        DomainCtrl.setnMaxStudentsSubgroup(nMaxStudentsSubgroup);
    }
}
