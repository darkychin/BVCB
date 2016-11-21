/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import BusinessClass.Appointment;
import BusinessClass.RotaTable;
import PersonClass.Receptionist;
import PersonClass.Vet;
import static Screens.ReceptionistMenu.AppointmentList;
import static Screens.ReceptionistMenu.VetList;
import com.sun.javafx.collections.VetoableListDecorator;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Chin
 */
public class AppointmentInfo extends javax.swing.JFrame implements Serializable {

    private String AppID;
    private String CusID;
    private String CusName;
    private String PetID;
    private String PetName;
    private String VetID;

    private List<String> VetNameList = new ArrayList<>();

    public AppointmentInfo() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public AppointmentInfo(String AppID, String cus_ID, String cus_name, String pet_ID, String pet_name, String Vet, String Date, String Time) {
        this.AppID = AppID;
        this.CusID = cus_ID;
        this.PetID = pet_ID;

        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        generateForm();
        generateCB();
        ownerN_tf.setText(cus_name);
        petN_tf.setText(pet_name);
        vet_cb.setSelectedItem(Vet);
        returnVetID();
        date_tf.setText(Date);
        time_cb.setSelectedItem(Time);

    }

    public AppointmentInfo(String cus_ID, String cus_name, String pet_ID, String pet_name) {

        this.CusID = cus_ID;
        this.CusName = cus_name;
        this.PetID = pet_ID;
        this.PetName = pet_name;
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        generateForm();
        generateCB();
    }

    private void generateForm() {
        ownerN_tf.setText(CusName);
        petN_tf.setText(PetName);

        switch (PetID.charAt(0)) {
            case 'C':
                species_tf.setText("Cat");
                break;
            case 'D':
                species_tf.setText("Dog");
                break;
            case 'H':
                species_tf.setText("Hamster");
                break;
            case 'L':
                species_tf.setText("Lizard");
                break;
            case 'R':
                species_tf.setText("Rabbit");
                break;
            default:
                JOptionPane.showMessageDialog(this, "Pet ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generateCB() {
        vet_cb.setEnabled(true);
        getCBList();
        vet_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameList.toArray()));
    }

    private void getCBList() {
        for (Vet vet : VetList) {
            Vet temp_vet = vet;
            if (temp_vet.getExp1().equals(species_tf.getText()) || temp_vet.getExp2().equals(species_tf.getText())) {
                VetNameList.add(temp_vet.getName());
            }
        }
    }

    private boolean checkEmpty() {
        if (date_tf.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter appointment date.");
            return true;
        } else {
            return false;
        }
    }

    private boolean checkAppTime() {
        String vet_name = vet_cb.getSelectedItem().toString();
        String date = date_tf.getText();
        String time = time_cb.getSelectedItem().toString();
        boolean x = true;
        for (Appointment app : AppointmentList) {
            Appointment temp_app = app;
            if (temp_app.getAppVetName().equals(vet_name) && temp_app.getAppDate().equals(date) && temp_app.getAppTime().equals(time)) {
                x = false;
                JOptionPane.showMessageDialog(this, "The appointment date and time is reserved.\nPlease select another date and time or change selected vet.", "Reserved Appoinment", JOptionPane.INFORMATION_MESSAGE);
            } else {
                x = true;
            }
        }
        return x;
    }

    private void returnVetID() {
        for (Vet vet : VetList) {
            Vet temp_vet = vet;
            if (temp_vet.getName().equals(vet_cb.getSelectedItem().toString())) {
                VetID = temp_vet.getVetID();
            }
        }
    }

    public void showCreateApp() {
        makeAppointment_btn.setVisible(true);
        done_btn.setVisible(false);
    }

    public void showEditApp() {
        done_btn.setVisible(true);
        makeAppointment_btn.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        time_cb = new javax.swing.JComboBox();
        vet_cb = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        makeAppointment_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ownerN_tf = new javax.swing.JTextField();
        petN_tf = new javax.swing.JTextField();
        cancel_btn = new javax.swing.JButton();
        species_tf = new javax.swing.JTextField();
        date_tf = new javax.swing.JTextField();
        done_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Appointment Info");

        jLabel6.setText("Species:");

        jLabel4.setText("Date:");

        jLabel5.setText("Time:");

        time_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09:00 AM - 10:00 AM", "10:00 AM - 11:00 AM", "11:00 AM - 12:00 PM", "12:00 PM - 01:00 PM", "01:00 PM - 02:00 PM", "02:00 PM - 03:00 PM", "03:00 PM - 04:00 PM", "04:00 AM - 05:00 PM", "05:00 AM - 06:00 PM", "06:00 AM - 07:00 PM" }));

        vet_cb.setEnabled(false);

        jLabel1.setText("Vet:");

        makeAppointment_btn.setText("Make Appointment");
        makeAppointment_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeAppointment_btnActionPerformed(evt);
            }
        });

        jLabel2.setText("Owner Name:");

        jLabel3.setText("Pet Name:");
        jLabel3.setToolTipText("");

        ownerN_tf.setEditable(false);

        petN_tf.setEditable(false);

        cancel_btn.setText("Cancel");
        cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btnActionPerformed(evt);
            }
        });

        species_tf.setEditable(false);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(36, 36, 36))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(39, 39, 39)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(42, 42, 42)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(time_cb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vet_cb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(petN_tf)
                            .addComponent(ownerN_tf)
                            .addComponent(species_tf)
                            .addComponent(date_tf))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(makeAppointment_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(cancel_btn)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(done_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancel_btn, makeAppointment_btn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ownerN_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(petN_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(species_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(date_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(time_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vet_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(done_btn)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(makeAppointment_btn)
                    .addComponent(cancel_btn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancel_btnActionPerformed

    private void makeAppointment_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeAppointment_btnActionPerformed
            returnVetID();
            if (checkEmpty() == false) {
                if (checkAppTime() == true) {
                    Receptionist rep = new Receptionist();
                    rep.createApp(AppointmentList, CusID, CusName, PetID, PetName, date_tf.getText(), time_cb.getSelectedItem().toString(), VetID, vet_cb.getSelectedItem().toString());
                    JOptionPane.showMessageDialog(this, "The appointment is successfully made.", "Reserved Appointment", JOptionPane.PLAIN_MESSAGE);
                    this.dispose();
                }
            }
    }//GEN-LAST:event_makeAppointment_btnActionPerformed

    private void done_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_done_btnActionPerformed
        try {
            returnVetID();
            if (checkEmpty() == false) {
                if (checkAppTime() == true) {
                    Receptionist rep = new Receptionist();
                    rep.overwriteApp(AppointmentList, AppID, PetID, date_tf.getText(), time_cb.getSelectedItem().toString(), VetID, vet_cb.getSelectedItem().toString());
                    JOptionPane.showMessageDialog(this, "The appointment is successfully edited.", "Edit Appointment", JOptionPane.PLAIN_MESSAGE);
                    this.dispose();
                }
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Fees field has wrong input!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_done_btnActionPerformed

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
            java.util.logging.Logger.getLogger(AppointmentInfo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentInfo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentInfo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentInfo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_btn;
    private javax.swing.JTextField date_tf;
    private javax.swing.JButton done_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton makeAppointment_btn;
    private javax.swing.JTextField ownerN_tf;
    private javax.swing.JTextField petN_tf;
    private javax.swing.JTextField species_tf;
    private javax.swing.JComboBox time_cb;
    private javax.swing.JComboBox vet_cb;
    // End of variables declaration//GEN-END:variables
}
