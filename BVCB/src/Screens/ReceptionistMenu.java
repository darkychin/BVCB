/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import BusinessClass.Appointment;
import BusinessClass.Boarding;
import BusinessClass.RotaTable;
import PersonClass.Customer;
import PersonClass.Receptionist;
import PersonClass.Vet;
import PetClass.Cat;
import PetClass.Dog;
import PetClass.Hamster;
import PetClass.Lizard;
import PetClass.Rabbit;

import java.io.File;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chin
 */
public class ReceptionistMenu extends javax.swing.JFrame implements Serializable {

    public static List<Customer> CustomerList = new LinkedList<>();
    public static List<Cat> CatList = new LinkedList<>();
    public static List<Dog> DogList = new LinkedList<>();
    public static List<Hamster> HamsterList = new LinkedList<>();
    public static List<Lizard> LizardList = new LinkedList<>();
    public static List<Rabbit> RabbitList = new LinkedList<>();
    public static List<Vet> VetList = new LinkedList<>();
    public static List<Appointment> AppointmentList = new LinkedList<>();
    public static List<Boarding> BoardingList= new LinkedList<>();

    public static DefaultTableModel model;

    private String temp_CusID;
    private String temp_PetID;
    private String temp_CusName;
    private String temp_PetName;

    public ReceptionistMenu() {

        initComponents();
        model = (DefaultTableModel) ReceptionTable.getModel();
        populateList();
        generateTable(model);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    public void populateList() {
        File f = null;

        Customer customer = new Customer();
        f = new File("Customer.dat");
        if (f.exists() && (f.length() != 0)) {
            customer.readList(CustomerList);
        } else {
            customer.writeList(CustomerList);
            customer.readList(CustomerList);
        }
        f = new File("Customer Counter.txt");
        if (!f.exists()) {
            customer.writeCounter(0);
        }

        Cat cat = new Cat();
        f = new File("Cat.dat");
        if (f.exists() && f.length() != 0) {
            cat.readList(CatList);
        } else {
            cat.writeList(CatList);
            cat.readList(CatList);
        }
        f = new File("Cat Counter.txt");
        if (!f.exists()) {
            cat.writeCounter(0);
        }

        Dog dog = new Dog();
        f = new File("Dog.dat");
        if (f.exists() && (f.length() != 0)) {
            dog.readList(DogList);
        } else {
            dog.writeList(DogList);
            dog.readList(DogList);
        }
        f = new File("Dog Counter.txt");
        if (!f.exists()) {
            dog.writeCounter(0);
        }

        Hamster hamster = new Hamster();
        f = new File("Hamster.dat");
        if (f.exists() && (f.length() != 0)) {
            hamster.readList(HamsterList);
        } else {
            hamster.writeList(HamsterList);
            hamster.readList(HamsterList);
        }
        f = new File("Hamster Counter.txt");
        if (!f.exists()) {
            hamster.writeCounter(0);
        }

        Lizard lizard = new Lizard();
        f = new File("Lizard.dat");
        if (f.exists() && (f.length() != 0)) {
            lizard.readList(LizardList);
        } else {
            lizard.writeList(LizardList);
            lizard.readList(LizardList);
        }
        f = new File("Lizard Counter.txt");
        if (!f.exists()) {
            lizard.writeCounter(0);
        }

        Rabbit rabbit = new Rabbit();
        f = new File("Rabbit.dat");
        if (f.exists() && (f.length() != 0)) {
            rabbit.readList(RabbitList);
        } else {
            rabbit.writeList(RabbitList);
            rabbit.readList(RabbitList);
        }
        f = new File("Rabbit Counter.txt");
        if (!f.exists()) {
            rabbit.writeCounter(0);
        }

        Vet vet = new Vet();
        f = new File("Vet.dat");
        if (f.exists() && (f.length() != 0)) {
            vet.readList(VetList);
        } else {
            JOptionPane.showMessageDialog(this, "Manager has not entered the vet list yet.\nHence reserving appoinment will be not available.",
                    "Vet List Error", JOptionPane.ERROR_MESSAGE);
        }

        Appointment app = new Appointment();
        f = new File("Appointment.dat");
        if (f.exists() && (f.length() != 0)) {
            app.readList(AppointmentList);
        } else {
            app.writeList(AppointmentList);
            app.readList(AppointmentList);
        }
        f = new File("Appointment Counter.txt");
        if (!f.exists()) {
            app.writeCounter(0);
        }
        
        Boarding boarding = new Boarding();
        f = new File("Boarding.dat");
        if (f.exists() && (f.length() != 0)) {
            boarding.readList(BoardingList);
        } else {
            boarding.writeList(BoardingList);
            boarding.readList(BoardingList);
        }
        f = new File("Boarding Counter.txt");
        if (!f.exists()) {
            boarding.writeCounter(0);
        }
    }

    public void generateTable(DefaultTableModel model) {
        int i = 0;
        int total = 0;
        for (Customer customer : CustomerList) {
            Customer cus_temp = customer;
            for (Cat cat : CatList) {
                Cat cat_temp = cat;
                if (cus_temp.getCustomerID().equals(cat_temp.getOwnerID())) {
                    i++;
                    model.addRow(new Object[]{i, cus_temp.getCustomerID(), cus_temp.getName(),
                        cat_temp.getCatID(), cat_temp.getName()});
                    total++;
                }
            }

            for (Dog dog : DogList) {
                Dog dog_temp = dog;
                if (cus_temp.getCustomerID().equals(dog_temp.getOwnerID())) {
                    i++;
                    model.addRow(new Object[]{i, cus_temp.getCustomerID(), cus_temp.getName(),
                        dog_temp.getDogID(), dog_temp.getName()});
                    total++;
                }
            }

            for (Hamster hamster : HamsterList) {
                Hamster hamster_temp = hamster;
                if (cus_temp.getCustomerID().equals(hamster_temp.getOwnerID())) {
                    i++;
                    model.addRow(new Object[]{i, cus_temp.getCustomerID(), cus_temp.getName(),
                        hamster_temp.getHamsterID(), hamster_temp.getName()});
                    total++;
                }
            }

            for (Lizard lizard : LizardList) {
                Lizard lizard_temp = lizard;
                if (cus_temp.getCustomerID().equals(lizard_temp.getOwnerID())) {
                    i++;
                    model.addRow(new Object[]{i, cus_temp.getCustomerID(), cus_temp.getName(),
                        lizard_temp.getLizardID(), lizard_temp.getName()});
                    total++;
                }
            }

            for (Rabbit rabbit : RabbitList) {
                Rabbit rabbit_temp = rabbit;
                if (cus_temp.getCustomerID().equals(rabbit_temp.getOwnerID())) {
                    i++;
                    model.addRow(new Object[]{i, cus_temp.getCustomerID(), cus_temp.getName(),
                        rabbit_temp.getRabbitID(), rabbit_temp.getName()});
                    total++;
                }
            }

            if (total == 0) {
                Receptionist r = new Receptionist();
                r.deleteCustomer(BoardingList, CustomerList, CatList, DogList, HamsterList, LizardList, RabbitList, cus_temp.getCustomerID());
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

    public void refreshTable() {
        clearTable(model);
        generateTable(model);
    }

    public void clearList(){
        CustomerList.clear();
        CatList.clear();
        DogList.clear();
        HamsterList.clear();
        LizardList.clear();
        RabbitList.clear();
        VetList.clear();
        BoardingList.clear();
        AppointmentList.clear();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        registerP_btn = new javax.swing.JButton();
        deleteP_btn = new javax.swing.JButton();
        editP_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ReceptionTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        makeApp_btn = new javax.swing.JButton();
        editApp_btn = new javax.swing.JButton();
        showApp_btn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        registerC_btn = new javax.swing.JButton();
        deleteC_btn = new javax.swing.JButton();
        editC_btn = new javax.swing.JButton();
        logout_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Receptionist Menu");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pet"));
        jPanel2.setToolTipText("");
        jPanel2.setName(""); // NOI18N

        registerP_btn.setText("Register Pet");
        registerP_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerP_btnActionPerformed(evt);
            }
        });

