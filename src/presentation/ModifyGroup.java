/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Group;
import javax.swing.JOptionPane;


public class ModifyGroup extends javax.swing.JFrame {
    private PresentationCtrl presentationctrl;
    private Group g = null;

    public ModifyGroup(PresentationCtrl presentationctrl) {
        initComponents();
        this.presentationctrl = presentationctrl;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modifyClassroomButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        hEndSlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        hIniHLabel = new javax.swing.JLabel();
        GroupNum = new javax.swing.JTextField();
        hEndHLabel = new javax.swing.JLabel();
        dIniLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dIniBox = new javax.swing.JComboBox<>();
        Enrolled = new javax.swing.JTextField();
        dEndLabel = new javax.swing.JLabel();
        dEndBox = new javax.swing.JComboBox<>();
        hIniLabel = new javax.swing.JLabel();
        hIniSlider = new javax.swing.JSlider();
        hEndLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        modifyClassroomButton.setText("Modificar");
        modifyClassroomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyClassroomButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar grup"));

        hEndSlider.setMaximum(23);
        hEndSlider.setValue(0);
        hEndSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hEndSliderStateChanged(evt);
            }
        });

        jLabel1.setText("Numero del grup:");

        hIniHLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hIniHLabel.setText("0");

        GroupNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GroupNumActionPerformed(evt);
            }
        });

        hEndHLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hEndHLabel.setText("0");
        hEndHLabel.setToolTipText("");

        dIniLabel.setText("Primer día útil de l'aula:");

        jLabel2.setText("Numero de inscrits en el grup:");

        dIniBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenje" }));

        Enrolled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnrolledActionPerformed(evt);
            }
        });

        dEndLabel.setText("Darrer día útil de l'aula:");

        dEndBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenje" }));
        dEndBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dEndBoxActionPerformed(evt);
            }
        });

        hIniLabel.setText("Primera hora útil de l'aula:");

        hIniSlider.setMaximum(23);
        hIniSlider.setValue(0);
        hIniSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hIniSliderStateChanged(evt);
            }
        });

        hEndLabel.setText("Darrera hora útil de l'aula:");
        hEndLabel.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hIniLabel)
                    .addComponent(dEndLabel)
                    .addComponent(dIniBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dEndBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(hEndSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(hIniSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(hEndLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hIniHLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hEndHLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Enrolled, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dIniLabel)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GroupNum, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GroupNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Enrolled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dIniLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dIniBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dEndLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dEndBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hIniLabel)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(hIniSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hEndLabel))
                    .addComponent(hIniHLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hEndSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hEndHLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(modifyClassroomButton)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modifyClassroomButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dEndBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dEndBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dEndBoxActionPerformed

    private void hIniSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hIniSliderStateChanged
        // TODO add your handling code here:
        hIniHLabel.setText(hIniSlider.getValue()+"");
    }//GEN-LAST:event_hIniSliderStateChanged

    private void hEndSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hEndSliderStateChanged
        // TODO add your handling code here:
        hEndHLabel.setText(hEndSlider.getValue()+"");
    }//GEN-LAST:event_hEndSliderStateChanged

    private void modifyClassroomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyClassroomButtonActionPerformed
        // TODO add your handling code here:
        String enrolled = Enrolled.getText();
        String num = GroupNum.getText();
        int dIni = dIniBox.getSelectedIndex();
        int dEnd = dEndBox.getSelectedIndex();
        int hIni = hIniSlider.getValue();
        int hEnd = hEndSlider.getValue();
        if (dIni > dEnd)
            JOptionPane.showMessageDialog(this, "El darrer día útil ha de\nser el mateix dia o \nposterior al inicial", "Atenció:", JOptionPane.WARNING_MESSAGE);
        if (hIni >= hEnd)
            JOptionPane.showMessageDialog(this, "La darrera hora útil ha de\nser posterior a la primera", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else if (enrolled.equals("") || num.equals(""))
            JOptionPane.showMessageDialog(this, "S'han d'omplir tots els camps.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else if (!presentationctrl.isInt(enrolled)) 
            JOptionPane.showMessageDialog(this, "El numero d'inscrits ha de ser un valor numèric.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else if (!presentationctrl.isInt(num))
            JOptionPane.showMessageDialog(this, "El numero de grup ha de ser un valor numèric.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else {
            presentationctrl.setEnrolled(g, Integer.parseInt(enrolled));
            presentationctrl.setNum(g, Integer.parseInt(num));
            presentationctrl.setdIni(g, dIni);
            presentationctrl.setdEnd(g, dEnd);
            presentationctrl.sethIni(g, hIni);
            presentationctrl.sethEnd(g, hEnd);
            presentationctrl.SwitchFromMGtoGM();
        }
    }//GEN-LAST:event_modifyClassroomButtonActionPerformed

    private void GroupNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GroupNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GroupNumActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        int enrolled = g.getEnrolled();
        int num = g.getNum();
        int dIni = g.getdIni();
        int dEnd = g.getdEnd();
        int hIni = g.gethIni();
        int hEnd = g.gethEnd();
        Enrolled.setText(Integer.toString(enrolled)+"");
        GroupNum.setText(Integer.toString(num)+"");
        dIniBox.setSelectedIndex(dIni);
        dEndBox.setSelectedIndex(dEnd);
        hIniSlider.setValue(hIni);
        hEndSlider.setValue(hEnd);
        hIniHLabel.setText(hIni+"");
        hEndHLabel.setText(hEnd+"");
    }//GEN-LAST:event_formWindowActivated

    private void EnrolledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnrolledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnrolledActionPerformed

    public void setGroup(Group g) {
        this.g = g;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Enrolled;
    private javax.swing.JTextField GroupNum;
    private javax.swing.JComboBox<String> dEndBox;
    private javax.swing.JLabel dEndLabel;
    private javax.swing.JComboBox<String> dIniBox;
    private javax.swing.JLabel dIniLabel;
    private javax.swing.JLabel hEndHLabel;
    private javax.swing.JLabel hEndLabel;
    private javax.swing.JSlider hEndSlider;
    private javax.swing.JLabel hIniHLabel;
    private javax.swing.JLabel hIniLabel;
    private javax.swing.JSlider hIniSlider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton modifyClassroomButton;
    // End of variables declaration//GEN-END:variables
}
