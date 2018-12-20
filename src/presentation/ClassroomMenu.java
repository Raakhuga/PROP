/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Classroom;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author raakhuga
 */
public class ClassroomMenu extends javax.swing.JFrame {
    
    PresentationCtrl presentationctrl;
    
    /**
     * Creates new form StateGen
     */
    public ClassroomMenu(PresentationCtrl presentationctrl) {
        initComponents();
        this.presentationctrl = presentationctrl;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        AddClassroom = new javax.swing.JButton();
        ModifyClassroom = new javax.swing.JButton();
        DeleteClassroom = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ClassroomsList = new javax.swing.JList<>();
        mainmenuButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Aules"));

        AddClassroom.setText("Afegir");
        AddClassroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClassroomActionPerformed(evt);
            }
        });

        ModifyClassroom.setText("Modificar");
        ModifyClassroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyClassroomActionPerformed(evt);
            }
        });

        DeleteClassroom.setText("Esborrar");
        DeleteClassroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteClassroomActionPerformed(evt);
            }
        });

        ClassroomsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ClassroomsList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddClassroom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ModifyClassroom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteClassroom, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AddClassroom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ModifyClassroom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteClassroom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainmenuButton.setText("Menú Principal");
        mainmenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainmenuButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Tornar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainmenuButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(mainmenuButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddClassroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClassroomActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromCMtoAC();
    }//GEN-LAST:event_AddClassroomActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        ClassroomsList.setModel(presentationctrl.getClassroomsRefs());
        jScrollPane1.setViewportView(ClassroomsList);
    }//GEN-LAST:event_formWindowActivated

    private void ModifyClassroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyClassroomActionPerformed
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
                presentationctrl.SwitchFromCMtoMC(classrooms.get(index));
            }
        }
    }//GEN-LAST:event_ModifyClassroomActionPerformed

    private void DeleteClassroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteClassroomActionPerformed
        // TODO add your handling code here:
        if(ClassroomsList.isSelectionEmpty())
            JOptionPane.showMessageDialog(this, "Seleccioni una aula.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else {
            int index = ClassroomsList.getSelectedIndex();
            if (ClassroomsList.getSelectedValue().equals("No hi ha cap aula al sistema")) {
                JOptionPane.showMessageDialog(this, "Afegeixi una aula.", "Atenció:", JOptionPane.WARNING_MESSAGE);
            }
            else {
                presentationctrl.removeClassroom(index);
                ClassroomsList.setModel(presentationctrl.getClassroomsRefs());
                jScrollPane1.setViewportView(ClassroomsList);
            }
        }
    }//GEN-LAST:event_DeleteClassroomActionPerformed

    private void mainmenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainmenuButtonActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromCMtoMM();
    }//GEN-LAST:event_mainmenuButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromCMtoSM();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClassroom;
    private javax.swing.JList<String> ClassroomsList;
    private javax.swing.JButton DeleteClassroom;
    private javax.swing.JButton ModifyClassroom;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mainmenuButton;
    // End of variables declaration//GEN-END:variables
}
