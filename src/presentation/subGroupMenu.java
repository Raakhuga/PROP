/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Group;
import domain.Level;
import domain.Subject;
import domain.subGroup;
import java.util.List;
import javax.swing.JOptionPane;


public class subGroupMenu extends javax.swing.JFrame {
    private PresentationCtrl presentationctrl;
    private Group g;
    private Level lvl;

    public subGroupMenu(PresentationCtrl presentationctrl) {
        initComponents();
        this.presentationctrl = presentationctrl;
    }
    
    public void setGroup(Group g) {
        this.g = g;
    }
    
    public void setLevel(Level lvl) {
        this.lvl = lvl;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        DeleteBottom = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        SubGroupList = new javax.swing.JList<>();
        AddBottom = new javax.swing.JButton();
        modifybottom = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        mainMenuButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Subgrups"));

        DeleteBottom.setText("Esborrar");
        DeleteBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBottomActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(SubGroupList);

        AddBottom.setText("Afegir");
        AddBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBottomActionPerformed(evt);
            }
        });

        modifybottom.setText("Modificar");
        modifybottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifybottomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(modifybottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeleteBottom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddBottom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modifybottom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteBottom))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainMenuButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainMenuButton)
                    .addComponent(backButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBottomActionPerformed
        // TODO add your handling code here:
        if(SubGroupList.isSelectionEmpty())
            JOptionPane.showMessageDialog(this, "Seleccioni un subgrup.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else {
            int index = SubGroupList.getSelectedIndex();
            if (SubGroupList.getSelectedValue().equals("No hi ha cap subgrup al sistema")) {
                JOptionPane.showMessageDialog(this, "Afegeixi un subgrup.", "Atenció:", JOptionPane.WARNING_MESSAGE);
            }
            else {
                presentationctrl.SwitchFromsGMtoDsG(index, g);
            }
        }
    }//GEN-LAST:event_DeleteBottomActionPerformed

    private void modifybottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifybottomActionPerformed
        // TODO add your handling code here:
        if(SubGroupList.isSelectionEmpty())
            JOptionPane.showMessageDialog(this, "Seleccioni un subgrup.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else {
            int index = SubGroupList.getSelectedIndex();
            if (SubGroupList.getSelectedValue().equals("No hi ha cap subgrup al sistema")) {
                JOptionPane.showMessageDialog(this, "Afegeixi un subgrup.", "Atenció:", JOptionPane.WARNING_MESSAGE);
            }
            else {
                List<subGroup> subGroupList = presentationctrl.getsubGroup(g);
                presentationctrl.SwitchFromssGMtoMsG(subGroupList.get(index));
            }
        }
    }//GEN-LAST:event_modifybottomActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        SubGroupList.setModel(presentationctrl.getsubGroupsRefs(g));
        jScrollPane2.setViewportView(SubGroupList);       
    }//GEN-LAST:event_formWindowActivated

    private void AddBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBottomActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromsGMtoAsG(g);

    }//GEN-LAST:event_AddBottomActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromsGMtoGM();
    }//GEN-LAST:event_backButtonActionPerformed

    private void mainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuButtonActionPerformed
        // TODO add your handling code here:
        presentationctrl.fixTimetables(lvl);
        presentationctrl.SwitchFromsGMtoMM();
    }//GEN-LAST:event_mainMenuButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBottom;
    private javax.swing.JButton DeleteBottom;
    private javax.swing.JList<String> SubGroupList;
    private javax.swing.JButton backButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton mainMenuButton;
    private javax.swing.JButton modifybottom;
    // End of variables declaration//GEN-END:variables
}
