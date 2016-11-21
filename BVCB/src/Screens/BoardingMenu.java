/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import BusinessClass.Boarding;
import PersonClass.BoardingStaff;
import PetClass.Cat;
import PetClass.Dog;
import PetClass.Hamster;
import PetClass.Lizard;
import PetClass.Rabbit;
import java.awt.GraphicsConfiguration;
import java.util.LinkedList;
import java.util.List;
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Chin
 */
public class BoardingMenu extends javax.swing.JFrame implements Serializable {

    private List<Boarding> BoardingList = new LinkedList<>();

    private String BoardingID;

    private DefaultTableModel model;

    private DateTimeFormatter fmt = DateTimeFormat.forPattern("HH : mm");

    public BoardingMenu() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        model = (DefaultTableModel) boarding_tb.getModel();
        populateList();
        generateTable(model);
    }

    private void populateList() {
        File f = null;

        Boarding boarding = new Boarding();
        f = new File("Boarding.dat");
        if (f.exists() && (f.length() != 0)) {
            boarding.readList(BoardingList);
        } else {
            boarding.writeList(BoardingList);
            boarding.readList(BoardingList);
            JOptionPane.showMessageDialog(this, "The boarding list is empty.", "Empty Boarding File", JOptionPane.ERROR_MESSAGE);
        }
        f = new File("Boarding Counter.txt");
        if (!f.exists()) {
            boarding.writeCounter(0);
        }

    }

    private void generateTable(DefaultTableModel model) {
        int i = 0;

        if (species_cb.getSelectedItem().toString().equals("Cat")) {
            for (Boarding boarding : BoardingList) {
                if (boarding.getSpecies().equals("Cat")) {
                    i++;
                    model.addRow(new Object[]{i, boarding.getBoardingID(), boarding.getPetName(), boarding.getSicknesslvl(), boarding.getStatus(), boarding.getL_Fed()});
                }
            }
        } else if (species_cb.getSelectedItem().toString().equals("Dog")) {
            for (Boarding boarding : BoardingList) {
                if (boarding.getSpecies().equals("Dog")) {
                    i++;
                    model.addRow(new Object[]{i, boarding.getBoardingID(), boarding.getPetName(), boarding.getSicknesslvl(), boarding.getStatus(), boarding.getL_Fed()});
                }
            }
        } else if (species_cb.getSelectedItem().toString().equals("Hamster")) {
            for (Boarding boarding : BoardingList) {
                if (boarding.getSpecies().equals("Hamster")) {
                    i++;
                    model.addRow(new Object[]{i, boarding.getBoardingID(), boarding.getPetName(), boarding.getSicknesslvl(), boarding.getStatus(), boarding.getL_Fed()});
                }
            }
        } else if (species_cb.getSelectedItem().toString().equals("Lizard")) {
            for (Boarding boarding : BoardingList) {
                if (boarding.getSpecies().equals("Lizard")) {
                    i++;
                    model.addRow(new Object[]{i, boarding.getBoardingID(), boarding.getPetName(), boarding.getSicknesslvl(), boarding.getStatus(), boarding.getL_Fed()});
                }
            }
        } else {
            for (Boarding boarding : BoardingList) {
                if (boarding.getSpecies().equals("Rabbit")) {
                    i++;
                    model.addRow(new Object[]{i, boarding.getBoardingID(), boarding.getPetName(), boarding.getSicknesslvl(), boarding.getStatus(), boarding.getL_Fed()});
                }
            }
        }
    }

    public void clearTable(DefaultTableModel model) {
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
    }

    public void fillForm(String boardingID) {
        try {
            for (Boarding board : BoardingList) {
                if (boardingID.equals(board.getBoardingID())) {
                    boardID_tf.setText(boardingID);
                    ownN_tf.setText(board.getCusName());
                    petID_tf.setText(board.getPetID());
                    petN_tf.setText(board.getPetName());
                    allergy_tf.setText(board.getAllergies());
                    status_cb.setSelectedItem(board.getStatus());
                    lastFed_tf.setText(board.getL_Fed().toString());
                }
            }
        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(this, "Please update the fed time.");
        }
    }

    public BoardingMenu(GraphicsConfiguration gc) {
        super(gc);
    }

    public void clearList() {
        BoardingList.clear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        species_cb = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        logout_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        boarding_tb = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ownN_tf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        petN_tf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        boardID_tf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        status_cb = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        lastFed_tf = new javax.swing.JTextField();
        feed_btn = new javax.swing.JButton();
        save_btn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        allergy_tf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        petID_tf = new javax.swing.JTextField();
        deleteBD_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Boarding Menu");

        species_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cat", "Dog", "Hamster", "Lizard", "Rabbit" }));
        species_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                species_cbActionPerformed(evt);
            }
        });

        jLabel1.setText("Species:");

        logout_btn.setText("Log Out");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        boarding_tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cell No.", "Boarding ID", "Pet Name", "Sickness Level", "Current Status", "Last Fed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        boarding_tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boarding_tbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(boarding_tb);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Owner Name:");

        ownN_tf.setEditable(false);

        jLabel3.setText("Pet Name:");

        petN_tf.setEditable(false);

        jLabel4.setText("Boarding ID:");

        boardID_tf.setEditable(false);

        jLabel5.setText("Status:");

        status_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Healthy", "Normal", "Sick", "Danger" }));

        jLabel6.setText("Last Fed:");

        lastFed_tf.setEditable(false);

        feed_btn.setText("Feed Pet");
        feed_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feed_btnActionPerformed(evt);
            }
        });

        save_btn.setText("Save");
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });

        jLabel7.setText("Allergies:");

        allergy_tf.setEditable(false);

        jLabel8.setText("Pet ID:");

        petID_tf.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(feed_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ownN_tf)
                            .addComponent(petN_tf)
                            .addComponent(boardID_tf)
                            .addComponent(allergy_tf)
                            .addComponent(status_cb, 0, 127, Short.MAX_VALUE)
                            .addComponent(lastFed_tf)
                            .addComponent(petID_tf))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {feed_btn, save_btn});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(boardID_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ownN_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(petID_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(petN_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(allergy_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(status_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastFed_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_btn)
                    .addComponent(feed_btn))
                .addContainerGap())
        );

        deleteBD_btn.setText("Delete Boarding");
        deleteBD_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBD_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(species_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(logout_btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteBD_btn))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteBD_btn, logout_btn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(species_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logout_btn)
                    .addComponent(deleteBD_btn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        Login L = new Login();
        L.setVisible(true);
        this.dispose();
        clearList();
    }//GEN-LAST:event_logout_btnActionPerformed

    private void species_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_species_cbActionPerformed
        clearTable(model);
        generateTable(model);
    }//GEN-LAST:event_species_cbActionPerformed

    private void boarding_tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boarding_tbMouseClicked
        BoardingID = model.getValueAt(boarding_tb.getSelectedRow(), 1).toString();
        fillForm(BoardingID);
    }//GEN-LAST:event_boarding_tbMouseClicked

    private void feed_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feed_btnActionPerformed
        LocalTime now = new LocalTime();
        lastFed_tf.setText(now.toString(fmt));
    }//GEN-LAST:event_feed_btnActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        BoardingStaff bs = new BoardingStaff();
        bs.overwriteBoarding(BoardingList, BoardingID, lastFed_tf.getText(), status_cb.getSelectedItem().toString());
        clearTable(model);
        generateTable(model);
    }//GEN-LAST:event_save_btnActionPerformed

    private void deleteBD_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBD_btnActionPerformed
        try {
            BoardingStaff bs = new BoardingStaff();
            bs.deleteBoarding(BoardingList, BoardingID);
            clearTable(model);
            generateTable(model);
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(this, "Please select a pet to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteBD_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BoardingMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoardingMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoardingMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoardingMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BoardingMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField allergy_tf;
    private javax.swing.JTextField boardID_tf;
    private javax.swing.JTable boarding_tb;
    private javax.swing.JButton deleteBD_btn;
    private javax.swing.JButton feed_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastFed_tf;
    private javax.swing.JButton logout_btn;
    private javax.swing.JTextField ownN_tf;
    private javax.swing.JTextField petID_tf;
    private javax.swing.JTextField petN_tf;
    private javax.swing.JButton save_btn;
    private javax.swing.JComboBox species_cb;
    private javax.swing.JComboBox status_cb;
    // End of variables declaration//GEN-END:variables
}
