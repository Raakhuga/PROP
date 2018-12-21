/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Classroom;
import domain.Group;
import domain.Level;
import domain.StudyProgram;
import domain.Subject;
import domain.subGroup;
import javax.swing.JLabel;

/**
 *
 * @author Raakhuga
 */
public class ViewState extends javax.swing.JFrame {
    private PresentationCtrl presentationctrl;
    private StudyProgram SP;
    private Level L;
    private Subject S;
    private Group G;
    /**
     * Creates new form ViewState
     */
    public ViewState(PresentationCtrl presentationctrl) {
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

        jPanel1 = new javax.swing.JPanel();
        SPScrollPane = new javax.swing.JScrollPane();
        SPList = new javax.swing.JList<>();
        LvlScrollPane = new javax.swing.JScrollPane();
        LvlList = new javax.swing.JList<>();
        SScrollPane = new javax.swing.JScrollPane();
        SList = new javax.swing.JList<>();
        CScrollPane = new javax.swing.JScrollPane();
        CList = new javax.swing.JList<>();
        GScrollPane = new javax.swing.JScrollPane();
        GList = new javax.swing.JList<>();
        sGScrollPane = new javax.swing.JScrollPane();
        sGList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Veure estat"));

        SPList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SPListMouseClicked(evt);
            }
        });
        SPScrollPane.setViewportView(SPList);

        LvlList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LvlListMouseClicked(evt);
            }
        });
        LvlScrollPane.setViewportView(LvlList);

        SList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SListMouseClicked(evt);
            }
        });
        SScrollPane.setViewportView(SList);

        CList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CListMouseClicked(evt);
            }
        });
        CScrollPane.setViewportView(CList);

        GList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GListMouseClicked(evt);
            }
        });
        GScrollPane.setViewportView(GList);

        sGList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sGListMouseClicked(evt);
            }
        });
        sGScrollPane.setViewportView(sGList);

        jLabel1.setText("Aules:");

        jLabel2.setText("Plans d'estudi:");

        jLabel3.setText("Nivells:");

        jLabel4.setText("Assignatures:");

        jLabel5.setText("Grups:");

        jLabel6.setText("Subgrups:");

        infoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Info"));

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        jLabel12.setText("jLabel12");

        jLabel13.setText("jLabel13");

        jLabel14.setText("jLabel14");

        jLabel15.setText("jLabel15");

        jLabel16.setText("jLabel16");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16))
        );

        jButton1.setText("Tornar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SPScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LvlScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sGScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sGScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SPScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LvlScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String dia(int id) {
        switch(id) {
            case 0:
                return "Dilluns";
            case 1:
                return "Dimarts";
            case 2:
                return "Dimecres";
            case 3:
                return "Dijous";
            case 4:
                return "Divendres";
            case 5:
                return "Dissabte";
            case 6:
                return "Diumenje";
        }
        return "error";
    }
    
    private void resetLabels() {
        jLabel7.setText("");
        jLabel8.setText("");
        jLabel9.setText("");
        jLabel10.setText("");
        jLabel11.setText("");
        jLabel12.setText("");
        jLabel13.setText("");
        jLabel14.setText("");
        jLabel15.setText("");
        jLabel16.setText("");
    }
    
    private void showClassInfo(Classroom c) {
        jLabel7.setText("Referencia de l'aula: " + c.getRef());
        jLabel8.setText("Capacitat de l'aula: " + c.getCapacity());
        jLabel9.setText("Tipus: " + c.getTypes());
        jLabel10.setText("Primer dia útil de l'aula: " + dia(c.getdIni()));
        jLabel11.setText("Darrer dia útil de l'aula: " + dia(c.getdEnd()));
        jLabel12.setText("Primera hora útil de l'aula: " + c.gethIni());
        jLabel13.setText("Darrera hora útil de l'aula: " + c.gethEnd());
    }
    
    private void showSubjectInfo(Subject s) {
        jLabel7.setText("Nom de la materia: " + s.getName());
        jLabel8.setText("Numero de sessions de teoría: " + s.getTheoryH());
        jLabel9.setText("Numero de sessions de laboratori: " + s.getLaboratoryH());
        jLabel10.setText("Numero de sessions de problemes: " + s.getProblemsH());
    }
    
    private void showGroup(Group g) {
        jLabel7.setText("Nummero de grup: " + g.getNum());
        jLabel8.setText("Numero de inscrits en el grup: " + g.getEnrolled());
        jLabel9.setText("Primer dia útil del grup: " + g.getdIni());
        jLabel10.setText("Darrer dia útil del grup: " + g.getdEnd());
        jLabel11.setText("Primera hora útil del grup: " + g.gethIni());
        jLabel12.setText("Darrera hora útil del grup " + g.gethEnd());
    }
    
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        resetLabels();
        CList.setModel(presentationctrl.getClassroomsRefs());
        CScrollPane.setViewportView(CList);
        SPList.setModel(presentationctrl.getStudyProgramsName());
        SPScrollPane.setViewportView(SPList);
    }//GEN-LAST:event_formWindowActivated

    private void CListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CListMouseClicked
        // TODO add your handling code here:
        int id = CList.getSelectedIndex();
        resetLabels();
        showClassInfo(presentationctrl.getClassrooms().get(id));
    }//GEN-LAST:event_CListMouseClicked

    private void SPListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SPListMouseClicked
        // TODO add your handling code here:
        int id = SPList.getSelectedIndex();
        SP = presentationctrl.getPrograms().get(id);
        LvlList.setModel(presentationctrl.getLevelsIden(SP));
    }//GEN-LAST:event_SPListMouseClicked

    private void LvlListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LvlListMouseClicked
        // TODO add your handling code here:
        int id = LvlList.getSelectedIndex();
        L = presentationctrl.getLevels(SP).get(id);
        SList.setModel(presentationctrl.getSubjectsName(L));
    }//GEN-LAST:event_LvlListMouseClicked

    private void SListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SListMouseClicked
        // TODO add your handling code here:
        int id = SList.getSelectedIndex();
        S = presentationctrl.getSubjects(L).get(id);
        GList.setModel(presentationctrl.getGroupsRefs(S));
        resetLabels();
        showSubjectInfo(S);
    }//GEN-LAST:event_SListMouseClicked

    private void GListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GListMouseClicked
        // TODO add your handling code here:
        int id = GList.getSelectedIndex();
        G = presentationctrl.getGroup(S).get(id);
        sGList.setModel(presentationctrl.getsubGroupsRefs(G));
        resetLabels();
        showGroup(G);
    }//GEN-LAST:event_GListMouseClicked

    private void sGListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sGListMouseClicked
        // TODO add your handling code here:
        int id = sGList.getSelectedIndex();
        subGroup  s = presentationctrl.getsubGroup(G).get(id);
        resetLabels();
        showGroup(s);
    }//GEN-LAST:event_sGListMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromVStoMM();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> CList;
    private javax.swing.JScrollPane CScrollPane;
    private javax.swing.JList<String> GList;
    private javax.swing.JScrollPane GScrollPane;
    private javax.swing.JList<String> LvlList;
    private javax.swing.JScrollPane LvlScrollPane;
    private javax.swing.JList<String> SList;
    private javax.swing.JList<String> SPList;
    private javax.swing.JScrollPane SPScrollPane;
    private javax.swing.JScrollPane SScrollPane;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JList<String> sGList;
    private javax.swing.JScrollPane sGScrollPane;
    // End of variables declaration//GEN-END:variables
}
