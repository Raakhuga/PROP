/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import javax.swing.JOptionPane;

/**
 *
 * @author raakhuga
 */
public class MainMenu extends javax.swing.JFrame {
    private PresentationCtrl presentationctrl;
    /**
     * Creates new form MainMenu
     */
    public MainMenu(PresentationCtrl presentationctrl) {
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

        ManualConfiguration = new javax.swing.JButton();
        Persistance = new javax.swing.JButton();
        view = new javax.swing.JButton();
        restrictions = new javax.swing.JButton();
        generateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        ManualConfiguration.setText("Configuració Manual");
        ManualConfiguration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManualConfigurationActionPerformed(evt);
            }
        });

        Persistance.setText("Guardar / Carregar");
        Persistance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersistanceActionPerformed(evt);
            }
        });

        view.setText("Veure Horari");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });

        restrictions.setText("Restriccions");
        restrictions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restrictionsActionPerformed(evt);
            }
        });

        generateButton.setText("Generar Horari");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restrictions, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ManualConfiguration, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Persistance, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(ManualConfiguration, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Persistance, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(restrictions, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void ManualConfigurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManualConfigurationActionPerformed
        if(presentationctrl.getFirst()) presentationctrl.SwitchFromMMtoFT();
        else presentationctrl.SwitchFromMMtoSM();
    }//GEN-LAST:event_ManualConfigurationActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromMMtoSC();
    }//GEN-LAST:event_viewActionPerformed

    private void PersistanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersistanceActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromMMtoSLM();
    }//GEN-LAST:event_PersistanceActionPerformed

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        // TODO add your handling code here:
        if(presentationctrl.generate()) 
            JOptionPane.showMessageDialog(this, "S'ha generat l'horari correctament.", "Generació:", JOptionPane.INFORMATION_MESSAGE);
        else 
            JOptionPane.showMessageDialog(this, "No s'ha pogut generar l'horari.", "Generació:", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_generateButtonActionPerformed

    private void restrictionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restrictionsActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromMMtoRM();
    }//GEN-LAST:event_restrictionsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ManualConfiguration;
    private javax.swing.JButton Persistance;
    private javax.swing.JButton generateButton;
    private javax.swing.JButton restrictions;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
