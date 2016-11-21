/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import PersonClass.Customer;
import PersonClass.Receptionist;
import PetClass.Cat;
import PetClass.Dog;
import PetClass.Hamster;
import PetClass.Lizard;
import PetClass.Rabbit;
import static Screens.ReceptionistMenu.CustomerList;
import Validators.EmailValidator;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Chin
 */
public class CustomerInfo extends javax.swing.JFrame implements Serializable {

    private EmailValidator emailValidator;
    
    private ReceptionistMenu MainReceptionistMenu;

    private String CustomerID;

    public CustomerInfo() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        emailValidator = new EmailValidator();
    }

    public CustomerInfo(ReceptionistMenu rep, String cusID, String F_Name, String L_name, String Gender, String Address,
            String ContactNo, String Email, String DOB) {

        this.MainReceptionistMenu = rep;
        this.CustomerID = cusID;
        emailValidator = new EmailValidator();
        initComponents();
        firstN_tf.setText(F_Name);
        lastN_tf.setText(L_name);
        if (Gender.equals("Female")) {
            female_rb.setSelected(true);
        } else {
            male_rb.setSelected(true);
        }
        address_tf.setText(Address);
        contactNo_tf.setText(ContactNo);
        email_tf.setText(Email);
        dob_tf.setText(DOB);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public CustomerInfo(ReceptionistMenu r) {
        this.MainReceptionistMenu = r;
        emailValidator = new EmailValidator();
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void showRegisterFrame() {
        next_btn.setVisible(true);
        done_btn.setVisible(false);
    }

    public void showEditFrame() {
        next_btn.setVisible(false);
        done_btn.setVisible(true);
    }

    public String checkGender() {
        String gender;
        if (female_rb.isSelected() == true) {
            gender = "Female";
        } else {
            gender = "Male";
        }
        return gender;
    }

    public boolean checkEmpty() {
        boolean b = true;

        if (firstN_tf.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill in customer's first name.", "Empty Text Box", JOptionPane.INFORMATION_MESSAGE);
        } else if (lastN_tf.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill in customer's last name.", "Empty Text Box", JOptionPane.INFORMATION_MESSAGE);
        } else if (gender_bg.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Please select the customer's gender.", "Empty Selection", JOptionPane.INFORMATION_MESSAGE);
        } else if (address_tf.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill in customer's address.", "Empty Text Box", JOptionPane.INFORMATION_MESSAGE);
        } else if (dob_tf.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill in customer's date of birth.", "Empty Text Box", JOptionPane.INFORMATION_MESSAGE);
        } else if (contactNo_tf.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill in customer's contact number.", "Empty Text Box", JOptionPane.INFORMATION_MESSAGE);
        } else if (email_tf.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill in customer's email address.", "Empty Text Box", JOptionPane.INFORMATION_MESSAGE);
        } else {
            b = false;
        }
        return b;
    }

    public boolean validateEmail(){
        boolean x=false;
        x=emailValidator.validate(email_tf.getText());
        if(!x){
            JOptionPane.showMessageDialog(this, "Please enter a valid email !","Invalid Input",JOptionPane.ERROR_MESSAGE);
        }
        return x;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        gender_bg = new javax.swing.ButtonGroup();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        firstN_tf = new javax.swing.JTextField();
        next_btn = new javax.swing.JButton();
        lastN_tf = new javax.swing.JTextField();
        cancel_btn = new javax.swing.JButton();
        dob_tf = new javax.swing.JTextField();
        male_rb = new javax.swing.JRadioButton();
        email_tf = new javax.swing.JTextField();
        female_rb = new javax.swing.JRadioButton();
        contactNo_tf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        address_tf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        done_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Info");

        jLabel6.setText("Contact No:");

        jLabel7.setText("Date of Birth:");

        firstN_tf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        next_btn.setText("Next");
        next_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_btnActionPerformed(evt);
            }
        });

        cancel_btn.setText("Cancel");
        cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btnActionPerformed(evt);
            }
        });

        dob_tf.setToolTipText("dd/MM/yyyy");

        gender_bg.add(male_rb);
        male_rb.setText("Male");

        email_tf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        gender_bg.add(female_rb);
        female_rb.setText("Female");

        jLabel1.setText("First Name:");

        jLabel2.setText("Last Name:");

        jLabel8.setText("Address:");

        jLabel3.setText("Email:");

        jLabel4.setText("Gender:");

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
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(firstN_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lastN_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(female_rb, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(male_rb))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(address_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(dob_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(contactNo_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(email_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(next_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(done_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(firstN_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(lastN_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4))
                    .addComponent(female_rb)
                    .addComponent(male_rb))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(address_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(dob_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(contactNo_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(email_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(next_btn)
                    .addComponent(done_btn)
                    .addComponent(cancel_btn))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void next_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_btnActionPerformed
        String FirstName;
        String LastName;
        String Gender;
        String Address;
        String DOB;
        String ContactNo;
        String Email;

        boolean Empty = checkEmpty();
        boolean Vemail= validateEmail();
        if ((!Empty)&&Vemail) {
            FirstName = firstN_tf.getText();
            LastName = lastN_tf.getText();
            Gender = checkGender();
            Address = address_tf.getText();
            DOB = dob_tf.getText();
            ContactNo = contactNo_tf.getText();
            Email = email_tf.getText();
            this.setVisible(false);

            PetInfo p = new PetInfo(MainReceptionistMenu, FirstName, LastName, Gender, Address, DOB, ContactNo, Email);
            p.showRegisterFrame();
            p.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_next_btnActionPerformed

    private void cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancel_btnActionPerformed

    private void done_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_done_btnActionPerformed
        boolean b = checkEmpty();
        boolean Vemail= validateEmail();
        if ((!b)&&Vemail) {
            Receptionist r = new Receptionist();
            r.overwriteCustomer(CustomerList, CustomerID, firstN_tf.getText(), lastN_tf.getText(), checkGender(),
                    address_tf.getText(), contactNo_tf.getText(), email_tf.getText(), dob_tf.getText());

            MainReceptionistMenu.refreshTable();
            this.dispose();
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
            java.util.logging.Logger.getLogger(CustomerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address_tf;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancel_btn;
    private javax.swing.JTextField contactNo_tf;
    private javax.swing.JTextField dob_tf;
    private javax.swing.JButton done_btn;
    private javax.swing.JTextField email_tf;
    private javax.swing.JRadioButton female_rb;
    private javax.swing.JTextField firstN_tf;
    private javax.swing.ButtonGroup gender_bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField lastN_tf;
    private javax.swing.JRadioButton male_rb;
    private javax.swing.JButton next_btn;
    // End of variables declaration//GEN-END:variables
}
