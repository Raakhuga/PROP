/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Group;
import domain.ClassSubject;
import domain.subGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author raakhuga
 */
public class GroupTimetable extends javax.swing.JFrame {
    private PresentationCtrl presentationctrl;
    private Group act;
    
    private JButton backButton;
    /**
     * Creates new form GroupTimetable
     */
    public GroupTimetable(PresentationCtrl presentationctrl) {
        initComponents();
        this.presentationctrl = presentationctrl;
    }
    
    public void setGroup(Group group) {
        this.act = group;
    }
    
    private void generateButtons(){
        for(int i = act.gethIni()-1; i < act.gethEnd(); i++) {
            for(int j = act.getdIni()-1; j <= act.getdEnd(); j++) {
                String cont = "";
                if (i == act.gethIni() -1){
                    if (j != act.getdIni() -1) {
                        JLabel Lact = null;
                        switch (j) {
                            case 0:
                                Lact = new JLabel("Dilluns");
                                break;
                            case 1:
                                Lact = new JLabel("Dimarts");
                                break;
                            case 2:
                                Lact = new JLabel("Dimecres");
                                break;
                            case 3:
                                Lact = new JLabel("Dijous");
                                break;
                            case 4:
                                Lact = new JLabel("Divendres");
                                break;
                            case 5:
                                Lact = new JLabel("Dissabte");
                                break;
                            case 6:
                                Lact = new JLabel("Diumenje");
                                break;
                            default:
                                break;
                        }
                        Lact.setSize(160,60);
                        Lact.setLocation(120+(j-act.getdIni())*160, 40);
                        Lact.setHorizontalAlignment(SwingConstants.CENTER);
                        getContentPane().add(Lact);
                    }
                }
                else if (j == act.getdIni() -1) {
                    String msg = "<html>" + i + ":00\\<br/>" + (i+1) + ":00</html>";
                    JLabel Lact = new JLabel(msg);
                    Lact.setSize(160,60);
                    Lact.setLocation(60, 80+(i-act.gethIni())*60);
                    Lact.setVerticalAlignment(SwingConstants.CENTER);
                    getContentPane().add(Lact);
                }
                else {
                    ClassSubject CSact = act.getTimetable().getClassSubject(j, i);
                    if(act.isSubGroup()) {
                        subGroup subact = (subGroup)act;
                        ClassSubject subCSact = subact.getSubTimetable().getClassSubject(j, i);
                        if(!CSact.isEmpty()) cont = "<html>Aula: " + CSact.getRefClassroom() + "<br/>Assignatura: " + CSact.getNameSubject()  + "<br/>" + subact.getSuperNum() + " " + CSact.getClassroom().getTimetable().getGroupSubject(j, i).getType() + "</html>";
                        else if (!subCSact.isEmpty()) cont = "<html>Aula: " + subCSact.getRefClassroom() + "<br/>Assignatura: " + subCSact.getNameSubject()  + "<br/>" + subact.getNum() + " " + subCSact.getClassroom().getTimetable().getGroupSubject(j, i).getType() + "</html>";
                        else cont = " ";
                    }
                    else {
                        if(CSact.isEmpty()) cont = " ";
                        else cont = "<html>Aula: " + CSact.getRefClassroom() + "<br/>Assignatura: " + CSact.getNameSubject()  + "<br/>" + CSact.getClassroom().getTimetable().getGroupSubject(j, i).getType() + "</html>";
                    }
                    JButton Bact = new JButton(cont);
                    Bact.setSize(160, 60);
                    Bact.setLocation(120+(j-act.getdIni())*160, 80+(i-act.gethIni())*60);
                    if(!Bact.getText().equals(" ")) Bact.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            presentationctrl.SwitchFromGTTtoCTT(CSact.getClassroom());
                        }
                    });
                    else {
                        if (act.getTimetable().isBanned(j, i)) Bact.setBackground(Color.RED);
                        else Bact.setBackground(Color.GRAY);
                        Bact.setForeground(Color.RED);
                    }
                    getContentPane().add(Bact);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        presentationctrl.SwitchFromGTTtoCTT();
    }
    
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        JLabel Title = new JLabel("Grup: " + act.getNum());
        Title.setSize(200, 20);
        Title.setLocation(20, 20);
        getContentPane().add(Title);
        generateButtons();
        this.setSize(400+(act.getdEnd())*160, 240+(act.gethEnd()-act.gethIni())*60);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        backButton = new JButton("Tornar");
        backButton.setSize(120, 40);
        backButton.setLocation((400+(act.getdEnd())*160) - 240, (240+(act.gethEnd()-act.gethIni())*60) - 120);
        getContentPane().add(backButton);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
    }//GEN-LAST:event_formWindowActivated

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
