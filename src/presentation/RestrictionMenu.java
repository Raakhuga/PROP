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
import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class RestrictionMenu extends javax.swing.JFrame {
    private PresentationCtrl presentationctrl;
    private StudyProgram sp;
    private Level lvl;
    private Group g;
    private Subject sub;
    private int actual = 0;
    private Classroom clas;
    private subGroup sG;
    
    public RestrictionMenu(PresentationCtrl presentationctrl) {
        initComponents();
        this.presentationctrl = presentationctrl;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SPScroll = new javax.swing.JScrollPane();
        SPList = new javax.swing.JList<>();
        back = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        hours = new javax.swing.JCheckBox();
        groupRes = new javax.swing.JCheckBox();
        subjectRes = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        lvlScroll = new javax.swing.JScrollPane();
        lvlList = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        subScroll = new javax.swing.JScrollPane();
        subjectList = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        groupScroll = new javax.swing.JScrollPane();
        groupList = new javax.swing.JList<>();
        lbtRes = new javax.swing.JCheckBox();
        crRes = new javax.swing.JCheckBox();
        checkedName = new javax.swing.JLabel();
        crScroll = new javax.swing.JScrollPane();
        crList = new javax.swing.JList<>();
        resScroll = new javax.swing.JScrollPane();
        resList = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        subGroupScroll = new javax.swing.JScrollPane();
        subGroupList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jLabel1.setText("Restriccions");

        jLabel2.setText("Aules:");

        jLabel3.setText("Plans d'estudi:");

        SPList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SPListMouseClicked(evt);
            }
        });
        SPScroll.setViewportView(SPList);

        back.setText("Enrrere");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel4.setText("Restriccions existents:");

        add.setText("Afegir");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        remove.setText("Esborrar");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        jLabel5.setText("Restriccions actives:");

        hours.setText("Restringir hores");
        hours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoursActionPerformed(evt);
            }
        });

        groupRes.setText("Restringir grups");
        groupRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupResActionPerformed(evt);
            }
        });

        subjectRes.setText("Restringir assignatures");

        jLabel6.setText("Nivell:");

        lvlList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lvlListMouseClicked(evt);
            }
        });
        lvlScroll.setViewportView(lvlList);

        jLabel7.setText("Assignatura:");

        subjectList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subjectListMouseClicked(evt);
            }
        });
        subScroll.setViewportView(subjectList);

        jLabel8.setText("Grup:");

        groupList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                groupListMouseClicked(evt);
            }
        });
        groupScroll.setViewportView(groupList);

        lbtRes.setText("Restringir classe de lab abans de teoria");
        lbtRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbtResActionPerformed(evt);
            }
        });

        crRes.setText("Restingir aules");

        crList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crListMouseClicked(evt);
            }
        });
        crScroll.setViewportView(crList);

        resScroll.setViewportView(resList);

        jLabel9.setText("Subgrups:");

        subGroupList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subGroupListMouseClicked(evt);
            }
        });
        subGroupScroll.setViewportView(subGroupList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(crScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkedName, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(resScroll, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(lvlScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(subScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(52, 52, 52))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(subjectRes)
                                                    .addComponent(groupRes)
                                                    .addComponent(hours)
                                                    .addComponent(crRes)
                                                    .addComponent(lbtRes))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel8)
                                                .addComponent(groupScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(subGroupScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(remove))
                                .addGap(46, 46, 46))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SPScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(back))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(crScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(checkedName, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(add)
                                .addGap(37, 37, 37)
                                .addComponent(remove))
                            .addComponent(resScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(10, 10, 10)
                                .addComponent(hours)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(groupRes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subjectRes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbtRes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(crRes)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(SPScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(18, 18, 18)
                                            .addComponent(subScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(lvlScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(8, 8, 8)
                                .addComponent(groupScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(subGroupScroll)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(back)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        if (hours.isSelected()) presentationctrl.activeRes(0);
        else presentationctrl.disactiveRes(0);
        if (groupRes.isSelected()) presentationctrl.activeRes(2);
        else  presentationctrl.disactiveRes(2);
        if (subjectRes.isSelected()) presentationctrl.activeRes(1);
        else presentationctrl.disactiveRes(1);
        if (lbtRes.isSelected()) presentationctrl.activeRes(4);
        else presentationctrl.disactiveRes(4);
        if (crRes.isSelected()) presentationctrl.activeRes(3);
        else presentationctrl.disactiveRes(3);
        presentationctrl.SwitchFromRMtoMM();
        
    }//GEN-LAST:event_backActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        //restriccio seleccionat es de classe
        if (actual == 1) {
            presentationctrl.SwitchFromRMtoACR(clas);
        }
        else if (actual == 2) {
            presentationctrl.SwitchFromRMtoAGR(g);
        }
        else if (actual == 3){
            presentationctrl.SwitchFromRMtoAsGR(sG);
        }
        else {
             JOptionPane.showMessageDialog(this, "Selecciona una aula, grup o subgrup per afegir una restriccio.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_addActionPerformed

    private void hoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hoursActionPerformed

    private void groupResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupResActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_groupResActionPerformed

    private void lbtResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbtResActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbtResActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        crList.setModel(presentationctrl.getClassroomsRefs());
        crScroll.setViewportView(crList);
        SPList.setModel(presentationctrl.getProgramsNames());
        SPScroll.setViewportView(SPList);
        hours.setSelected(presentationctrl.rExtra(0));
        subjectRes.setSelected(presentationctrl.rExtra(1));
        groupRes.setSelected(presentationctrl.rExtra(2));
        crRes.setSelected(presentationctrl.rExtra(3));
        lbtRes.setSelected(presentationctrl.rExtra(4));
        if (actual != 0) {
            if (actual == 1) {
                if (!crList.isSelectionEmpty()){
                    presentationctrl.removeRestriction(clas, resList.getSelectedIndex());
                    int index = crList.getSelectedIndex();
                    List<Classroom> classrooms = presentationctrl.getClassrooms();
                    resList.setModel(presentationctrl.getRestrictions(classrooms.get(index)));
                    resScroll.setViewportView(resList);
                }
            }
            else if (actual == 3) {
                if(!subGroupList.isSelectionEmpty()) {
                    presentationctrl.removeRestriction(g, resList.getSelectedIndex());
                    int index = groupList.getSelectedIndex();
                    List<Group> groups = presentationctrl.getGroup(sub);
                    resList.setModel(presentationctrl.getRestrictions(g));
                    resScroll.setViewportView(resList);
                    
                }
            }
            else {
                if (!groupList.isSelectionEmpty()) {
                    int index = subGroupList.getSelectedIndex();
                    List<subGroup> subgroups = presentationctrl.getsubGroup(g);
                    resList.setModel(presentationctrl.getRestrictions(subgroups.get(index)));
                    resScroll.setViewportView(resList);
                    
                }
            }
        }
    }//GEN-LAST:event_formWindowActivated

    private void crListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crListMouseClicked
        // TODO add your handling code here:
        crList = (JList)evt.getSource();
        if (evt.getClickCount() == 2) {
            // Double-click detected
            int index = crList.getSelectedIndex();
            List<Classroom> classrooms = presentationctrl.getClassrooms();
            actual = 1;
            clas = classrooms.get(index);
            resList.setModel(presentationctrl.getRestrictions(classrooms.get(index)));
            checkedName.setText(classrooms.get(index).getRef());
            resScroll.setViewportView(resList);
        }
    }//GEN-LAST:event_crListMouseClicked

    private void SPListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SPListMouseClicked
        // TODO add your handling code here:
        SPList = (JList)evt.getSource();
        if (evt.getClickCount() == 2) {
            // Double-click detected
            int index = SPList.getSelectedIndex();
            List<StudyProgram> stuydyprograms = presentationctrl.getSP();
            sp = stuydyprograms.get(index);
            lvlList.setModel(presentationctrl.getLevel(stuydyprograms.get(index)));
            lvlScroll.setViewportView(lvlList);
        }
    }//GEN-LAST:event_SPListMouseClicked

    private void lvlListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lvlListMouseClicked
        // TODO add your handling code here:
        lvlList = (JList)evt.getSource();
        if (evt.getClickCount() == 2) {
            // Double-click detected
            int index = lvlList.getSelectedIndex();
            List<Level> levels = presentationctrl.getLevels(sp);
            lvl = levels.get(index);
            subjectList.setModel(presentationctrl.getSubject(levels.get(index)));
            subScroll.setViewportView(subjectList);
        }
    }//GEN-LAST:event_lvlListMouseClicked

    private void subjectListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectListMouseClicked
        // TODO add your handling code here:
        subjectList = (JList)evt.getSource();
        if (evt.getClickCount() == 2) {
            // Double-click detected
            int index = subjectList.getSelectedIndex();
            List<Subject> subjects = presentationctrl.getSubjects(lvl);
            sub = subjects.get(index);
            groupList.setModel(presentationctrl.getGroupsRefs(subjects.get(index)));
            groupScroll.setViewportView(groupList);
        }
    }//GEN-LAST:event_subjectListMouseClicked

    private void groupListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groupListMouseClicked
        // TODO add your handling code here:
        groupList = (JList)evt.getSource();
        if (evt.getClickCount() == 2) {
            // Double-click detected
            int index = groupList.getSelectedIndex();
            List<Group> groups = presentationctrl.getGroup(sub);
            g = groups.get(index);
            checkedName.setText("Grup " + g.getNum());
            actual = 2;
            resList.setModel(presentationctrl.getRestrictions(g));
            resScroll.setViewportView(resList);
            subGroupList.setModel(presentationctrl.getsubGroupsRefs(groups.get(index)));
            subGroupScroll.setViewportView(subGroupList);
        }
    }//GEN-LAST:event_groupListMouseClicked

    private void subGroupListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subGroupListMouseClicked
        // TODO add your handling code here:
        subGroupList = (JList)evt.getSource();
        if (evt.getClickCount() == 2) {
            // Double-click detected
            int index = subGroupList.getSelectedIndex();
            List<subGroup> subgroups = presentationctrl.getsubGroup(g);
            actual = 3;
            sG = subgroups.get(index);
            checkedName.setText("Subgrup " + subgroups.get(index).getNum());
            resList.setModel(presentationctrl.getRestrictions(subgroups.get(index)));
            resScroll.setViewportView(resList);
        }
    }//GEN-LAST:event_subGroupListMouseClicked

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:
        if (!resList.isSelectionEmpty()) {
            if (actual == 1) {
                presentationctrl.removeRestriction(clas, resList.getSelectedIndex());
                int index = crList.getSelectedIndex();
                List<Classroom> classrooms = presentationctrl.getClassrooms();
                resList.setModel(presentationctrl.getRestrictions(classrooms.get(index)));
                resScroll.setViewportView(resList);
            }
            else if (actual == 2) {
                presentationctrl.removeRestriction(g, resList.getSelectedIndex());
                int index = groupList.getSelectedIndex();
                List<Group> groups = presentationctrl.getGroup(sub);
                resList.setModel(presentationctrl.getRestrictions(g));
                resScroll.setViewportView(resList);
                
            }
            else if (actual == 3){
                presentationctrl.removeRestriction(sG, resList.getSelectedIndex());
                int index = subGroupList.getSelectedIndex();
                List<subGroup> subgroups = presentationctrl.getsubGroup(g);
                resList.setModel(presentationctrl.getRestrictions(subgroups.get(index)));
                resScroll.setViewportView(resList);
            }
            else {
                JOptionPane.showMessageDialog(this, "Selecciona una aula, grup o subgrup per esborrar una restriccio.", "Atenció:", JOptionPane.WARNING_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Selecciona una aula, grup o subgrup per esborrar una restriccio.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_removeActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> SPList;
    private javax.swing.JScrollPane SPScroll;
    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JLabel checkedName;
    private javax.swing.JList<String> crList;
    private javax.swing.JCheckBox crRes;
    private javax.swing.JScrollPane crScroll;
    private javax.swing.JList<String> groupList;
    private javax.swing.JCheckBox groupRes;
    private javax.swing.JScrollPane groupScroll;
    private javax.swing.JCheckBox hours;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JCheckBox lbtRes;
    private javax.swing.JList<String> lvlList;
    private javax.swing.JScrollPane lvlScroll;
    private javax.swing.JButton remove;
    private javax.swing.JList<String> resList;
    private javax.swing.JScrollPane resScroll;
    private javax.swing.JList<String> subGroupList;
    private javax.swing.JScrollPane subGroupScroll;
    private javax.swing.JScrollPane subScroll;
    private javax.swing.JList<String> subjectList;
    private javax.swing.JCheckBox subjectRes;
    // End of variables declaration//GEN-END:variables
}
