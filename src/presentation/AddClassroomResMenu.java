/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Classroom;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AddClassroomResMenu extends javax.swing.JFrame {
    private Classroom clas;
    private PresentationCtrl presentationctrl;

    public AddClassroomResMenu(PresentationCtrl presentationctrl) {
        initComponents();
        this.presentationctrl = presentationctrl;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        subjectname = new javax.swing.JTextField();
        dIniLabel1 = new javax.swing.JLabel();
        dIniBox1 = new javax.swing.JComboBox<>();
        dEndLabel1 = new javax.swing.JLabel();
        dEndBox1 = new javax.swing.JComboBox<>();
        hIniLabel1 = new javax.swing.JLabel();
        hIniSlidersubject = new javax.swing.JSlider();
        hEndLabel1 = new javax.swing.JLabel();
        hEndSlidersubject = new javax.swing.JSlider();
        hEndHLabel1 = new javax.swing.JLabel();
        hIniHLabel1 = new javax.swing.JLabel();
        addSubjectResBotoom = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        groupnum = new javax.swing.JTextField();
        dIniLabel = new javax.swing.JLabel();
        dIniBox = new javax.swing.JComboBox<>();
        dEndLabel = new javax.swing.JLabel();
        dEndBox = new javax.swing.JComboBox<>();
        hIniLabel = new javax.swing.JLabel();
        hIniSlidergroup = new javax.swing.JSlider();
        hEndLabel = new javax.swing.JLabel();
        hEndSlidergroup = new javax.swing.JSlider();
        hEndHLabel = new javax.swing.JLabel();
        hIniHLabel = new javax.swing.JLabel();
        addGroupResBotoom = new javax.swing.JButton();
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
        setPreferredSize(new java.awt.Dimension(500, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Aula:");

        jTabbedPane1.setToolTipText("Banejar grup\nBanejar assignatura\nBanejar hora");

        jLabel4.setText("Introdueixi el nom de l'assignatura que vol bloquejar:");

        subjectname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectnameActionPerformed(evt);
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

        hIniSlidersubject.setMaximum(23);
        hIniSlidersubject.setValue(0);
        hIniSlidersubject.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hIniSlidersubjectStateChanged(evt);
            }
        });

        hEndLabel1.setText("Selecciona la darrera hora a bloquejar:");
        hEndLabel1.setToolTipText("");

        hEndSlidersubject.setMaximum(23);
        hEndSlidersubject.setValue(0);
        hEndSlidersubject.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hEndSlidersubjectStateChanged(evt);
            }
        });

        hEndHLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hEndHLabel1.setText("0");
        hEndHLabel1.setToolTipText("");

        hIniHLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hIniHLabel1.setText("0");

        addSubjectResBotoom.setText("Afegir");
        addSubjectResBotoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSubjectResBotoomActionPerformed(evt);
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
                            .addComponent(hEndSlidersubject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hIniSlidersubject, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(hEndLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hIniHLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hEndHLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(addSubjectResBotoom))))
                    .addComponent(jLabel4)
                    .addComponent(subjectname, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hIniLabel1)
                    .addComponent(dEndLabel1)
                    .addComponent(dIniLabel1)
                    .addComponent(dIniBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dEndBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(subjectname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(hIniSlidersubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hIniHLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hEndLabel1)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hEndSlidersubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hEndHLabel1))
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addSubjectResBotoom))))
        );

        jTabbedPane1.addTab("Bloquejar assignatura", jPanel2);

        jLabel3.setText("Introdueixi el numero del grup que vol bloquejar:");

        groupnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupnumActionPerformed(evt);
            }
        });

        dIniLabel.setText("Selecciona el primer dia a bloquejar:");

        dIniBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenje" }));

        dEndLabel.setText("Selecciona el darrer dia a bloquejar:");

        dEndBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenje" }));
        dEndBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dEndBoxActionPerformed(evt);
            }
        });

        hIniLabel.setText("Selecciona la primera hora a bloquejar:");

        hIniSlidergroup.setMaximum(23);
        hIniSlidergroup.setValue(0);
        hIniSlidergroup.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hIniSlidergroupStateChanged(evt);
            }
        });

        hEndLabel.setText("Selecciona la darrera hora a bloquejar:");
        hEndLabel.setToolTipText("");

        hEndSlidergroup.setMaximum(23);
        hEndSlidergroup.setValue(0);
        hEndSlidergroup.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hEndSlidergroupStateChanged(evt);
            }
        });

        hEndHLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hEndHLabel.setText("0");
        hEndHLabel.setToolTipText("");

        hIniHLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hIniHLabel.setText("0");

        addGroupResBotoom.setText("Afegir");
        addGroupResBotoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGroupResBotoomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(groupnum, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hIniLabel)
                    .addComponent(dEndLabel)
                    .addComponent(dIniLabel)
                    .addComponent(dIniBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dEndBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(hIniSlidergroup, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hIniHLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hEndHLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(hEndSlidergroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hEndLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addGroupResBotoom)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(groupnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dIniLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dIniBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dEndLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dEndBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hIniLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(hIniHLabel)
                            .addComponent(hIniSlidergroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(hEndLabel)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hEndSlidergroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hEndHLabel))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addGroupResBotoom))))
        );

        jTabbedPane1.addTab("Bloquejar grup", jPanel1);

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
                .addContainerGap(225, Short.MAX_VALUE))
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backBottom)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        name.setText(clas.getRef());
        this.setSize(500,500);
    }//GEN-LAST:event_formWindowActivated

    private void groupnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_groupnumActionPerformed

    private void dEndBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dEndBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dEndBoxActionPerformed

    private void hIniSlidergroupStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hIniSlidergroupStateChanged
        // TODO add your handling code here:
        hIniHLabel.setText(hIniSlidergroup.getValue()+"");
    }//GEN-LAST:event_hIniSlidergroupStateChanged

    private void hEndSlidergroupStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hEndSlidergroupStateChanged
        // TODO add your handling code here:
        hEndHLabel.setText(hEndSlidergroup.getValue()+"");
    }//GEN-LAST:event_hEndSlidergroupStateChanged

    private void subjectnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectnameActionPerformed

    private void dEndBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dEndBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dEndBox1ActionPerformed

    private void hIniSlidersubjectStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hIniSlidersubjectStateChanged
        // TODO add your handling code here:
        hIniHLabel1.setText(hIniSlidersubject.getValue()+"");
    }//GEN-LAST:event_hIniSlidersubjectStateChanged

    private void dEndBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dEndBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dEndBox2ActionPerformed

    private void hIniSliderHourStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hIniSliderHourStateChanged
        // TODO add your handling code here:
        hIniHLabel2.setText(hIniSliderHour.getValue()+"");
    }//GEN-LAST:event_hIniSliderHourStateChanged

    private void hEndSliderHourStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hEndSliderHourStateChanged
        // TODO add your handling code here:
        hEndHLabel2.setText(hEndSliderHour.getValue()+"");
    }//GEN-LAST:event_hEndSliderHourStateChanged

    private void addSubjectResBotoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSubjectResBotoomActionPerformed
        // TODO add your handling code here:
        String name = subjectname.getText();
        int dIni = Integer.parseInt(dIniBox1.getSelectedIndex()+"");   
        int dEnd = Integer.parseInt(dEndBox1.getSelectedIndex()+"");
        int hIni = Integer.parseInt(hIniHLabel1.getText());
        int hEnd = Integer.parseInt(hEndHLabel1.getText());
        if(name.equals(""))
            JOptionPane.showMessageDialog(this, "S'han d'omplir tots els camps.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else if(!presentationctrl.subjectscontain(name))
            JOptionPane.showMessageDialog(this, "No hi ha cap assignatura amb aquest nom.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else if(!presentationctrl.addResClass(clas, dIni, dEnd, hIni, hEnd, name))
            JOptionPane.showMessageDialog(this, "Ja existeix aquesta restricció.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else presentationctrl.SwitchFromAClassResMtoRM();
            
    }//GEN-LAST:event_addSubjectResBotoomActionPerformed

    private void addGroupResBotoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGroupResBotoomActionPerformed
        // TODO add your handling code here:
        String num = groupnum.getText();
        int dIni = Integer.parseInt(dIniBox.getSelectedIndex()+"");   
        int dEnd = Integer.parseInt(dEndBox.getSelectedIndex()+"");
        int hIni = Integer.parseInt(hIniHLabel.getText());
        int hEnd = Integer.parseInt(hEndHLabel.getText());
        if (dIni > dEnd)
            JOptionPane.showMessageDialog(this, "El darrer día útil ha de\nser el mateix dia o \nposterior al inicial", "Atenció:", JOptionPane.WARNING_MESSAGE);
        if (hIni >= hEnd)
            JOptionPane.showMessageDialog(this, "La darrera hora útil ha de\nser posterior a la primera", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else if (num.equals(""))
            JOptionPane.showMessageDialog(this, "S'han d'omplir tots els camps.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else if (!presentationctrl.isInt(num))
            JOptionPane.showMessageDialog(this, "El numero de grup ha de ser un valor numèric.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else if(!presentationctrl.addResClass(clas, dIni, dEnd, hIni, hEnd, Integer.parseInt(num)))
            JOptionPane.showMessageDialog(this, "Ja existeix aquesta restricció.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else presentationctrl.SwitchFromAClassResMtoRM();
    }//GEN-LAST:event_addGroupResBotoomActionPerformed

    private void addHourResBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHourResBottomActionPerformed
        // TODO add your handling code here:
        int dIni = Integer.parseInt(dIniBox2.getSelectedIndex()+"");   
        int dEnd = Integer.parseInt(dEndBox2.getSelectedIndex()+"");
        int hIni = Integer.parseInt(hIniHLabel2.getText());
        int hEnd = Integer.parseInt(hEndHLabel2.getText());
        if (dIni > dEnd)
            JOptionPane.showMessageDialog(this, "El darrer día útil ha de\nser el mateix dia o \nposterior al inicial", "Atenció:", JOptionPane.WARNING_MESSAGE);
        if (hIni >= hEnd)
            JOptionPane.showMessageDialog(this, "La darrera hora útil ha de\nser posterior a la primera", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else if (!presentationctrl.addResClass(clas, dIni, dEnd, hIni, hEnd))
            JOptionPane.showMessageDialog(this, "Ja existeix aquesta restricció.", "Atenció:", JOptionPane.WARNING_MESSAGE);
        else
            presentationctrl.SwitchFromAClassResMtoRM();
    }//GEN-LAST:event_addHourResBottomActionPerformed

    private void backBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBottomActionPerformed
        // TODO add your handling code here:
        presentationctrl.SwitchFromAClassResMtoRM();
    }//GEN-LAST:event_backBottomActionPerformed

    private void hEndSlidersubjectStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hEndSlidersubjectStateChanged
        // TODO add your handling code here:
        hEndHLabel1.setText(hEndSlidersubject.getValue()+"");
    }//GEN-LAST:event_hEndSlidersubjectStateChanged

    public void setClass(Classroom clas) {
        this.clas = clas;
        name.setText(clas.getRef());
    }

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addGroupResBotoom;
    private javax.swing.JButton addHourResBottom;
    private javax.swing.JButton addSubjectResBotoom;
    private javax.swing.JButton backBottom;
    private javax.swing.JComboBox<String> dEndBox;
    private javax.swing.JComboBox<String> dEndBox1;
    private javax.swing.JComboBox<String> dEndBox2;
    private javax.swing.JLabel dEndLabel;
    private javax.swing.JLabel dEndLabel1;
    private javax.swing.JLabel dEndLabel2;
    private javax.swing.JComboBox<String> dIniBox;
    private javax.swing.JComboBox<String> dIniBox1;
    private javax.swing.JComboBox<String> dIniBox2;
    private javax.swing.JLabel dIniLabel;
    private javax.swing.JLabel dIniLabel1;
    private javax.swing.JLabel dIniLabel2;
    private javax.swing.JTextField groupnum;
    private javax.swing.JLabel hEndHLabel;
    private javax.swing.JLabel hEndHLabel1;
    private javax.swing.JLabel hEndHLabel2;
    private javax.swing.JLabel hEndLabel;
    private javax.swing.JLabel hEndLabel1;
    private javax.swing.JLabel hEndLabel2;
    private javax.swing.JSlider hEndSliderHour;
    private javax.swing.JSlider hEndSlidergroup;
    private javax.swing.JSlider hEndSlidersubject;
    private javax.swing.JLabel hIniHLabel;
    private javax.swing.JLabel hIniHLabel1;
    private javax.swing.JLabel hIniHLabel2;
    private javax.swing.JLabel hIniLabel;
    private javax.swing.JLabel hIniLabel1;
    private javax.swing.JLabel hIniLabel2;
    private javax.swing.JSlider hIniSliderHour;
    private javax.swing.JSlider hIniSlidergroup;
    private javax.swing.JSlider hIniSlidersubject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel name;
    private javax.swing.JTextField subjectname;
    // End of variables declaration//GEN-END:variables
}
