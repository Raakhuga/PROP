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

        jDialog1 = new javax.swing.JDialog();
        booleanGroup = new javax.swing.ButtonGroup();
        modifyClassroomButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        laboratoryRadioButton = new javax.swing.JRadioButton();
        theoryRadioButton = new javax.swing.JRadioButton();
        CapacityLabel = new javax.swing.JLabel();
        hIniSlider = new javax.swing.JSlider();
        hEndHLabel = new javax.swing.JLabel();
        dIniLabel = new javax.swing.JLabel();
        problemsRadioButton = new javax.swing.JRadioButton();
        hEndSlider = new javax.swing.JSlider();
        typeLabel = new javax.swing.JLabel();
        hIniLabel = new javax.swing.JLabel();
        hIniHLabel = new javax.swing.JLabel();
        RefLabel = new javax.swing.JLabel();
        hEndLabel = new javax.swing.JLabel();
        dEndLabel = new javax.swing.JLabel();
        dIniBox = new javax.swing.JComboBox<>();
        capacityField = new javax.swing.JTextField();
        dEndBox = new javax.swing.JComboBox<>();
        RefField = new javax.swing.JTextField();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar aula");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar Aula:"));

        booleanGroup.add(laboratoryRadioButton);
        laboratoryRadioButton.setText("Laboratori");

        booleanGroup.add(theoryRadioButton);
        theoryRadioButton.setText("Teoría");

        CapacityLabel.setText("Nombre màxim d'estudiants que caben a l'aula:");
        CapacityLabel.setToolTipText("");

        hIniSlider.setMaximum(23);
        hIniSlider.setValue(0);
        hIniSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hIniSliderStateChanged(evt);
            }
        });

        hEndHLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hEndHLabel.setText("0");
        hEndHLabel.setToolTipText("");

        dIniLabel.setText("Primer día útil de l'aula:");

        booleanGroup.add(problemsRadioButton);
        problemsRadioButton.setText("Problemes");

        hEndSlider.setMaximum(23);
        hEndSlider.setValue(0);
        hEndSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hEndSliderStateChanged(evt);
            }
        });

        typeLabel.setText("Tipus:");

        hIniLabel.setText("Primera hora útil de l'aula:");

        hIniHLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hIniHLabel.setText("0");

        RefLabel.setText("Nom de l'aula:");

        hEndLabel.setText("Darrera hora útil de l'aula:");
        hEndLabel.setToolTipText("");

        dEndLabel.setText("Darrer día útil de l'aula:");

        dIniBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenje" }));

        dEndBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenje" }));
        dEndBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dEndBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(hEndSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(hIniSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(hEndLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hIniHLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hEndHLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(hIniLabel)
                    .addComponent(dEndLabel)
                    .addComponent(CapacityLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(RefLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(dIniLabel)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addComponent(dIniBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RefField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(problemsRadioButton)
                            .addComponent(laboratoryRadioButton)
                            .addComponent(typeLabel)
                            .addComponent(theoryRadioButton)))
                    .addComponent(dEndBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capacityField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(hIniSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hEndLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hEndHLabel)
                    .addComponent(hEndSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modifyClassroomButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modifyClassroomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyClassroomButtonActionPerformed
        // TODO add your handling code here:
        String capacity = capacityField.getText();
        String ref = RefField.getText();
        int dIni = dIniBox.getSelectedIndex();
        int dEnd = dEndBox.getSelectedIndex();
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
            presentationctrl.setCapacity(act, Integer.parseInt(capacity));
            presentationctrl.setRef(act, ref);
            presentationctrl.setdIni(act, dIni);
            presentationctrl.setdEnd(act, dEnd);
            presentationctrl.sethIni(act, hIni);
            presentationctrl.sethEnd(act, hEnd);
            presentationctrl.SwitchFromMCtoCM();
            presentationctrl.setTheory(act, theoryRadioButton.isSelected());
            presentationctrl.setLaboratory(act, laboratoryRadioButton.isSelected());
            presentationctrl.setProblems(act, problemsRadioButton.isSelected());
        }
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
        dIniBox.setSelectedIndex(dIni);
        dEndBox.setSelectedIndex(dEnd);
        hIniSlider.setValue(hIni);
        hEndSlider.setValue(hEnd);
        hIniHLabel.setText(hIni+"");
        hEndHLabel.setText(hEnd+"");
        boolean theory = presentationctrl.isTheory(act);
        boolean laboratory = presentationctrl.isLaboratory(act);
        boolean problems = presentationctrl.isProblems(act);
        theoryRadioButton.setSelected(theory);
        laboratoryRadioButton.setSelected(laboratory);
        problemsRadioButton.setSelected(problems);
    }//GEN-LAST:event_formWindowActivated

    private void hIniSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hIniSliderStateChanged
        // TODO add your handling code here:
        hIniHLabel.setText(hIniSlider.getValue()+"");
    }//GEN-LAST:event_hIniSliderStateChanged

    private void dEndBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dEndBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dEndBoxActionPerformed

    private void hEndSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hEndSliderStateChanged
        // TODO add your handling code here:
        hEndHLabel.setText(hEndSlider.getValue()+"");
    }//GEN-LAST:event_hEndSliderStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CapacityLabel;
    private javax.swing.JTextField RefField;
    private javax.swing.JLabel RefLabel;
    private javax.swing.ButtonGroup booleanGroup;
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
    private javax.swing.JDialog jDialog1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton laboratoryRadioButton;
    private javax.swing.JButton modifyClassroomButton;
    private javax.swing.JRadioButton problemsRadioButton;
    private javax.swing.JRadioButton theoryRadioButton;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
