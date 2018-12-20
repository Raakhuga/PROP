/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Classroom;
import javax.swing.JOptionPane;

/**
 *
 * @author Raakhuga
 */
public class AddClassroom extends javax.swing.JFrame {
    private PresentationCtrl presentationctrl;
    /**
     * Creates new form AddClassroom
     */
    public AddClassroom(PresentationCtrl presentationctrl) {
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

        boolGroup = new javax.swing.ButtonGroup();
        addClassroom = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        typeLabel = new javax.swing.JLabel();
        theoryRadioButton = new javax.swing.JRadioButton();
        CapacityLabel = new javax.swing.JLabel();
        laboratoryRadioButton = new javax.swing.JRadioButton();
        capacityField = new javax.swing.JTextField();
        problemsRadioButton = new javax.swing.JRadioButton();
        RefLabel = new javax.swing.JLabel();
        dIniBox = new javax.swing.JComboBox<>();
        RefField = new javax.swing.JTextField();
        dEndBox = new javax.swing.JComboBox<>();
        dIniLabel = new javax.swing.JLabel();
        hIniSlider = new javax.swing.JSlider();
        dEndLabel = new javax.swing.JLabel();
        hEndSlider = new javax.swing.JSlider();
        hIniLabel = new javax.swing.JLabel();
        hIniHLabel = new javax.swing.JLabel();
        hEndLabel = new javax.swing.JLabel();
        hEndHLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        addClassroom.setText("Afegir");
        addClassroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassroomActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Afegir Aula:"));

        typeLabel.setText("Tipus:");

        boolGroup.add(theoryRadioButton);
        theoryRadioButton.setText("Teoría");

        CapacityLabel.setText("Nombre màxim d'estudiants que caben a l'aula:");
        CapacityLabel.setToolTipText("");

        boolGroup.add(laboratoryRadioButton);
        laboratoryRadioButton.setText("Laboratori");

        boolGroup.add(problemsRadioButton);
        problemsRadioButton.setText("Problemes");

        RefLabel.setText("Nom de l'aula:");

        dIniBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenje" }));
        dIniBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dIniBoxActionPerformed(evt);
            }
        });

        dEndBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenje" }));

        dIniLabel.setText("Primer día útil de l'aula:");

        hIniSlider.setMaximum(23);
        hIniSlider.setValue(8);
        hIniSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hIniSliderStateChanged(evt);
            }
        });

        dEndLabel.setText("Darrer día útil de l'aula:");

        hEndSlider.setMaximum(23);
        hEndSlider.setValue(20);
        hEndSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hEndSliderStateChanged(evt);
            }
        });

        hIniLabel.setText("Primera hora útil de l'aula:");

        hIniHLabel.setText("8");

        hEndLabel.setText("Darrera hora útil de l'aula:");

        hEndHLabel.setText("20");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(hEndLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hEndSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(hIniSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hEndHLabel)
                            .addComponent(hIniHLabel)))
                    .addComponent(CapacityLabel)
                    .addComponent(hIniLabel)
                    .addComponent(dEndLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RefLabel)
                            .addComponent(dIniLabel)
                            .addComponent(dIniBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(capacityField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(RefField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(problemsRadioButton)
                            .addComponent(laboratoryRadioButton)
                            .addComponent(typeLabel)
                            .addComponent(theoryRadioButton)))
                    .addComponent(dEndBox, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CapacityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(capacityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(RefLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RefField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(3, 3, 3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(typeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(theoryRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(laboratoryRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(problemsRadioButton)
                        .addGap(70, 70, 70)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hIniHLabel)
                    .addComponent(hIniSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hEndLabel)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(hEndHLabel)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hEndSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addClassroom)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addClassroom)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void addClassroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClassroomActionPerformed
        // TODO add your handling code here:
        String capacity = capacityField.getText();
        String ref = RefField.getText();
        int dIni = Integer.parseInt(dIniBox.getSelectedIndex()+"");   
        int dEnd = Integer.parseInt(dEndBox.getSelectedIndex()+"");
        int hIni = Integer.parseInt(hIniHLabel.getText());
        int hEnd = Integer.parseInt(hEndHLabel.getText());
        if (dIni > dEnd) 
            JOptionPane.showMessageDialog(this, "El darrer día útil ha de\nser el mateix dia o \nposterior al inicial", "Atenció:", JOptionPane.WARNING_MESSAGE);
        if (hIni >= hEnd) 
            JOptionPane.showMessageDialog(this, "La darrera hora útil ha de\nser posterior a la primera", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else if (capacity.equals("") || ref.equals("") || (!theoryRadioButton.isSelected() && !laboratoryRadioButton.isSelected() && !problemsRadioButton.isSelected())) {
            JOptionPane.showMessageDialog(this, "S'han d'omplir tots els camps.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        }
        else if (!presentationctrl.isInt(capacity)){
            JOptionPane.showMessageDialog(this, "La capacitat ha de ser un valor numèric.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        }
        else {
            Classroom c = presentationctrl.addClassroom(Integer.parseInt(capacity), ref, dIni, dEnd, hIni, hEnd);
            presentationctrl.setTheory(c, theoryRadioButton.isSelected());
            presentationctrl.setLaboratory(c, laboratoryRadioButton.isSelected());
            presentationctrl.setProblems(c, problemsRadioButton.isSelected());
            presentationctrl.SwitchFromACtoCM();
        }
    }//GEN-LAST:event_addClassroomActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void dIniBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dIniBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dIniBoxActionPerformed

    private void hIniSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hIniSliderStateChanged
        // TODO add your handling code here:
        hIniHLabel.setText(hIniSlider.getValue()+"");
    }//GEN-LAST:event_hIniSliderStateChanged

    private void hEndSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hEndSliderStateChanged
        // TODO add your handling code here:
        hEndHLabel.setText(hEndSlider.getValue()+"");
    }//GEN-LAST:event_hEndSliderStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CapacityLabel;
    private javax.swing.JTextField RefField;
    private javax.swing.JLabel RefLabel;
    private javax.swing.JButton addClassroom;
    private javax.swing.ButtonGroup boolGroup;
    private javax.swing.JTextField capacityField;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton laboratoryRadioButton;
    private javax.swing.JRadioButton problemsRadioButton;
    private javax.swing.JRadioButton theoryRadioButton;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
