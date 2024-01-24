
import java.awt.Image;
import javax.swing.JFileChooser;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class User_sign_up extends javax.swing.JFrame {

    /*File ph;
    JFileChooser jfc;
     */
    public User_sign_up() {
        initComponents();
        setSize(800, 820);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ImageIcon ic = new ImageIcon("src/pics/blue.jpeg");
        Image img = ic.getImage().getScaledInstance(ll.getWidth(), ll.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        ll.setIcon(ic1);
        ImageIcon ic3 = new ImageIcon("src/pics/back_1.jpeg");
        Image img1 = ic3.getImage().getScaledInstance(bb.getWidth(), bb.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic2 = new ImageIcon(img1);
        bb.setIcon(ic2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        phonetf = new javax.swing.JTextField();
        usernametf = new javax.swing.JTextField();
        emailtf = new javax.swing.JTextField();
        bt2 = new javax.swing.JButton();
        passwordtf = new javax.swing.JPasswordField();
        ll = new javax.swing.JLabel();
        bb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USER SIGN UP");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 80, 570, 70);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Username");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 200, 130, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Email");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 310, 130, 40);

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 410, 130, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(" Phone No.");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 530, 130, 40);
        getContentPane().add(phonetf);
        phonetf.setBounds(270, 530, 400, 40);
        getContentPane().add(usernametf);
        usernametf.setBounds(270, 210, 400, 40);
        getContentPane().add(emailtf);
        emailtf.setBounds(270, 310, 400, 40);

        bt2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        bt2.setText("SUBMIT");
        bt2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(380, 660, 150, 60);
        getContentPane().add(passwordtf);
        passwordtf.setBounds(270, 420, 400, 40);
        getContentPane().add(ll);
        ll.setBounds(0, 0, 800, 880);

        bb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbActionPerformed(evt);
            }
        });
        getContentPane().add(bb);
        bb.setBounds(10, 10, 100, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        String username = usernametf.getText();
        String email = emailtf.getText();
        String password = passwordtf.getText();
        String phone = phonetf.getText();
        if (username.isEmpty() || email.isEmpty() || password.equals("") || phone.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "All fileds are Mandatory");
        } else {
// with otp signup
//            int otp = (int) (1000 + (9999 - 1000) * Math.random());
//            sendemail obj = new sendemail(email, "OTP for Verification", otp + "");
//
//            int ans2 = Integer.parseInt(JOptionPane.showInputDialog("Enter The OTP"));
//
//            if (otp == ans2) {
//                JOptionPane.showMessageDialog(this, "OTP Matched Successfully");
//
//                String ans = MyClient.signup(username, email, password, phone);
//
//                if (ans.trim().equals("exist")) {
//                    JOptionPane.showMessageDialog(rootPane, "Already Exist");
//                } else if (ans.trim().equals("success")) {
//                    JOptionPane.showMessageDialog(rootPane, "success");
//                } else {
//                    JOptionPane.showMessageDialog(rootPane, ans);
//                }
//
//            } else {
//                JOptionPane.showMessageDialog(this, "Wrong OTP");
//            }
// without otp sign up
         String  ans = MyClient.signup(username, email, password, phone);
         
         if(ans.trim().equals("exist"))
         {
             JOptionPane.showMessageDialog(rootPane, "Already Exist");
         }
         else if(ans.trim().equals("success"))
         {
             JOptionPane.showMessageDialog(rootPane, "success");
         }
         else
         {
             JOptionPane.showMessageDialog(rootPane, ans);
         }
        }


    }//GEN-LAST:event_bt2ActionPerformed

    private void bbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbActionPerformed
        Start obj = new Start();
        obj.setVisible(true);
dispose();// TODO add your handling code here:
    }//GEN-LAST:event_bbActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_sign_up().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bb;
    private javax.swing.JButton bt2;
    private javax.swing.JTextField emailtf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel ll;
    private javax.swing.JPasswordField passwordtf;
    private javax.swing.JTextField phonetf;
    private javax.swing.JTextField usernametf;
    // End of variables declaration//GEN-END:variables
}
