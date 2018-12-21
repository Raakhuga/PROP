/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Classroom;
import domain.GroupSubject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class ClassroomTimetable extends javax.swing.JFrame {
    private PresentationCtrl presentationctrl;
    private Classroom act = null;
    private List< List<JButton> > buttons;
    private JButton backButton;
    private JButton modifyButton;
    
    public ClassroomTimetable(PresentationCtrl presentationctrl) {
        initComponents();
        buttons = new ArrayList<>();
        this.presentationctrl = presentationctrl;
    }
    
    public void setClassroom(Classroom classroom) {
        this.act = classroom;
    }

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
            .addGap(0, 284, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                    GroupSubject GSact = act.getTimetable().getGroupSubject(j, i);
                    if(GSact.isEmpty()) cont = "";
                    else cont = "<html>" + GSact.getNameSubject() + "<br/>Grup: " + GSact.getNumGroup() + "<br/>" + GSact.getType() + "</html>";
                    JButton Bact = new JButton(cont);
                    Bact.setSize(160, 60);
                    Bact.setLocation(120+(j-act.getdIni())*160, 80+(i-act.gethIni())*60);
                    if(!Bact.getText().equals(""))  {
                        Bact.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                presentationctrl.SwitchFromCTTtoGTT(GSact.getGroup());
                            }
                        });
                        Bact.setBackground(Color.WHITE);
                    }
                    else {
                        if (act.getTimetable().isBanned(j, i)) Bact.setBackground(Color.RED);
                        else Bact.setBackground(Color.GRAY);
                        Bact.setForeground(Color.RED);
                        Bact.setEnabled(false);
                    }
                    getContentPane().add(Bact);
                }
            }
        }
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        presentationctrl.SwitchFromCTTtoSC();
    }
    
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        JLabel Title = new JLabel("Aula: " + act.getRef());
        Title.setSize(200, 20);
        Title.setLocation(20, 20);
        getContentPane().add(Title);
        generateButtons();
        this.setSize(400+(act.getdEnd())*160, 240+(act.gethEnd()-act.gethIni())*60);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        backButton = new JButton("Tornar");
        modifyButton = new JButton("Modificar");
        backButton.setSize(120, 40);
        modifyButton.setSize(120, 40);
        backButton.setLocation((400+(act.getdEnd())*160) - 240, (240+(act.gethEnd()-act.gethIni())*60) - 120);
        modifyButton.setLocation(((act.getdEnd())*160), (240+(act.gethEnd()-act.gethIni())*60) - 120);
        getContentPane().add(backButton);
        getContentPane().add(modifyButton);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presentationctrl.SwitchFromCTTtoMCT(act);
            }
        });
    }//GEN-LAST:event_formWindowActivated

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
