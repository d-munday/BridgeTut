/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author Ishaan
 */
public class newUserAccountScreen extends javax.swing.JFrame {

    /**
     * Creates new form newUserAccountScreen
     */
    public newUserAccountScreen() {
        initComponents();
        pnlNewAcc.setPreferredSize(new Dimension(500, 500));
        setSize(new Dimension(560, 300));
    }
    
    public void initilizeFields(){
        txfPswrd.setText("Enter a password");
        txfuserName.setText("Enter your username");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNewAcc = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        lblHeading = new javax.swing.JLabel();
        lblNewUser = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txfuserName = new javax.swing.JTextField();
        txfPswrd = new javax.swing.JTextField();
        btnProcess = new javax.swing.JButton();
        lblBackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        pnlNewAcc.setLayout(null);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/arrow-112-32.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        pnlNewAcc.add(btnBack);
        btnBack.setBounds(0, 0, 60, 50);

        lblHeading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/newAcc40.png"))); // NOI18N
        pnlNewAcc.add(lblHeading);
        lblHeading.setBounds(170, 0, 250, 68);

        lblNewUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/playerName30.png"))); // NOI18N
        pnlNewAcc.add(lblNewUser);
        lblNewUser.setBounds(60, 80, 210, 65);

        lblPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/Password30.png"))); // NOI18N
        pnlNewAcc.add(lblPassword);
        lblPassword.setBounds(60, 130, 180, 59);

        txfuserName.setText("Enter your username here");
        txfuserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txfuserNameFocusGained(evt);
            }
        });
        pnlNewAcc.add(txfuserName);
        txfuserName.setBounds(290, 100, 170, 30);

        txfPswrd.setText("Enter Password here");
        txfPswrd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txfPswrdFocusGained(evt);
            }
        });
        pnlNewAcc.add(txfPswrd);
        txfPswrd.setBounds(290, 150, 170, 30);

        btnProcess.setText("PROCESS");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });
        pnlNewAcc.add(btnProcess);
        btnProcess.setBounds(220, 210, 110, 23);

        lblBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/background.jpg"))); // NOI18N
        lblBackGround.setText("jLabel1");
        pnlNewAcc.add(lblBackGround);
        lblBackGround.setBounds(0, 0, 560, 310);

        getContentPane().add(pnlNewAcc);
        pnlNewAcc.setBounds(0, 0, 600, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//variables
    
    String username=null;
    String password=null;
    boolean existingUser=false; //Check if a username is already taken
    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // Will make a new user account by calling appropriate methods from the user class
        username=txfuserName.getText();
        password=txfPswrd.getText();
        
        if (username.equals("")||password.equals("")) {
            JOptionPane.showMessageDialog(null, "You cannot leave username or password field blank!");
            initilizeFields();
        }
        
        else if(username.equalsIgnoreCase("Enter Username here")||password.equalsIgnoreCase("Enter Password here")){
            JOptionPane.showMessageDialog(null, "Please choose appropriate username and password");
            initilizeFields();
        }
        else if(username.contains(" ")||password.contains(" ")){
            JOptionPane.showMessageDialog(null, "Username and password cannot contain spaces");
            initilizeFields();
        }
        else{
            User obj=new User(username,password);
        
        //Authenticate first to see if username already exists in textfile database
        
            existingUser= obj.authenticateUser();
        
            if (existingUser==true) {
                JOptionPane.showMessageDialog(null, "The username: "+username+" already exists!\nPlease try another username. ");
                initilizeFields();
            }
            else{
                obj.saveNewUser();
                JOptionPane.showMessageDialog(null, "New user saved successfully!");
                
                new LoginScreen().setVisible(true);

                this.setVisible(false);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new LoginScreen().setVisible(true);

                this.setVisible(false);
                this.dispose(); 
    }//GEN-LAST:event_btnBackActionPerformed

    private void txfuserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfuserNameFocusGained
        txfuserName.setText("");
    }//GEN-LAST:event_txfuserNameFocusGained

    private void txfPswrdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfPswrdFocusGained
        txfPswrd.setText("");
    }//GEN-LAST:event_txfPswrdFocusGained

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
            java.util.logging.Logger.getLogger(newUserAccountScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newUserAccountScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newUserAccountScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newUserAccountScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newUserAccountScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnProcess;
    private javax.swing.JLabel lblBackGround;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblNewUser;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JPanel pnlNewAcc;
    private javax.swing.JTextField txfPswrd;
    private javax.swing.JTextField txfuserName;
    // End of variables declaration//GEN-END:variables
}