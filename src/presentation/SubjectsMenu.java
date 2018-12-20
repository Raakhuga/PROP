/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Level;
import domain.Subject;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
/**
 *
 * @author adria
 */
public class SubjectsMenu extends javax.swing.JFrame {

    PresentationCtrl presentationctrl;
    Level lvl;
    /**
     * Creates new form SubjectsMenu
     */
    public SubjectsMenu(PresentationCtrl presentationctrl) {
        initComponents();
        this.presentationctrl = presentationctrl;
    }
    
    public void setLevel(Level lvl){
        this.lvl = lvl;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        addSubject = new javax.swing.JButton();
        modifySubject = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        SubjectsList = new javax.swing.JList<>();
        delete = new javax.swing.JButton();
        groups = new javax.swing.JButton();
        mainmenuButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        exit.setText("Tornar");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Assignatures"));

        addSubject.setText("Afegir");
        addSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSubjectActionPerformed(evt);
            }
        });

        modifySubject.setText("Modificar");
        modifySubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifySubjectActionPerformed(evt);
            }
        });

        SubjectsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(SubjectsList);

        delete.setText("Esborrar");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        groups.setText("Gestionar grups");
        groups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modifySubject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addSubject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(groups, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addSubject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modifySubject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(groups)
                .addContainerGap(26, Short.MAX_VALUE))
        );

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
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exit)
                    .addComponent(mainmenuButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSubjectActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromSMtoAS(lvl);
    }//GEN-LAST:event_addSubjectActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        presentationctrl.fixTimetables(lvl);
        presentationctrl.SwitchFromSMtoLM();
    }//GEN-LAST:event_exitActionPerformed

    private void modifySubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifySubjectActionPerformed
        // TODO add your handling code here:
        int index = SubjectsList.getSelectedIndex();
        List<Subject> subjects = presentationctrl.getSubjects(lvl);
        presentationctrl.SwitchFromSMtoMS(subjects.get(index));
    }//GEN-LAST:event_modifySubjectActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        SubjectsList.setModel(presentationctrl.getSubjectsName(lvl));
        jScrollPane2.setViewportView(SubjectsList);
    }//GEN-LAST:event_formWindowActivated

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int index = SubjectsList.getSelectedIndex();
        List<Subject> subjects = presentationctrl.getSubjects(lvl);
        presentationctrl.SwitchFromSMtoDS(lvl, subjects.get(index));
    }//GEN-LAST:event_deleteActionPerformed

    private void groupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupsActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_groupsActionPerformed

    private void mainmenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainmenuButtonActionPerformed
        // TODO add your handling code here:
        presentationctrl.fixTimetables(lvl);
        presentationctrl.SwitchFromSjMtoMM();
    }//GEN-LAST:event_mainmenuButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> SubjectsList;
    private javax.swing.JButton addSubject;
    private javax.swing.JButton delete;
    private javax.swing.JButton exit;
    private javax.swing.JButton groups;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton mainmenuButton;
    private javax.swing.JButton modifySubject;
    // End of variables declaration//GEN-END:variables
}
