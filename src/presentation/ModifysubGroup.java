/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.subGroup;
import javax.swing.JOptionPane;

public class ModifysubGroup extends javax.swing.JFrame {
    private PresentationCtrl presentationctrl;
    private subGroup subG;

    public ModifysubGroup(PresentationCtrl pre) {
        initComponents();
        presentationctrl = pre;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Enrolled = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        subGroupNum = new javax.swing.JTextField();
        modifyBottom = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar subgrup"));

        jLabel2.setText("Numero de inscrits en el subgrup:");

        Enrolled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnrolledActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero del subgrup:");

        subGroupNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subGroupNumActionPerformed(evt);
            }
        });

        modifyBottom.setText("Modificar");
        modifyBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBottomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Enrolled)
                    .addComponent(subGroupNum)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(modifyBottom)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subGroupNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Enrolled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modifyBottom)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        backButton.setText("Tornar");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backButton)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modifyBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBottomActionPerformed
        // TODO add your handling code here:
        String enrolled = Enrolled.getText();
        String num = subGroupNum.getText();
        if(enrolled.equals("") || num.equals("")) 
            JOptionPane.showMessageDialog(this, "S'han domplir tots els camps.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else if(!presentationctrl.isInt(enrolled)) 
            JOptionPane.showMessageDialog(this, "El número d'inscrits ha de ser un valor numèric.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else if(!presentationctrl.isInt(num)) 
            JOptionPane.showMessageDialog(this, "El número del subgrup ha de ser un valor numèric.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else {
            presentationctrl.setEnrolled(subG, Integer.parseInt(enrolled));
            presentationctrl.setNum(subG, Integer.parseInt(num));
            presentationctrl.SwitchFromMsGtosGM();
        }
    }//GEN-LAST:event_modifyBottomActionPerformed

    private void EnrolledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnrolledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnrolledActionPerformed

    private void subGroupNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subGroupNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subGroupNumActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromMsGtosGM();
    }//GEN-LAST:event_backButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        Enrolled.setText(subG.getEnrolled()+"");
        subGroupNum.setText(subG.getNum()+"");
    }//GEN-LAST:event_formWindowActivated

    public void setsubGroup(subGroup sG) {
        subG = sG;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Enrolled;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton modifyBottom;
    private javax.swing.JTextField subGroupNum;
    // End of variables declaration//GEN-END:variables
}
