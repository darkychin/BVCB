/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import java.awt.event.WindowEvent;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Chin
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id_tf = new javax.swing.JTextField();
        login_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        password_pf = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jLabel1.setText("Login ID:");

        jLabel2.setText("Password:");

        id_tf.setToolTipText("Enter your username");

        login_btn.setText("Login");
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });

        exit_btn.setText("Exit");
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });

        password_pf.setToolTipText("Enter your password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_tf)
                            .addComponent(password_pf)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(exit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(password_pf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exit_btnActionPerformed

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        verifyUser();
    }//GEN-LAST:event_login_btnActionPerformed

    private void verifyUser() {
        char[] p = password_pf.getPassword();

        if ((id_tf.getText().isEmpty()) || (p.length == 0)) {
            JOptionPane.showMessageDialog(this, "Please fill up all the text box.", "Invalid input", JOptionPane.ERROR_MESSAGE);
        } else if ((id_tf.getText().equals("receptionist")) && (Arrays.equals(p, ("recep".toCharArray())))) {
            JOptionPane.showMessageDialog(this, "Welcome receptionist", "Welcome", JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
            ReceptionistMenu r = new ReceptionistMenu();
            r.setVisible(true);
        } else if ((id_tf.getText().equals("vet1")) && (Arrays.equals(p, ("vet1".toCharArray())))) {
            JOptionPane.showMessageDialog(this, "Welcome vet1.", "Welcome", JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
            VetMenu vm = new VetMenu("V001");
            vm.setVisible(true);
        } else if ((id_tf.getText().equals("vet2")) && (Arrays.equals(p, ("vet2".toCharArray())))) {
            JOptionPane.showMessageDialog(this, "Welcome vet2.", "Welcome", JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
            VetMenu vm = new VetMenu("V002");
            vm.setVisible(true);
        } else if ((id_tf.getText().equals("vet3")) && (Arrays.equals(p, ("vet3".toCharArray())))) {
            JOptionPane.showMessageDialog(this, "Welcome vet3.", "Welcome", JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
            VetMenu vm = new VetMenu("V003");
            vm.setVisible(true);
        } else if ((id_tf.getText().equals("vet4")) && (Arrays.equals(p, ("vet4".toCharArray())))) {
            JOptionPane.showMessageDialog(this, "Welcome vet4.", "Welcome", JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
            VetMenu vm = new VetMenu("V004");
            vm.setVisible(true);
        } else if ((id_tf.getText().equals("vet5")) && (Arrays.equals(p, ("vet5".toCharArray())))) {
            JOptionPane.showMessageDialog(this, "Welcome vet5.", "Welcome", JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
            VetMenu vm = new VetMenu("V005");
            vm.setVisible(true);
        } else if ((id_tf.getText().equals("vet6")) && (Arrays.equals(p, ("vet6".toCharArray())))) {
            JOptionPane.showMessageDialog(this, "Welcome vet6.", "Welcome", JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
            VetMenu vm = new VetMenu("V006");
            vm.setVisible(true);
        } else if ((id_tf.getText().equals("vet7")) && (Arrays.equals(p, ("vet7".toCharArray())))) {
            JOptionPane.showMessageDialog(this, "Welcome vet7.", "Welcome", JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
            VetMenu vm = new VetMenu("V007");
            vm.setVisible(true);
        } else if ((id_tf.getText().equals("vet8")) && (Arrays.equals(p, ("vet8".toCharArray())))) {
            JOptionPane.showMessageDialog(this, "Welcome vet8.", "Welcome", JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
            VetMenu vm = new VetMenu("V008");
            vm.setVisible(true);
        } else if ((id_tf.getText().equals("board1")) && (Arrays.equals(p, ("board1".toCharArray())))) {
            JOptionPane.showMessageDialog(this, "Welcome boardingstaff1", "Welcome", JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
            BoardingMenu bm = new BoardingMenu();
            bm.setVisible(true);
        } else if ((id_tf.getText().equals("board2")) && (Arrays.equals(p, ("board2".toCharArray())))) {
            JOptionPane.showMessageDialog(this, "Welcome boardingstaff2", "Welcome", JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
            BoardingMenu bm = new BoardingMenu();
            bm.setVisible(true);
        } else if ((id_tf.getText().equals("manager")) && (Arrays.equals(p, ("manager".toCharArray())))) {
            JOptionPane.showMessageDialog(this, "Welcome manager", "Welcome", JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
            ManagerMenu m = new ManagerMenu();
            m.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit_btn;
    private javax.swing.JTextField id_tf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton login_btn;
    private javax.swing.JPasswordField password_pf;
    // End of variables declaration//GEN-END:variables
}
