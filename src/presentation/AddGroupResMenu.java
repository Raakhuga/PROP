/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Classroom;
import domain.Group;
import domain.subGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AddGroupResMenu extends javax.swing.JFrame {
    private Group group;
    private PresentationCtrl presentationctrl;


    
    public AddGroupResMenu(PresentationCtrl presentationctrl) {
        initComponents();
        this.presentationctrl = presentationctrl;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        classname = new javax.swing.JTextField();
        dIniLabel1 = new javax.swing.JLabel();
        dIniBox1 = new javax.swing.JComboBox<>();
        dEndLabel1 = new javax.swing.JLabel();
        dEndBox1 = new javax.swing.JComboBox<>();
        hIniLabel1 = new javax.swing.JLabel();
        hIniSliderclass = new javax.swing.JSlider();
        hEndLabel1 = new javax.swing.JLabel();
        hEndSliderclass = new javax.swing.JSlider();
        hEndHLabel1 = new javax.swing.JLabel();
        hIniHLabel1 = new javax.swing.JLabel();
        addClassroomResBotoom = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        dIniLabel2 = new javax.swing.JLabel();
        dIniBox2 = new javax.swing.JComboBox<>();
        dEndLabel2 = new javax.swing.JLabel();
        dEndBox2 = new javax.swing.JComboBox<>();
        hIniLabel2 = new javax.swing.JLabel();
        hIniSliderHour = new javax.swing.JSlider();
        hEndLabel2 = new javax.swing.JLabel();
        hEndSliderHour = new javax.swing.JSlider();
        hEndHLabel2 = new javax.swing.JLabel();
        hIniHLabel2 = new javax.swing.JLabel();
        addHourResBottom = new javax.swing.JButton();
        backBottom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTabbedPane1.setToolTipText("Banejar grup\nBanejar assignatura\nBanejar hora");

        jLabel4.setText("Introdueixi el nom de l'aula que vol bloquejar:");

        classname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classnameActionPerformed(evt);
            }
        });

        dIniLabel1.setText("Selecciona el primer dia a bloquejar:");

        dIniBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenje" }));

        dEndLabel1.setText("Selecciona el darrer dia a bloquejar:");

        dEndBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenje" }));
        dEndBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dEndBox1ActionPerformed(evt);
            }
        });

        hIniLabel1.setText("Selecciona la primera hora a bloquejar:");

        hIniSliderclass.setMaximum(23);
        hIniSliderclass.setValue(0);
        hIniSliderclass.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hIniSliderclassStateChanged(evt);
            }
        });

        hEndLabel1.setText("Selecciona la darrera hora a bloquejar:");
        hEndLabel1.setToolTipText("");

        hEndSliderclass.setMaximum(23);
        hEndSliderclass.setValue(0);
        hEndSliderclass.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hEndSliderclassStateChanged(evt);
            }
        });

        hEndHLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hEndHLabel1.setText("0");
        hEndHLabel1.setToolTipText("");

        hIniHLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hIniHLabel1.setText("0");

        addClassroomResBotoom.setText("Afegir");
        addClassroomResBotoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassroomResBotoomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(hEndSliderclass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hIniSliderclass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(hEndLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hIniHLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hEndHLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(addClassroomResBotoom))))
                    .addComponent(jLabel4)
                    .addComponent(classname, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hIniLabel1)
                    .addComponent(dEndLabel1)
                    .addComponent(dIniLabel1)
                    .addComponent(dIniBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dEndBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(classname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dIniLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dIniBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dEndLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dEndBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hIniLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hIniSliderclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hIniHLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hEndLabel1)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hEndSliderclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hEndHLabel1))
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addClassroomResBotoom))))
        );

        jTabbedPane1.addTab("Bloquejar aula", jPanel2);

        dIniLabel2.setText("Selecciona el primer dia a bloquejar:");

        dIniBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenje" }));

        dEndLabel2.setText("Selecciona el darrer dia a bloquejar:");

        dEndBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenje" }));
        dEndBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dEndBox2ActionPerformed(evt);
            }
        });

        hIniLabel2.setText("Selecciona la primera hora a bloquejar:");

        hIniSliderHour.setMaximum(23);
        hIniSliderHour.setValue(0);
        hIniSliderHour.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hIniSliderHourStateChanged(evt);
            }
        });

        hEndLabel2.setText("Selecciona la darrera hora a bloquejar:");
        hEndLabel2.setToolTipText("");

        hEndSliderHour.setMaximum(23);
        hEndSliderHour.setValue(0);
        hEndSliderHour.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hEndSliderHourStateChanged(evt);
            }
        });

        hEndHLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hEndHLabel2.setText("0");
        hEndHLabel2.setToolTipText("");

        hIniHLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hIniHLabel2.setText("0");

        addHourResBottom.setText("Afegir");
        addHourResBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHourResBottomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hIniLabel2)
                    .addComponent(dEndLabel2)
                    .addComponent(dIniLabel2)
                    .addComponent(dIniBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dEndBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(hEndSliderHour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hIniSliderHour, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(hEndLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hIniHLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hEndHLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(191, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addHourResBottom)
                .addGap(112, 112, 112))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hIniLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hIniSliderHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hIniHLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hEndLabel2)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hEndHLabel2)
                    .addComponent(hEndSliderHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dEndLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dEndBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dIniLabel2)
                .addGap(11, 11, 11)
                .addComponent(dIniBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(addHourResBottom))
        );

        jTabbedPane1.addTab("Bloquejar hora", jPanel3);

        backBottom.setText("Tornar");
        backBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBottomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBottom)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backBottom)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void setGroup(Group g){
        group = g;
        name.setText("Group: " + g.getNum());
    }
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void backBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBottomActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromAGroupResMtoRM();
    }//GEN-LAST:event_backBottomActionPerformed

    private void addHourResBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHourResBottomActionPerformed
        // TODO add your handling code here:
        int dIni = Integer.parseInt(dIniBox2.getSelectedIndex()+"");
        int dEnd = Integer.parseInt(dEndBox2.getSelectedIndex()+"");
        int hIni = Integer.parseInt(hIniHLabel2.getText());
        int hEnd = Integer.parseInt(hEndHLabel2.getText());
        if (dIni > dEnd)
            JOptionPane.showMessageDialog(this, "El darrer día útil ha de\nser el mateix dia o \nposterior al inicial", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else if (hIni >= hEnd)
        JOptionPane.showMessageDialog(this, "La darrera hora útil ha de\nser posterior a la primera", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else if (!presentationctrl.addGroupRes(group, dIni, dEnd, hIni, hEnd))
            JOptionPane.showMessageDialog(this, "Ja existeix aquesta restricció.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else
            presentationctrl.SwitchFromAGroupResMtoRM();
    }//GEN-LAST:event_addHourResBottomActionPerformed

    private void hEndSliderHourStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hEndSliderHourStateChanged
        // TODO add your handling code here:
        hEndHLabel2.setText(hEndSliderHour.getValue()+"");
    }//GEN-LAST:event_hEndSliderHourStateChanged

    private void hIniSliderHourStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hIniSliderHourStateChanged
        // TODO add your handling code here:
        hIniHLabel2.setText(hIniSliderHour.getValue()+"");
    }//GEN-LAST:event_hIniSliderHourStateChanged

    private void dEndBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dEndBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dEndBox2ActionPerformed

    private void addClassroomResBotoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClassroomResBotoomActionPerformed
        // TODO add your handling code here:
        String name = classname.getText();
        int dIni = Integer.parseInt(dIniBox1.getSelectedIndex()+"");
        int dEnd = Integer.parseInt(dEndBox1.getSelectedIndex()+"");
        int hIni = Integer.parseInt(hIniHLabel1.getText());
        int hEnd = Integer.parseInt(hEndHLabel1.getText());
        if(name.equals(""))
            JOptionPane.showMessageDialog(this, "S'han d'omplir tots els camps.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else if(!presentationctrl.classcontain(name))
            JOptionPane.showMessageDialog(this, "No hi ha cap aula amb aquest nom.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else if(!presentationctrl.addGroupRes(group, dIni, dEnd, hIni, hEnd, name))
            JOptionPane.showMessageDialog(this, "Ja existeix aquesta restricció.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else
            presentationctrl.SwitchFromAGroupResMtoRM();
            
    }//GEN-LAST:event_addClassroomResBotoomActionPerformed

    private void hEndSliderclassStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hEndSliderclassStateChanged
        // TODO add your handling code here:
        hEndHLabel1.setText(hEndSliderclass.getValue()+"");
    }//GEN-LAST:event_hEndSliderclassStateChanged

    private void hIniSliderclassStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hIniSliderclassStateChanged
        // TODO add your handling code here:
        hIniHLabel1.setText(hIniSliderclass.getValue()+"");
    }//GEN-LAST:event_hIniSliderclassStateChanged

    private void dEndBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dEndBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dEndBox1ActionPerformed

    private void classnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classnameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addClassroomResBotoom;
    private javax.swing.JButton addHourResBottom;
    private javax.swing.JButton backBottom;
    private javax.swing.JTextField classname;
    private javax.swing.JComboBox<String> dEndBox1;
    private javax.swing.JComboBox<String> dEndBox2;
    private javax.swing.JLabel dEndLabel1;
    private javax.swing.JLabel dEndLabel2;
    private javax.swing.JComboBox<String> dIniBox1;
    private javax.swing.JComboBox<String> dIniBox2;
    private javax.swing.JLabel dIniLabel1;
    private javax.swing.JLabel dIniLabel2;
    private javax.swing.JLabel hEndHLabel1;
    private javax.swing.JLabel hEndHLabel2;
    private javax.swing.JLabel hEndLabel1;
    private javax.swing.JLabel hEndLabel2;
    private javax.swing.JSlider hEndSliderHour;
    private javax.swing.JSlider hEndSliderclass;
    private javax.swing.JLabel hIniHLabel1;
    private javax.swing.JLabel hIniHLabel2;
    private javax.swing.JLabel hIniLabel1;
    private javax.swing.JLabel hIniLabel2;
    private javax.swing.JSlider hIniSliderHour;
    private javax.swing.JSlider hIniSliderclass;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
}
