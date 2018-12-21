/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Group;
import domain.Level;
import domain.Subject;
import java.util.List;
import javax.swing.JOptionPane;


public class GroupMenu extends javax.swing.JFrame {
    private Subject mSub;
    private Level lvl;
    private PresentationCtrl presentationctrl;

    public GroupMenu(PresentationCtrl presentationctrl) {
        initComponents();
        this.presentationctrl = presentationctrl;
    }
    
    public void setSubj(Subject s){
        this.mSub = s;
    }
    
    public void setLevel(Level lvl) {
        this.lvl = lvl;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        modifybottom = new javax.swing.JButton();
        DeleteBottom = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        GroupList = new javax.swing.JList<>();
        detall = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        mainMenuButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Grups"));

        jButton2.setText("Afegir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClassroomActionPerformed(evt);
            }
        });

        modifybottom.setText("Modificar");
        modifybottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifybottomActionPerformed(evt);
            }
        });

        DeleteBottom.setText("Esborrar");
        DeleteBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBottomActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(GroupList);

        detall.setText("Gestionar subgrups");
        detall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detallActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modifybottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(detall, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modifybottom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteBottom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detall))
        );

        backButton.setText("Tornar");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        mainMenuButton.setText("Menú Principal");
        mainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainMenuButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(mainMenuButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBottomActionPerformed
        // TODO add your handling code here:
        if(GroupList.isSelectionEmpty())
            JOptionPane.showMessageDialog(this, "Seleccioni un grup.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else {
            int index = GroupList.getSelectedIndex();
            if (GroupList.getSelectedValue().equals("No hi ha cap grup al sistema")) {
                JOptionPane.showMessageDialog(this, "Afegeixi un grup.", "Atenció:", JOptionPane.WARNING_MESSAGE);
            }
            else {
                presentationctrl.SwitchFromGMtoDG(index, mSub);
            }
        }
    }//GEN-LAST:event_DeleteBottomActionPerformed

    private void modifybottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifybottomActionPerformed
        // TODO add your handling code here:
        if(GroupList.isSelectionEmpty())
            JOptionPane.showMessageDialog(this, "Seleccioni un grup.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else {
            int index = GroupList.getSelectedIndex();
            if (GroupList.getSelectedValue().equals("No hi ha cap grup al sistema")) {
                JOptionPane.showMessageDialog(this, "Afegeixi un grup.", "Atenció:", JOptionPane.WARNING_MESSAGE);
            }
            else {
                List<Group> groupList = presentationctrl.getGroup(mSub);
                presentationctrl.SwitchFromGMtoMG(groupList.get(index));
            }
        }
    }//GEN-LAST:event_modifybottomActionPerformed

    private void AddClassroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClassroomActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromGMtoAG(mSub);

    }//GEN-LAST:event_AddClassroomActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        GroupList.setModel(presentationctrl.getGroupsRefs(mSub));
        jScrollPane2.setViewportView(GroupList);       
    }//GEN-LAST:event_formWindowActivated

    private void detallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detallActionPerformed
        // TODO add your handling code here:
        if(GroupList.isSelectionEmpty())
            JOptionPane.showMessageDialog(this, "Seleccioni un grup.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else {
            int index = GroupList.getSelectedIndex();
            if (GroupList.getSelectedValue().equals("No hi ha cap grup al sistema")) {
                JOptionPane.showMessageDialog(this, "Afegeixi un grup.", "Atenció:", JOptionPane.WARNING_MESSAGE);
            }
            else {
            List<Group> groupList = presentationctrl.getGroup(mSub);
            presentationctrl.SwitchFromGMtosGM(groupList.get(index), lvl);
            }
        }
    }//GEN-LAST:event_detallActionPerformed

    private void mainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuButtonActionPerformed
        // TODO add your handling code here:
        presentationctrl.fixTimetables(lvl);
        presentationctrl.SwitchFromGMtoMM();
    }//GEN-LAST:event_mainMenuButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromGMtoSM();
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteBottom;
    private javax.swing.JList<String> GroupList;
    private javax.swing.JButton backButton;
    private javax.swing.JButton detall;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton mainMenuButton;
    private javax.swing.JButton modifybottom;
    // End of variables declaration//GEN-END:variables
}
