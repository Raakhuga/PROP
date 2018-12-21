/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.StudyProgram;
import domain.Level;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author adria
 */
public class LevelMenu extends javax.swing.JFrame {

    PresentationCtrl presentationctrl;
    StudyProgram act;
    /**
     * Creates new form LevelMenu
     */
    public LevelMenu(PresentationCtrl presentationctrl) {
        initComponents();
        this.presentationctrl = presentationctrl;
    }
    
    public void setStudyProgram(StudyProgram sp){
        this.act = sp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LevelsList = new javax.swing.JList<>();
        subjects = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        modify = new javax.swing.JButton();
        add = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        mainmenuButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nivells"));

        LevelsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(LevelsList);

        subjects.setText("Gestionar assignatures");
        subjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectsActionPerformed(evt);
            }
        });

        delete.setText("Esborrar");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        modify.setText("Modificar");
        modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyActionPerformed(evt);
            }
        });

        add.setText("Afegir");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subjects)
                .addGap(8, 8, 8))
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(mainmenuButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exit)
                    .addComponent(mainmenuButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromLMtoSPM();
    }//GEN-LAST:event_exitActionPerformed

    private void subjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectsActionPerformed
        // TODO add your handling code here:
        if(LevelsList.isSelectionEmpty())
            JOptionPane.showMessageDialog(this, "Seleccioni un nivell.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else {
            int index = LevelsList.getSelectedIndex();
            if (LevelsList.getSelectedValue().equals("No hi ha cap nivell al sistema en aquest pla d'estudis")) {
                JOptionPane.showMessageDialog(this, "Afegeixi un nivell.", "Atenció:", JOptionPane.WARNING_MESSAGE);
            }
            else {
                List<Level> levels = presentationctrl.getLevels(act);
                presentationctrl.SwitchFromLMtoSM(levels.get(index));
            }
        }
    }//GEN-LAST:event_subjectsActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromLMtoAL(act, presentationctrl.getLevelsIden(act));
    }//GEN-LAST:event_addActionPerformed

    private void modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyActionPerformed
        // TODO add your handling code here:
        if(LevelsList.isSelectionEmpty())
            JOptionPane.showMessageDialog(this, "Seleccioni un nivell.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else {
            int index = LevelsList.getSelectedIndex();
            if (LevelsList.getSelectedValue().equals("No hi ha cap nivell al sistema en aquest pla d'estudis")) {
                JOptionPane.showMessageDialog(this, "Afegeixi un nivell.", "Atenció:", JOptionPane.WARNING_MESSAGE);
            }
            else {
                List<Level> levels = presentationctrl.getLevels(act);
                presentationctrl.SwitchFromLMtoML(levels.get(index), presentationctrl.getLevelsIden(act));
            }
        }
    }//GEN-LAST:event_modifyActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        if(LevelsList.isSelectionEmpty())
            JOptionPane.showMessageDialog(this, "Seleccioni un nivell.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else {
            int index = LevelsList.getSelectedIndex();
            if (LevelsList.getSelectedValue().equals("No hi ha cap nivell al sistema en aquest pla d'estudis")) {
                JOptionPane.showMessageDialog(this, "Afegeixi un nivell.", "Atenció:", JOptionPane.WARNING_MESSAGE);
            }
            else {
                List<Level> levels = presentationctrl.getLevels(act);
                presentationctrl.SwitchFromLMtoDL(act, levels.get(index));
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        LevelsList.setModel(presentationctrl.getLevelsIden(act));
        jScrollPane1.setViewportView(LevelsList);
    }//GEN-LAST:event_formWindowActivated

    private void mainmenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainmenuButtonActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromLMtoMM();
    }//GEN-LAST:event_mainmenuButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> LevelsList;
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JButton exit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mainmenuButton;
    private javax.swing.JButton modify;
    private javax.swing.JButton subjects;
    // End of variables declaration//GEN-END:variables
}