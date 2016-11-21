package Screens;

import BusinessClass.Appointment;
import BusinessClass.Boarding;
import BusinessClass.Consultation;
import BusinessClass.RotaTable;
import PersonClass.Vet;
import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class VetMenu extends javax.swing.JFrame implements Serializable {

    public static List<Vet> VetList = new LinkedList<>();
    public static List<Appointment> AppointmentList = new LinkedList<>();
    public static List<Consultation> ConsultList = new LinkedList<>();
    public static List<Boarding> BoardingList = new LinkedList<>();
    public static List<RotaTable> RotaList = new LinkedList<>();

    private String[] VetExp = new String[2];

    private String VetID;
    private String AppointmentID, PetID, PetName;

    public static DefaultTableModel AppModel;
    public static DefaultTableModel BoardModel;
    public static DefaultTableModel RotaModel;

    public VetMenu() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    public VetMenu(String vetID) {
        this.VetID = vetID;
        initComponents();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        AppModel = (DefaultTableModel) appList_tb.getModel();
        BoardModel = (DefaultTableModel) boardList_tb.getModel();
        RotaModel = (DefaultTableModel) rota_tb.getModel();
        populateList();
        generateRotaTable(RotaModel);
        generateAppTable(AppModel);
        generateBoardTable(BoardModel);
    }

    public void populateList() {
        File f = null;

        Vet vet = new Vet();
        f = new File("Vet.dat");
        if (f.exists() && (f.length() != 0)) {
            vet.readList(VetList);
        } else {
            JOptionPane.showMessageDialog(this, "Manager has not entered the vet list yet.\nHence reserving appoinment will be not available.",
                    "Vet List Error", JOptionPane.ERROR_MESSAGE);
        }

        RotaTable rotatb = new RotaTable();
        f = new File("RotationTable.dat");
        if (f.exists() && (f.length() != 0)) {
            rotatb.readList(RotaList);
        } else {
            JOptionPane.showMessageDialog(this, "Manager has not filled in the rota table list yet.\nHence reserving appoinment will be not available.",
                    "Rota Table List Error", JOptionPane.ERROR_MESSAGE);
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

        Consultation cons = new Consultation();
        f = new File("Consultation.dat");
        if (f.exists() && (f.length() != 0)) {
            cons.readList(ConsultList);
        } else {
            cons.writeList(ConsultList);
            cons.readList(ConsultList);
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

    public void generateRotaTable(DefaultTableModel rota_model) {
        for (RotaTable rt : RotaList) {
            rota_model.addRow(new Object[]{rt.getDay(), rt.getVet_name1(), rt.getVet_name2(), rt.getVet_name3()});
        }
    }

    private void generateBoardTable(DefaultTableModel board_model) {
        int i = 0;
        try {
            if (species_cb.getSelectedItem().toString().equals("Cat")) {
                for (Boarding boarding : BoardingList) {
                    if (boarding.getSpecies().equals("Cat")) {
                        i++;
                        board_model.addRow(new Object[]{i, boarding.getBoardingID(), boarding.getPetName(), boarding.getSicknesslvl(), boarding.getStatus(), boarding.getL_Fed()});
                    }
                }
            } else if (species_cb.getSelectedItem().toString().equals("Dog")) {
                for (Boarding boarding : BoardingList) {
                    if (boarding.getSpecies().equals("Dog")) {
                        i++;
                        board_model.addRow(new Object[]{i, boarding.getBoardingID(), boarding.getPetName(), boarding.getSicknesslvl(), boarding.getStatus(), boarding.getL_Fed()});
                    }
                }
            } else if (species_cb.getSelectedItem().toString().equals("Hamster")) {
                for (Boarding boarding : BoardingList) {
                    if (boarding.getSpecies().equals("Hamster")) {
                        i++;
                        board_model.addRow(new Object[]{i, boarding.getBoardingID(), boarding.getPetName(), boarding.getSicknesslvl(), boarding.getStatus(), boarding.getL_Fed()});
                    }
                }
            } else if (species_cb.getSelectedItem().toString().equals("Lizard")) {
                for (Boarding boarding : BoardingList) {
                    if (boarding.getSpecies().equals("Lizard")) {
                        i++;
                        board_model.addRow(new Object[]{i, boarding.getBoardingID(), boarding.getPetName(), boarding.getSicknesslvl(), boarding.getStatus(), boarding.getL_Fed()});
                    }
                }
            } else {
                for (Boarding boarding : BoardingList) {
                    if (boarding.getSpecies().equals("Rabbit")) {
                        i++;
                        board_model.addRow(new Object[]{i, boarding.getBoardingID(), boarding.getPetName(), boarding.getSicknesslvl(), boarding.getStatus(), boarding.getL_Fed()});
                    }
                }
            }
        } catch (NullPointerException npe) {

        }
    }

    public void generateAppTable(DefaultTableModel app_model) {
        int i = 0;

        for (Appointment app : AppointmentList) {
            if (app.getAppVetID().equals(VetID)) {
                i++;
                app_model.addRow(new Object[]{i, app.getAppID(), app.getAppPetID(), app.getAppPetName(), app.getAppTime(), getConsStatus(app.getAppID())});

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
        clearTable(AppModel);
        clearTable(BoardModel);
        generateAppTable(AppModel);
        generateBoardTable(BoardModel);
    }

    public String getConsStatus(String appID) {
        String conStat = "";
        for (Consultation cons : ConsultList) {
            if (cons.getAppID().equals(appID)) {
                conStat = "Checked";
            }
        }
        return conStat;
    }

    public void clearList() {
        AppointmentList.clear();
        VetList.clear();
        BoardingList.clear();
        RotaList.clear();
        ConsultList.clear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        appList_tb = new javax.swing.JTable();
        addCons_btn = new javax.swing.JButton();
        editCons_btn = new javax.swing.JButton();
        viewCons_btn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        species_cb = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        boardList_tb = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        rota_tb = new javax.swing.JTable();
        logout_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vet Menu");

        appList_tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Appoinment ID", "Pet ID", "Pet Name", "Appoinment Time", "Consultation"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        appList_tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appList_tbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(appList_tb);

        addCons_btn.setText("Add Consultation");
        addCons_btn.setEnabled(false);
        addCons_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCons_btnActionPerformed(evt);
            }
        });

        editCons_btn.setText("Edit Consultation");
        editCons_btn.setEnabled(false);
        editCons_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCons_btnActionPerformed(evt);
            }
        });

        viewCons_btn.setText("View Consultation");
        viewCons_btn.setEnabled(false);
        viewCons_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCons_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addCons_btn)
                        .addGap(18, 18, 18)
                        .addComponent(editCons_btn)
                        .addGap(18, 18, 18)
                        .addComponent(viewCons_btn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editCons_btn)
                    .addComponent(addCons_btn)
                    .addComponent(viewCons_btn))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Appointment List", jPanel1);

        jLabel1.setText("Species:");

        species_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cat", "Dog", "Hamster", "Lizard", "Rabbit" }));
        species_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                species_cbActionPerformed(evt);
            }
        });

        boardList_tb.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(boardList_tb);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(species_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(species_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );

        jTabbedPane1.addTab("Boarding List", jPanel2);

        rota_tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Day", "First Vet", "Second Vet", "Third Vet"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(rota_tb);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Rota Table", jPanel3);

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout_btn))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(18, 18, 18)
                .addComponent(logout_btn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void species_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_species_cbActionPerformed
        clearTable(BoardModel);
        generateBoardTable(BoardModel);
    }//GEN-LAST:event_species_cbActionPerformed

    private void addCons_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCons_btnActionPerformed
        ConsultationForm cf = new ConsultationForm(this, AppointmentID, VetID, PetID, PetName);
        cf.showCreateCons();
        cf.setVisible(true);
    }//GEN-LAST:event_addCons_btnActionPerformed

    private void appList_tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appList_tbMouseClicked
        AppModel = (DefaultTableModel) appList_tb.getModel();
        AppointmentID = AppModel.getValueAt(appList_tb.getSelectedRow(), 1).toString();
        PetID = AppModel.getValueAt(appList_tb.getSelectedRow(), 2).toString();
        PetName = AppModel.getValueAt(appList_tb.getSelectedRow(), 3).toString();
        addCons_btn.setEnabled(true);
        editCons_btn.setEnabled(true);
        viewCons_btn.setEnabled(true);
    }//GEN-LAST:event_appList_tbMouseClicked

    private void editCons_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCons_btnActionPerformed
        String prog = "";
        String diag = "";
        String sicklvl = "";
        int fees = 0;
        for (Consultation cons : ConsultList) {
            if (cons.getAppID().equals(AppointmentID)) {
                prog = cons.getProg();
                diag = cons.getDiag();
                sicklvl = cons.getSicklvl();
                fees = cons.getFees();
            }
        }
        ConsultationForm cf = new ConsultationForm(this, AppointmentID, VetID, PetID, PetName, prog, diag, sicklvl, fees);
        cf.showEditCons();
        cf.setVisible(true);
    }//GEN-LAST:event_editCons_btnActionPerformed

    private void viewCons_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCons_btnActionPerformed
        String prog = "";
        String diag = "";
        String sicklvl = "";
        int fees = 0;
        for (Consultation cons : ConsultList) {
            if (cons.getAppID().equals(AppointmentID)) {
                prog = cons.getProg();
                diag = cons.getDiag();
                sicklvl = cons.getSicklvl();
                fees = cons.getFees();
            }
        }
        ConsultationForm cf = new ConsultationForm(this, AppointmentID, VetID, PetID, PetName, prog, diag, sicklvl, fees);
        cf.showViewCons();
        cf.setVisible(true);
    }//GEN-LAST:event_viewCons_btnActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        this.dispose();
        clearList();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_logout_btnActionPerformed

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
            java.util.logging.Logger.getLogger(VetMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VetMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VetMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VetMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VetMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCons_btn;
    private javax.swing.JTable appList_tb;
    private javax.swing.JTable boardList_tb;
    private javax.swing.JButton editCons_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logout_btn;
    private javax.swing.JTable rota_tb;
    private javax.swing.JComboBox species_cb;
    private javax.swing.JButton viewCons_btn;
    // End of variables declaration//GEN-END:variables
}
