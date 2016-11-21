/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import BusinessClass.Boarding;
import PersonClass.Customer;
import PersonClass.Receptionist;
import PetClass.Cat;
import PetClass.Dog;
import PetClass.Hamster;
import PetClass.Lizard;
import PetClass.Rabbit;
import static Screens.ReceptionistMenu.BoardingList;
import static Screens.ReceptionistMenu.CatList;
import static Screens.ReceptionistMenu.CustomerList;
import static Screens.ReceptionistMenu.DogList;
import static Screens.ReceptionistMenu.HamsterList;
import static Screens.ReceptionistMenu.LizardList;
import static Screens.ReceptionistMenu.RabbitList;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Chin
 */
public class PetInfo extends javax.swing.JFrame implements Serializable {

    private String OwnerID, OwnFirstName, OwnLastName, OwnGender, OwnAddress, OwnDOB, OwnContactNo, OwnEmail;

    private String PetID;

    private ReceptionistMenu MainReceptionistMenu;

    public PetInfo() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    //the constructor that handle registration of 2nd and more pet
    public PetInfo(ReceptionistMenu repMenu, String CusID, String Cus_Name) {

        this.MainReceptionistMenu = repMenu;
        this.OwnerID = CusID;

        initComponents();
        ownerN_tf.setText(Cus_Name);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    //the constructor that handle registration of first-time customer
    public PetInfo(ReceptionistMenu repMenu, String OwnFirstName, String OwnLastName, String OwnGender, String OwnAddress, String OwnDOB, String OwnContactNo, String OwnEmail) {

        this.MainReceptionistMenu = repMenu;

        this.OwnFirstName = OwnFirstName;
        this.OwnLastName = OwnLastName;
        this.OwnGender = OwnGender;
        this.OwnAddress = OwnAddress;
        this.OwnDOB = OwnDOB;
        this.OwnContactNo = OwnContactNo;
        this.OwnEmail = OwnEmail;

        initComponents();
        ownerN_tf.setText(this.OwnLastName + " " + this.OwnFirstName);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    //the constructor that handle edit pet data
    public PetInfo(ReceptionistMenu repMenu, String OwnerName, String petID,
            String PetName, String Sex, String Species, int PetAge, String Allergies, boolean Boarding) {
        this.MainReceptionistMenu = repMenu;
        this.PetID = petID;

        initComponents();
        ownerN_tf.setText(OwnerName);
        petN_tf.setText(PetName);

        if (Sex.equals("Female")) {
            female_rb.setSelected(true);
        } else {
            male_rb.setSelected(true);
        }

        if (Species.equals("Cat")) {
            species_cb.setSelectedItem("Cat");
        } else if (Species.equals("Dog")) {
            species_cb.setSelectedItem("Dog");
        } else if (Species.equals("Hamster")) {
            species_cb.setSelectedItem("Hamster");
        } else if (Species.equals("Lizard")) {
            species_cb.setSelectedItem("Lizard");
        } else {
            species_cb.setSelectedItem("Rabbit");
        }

        petAge_tf.setText(Integer.toString(PetAge));
        allergies_tf.setText(Allergies);

        if (Boarding == true) {
            boarding_cb.setSelectedIndex(0);
        } else {
            boarding_cb.setSelectedIndex(1);
        }
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void showRegisterFrame() {
        registerAll_btn.setVisible(true);
        addPet_btn.setVisible(false);
        done_btn.setVisible(false);
    }

    public void showEditFrame() {
        registerAll_btn.setVisible(false);
        addPet_btn.setVisible(false);
        done_btn.setVisible(true);
    }

    public void showAddPetFrame() {
        registerAll_btn.setVisible(false);
        addPet_btn.setVisible(true);
        done_btn.setVisible(false);
    }

    public boolean checkEmpty() {
        boolean b = true;

        if (petN_tf.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill in pet's name.", "Empty Text Box", JOptionPane.INFORMATION_MESSAGE);
        } else if (sex_bg.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Please select pet's sex.", "Empty Selectiom", JOptionPane.INFORMATION_MESSAGE);
        } else if (petAge_tf.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill in pet's age.", "Empty Selection", JOptionPane.INFORMATION_MESSAGE);
        } else {
            b = false;
        }
        return b;
    }

    public String checkSex() {
        String pet_sex;
        if (female_rb.isSelected() == true) {
            pet_sex = "Female";
        } else {
            pet_sex = "Male";
        }
        return pet_sex;
    }

    public boolean checkBoarding() {
        boolean board_stat;
        if (boarding_cb.getSelectedItem().toString().equals("Yes")) {
            board_stat = true;
        } else {
            board_stat = false;
        }
        return board_stat;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sex_bg = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        registerAll_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cancel_btn = new javax.swing.JButton();
        male_rb = new javax.swing.JRadioButton();
        species_cb = new javax.swing.JComboBox();
        female_rb = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        boarding_cb = new javax.swing.JComboBox();
        petN_tf = new javax.swing.JTextField();
        petAge_tf = new javax.swing.JTextField();
        allergies_tf = new javax.swing.JTextField();
        ownerN_tf = new javax.swing.JTextField();
        done_btn = new javax.swing.JButton();
        addPet_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pet Info");

        jLabel1.setText("Owner Name:");

        jLabel6.setText("Allergies:");

        jLabel2.setText("Pet Name:");

        jLabel7.setText("Age:");

        jLabel8.setText("Species:");

        registerAll_btn.setText("Register All");
        registerAll_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerAll_btnActionPerformed(evt);
            }
        });

        jLabel4.setText("Sex:");

        cancel_btn.setText("Cancel");
        cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btnActionPerformed(evt);
            }
        });

        sex_bg.add(male_rb);
        male_rb.setText("Male");

        species_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cat", "Dog", "Hamster", "Lizard", "Rabbit" }));

        sex_bg.add(female_rb);
        female_rb.setText("Female");

        jLabel3.setText("Boarding:");

        boarding_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));

        allergies_tf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        ownerN_tf.setEditable(false);

        done_btn.setText("Done");
        done_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                done_btnActionPerformed(evt);
            }
        });

        addPet_btn.setText("AddPet");
        addPet_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPet_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(female_rb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(male_rb))
                    .addComponent(petN_tf)
                    .addComponent(petAge_tf)
                    .addComponent(allergies_tf)
                    .addComponent(species_cb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boarding_cb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ownerN_tf))
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addPet_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerAll_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(done_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancel_btn, done_btn, registerAll_btn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ownerN_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(petN_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(male_rb)
                    .addComponent(female_rb)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(species_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(petAge_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(allergies_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boarding_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(addPet_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerAll_btn)
                    .addComponent(cancel_btn)
                    .addComponent(done_btn))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancel_btnActionPerformed

    private void registerAll_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerAll_btnActionPerformed
        boolean a = checkEmpty();
        try {
            if (!a) {
                Receptionist r = new Receptionist();
                OwnerID = r.createCustomer(CustomerList, OwnFirstName, OwnLastName, OwnGender, OwnAddress, OwnContactNo, OwnEmail, OwnDOB);

                String Sex = checkSex();
                boolean Boarding = checkBoarding();
                String Species = species_cb.getSelectedItem().toString();

                String PetID = r.createPet(CatList, DogList, HamsterList, LizardList, RabbitList,
                        OwnerID, petN_tf.getText(), Sex, Species, Integer.parseInt(petAge_tf.getText()), allergies_tf.getText(), Boarding);

                if (Boarding == true) {
                    r.createBoarding(BoardingList, OwnerID, ownerN_tf.getText(), PetID, petN_tf.getText(), Species, allergies_tf.getText(), "Level 1");
                } else {
                    r.deleteBoarding(BoardingList, PetID);
                }
                MainReceptionistMenu.refreshTable();
                this.dispose();
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Please enter number only into age text field.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_registerAll_btnActionPerformed

    private void done_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_done_btnActionPerformed
        boolean b = checkEmpty();
        String species = species_cb.getSelectedItem().toString();
        boolean x = false;
        try {
            if (!b) {
                //int Pet_Counter, String PetName, String Sex, String Species, int PetAge, String Allergies,boolean Boarding)

                Receptionist r = new Receptionist();

                r.overwritePet(CatList, DogList, HamsterList, LizardList, RabbitList,
                        PetID, petN_tf.getText(), checkSex(), species,
                        Integer.parseInt(petAge_tf.getText()), allergies_tf.getText(), checkBoarding());

                if (checkBoarding() == true) {
                    for (Boarding onboard : BoardingList) {
                        if (!onboard.getPetID().equals(PetID)) {
                            x = true;
                        } else {
                            x = false;
                        }
                    }
                    if (x) {
                        r.createBoarding(BoardingList, OwnerID, ownerN_tf.getText(), PetID, petN_tf.getText(), species, allergies_tf.getText(), "Level 1");
                    } else {
                        r.deleteBoarding(BoardingList, PetID);
                        r.createBoarding(BoardingList, OwnerID, ownerN_tf.getText(), PetID, petN_tf.getText(), species, allergies_tf.getText(), "Level 1");
                    }
                } else {
                    r.deleteBoarding(BoardingList, PetID);
                }

                MainReceptionistMenu.refreshTable();
                this.dispose();
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Please enter number only into age text field.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_done_btnActionPerformed

    private void addPet_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPet_btnActionPerformed
        boolean a = checkEmpty();
        try {
            if (!a) {
                Receptionist r = new Receptionist();
                String Sex = checkSex();
                boolean Boarding = checkBoarding();
                String Species = species_cb.getSelectedItem().toString();

                PetID = r.createPet(CatList, DogList, HamsterList, LizardList, RabbitList,
                        OwnerID, petN_tf.getText(), Sex, Species, Integer.parseInt(petAge_tf.getText()), allergies_tf.getText(), Boarding);

                if (Boarding == true) {
                    r.createBoarding(BoardingList, OwnerID, ownerN_tf.getText(), PetID, petN_tf.getText(), Species, allergies_tf.getText(), "Level 1");
                } else {
                    r.deleteBoarding(BoardingList, PetID);
                }
                MainReceptionistMenu.refreshTable();
                this.dispose();

            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Please enter number only into age text field.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_addPet_btnActionPerformed

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
            java.util.logging.Logger.getLogger(PetInfo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PetInfo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PetInfo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PetInfo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PetInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPet_btn;
    private javax.swing.JTextField allergies_tf;
    private javax.swing.JComboBox boarding_cb;
    private javax.swing.JButton cancel_btn;
    private javax.swing.JButton done_btn;
    private javax.swing.JRadioButton female_rb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton male_rb;
    private javax.swing.JTextField ownerN_tf;
    private javax.swing.JTextField petAge_tf;
    private javax.swing.JTextField petN_tf;
    private javax.swing.JButton registerAll_btn;
    private javax.swing.ButtonGroup sex_bg;
    private javax.swing.JComboBox species_cb;
    // End of variables declaration//GEN-END:variables
}