        deleteP_btn.setText("Delete Pet");
        deleteP_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteP_btnActionPerformed(evt);
            }
        });

        editP_btn.setText("Edit Details");
        editP_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editP_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteP_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editP_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerP_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteP_btn, editP_btn, registerP_btn});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerP_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editP_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteP_btn)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        ReceptionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Customer ID", "Customer Name", "Pet ID", "Pet Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ReceptionTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        ReceptionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReceptionTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ReceptionTable);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Appointment"));

        makeApp_btn.setText("Make Appointment");
        makeApp_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeApp_btnActionPerformed(evt);
            }
        });

        editApp_btn.setText("Edit Appointment");
        editApp_btn.setActionCommand("");
        editApp_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editApp_btnActionPerformed(evt);
            }
        });

        showApp_btn.setText("Show Appoinment");
        showApp_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showApp_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editApp_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(makeApp_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showApp_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {editApp_btn, makeApp_btn});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showApp_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(makeApp_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editApp_btn)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer"));

        registerC_btn.setText("Register Customer");
        registerC_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerC_btnActionPerformed(evt);
            }
        });

        deleteC_btn.setText("Delete Customer");
        deleteC_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteC_btnActionPerformed(evt);
            }
        });

        editC_btn.setText("Edit Details");
        editC_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editC_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteC_btn)
                    .addComponent(editC_btn)
                    .addComponent(registerC_btn))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteC_btn, editC_btn, registerC_btn});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerC_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editC_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteC_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {deleteC_btn, editC_btn, registerC_btn});

        logout_btn.setText("Log Out");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logout_btn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel1, jPanel2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(logout_btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel1, jPanel2, jPanel3});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerC_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerC_btnActionPerformed
        CustomerInfo c = new CustomerInfo(this);
        c.showRegisterFrame();
        c.setVisible(true);
    }//GEN-LAST:event_registerC_btnActionPerformed

    private void editC_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editC_btnActionPerformed
        // force promp
        String F_Name, L_name, Gender, Address, ContactNo, Email, DOB;
        for (Customer customer : CustomerList) {
            Customer temp = customer;
            if (temp.getCustomerID().equals(temp_CusID)) {
                F_Name = temp.getF_name();
                L_name = temp.getL_name();
                Gender = temp.getGender();
                Address = temp.getAddress();
                ContactNo = temp.getContactNo();
                Email = temp.getEmail();
                DOB = temp.getDOB();

                CustomerInfo c = new CustomerInfo(this, temp_CusID, F_Name, L_name, Gender, Address, ContactNo, Email, DOB);
                c.showEditFrame();
                c.setVisible(true);
            }
        }


    }//GEN-LAST:event_editC_btnActionPerformed

    private void makeApp_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeApp_btnActionPerformed
        try {
            AppointmentInfo appInfo = new AppointmentInfo(temp_CusID, temp_CusName, temp_PetID, temp_PetName);
            appInfo.showCreateApp();
            appInfo.setVisible(true);
        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(this, "Please select a pet to make appointment.", "Empty selection", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_makeApp_btnActionPerformed

    private void editApp_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editApp_btnActionPerformed
            
            String AppID = "";
            String vet = "";
            String date = "";
            String time = "";
            for (Appointment app : AppointmentList) {
                Appointment app_temp = app;
                if (app_temp.getAppPetID().equals(temp_PetID)) {
                    AppID = app_temp.getAppID();
                    vet = app_temp.getAppVetName();
                    date = app_temp.getAppDate();
                    time = app_temp.getAppTime();
                }
            }
            if ((!AppID.equals("")) && (!vet.equals("")) && (!date.equals("")) && (!time.equals(""))) {
                AppointmentInfo appInfo = new AppointmentInfo(AppID, temp_CusID, temp_CusName, temp_PetID, temp_PetName, vet, date, time);
                appInfo.showEditApp();
                appInfo.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "There is no appointment to edit.", "Empty Appointment", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_editApp_btnActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        this.setVisible(false);
        Login L = new Login();
        L.setVisible(true);
        this.dispose();
        clearList();
    }//GEN-LAST:event_logout_btnActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void ReceptionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReceptionTableMouseClicked
        model = (DefaultTableModel) ReceptionTable.getModel();
        temp_CusID = model.getValueAt(ReceptionTable.getSelectedRow(), 1).toString();
        temp_CusName = model.getValueAt(ReceptionTable.getSelectedRow(), 2).toString();
        temp_PetID = model.getValueAt(ReceptionTable.getSelectedRow(), 3).toString();
        temp_PetName = model.getValueAt(ReceptionTable.getSelectedRow(), 4).toString();
    }//GEN-LAST:event_ReceptionTableMouseClicked

    private void registerP_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerP_btnActionPerformed
        String Cus_Name;
        try {
            for (Customer customer : CustomerList) {
                Customer temp = customer;
                if (temp.getCustomerID().equals(temp_CusID)) {
                    Cus_Name = temp.getName();
                    PetInfo PetScreen = new PetInfo(this, temp_CusID, Cus_Name);
                    PetScreen.showAddPetFrame();
                    PetScreen.setVisible(true);
                }
            }
        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(this, "Please select a customer to add pet.", "Select Customer", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_registerP_btnActionPerformed

    private void editP_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editP_btnActionPerformed
        int PetAge;
        String PetName, Sex, Species, Allergies;
        boolean Boarding;

        for (Cat cat : CatList) {
            Cat temp = cat;
            if (temp.getCatID().equals(temp_PetID)) {
                PetName = temp.getName();
                Sex = temp.getSex();
                PetAge = temp.getAge();
                Allergies = temp.getAllergies();
                Boarding = temp.getBoarding();
                Species = "Cat";

                PetInfo p = new PetInfo(this, temp_CusName, temp_PetID, PetName, Sex, Species, PetAge, Allergies, Boarding);
                p.showEditFrame();
                p.setVisible(true);
            }
        }

        for (Dog dog : DogList) {
            Dog temp = dog;
            if (temp.getDogID().equals(temp_PetID)) {
                PetName = temp.getName();
                Sex = temp.getSex();
                PetAge = temp.getAge();
                Allergies = temp.getAllergies();
                Boarding = temp.getBoarding();
                Species = "Dog";

                PetInfo p = new PetInfo(this, temp_CusName, temp_PetID, PetName, Sex, Species, PetAge, Allergies, Boarding);
                p.showEditFrame();
                p.setVisible(true);
            }
        }

        for (Hamster hamster : HamsterList) {
            Hamster temp = hamster;
            if (temp.getHamsterID().equals(temp_PetID)) {
                PetName = temp.getName();
                Sex = temp.getSex();
                PetAge = temp.getAge();
                Allergies = temp.getAllergies();
                Boarding = temp.getBoarding();
                Species = "Hamster";

                PetInfo p = new PetInfo(this, temp_CusName, temp_PetID, PetName, Sex, Species, PetAge, Allergies, Boarding);
                p.showEditFrame();
                p.setVisible(true);
            }
        }

        for (Lizard lizard : LizardList) {
            Lizard temp = lizard;
            if (temp.getLizardID().equals(temp_PetID)) {
                PetName = temp.getName();
                Sex = temp.getSex();
                PetAge = temp.getAge();
                Allergies = temp.getAllergies();
                Boarding = temp.getBoarding();
                Species = "Lizard";

                PetInfo p = new PetInfo(this, temp_CusName, temp_PetID, PetName, Sex, Species, PetAge, Allergies, Boarding);
                p.showEditFrame();
                p.setVisible(true);
            }
        }

        for (Rabbit rabbit : RabbitList) {
            Rabbit temp = rabbit;
            if (temp.getRabbitID().equals(temp_PetID)) {
                PetName = temp.getName();
                Sex = temp.getSex();
                PetAge = temp.getAge();
                Allergies = temp.getAllergies();
                Boarding = temp.getBoarding();
                Species = "Rabbit";

                PetInfo p = new PetInfo(this, temp_CusName, temp_PetID, PetName, Sex, Species, PetAge, Allergies, Boarding);
                p.showEditFrame();
                p.setVisible(true);
            }
        }

    }//GEN-LAST:event_editP_btnActionPerformed

    private void deleteC_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteC_btnActionPerformed
        Receptionist r = new Receptionist();
        r.deleteCustomer(BoardingList,CustomerList, CatList, DogList, HamsterList, LizardList, RabbitList, temp_CusID);
        this.refreshTable();
    }//GEN-LAST:event_deleteC_btnActionPerformed

    private void deleteP_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteP_btnActionPerformed
        Receptionist r = new Receptionist();
        r.deletePet(BoardingList,CatList, DogList, HamsterList, LizardList, RabbitList, temp_PetID);
        this.refreshTable();
    }//GEN-LAST:event_deleteP_btnActionPerformed

    private void showApp_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showApp_btnActionPerformed
        AppointmentList applist = new AppointmentList();
        applist.setVisible(true);
    }//GEN-LAST:event_showApp_btnActionPerformed

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
            java.util.logging.Logger.getLogger(ReceptionistMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceptionistMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceptionistMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceptionistMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new ReceptionistMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ReceptionTable;
    private javax.swing.JButton deleteC_btn;
    private javax.swing.JButton deleteP_btn;
    private javax.swing.JButton editApp_btn;
    private javax.swing.JButton editC_btn;
    private javax.swing.JButton editP_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout_btn;
    private javax.swing.JButton makeApp_btn;
    private javax.swing.JButton registerC_btn;
    private javax.swing.JButton registerP_btn;
    private javax.swing.JButton showApp_btn;
    // End of variables declaration//GEN-END:variables
}
