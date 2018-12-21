/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.StudyProgram;
import java.util.List;
import javax.swing.JOptionPane;

public class StudyProgramMenu extends javax.swing.JFrame {

    PresentationCtrl presentationctrl;

    public StudyProgramMenu(PresentationCtrl presentationctrl) {
        initComponents();
        this.presentationctrl = presentationctrl;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StudyProgramsList = new javax.swing.JList<>();
        add = new javax.swing.JButton();
        modify = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        levels = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        mainmenuButton = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Plans d'estudi"));

        StudyProgramsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(StudyProgramsList);

        add.setText("Afegir");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        modify.setText("Modificar");
        modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyActionPerformed(evt);
            }
        });

        delete.setText("Esborrar");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        levels.setText("Gestionar nivells");
        levels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(modify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(levels))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(levels))
        );

        exit.setText("Tornar");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        mainmenuButton.setText("Menú Principal");
        mainmenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainmenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mainmenuButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exit)
                    .addComponent(mainmenuButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        StudyProgramsList.setModel(presentationctrl.getStudyProgramsName());
        jScrollPane1.setViewportView(StudyProgramsList);
    }//GEN-LAST:event_formWindowActivated

    private void levelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelsActionPerformed
        // TODO add your handling code here:
        if(StudyProgramsList.isSelectionEmpty())
            JOptionPane.showMessageDialog(this, "Seleccioni un pla d'estudis.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else {
            int index = StudyProgramsList.getSelectedIndex();
            if (StudyProgramsList.getSelectedValue().equals("No hi ha cap pla d'estudis al sistema")) {
                JOptionPane.showMessageDialog(this, "Afegeixi un pla d'estudis.", "Atenció:", JOptionPane.WARNING_MESSAGE);
            }
            else {
                List<StudyProgram> studyprograms = presentationctrl.getPrograms();
                presentationctrl.SwitchFromSPMtoLM(studyprograms.get(index));
            }
        }
    }//GEN-LAST:event_levelsActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromSPMtoSM();
    }//GEN-LAST:event_exitActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromSPMtoASP(presentationctrl.getProgramsNames());
    }//GEN-LAST:event_addActionPerformed

    private void modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyActionPerformed
        // TODO add your handling code here:
        if(StudyProgramsList.isSelectionEmpty())
            JOptionPane.showMessageDialog(this, "Seleccioni un pla d'estudis.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else {
            int index = StudyProgramsList.getSelectedIndex();
            if (StudyProgramsList.getSelectedValue().equals("No hi ha cap pla d'estudis al sistema")) {
                JOptionPane.showMessageDialog(this, "Afegeixi un pla d'estudis.", "Atenció:", JOptionPane.WARNING_MESSAGE);
            }
            else {
                List<StudyProgram> studyprograms = presentationctrl.getPrograms();
                presentationctrl.SwitchFromSPMtoMSP(studyprograms.get(index), presentationctrl.getProgramsNames());
            }
        }
    }//GEN-LAST:event_modifyActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        if(StudyProgramsList.isSelectionEmpty())
            JOptionPane.showMessageDialog(this, "Seleccioni un pla d'estudis.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else {
            int index = StudyProgramsList.getSelectedIndex();
            if (StudyProgramsList.getSelectedValue().equals("No hi ha cap pla d'estudis al sistema")) {
                JOptionPane.showMessageDialog(this, "Afegeixi un pla d'estudis.", "Atenció:", JOptionPane.WARNING_MESSAGE);
            }
            else {
                List<StudyProgram> studyprograms = presentationctrl.getPrograms();
                presentationctrl.SwitchFromSPMtoDSP(studyprograms.get(index));
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void mainmenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainmenuButtonActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromSPMtoMM();
    }//GEN-LAST:event_mainmenuButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> StudyProgramsList;
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JButton exit;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton levels;
    private javax.swing.JButton mainmenuButton;
    private javax.swing.JButton modify;
    // End of variables declaration//GEN-END:variables
}
