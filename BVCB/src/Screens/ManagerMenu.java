/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import BusinessClass.Appointment;
import BusinessClass.Boarding;
import BusinessClass.Consultation;
import BusinessClass.RotaTable;
import PersonClass.Manager;
import PersonClass.Vet;
import java.io.*;
import java.util.*;
import javafx.scene.control.ComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chin
 */
public class ManagerMenu extends javax.swing.JFrame implements Serializable {

    private DefaultTableModel model;
    private DefaultComboBoxModel comboBoxModel;
    private List<Vet> VetList = new LinkedList<>();
    private String[] VetNameArray = new String[9];
    private boolean mon, tues, wed, thurs, fri, sat, sun;
    private List<RotaTable> OriRotaList = new LinkedList<>();
    private List<RotaTable> NewRotaList = new LinkedList<>();
    private List<Appointment> AppList = new LinkedList<>();
    private List<Boarding> BoardingList = new LinkedList<>();
    private List<Consultation> ConsList = new LinkedList<>();

    public ManagerMenu() {
        populateList();
        initComponents();
        model = (DefaultTableModel) vet_jtable.getModel();
        generateTable();

        getVetArray(VetList, VetNameArray);
        fillComboBox();
        generateReport();
    }

    private void getVetArray(List<Vet> VetList, String[] VetNameArray) {
        int i = 0;
        VetNameArray[0] = "None";
        i++;
        for (Vet vet : VetList) {
            Vet temp_vet = vet;
            VetNameArray[i] = temp_vet.getName();
            i++;
        }
    }

