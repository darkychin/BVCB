/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import BusinessClass.Boarding;
import BusinessClass.Consultation;
import PersonClass.Vet;
import static Screens.VetMenu.ConsultList;
import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Chin
 */
public class ConsultationForm extends javax.swing.JFrame implements Serializable {

    private VetMenu MainVetMenu;
    private String VetID;

    public ConsultationForm() {
        initComponents();
    }

    public ConsultationForm(VetMenu vm, String appoinmentID, String vetID, String petID, String petName,
            String prognosis, String diagnosis, String sicklvl, int fees) {
        this.MainVetMenu = vm;
        this.VetID = vetID;
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        appID_tf.setText(appoinmentID);
        petID_tf.setText(petID);
        petName_tf.setText(petName);
        species_tf.setText(checkSpecies(petID));
        prog_ta.setText(prognosis);
        diag_ta.setText(diagnosis);
        sicklvl_cb.setSelectedItem(sicklvl);
        fees_tf.setText(Integer.toString(fees));
    }

    public ConsultationForm(VetMenu vm, String appoinmentID, String vetID, String petID, String petName) {
        this.MainVetMenu = vm;
        this.VetID = vetID;
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        appID_tf.setText(appoinmentID);
        petID_tf.setText(petID);
        petName_tf.setText(petName);
        species_tf.setText(checkSpecies(petID));
    }

    public void showCreateCons() {
        save_btn.setVisible(true);
        done_btn.setVisible(false);
    }

    public void showEditCons() {
        save_btn.setVisible(false);
        done_btn.setVisible(true);
    }

    public void showViewCons() {
        save_btn.setVisible(false);
        done_btn.setVisible(false);
        prog_ta.setEditable(false);
        diag_ta.setEditable(false);
        sicklvl_cb.setEditable(false);
        fees_tf.setEditable(false);
    }

    public void updateSicklvl() {
        for (Boarding board : VetMenu.BoardingList) {
            if (board.getPetID().equals(petID_tf.getText())) {
                board.setSicknesslvl(sicklvl_cb.getSelectedItem().toString());
            }
            board.writeList(VetMenu.BoardingList);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        sicklvl_cb = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        fees_tf = new javax.swing.JTextField();
        save_btn = new javax.swing.JButton();
        cancel_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        prog_ta = new javax.swing.JTextArea();
        appID_tf = new javax.swing.JTextField();
        petID_tf = new javax.swing.JTextField();
        petName_tf = new javax.swing.JTextField();
        species_tf = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        diag_ta = new javax.swing.JTextArea();
        done_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pet ID:");

        jLabel2.setText("Pet Name:");

        jLabel3.setText("Prognosis:");

        jLabel4.setText("Species:");

        jLabel5.setText("Diagnosis:");

        jLabel6.setText("Fees:");

        jLabel7.setText("Sickness Level:");

        sicklvl_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Level 1", "Level 2", "Level 3" }));

        jLabel8.setText("Appointment ID:");

        save_btn.setText("Save Consultation");
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });

        cancel_btn.setText("Cancel");
        cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btnActionPerformed(evt);
            }
        });

        prog_ta.setColumns(20);
        prog_ta.setRows(5);
        jScrollPane1.setViewportView(prog_ta);

        appID_tf.setEditable(false);

        petID_tf.setEditable(false);

        petName_tf.setEditable(false);

        species_tf.setEditable(false);

        diag_ta.setColumns(20);
        diag_ta.setRows(5);
        jScrollPane2.setViewportView(diag_ta);

        done_btn.setText("Done");
        done_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                done_btnActionPerformed(evt);
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
                        .addComponent(save_btn)
                        .addGap(18, 18, 18)
                        .addComponent(done_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(cancel_btn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel8)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(petName_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(species_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sicklvl_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fees_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(appID_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(petID_tf))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancel_btn, done_btn, save_btn});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {appID_tf, fees_tf, petID_tf, petName_tf, sicklvl_cb, species_tf});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(appID_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(petID_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(petName_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(species_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sicklvl_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fees_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_btn)
                    .addComponent(cancel_btn)
                    .addComponent(done_btn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        try {
            Vet vet = new Vet();
            vet.saveCons(ConsultList, appID_tf.getText(), VetID, petID_tf.getText(), prog_ta.getText(), diag_ta.getText(),
                    sicklvl_cb.getSelectedItem().toString(), Integer.parseInt(fees_tf.getText()));
            updateSicklvl();
            this.dispose();
            MainVetMenu.refreshTable();
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Fees field has wrong input !", "Input Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_save_btnActionPerformed

    private void done_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_done_btnActionPerformed
        try {
            Vet vet = new Vet();
            vet.overwriteCons(ConsultList, appID_tf.getText(), prog_ta.getText(), diag_ta.getText(),
                    sicklvl_cb.getSelectedItem().toString(), Integer.parseInt(fees_tf.getText()));
            updateSicklvl();
            this.dispose();
            MainVetMenu.refreshTable();
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Fees field has wrong input !", "Input Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_done_btnActionPerformed

    private void cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancel_btnActionPerformed

    private String checkSpecies(String petID) {
        String string = "";
        switch (petID.charAt(0)) {
            case 'C':
                return string = "Cat";

            case 'D':
                return string = "Dog";

            case 'H':
                return string = "Hamster";

            case 'L':
                return string = "Lizard";

            case 'R':
                return string = "Rabbit";

        }
        return string;
    }

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
            java.util.logging.Logger.getLogger(ConsultationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField appID_tf;
    private javax.swing.JButton cancel_btn;
    private javax.swing.JTextArea diag_ta;
    private javax.swing.JButton done_btn;
    private javax.swing.JTextField fees_tf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField petID_tf;
    private javax.swing.JTextField petName_tf;
    private javax.swing.JTextArea prog_ta;
    private javax.swing.JButton save_btn;
    private javax.swing.JComboBox sicklvl_cb;
    private javax.swing.JTextField species_tf;
    // End of variables declaration//GEN-END:variables
}
