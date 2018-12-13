/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Classroom;

/**
 *
 * @author Raakhuga
 */
public class ModifyClassroom extends javax.swing.JFrame {
    private PresentationCtrl presentationctrl;
    private Classroom act = null;
    /**
     * Creates new form AddClassroom
     */
    public ModifyClassroom(PresentationCtrl presentationctrl) {
        initComponents();
        this.presentationctrl = presentationctrl;
    }   
    
    public void setClassroom(Classroom classroom) {
        this.act = classroom;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CapacityLabel = new javax.swing.JLabel();
        capacityField = new javax.swing.JTextField();
        RefLabel = new javax.swing.JLabel();
        RefField = new javax.swing.JTextField();
        dIniLabel = new javax.swing.JLabel();
        dIniField = new javax.swing.JTextField();
        dEndLabel = new javax.swing.JLabel();
        dEndField = new javax.swing.JTextField();
        hIniLabel = new javax.swing.JLabel();
        hIniField = new javax.swing.JTextField();
        hEndLabel = new javax.swing.JLabel();
        hEndField = new javax.swing.JTextField();
        modifyClassroomButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar aula");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        CapacityLabel.setText("Nombre màxim d'estudiants que caben a l'aula:");
        CapacityLabel.setToolTipText("");

        RefLabel.setText("Nom de l'aula:");

        dIniLabel.setText("Primer día útil de l'aula:");

        dEndLabel.setText("Darrer día útil de l'aula:");

        dEndField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dEndFieldActionPerformed(evt);
            }
        });

        hIniLabel.setText("Primera hora útil de l'aula:");

        hIniField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hIniFieldActionPerformed(evt);
            }
        });

        hEndLabel.setText("Darrera hora útil de l'aula:");

        hEndField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hEndFieldActionPerformed(evt);
            }
        });

        modifyClassroomButton.setText("Modificar");
        modifyClassroomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyClassroomButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hEndLabel)
                    .addComponent(hIniLabel)
                    .addComponent(dEndLabel)
                    .addComponent(dIniLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(capacityField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(RefField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(RefLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(dIniField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dEndField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hIniField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(hEndField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modifyClassroomButton))
                        .addComponent(CapacityLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CapacityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(capacityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RefLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RefField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dIniLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dIniField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dEndLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dEndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hIniLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hIniField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hEndLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hEndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(modifyClassroomButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hIniFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hIniFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hIniFieldActionPerformed

    private void dEndFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dEndFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dEndFieldActionPerformed

    private void hEndFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hEndFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hEndFieldActionPerformed

    private void modifyClassroomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyClassroomButtonActionPerformed
        // TODO add your handling code here:
        int capacity = Integer.parseInt(capacityField.getText());
        String ref = RefField.getText();
        int dIni = Integer.parseInt(dIniField.getText());
        int dEnd = Integer.parseInt(dEndField.getText());
        int hIni = Integer.parseInt(hIniField.getText());
        int hEnd = Integer.parseInt(hEndField.getText());
        presentationctrl.setCapacity(act, capacity);
        presentationctrl.setRef(act, ref);
        presentationctrl.setdIni(act, dIni);
        presentationctrl.setdEnd(act, dEnd);
        presentationctrl.sethIni(act, hIni);
        presentationctrl.sethEnd(act, hEnd);
        presentationctrl.SwitchFromMCtoSG();
    }//GEN-LAST:event_modifyClassroomButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        int capacity = act.getCapacity();
        String ref = act.getRef();
        int dIni = act.getdIni();
        int dEnd = act.getdEnd();
        int hIni = act.gethIni();
        int hEnd = act.gethEnd();
        capacityField.setText(capacity+"");
        RefField.setText(ref);
        dIniField.setText(dIni+"");
        dEndField.setText(dEnd+"");
        hIniField.setText(hIni+"");
        hEndField.setText(hEnd+"");
    }//GEN-LAST:event_formWindowActivated

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CapacityLabel;
    private javax.swing.JTextField RefField;
    private javax.swing.JLabel RefLabel;
    private javax.swing.JTextField capacityField;
    private javax.swing.JTextField dEndField;
    private javax.swing.JLabel dEndLabel;
    private javax.swing.JTextField dIniField;
    private javax.swing.JLabel dIniLabel;
    private javax.swing.JTextField hEndField;
    private javax.swing.JLabel hEndLabel;
    private javax.swing.JTextField hIniField;
    private javax.swing.JLabel hIniLabel;
    private javax.swing.JButton modifyClassroomButton;
    // End of variables declaration//GEN-END:variables
}