    private void fillComboBox() {
        mon1_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));
        mon2_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));
        mon3_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));

        tues1_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));
        tues2_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));
        tues3_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));

        wed1_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));
        wed2_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));
        wed3_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));

        thurs1_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));
        thurs2_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));
        thurs3_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));

        fri1_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));
        fri2_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));
        fri3_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));

        sat1_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));
        sat2_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));
        sat3_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));

        sun1_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));
        sun2_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));
        sun3_cb.setModel(new javax.swing.DefaultComboBoxModel(VetNameArray));

        for (RotaTable r : OriRotaList) {
            RotaTable temp_rt = r;
            if (temp_rt == null) {
                resetAllCB();
            } else {
                if (temp_rt.getDay().equals("Monday")) {
                    mon1_cb.setSelectedItem(temp_rt.getVet_name1());
                    mon2_cb.setSelectedItem(temp_rt.getVet_name2());
                    mon3_cb.setSelectedItem(temp_rt.getVet_name3());
                } else if (temp_rt.getDay().equals("Tuesday")) {
                    tues1_cb.setSelectedItem(temp_rt.getVet_name1());
                    tues2_cb.setSelectedItem(temp_rt.getVet_name2());
                    tues3_cb.setSelectedItem(temp_rt.getVet_name3());
                } else if (temp_rt.getDay().equals("Wednesday")) {
                    wed1_cb.setSelectedItem(temp_rt.getVet_name1());
                    wed2_cb.setSelectedItem(temp_rt.getVet_name2());
                    wed3_cb.setSelectedItem(temp_rt.getVet_name3());
                } else if (temp_rt.getDay().equals("Thursday")) {
                    thurs1_cb.setSelectedItem(temp_rt.getVet_name1());
                    thurs2_cb.setSelectedItem(temp_rt.getVet_name2());
                    thurs3_cb.setSelectedItem(temp_rt.getVet_name3());
                } else if (temp_rt.getDay().equals("Friday")) {
                    fri1_cb.setSelectedItem(temp_rt.getVet_name1());
                    fri2_cb.setSelectedItem(temp_rt.getVet_name2());
                    fri3_cb.setSelectedItem(temp_rt.getVet_name3());
                } else if (temp_rt.getDay().equals("Saturday")) {
                    sat1_cb.setSelectedItem(temp_rt.getVet_name1());
                    sat2_cb.setSelectedItem(temp_rt.getVet_name2());
                    sat3_cb.setSelectedItem(temp_rt.getVet_name3());
                } else if (temp_rt.getDay().equals("Sunday")) {
                    sun1_cb.setSelectedItem(temp_rt.getVet_name1());
                    sun2_cb.setSelectedItem(temp_rt.getVet_name2());
                    sun3_cb.setSelectedItem(temp_rt.getVet_name3());
                }
            }
        }
    }

    public void generateReport() {
        calApp();
        calBoard();
        calRev();
    }

    private void populateList() {
        File f = null;

        Vet vet = new Vet();
        f = new File("Vet.dat");
        if (f.exists() && (f.length() != 0)) {
            vet.readList(VetList);
        } else {

            Manager manager = new Manager();
            manager.registerVet(VetList, 1, "Vet1", "", "Male", "76, Jalan1", "012-3695487", "Vet1@mail.com", "12/12/1995", "Cat", "Dog");
            manager.registerVet(VetList, 2, "Vet2", "", "Female", "77, Jalan2", "013-3589060", "Vet2@mail.com", "04/09/1993", "Cat", "Lizard");
            manager.registerVet(VetList, 3, "Vet3", "", "Male", "78, Jalan3", "014-4580467", "Vet3@mail.com", "04/05/1987", "Dog", "Hamster");
            manager.registerVet(VetList, 4, "Vet4", "", "Female", "79, Jalan4", "015-7070777", "Vet4@mail.com", "04/05/1980", "Dog", "Rabbit");
            manager.registerVet(VetList, 5, "Vet5", "", "Male", "80, Jalan5", "016-5480169", "Vet5@mail.com", "04/05/1988", "Hamster", "Lizard");
            manager.registerVet(VetList, 6, "Vet6", "", "Female", "81, Jalan6", "017-8899889", "Vet6@mail.com", "04/05/1973", "Cat", "Rabbit");
            manager.registerVet(VetList, 7, "Vet7", "", "Male", "82, Jalan7", "018-1590789", "Vet7@mail.com", "04/05/1978", "Lizard", "Rabbit");
            manager.registerVet(VetList, 8, "Vet8", "", "Female", "83, Jalan8", "019-2334872", "Vet8@mail.com", "04/05/1970", "Dog", "Hamster");

        }

        RotaTable rotatable = new RotaTable();
        f = new File("RotationTable.dat");
        if (f.exists() && (f.length() != 0)) {
            rotatable.readList(OriRotaList);
        } else {
            JOptionPane.showMessageDialog(this, "The rota table is empty", "Setup Rotatable", JOptionPane.INFORMATION_MESSAGE);
            rotatable.writeList(OriRotaList);
            rotatable.readList(OriRotaList);
        }

        Appointment app = new Appointment();
        f = new File("Appointment.dat");
        if (f.exists() && (f.length() != 0)) {
            app.readList(AppList);
        } else {
            app.writeList(AppList);
            app.readList(AppList);
        }
        f = new File("Appointment Counter.txt");
        if (!f.exists()) {
            app.writeCounter(0);
        }

        Consultation cons = new Consultation();
        f = new File("Consultation.dat");
        if (f.exists() && (f.length() != 0)) {
            cons.readList(ConsList);
        } else {
            cons.writeList(ConsList);
            cons.readList(ConsList);
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

    public void generateTable() {
        int i = 0;
        for (Vet vet : VetList) {
            Vet temp = vet;
            i++;
            model.addRow(new Object[]{i, temp.getVetID(), temp.getName(), temp.getAge(), temp.getExp1(), temp.getExp2()});
        }
    }

    public void calApp() {
        int vet1=0;
        int vet2=0;
        int vet3=0;
        int vet4=0;
        int vet5 =0;
        int vet6=0;
        int vet7=0;
        int vet8=0;
        int totalApp=0;
        for (Appointment app : AppList) {
            if (app.getAppVetID().equals("V001")) {
                totalApp++;
                vet1++;
            } else if (app.getAppVetID().equals("V002")) {
                totalApp++;
                vet2++;
            } else if (app.getAppVetID().equals("V003")) {
                totalApp++;
                vet3++;
            } else if (app.getAppVetID().equals("V004")) {
                totalApp++;
                vet4++;
            } else if (app.getAppVetID().equals("V005")) {
                totalApp++;
                vet5++;
            } else if (app.getAppVetID().equals("V006")) {
                totalApp++;
                vet6++;
            } else if (app.getAppVetID().equals("V007")) {
                totalApp++;
                vet7++;
            } else if (app.getAppVetID().equals("V008")) {
                totalApp++;
                vet8++;
            }
        }
        vet1App_tf.setText(Integer.toString(vet1));
        vet2App_tf.setText(Integer.toString(vet2));
        vet3App_tf.setText(Integer.toString(vet3));
        vet4App_tf.setText(Integer.toString(vet4));
        vet5App_tf.setText(Integer.toString(vet5));
        vet6App_tf.setText(Integer.toString(vet6));
        vet7App_tf.setText(Integer.toString(vet7));
        vet8App_tf.setText(Integer.toString(vet8));
        totalApp_tf.setText(Integer.toString(totalApp));
    }
    
    public void calBoard(){
        int board=0;
        for(Boarding boarding: BoardingList){
            board++;
        }
        totalB_tf.setText(Integer.toString(board));
    }
    
    public void calRev(){
        int revenue=0;
        
        for(Consultation cons: ConsList){
            revenue= revenue+ cons.getFees();
        }
        
        totalRev_tf.setText(Integer.toString(revenue));
    }

    private boolean rotaResult(boolean cat, boolean dog, boolean hamster, boolean lizard, boolean rabbit, String day) {
        boolean x = false;
        if (cat == false) {
            JOptionPane.showMessageDialog(this, "There is no cat expertise in " + day + ".", "Rota Error", JOptionPane.INFORMATION_MESSAGE);
        } else if (dog == false) {
            JOptionPane.showMessageDialog(this, "There is no dog expertise in " + day + ".", "Rota Error", JOptionPane.INFORMATION_MESSAGE);
        } else if (hamster == false) {
            JOptionPane.showMessageDialog(this, "There is no hamster expertise in " + day + ".", "Rota Error", JOptionPane.INFORMATION_MESSAGE);
        } else if (lizard == false) {
            JOptionPane.showMessageDialog(this, "There is no lizard expertise in " + day + ".", "Rota Error", JOptionPane.INFORMATION_MESSAGE);
        } else if (rabbit == false) {
            JOptionPane.showMessageDialog(this, "There is no rabbit expertise in " + day + ".", "Rota Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
            x = true;
        }
        return x;
    }

    private boolean checkCombB(List<Vet> VetList, String vet1, String vet2, String vet3, String day) {

        boolean cat = false;
        boolean dog = false;
        boolean hamster = false;
        boolean lizard = false;
        boolean rabbit = false;
        boolean rota_result = false;

        if (vet1.equals("None") || vet2.equals("None") || vet3.equals("None")) {
            JOptionPane.showMessageDialog(this, "Please select 3 Vet in " + day + ".", "Rota Error", JOptionPane.INFORMATION_MESSAGE);
        } else if (vet1.equals(vet2) || vet2.equals(vet3) || vet3.equals(vet1)) {
            JOptionPane.showMessageDialog(this, "Same vet is selected twice or more in " + day + ".\nPlease select another vet.", "Rota Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
            List<String> VetExp = new LinkedList<>();
            for (Vet vet : VetList) {
                Vet temp_vet = vet;
                if (temp_vet.getName().equals(vet1)) {
                    VetExp.add(temp_vet.getExp1());
                    VetExp.add(temp_vet.getExp2());
                } else if (temp_vet.getName().equals(vet2)) {
                    VetExp.add(temp_vet.getExp1());
                    VetExp.add(temp_vet.getExp2());
                } else if (temp_vet.getName().equals(vet3)) {
                    VetExp.add(temp_vet.getExp1());
                    VetExp.add(temp_vet.getExp2());
                }
            }

            for (String exp : VetExp) {
                String temp_exp = exp;
                if (temp_exp.equals("Cat")) {
                    cat = true;
                } else if (temp_exp.equals("Dog")) {
                    dog = true;
                } else if (temp_exp.equals("Hamster")) {
                    hamster = true;
                } else if (temp_exp.equals("Lizard")) {
                    lizard = true;
                } else if (temp_exp.equals("Rabbit")) {
                    rabbit = true;
                }
            }

            rota_result = rotaResult(cat, dog, hamster, lizard, rabbit, day);
        }
        return rota_result;
    }

    private void saveRotatable() {
        Manager manager = new Manager();

        manager.saveRota(NewRotaList, "Monday", mon1_cb.getSelectedItem().toString(), mon2_cb.getSelectedItem().toString(), mon3_cb.getSelectedItem().toString());
        manager.saveRota(NewRotaList, "Tuesday", tues1_cb.getSelectedItem().toString(), tues2_cb.getSelectedItem().toString(), tues3_cb.getSelectedItem().toString());
        manager.saveRota(NewRotaList, "Wednesday", wed1_cb.getSelectedItem().toString(), wed2_cb.getSelectedItem().toString(), wed3_cb.getSelectedItem().toString());
        manager.saveRota(NewRotaList, "Thursday", thurs1_cb.getSelectedItem().toString(), thurs2_cb.getSelectedItem().toString(), thurs3_cb.getSelectedItem().toString());
        manager.saveRota(NewRotaList, "Friday", fri1_cb.getSelectedItem().toString(), fri2_cb.getSelectedItem().toString(), fri3_cb.getSelectedItem().toString());
        manager.saveRota(NewRotaList, "Saturday", sat1_cb.getSelectedItem().toString(), sat2_cb.getSelectedItem().toString(), sat3_cb.getSelectedItem().toString());
        manager.saveRota(NewRotaList, "Sunday", sun1_cb.getSelectedItem().toString(), sun2_cb.getSelectedItem().toString(), sun3_cb.getSelectedItem().toString());
    }

    private void resetAllCB() {
        mon1_cb.setSelectedIndex(0);
        mon2_cb.setSelectedIndex(0);
        mon3_cb.setSelectedIndex(0);

        tues1_cb.setSelectedIndex(0);
        tues2_cb.setSelectedIndex(0);
        tues3_cb.setSelectedIndex(0);

        wed1_cb.setSelectedIndex(0);
        wed2_cb.setSelectedIndex(0);
        wed3_cb.setSelectedIndex(0);

        thurs1_cb.setSelectedIndex(0);
        thurs2_cb.setSelectedIndex(0);
        thurs3_cb.setSelectedIndex(0);

        fri1_cb.setSelectedIndex(0);
        fri2_cb.setSelectedIndex(0);
        fri3_cb.setSelectedIndex(0);

        sat1_cb.setSelectedIndex(0);
        sat2_cb.setSelectedIndex(0);
        sat3_cb.setSelectedIndex(0);

        sun1_cb.setSelectedIndex(0);
        sun2_cb.setSelectedIndex(0);
        sun3_cb.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logout_btn = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vet_jtable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        mon1_cb = new javax.swing.JComboBox();
        mon2_cb = new javax.swing.JComboBox();
        mon3_cb = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        tues1_cb = new javax.swing.JComboBox();
        tues2_cb = new javax.swing.JComboBox();
        tues3_cb = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        wed1_cb = new javax.swing.JComboBox();
        wed2_cb = new javax.swing.JComboBox();
        wed3_cb = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        fri1_cb = new javax.swing.JComboBox();
        fri2_cb = new javax.swing.JComboBox();
        fri3_cb = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        thurs1_cb = new javax.swing.JComboBox();
        thurs2_cb = new javax.swing.JComboBox();
        thurs3_cb = new javax.swing.JComboBox();
        jPanel9 = new javax.swing.JPanel();
        sun1_cb = new javax.swing.JComboBox();
        sun2_cb = new javax.swing.JComboBox();
        sun3_cb = new javax.swing.JComboBox();
        jPanel11 = new javax.swing.JPanel();
        sat1_cb = new javax.swing.JComboBox();
        sat2_cb = new javax.swing.JComboBox();
        sat3_cb = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        saveRota_btn = new javax.swing.JButton();
        resetAll_btn = new javax.swing.JButton();
        checkRota_btn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        totalB_tf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        totalRev_tf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        totalApp_tf = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        vet1App_tf = new javax.swing.JTextField();
        vet2App_tf = new javax.swing.JTextField();
        vet3App_tf = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        vet4App_tf = new javax.swing.JTextField();
        vet5App_tf = new javax.swing.JTextField();
        vet6App_tf = new javax.swing.JTextField();
        vet7App_tf = new javax.swing.JTextField();
        vet8App_tf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager Menu");

        logout_btn.setText("Log Out");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        vet_jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Vet ID", "Name", "Age", "Expertise 1", "Expertise 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(vet_jtable);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(mon1_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(mon2_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(mon3_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {mon1_cb, mon2_cb, mon3_cb});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mon1_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mon2_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mon3_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tues1_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(tues2_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(tues3_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tues1_cb, tues2_cb, tues3_cb});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tues1_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tues2_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tues3_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(wed1_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(wed2_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(wed3_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {wed1_cb, wed2_cb, wed3_cb});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wed1_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wed2_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wed3_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fri1_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(fri2_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(fri3_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {fri1_cb, fri2_cb, fri3_cb});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fri1_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fri2_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fri3_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(thurs1_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(thurs2_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(thurs3_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {thurs1_cb, thurs2_cb, thurs3_cb});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thurs1_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thurs2_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thurs3_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sun1_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(sun2_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(sun3_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {sun1_cb, sun2_cb, sun3_cb});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sun1_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sun2_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sun3_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sat1_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(sat2_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(sat3_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {sat1_cb, sat2_cb, sat3_cb});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sat1_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sat2_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sat3_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jLabel1.setText("Monday");

        jLabel2.setText("Tuesday");

        jLabel3.setText("Wednesday");

        jLabel4.setText("Thrusday");

        jLabel5.setText("Sunday");

        jLabel6.setText("Friday");

        jLabel7.setText("Saturday");

        saveRota_btn.setText("Save");
        saveRota_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRota_btnActionPerformed(evt);
            }
        });

        resetAll_btn.setText("Reset All");
        resetAll_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetAll_btnActionPerformed(evt);
            }
        });

        checkRota_btn.setText("Check Rotatable");
        checkRota_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkRota_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(saveRota_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(checkRota_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89)
                                .addComponent(resetAll_btn)))))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {checkRota_btn, resetAll_btn, saveRota_btn});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveRota_btn)
                    .addComponent(resetAll_btn)
                    .addComponent(checkRota_btn))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Vet Table & Rota Table", jPanel2);

        totalB_tf.setEditable(false);

        jLabel8.setText("Total Boarding :");

        jLabel9.setText("Total Revenue :");

        totalRev_tf.setEditable(false);

        jLabel10.setText("Total Appointment :");

        totalApp_tf.setEditable(false);

        jLabel11.setText("Vet 1 's Appointment :");

        jLabel12.setText("Vet 2 's Appointment :");

        jLabel13.setText("Vet 3 's Appointment :");

        vet1App_tf.setEditable(false);

        vet2App_tf.setEditable(false);

        vet3App_tf.setEditable(false);

        jLabel14.setText("Vet 6 's Appointment :");

        jLabel15.setText("Vet 4 's Appointment :");

        jLabel16.setText("Vet 5 's Appointment :");

        jLabel17.setText("Vet 7 's Appointment :");

        jLabel18.setText("Vet 8 's Appointment :");

        vet4App_tf.setEditable(false);

        vet5App_tf.setEditable(false);

        vet6App_tf.setEditable(false);

        vet7App_tf.setEditable(false);

        vet8App_tf.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vet1App_tf)
                    .addComponent(vet2App_tf)
                    .addComponent(vet3App_tf)
                    .addComponent(vet4App_tf)
                    .addComponent(vet5App_tf)
                    .addComponent(vet6App_tf)
                    .addComponent(vet7App_tf)
                    .addComponent(vet8App_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalB_tf)
                    .addComponent(totalApp_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalRev_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(vet1App_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(totalB_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(vet2App_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalApp_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(vet3App_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalRev_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(vet4App_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(vet5App_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(vet6App_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(vet7App_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(vet8App_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("General Report", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(logout_btn)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        Login login = new Login();
        this.dispose();
        login.setVisible(true);
        
    }//GEN-LAST:event_logout_btnActionPerformed

    private void checkRota_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkRota_btnActionPerformed
        mon = checkCombB(VetList, mon1_cb.getSelectedItem().toString(), mon2_cb.getSelectedItem().toString(), mon3_cb.getSelectedItem().toString(), "Monday");
        if (mon == true) {
            tues = checkCombB(VetList, tues1_cb.getSelectedItem().toString(), tues2_cb.getSelectedItem().toString(), tues3_cb.getSelectedItem().toString(), "Tuesday");
            if (tues == true) {
                wed = checkCombB(VetList, wed1_cb.getSelectedItem().toString(), wed2_cb.getSelectedItem().toString(), wed3_cb.getSelectedItem().toString(), "Wednesday");
                if (wed == true) {
                    thurs = checkCombB(VetList, thurs1_cb.getSelectedItem().toString(), thurs2_cb.getSelectedItem().toString(), thurs3_cb.getSelectedItem().toString(), "Thursday");
                    if (thurs == true) {
                        fri = checkCombB(VetList, fri1_cb.getSelectedItem().toString(), fri2_cb.getSelectedItem().toString(), fri3_cb.getSelectedItem().toString(), "Friday");
                        if (fri == true) {
                            sat = checkCombB(VetList, sat1_cb.getSelectedItem().toString(), sat2_cb.getSelectedItem().toString(), sat3_cb.getSelectedItem().toString(), "Saturday");
                            if (sat == true) {
                                sun = checkCombB(VetList, sun1_cb.getSelectedItem().toString(), sun2_cb.getSelectedItem().toString(), sun3_cb.getSelectedItem().toString(), "Sunday");
                                if (sun == true) {
                                    JOptionPane.showMessageDialog(this, "The table is completed.\n You may save now.", "Rota Check Succeed", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        }
                    }
                }
            }
        }

    }//GEN-LAST:event_checkRota_btnActionPerformed

    private void resetAll_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetAll_btnActionPerformed
        resetAllCB();
    }//GEN-LAST:event_resetAll_btnActionPerformed

    private void saveRota_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRota_btnActionPerformed
        if (mon == true && tues == true && wed == true && thurs == true && fri == true && sat == true && sun == true) {
            saveRotatable();
        } else {
            int x = JOptionPane.showConfirmDialog(this, "The rotatable is not balanced with pet expetises.\nAre you sure you want to save?", "Confirm Save Rota", JOptionPane.YES_NO_OPTION);
            if (x == JOptionPane.YES_OPTION) {
                saveRotatable();
            }
        }
    }//GEN-LAST:event_saveRota_btnActionPerformed

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
            java.util.logging.Logger.getLogger(ManagerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkRota_btn;
    private javax.swing.JComboBox fri1_cb;
    private javax.swing.JComboBox fri2_cb;
    private javax.swing.JComboBox fri3_cb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logout_btn;
    private javax.swing.JComboBox mon1_cb;
    private javax.swing.JComboBox mon2_cb;
    private javax.swing.JComboBox mon3_cb;
    private javax.swing.JButton resetAll_btn;
    private javax.swing.JComboBox sat1_cb;
    private javax.swing.JComboBox sat2_cb;
    private javax.swing.JComboBox sat3_cb;
    private javax.swing.JButton saveRota_btn;
    private javax.swing.JComboBox sun1_cb;
    private javax.swing.JComboBox sun2_cb;
    private javax.swing.JComboBox sun3_cb;
    private javax.swing.JComboBox thurs1_cb;
    private javax.swing.JComboBox thurs2_cb;
    private javax.swing.JComboBox thurs3_cb;
    private javax.swing.JTextField totalApp_tf;
    private javax.swing.JTextField totalB_tf;
    private javax.swing.JTextField totalRev_tf;
    private javax.swing.JComboBox tues1_cb;
    private javax.swing.JComboBox tues2_cb;
    private javax.swing.JComboBox tues3_cb;
    private javax.swing.JTextField vet1App_tf;
    private javax.swing.JTextField vet2App_tf;
    private javax.swing.JTextField vet3App_tf;
    private javax.swing.JTextField vet4App_tf;
    private javax.swing.JTextField vet5App_tf;
    private javax.swing.JTextField vet6App_tf;
    private javax.swing.JTextField vet7App_tf;
    private javax.swing.JTextField vet8App_tf;
    private javax.swing.JTable vet_jtable;
    private javax.swing.JComboBox wed1_cb;
    private javax.swing.JComboBox wed2_cb;
    private javax.swing.JComboBox wed3_cb;
    // End of variables declaration//GEN-END:variables
}
