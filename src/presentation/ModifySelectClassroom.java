/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Classroom;
import domain.GroupSubject;
import java.util.List;
import javax.swing.JOptionPane;

public class ModifySelectClassroom extends javax.swing.JFrame {
    private PresentationCtrl presentationctrl;
    private GroupSubject GS;
    private int dorig;
    private int horig;
    private Classroom corig;

    public ModifySelectClassroom(PresentationCtrl presentationctrl) {
        initComponents();
        this.presentationctrl = presentationctrl;
    }
    
    public void setGroupSubject(GroupSubject GS) {
        this.GS = GS;
    }
    
    public void setDorig(int dorig) {
        this.dorig = dorig;
    }
    
    public void setHorig(int horig) {
        this.horig = horig;
    }
    
    public void setCorig(Classroom corig) {
        this.corig = corig;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectClassroomLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ClassroomsList = new javax.swing.JList<>();
        backButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        selectClassroomLabel.setText("Seleccioneu l'aula amb la que es desitja intercambiar");

        jScrollPane1.setViewportView(ClassroomsList);

        backButton.setText("Tornar");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        acceptButton.setText("Seleccionar");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("la hora escollida:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(selectClassroomLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(backButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(acceptButton))
                        .addComponent(jScrollPane1))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectClassroomLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(acceptButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        ClassroomsList.setModel(presentationctrl.getClassroomsRefsType());
    }//GEN-LAST:event_formWindowActivated

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        // TODO add your handling code here:
        if(ClassroomsList.isSelectionEmpty())
            JOptionPane.showMessageDialog(this, "Seleccioni una aula.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else {
            int index = ClassroomsList.getSelectedIndex();
            if (ClassroomsList.getSelectedValue().equals("No hi ha cap aula al sistema")) {
                JOptionPane.showMessageDialog(this, "Afegeixi una aula.", "Atenció:", JOptionPane.WARNING_MESSAGE);
            }
            else {
                List<Classroom> classrooms = presentationctrl.getClassrooms();
                presentationctrl.SwitchFromMSCtoMCT(classrooms.get(index), corig, GS, dorig, horig);
            }
        }
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromMSCtoMCT(corig);
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ClassroomsList;
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel selectClassroomLabel;
    // End of variables declaration//GEN-END:variables
}
