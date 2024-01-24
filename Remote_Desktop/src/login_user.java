
import java.awt.Image;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class login_user extends javax.swing.JFrame {

    public login_user() {
        initComponents();
        setSize(800,820);
        setLocation(350,5);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ImageIcon ic=new ImageIcon("src/pics/blue.jpeg");
        Image img=ic.getImage().getScaledInstance(ll.getWidth(), ll.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon ic1=new ImageIcon(img);
        ll.setIcon(ic1);
        ImageIcon ic2=new ImageIcon("src/pics/back_1.jpeg");
        Image img1=ic2.getImage().getScaledInstance(bb.getWidth(),bb.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon ic3=new ImageIcon(img1);
        bb.setIcon(ic3);
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        bt = new javax.swing.JButton();
        pf1 = new javax.swing.JPasswordField();
        bb = new javax.swing.JButton();
        ll = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USER   LOGIN");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 130, 580, 80);

        lb2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lb2.setText("PASSWORD");
        getContentPane().add(lb2);
        lb2.setBounds(80, 400, 140, 40);

        lb1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lb1.setText("USERNAME");
        getContentPane().add(lb1);
        lb1.setBounds(80, 290, 140, 40);

        tf1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });
        getContentPane().add(tf1);
        tf1.setBounds(280, 290, 370, 50);

        bt.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        bt.setText("Login");
        bt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(310, 580, 170, 70);

        pf1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(pf1);
        pf1.setBounds(280, 400, 370, 50);

        bb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbActionPerformed(evt);
            }
        });
        getContentPane().add(bb);
        bb.setBounds(20, 30, 100, 50);
        getContentPane().add(ll);
        ll.setBounds(0, 0, 800, 820);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed

    }//GEN-LAST:event_tf1ActionPerformed

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        // TODO add yourString u=tf1.getText().trim();
    String u=tf1.getText().trim();
     String p=pf1.getText().trim();
     if(checklogin(u,p))
     {JOptionPane.showMessageDialog(this, "LOGIN SUCCESSFUL");
     Welcome obj;
     obj=new Welcome();
     obj.setVisible(true);
     dispose();
     }
     else
     {JOptionPane.showMessageDialog(this, "LOGIN FAILED");}
    }                                  
   static boolean checklogin(String u,String p)
{try
{
    ResultSet rs=DBLOADER.executeQuery("select * from users where username=\'"+u+"\'and password =\'"+p+"\'");
    if(rs.next())
    { return true;
    }
    else
    {return false;
    }
    
}
catch(Exception ex)
{ex.printStackTrace(); 
return false;
}

    }//GEN-LAST:event_btActionPerformed

    private void bbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbActionPerformed
Start obj=new Start();
obj.setVisible(true);
dispose();

// TODO add your handling code here:
    }//GEN-LAST:event_bbActionPerformed

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
            java.util.logging.Logger.getLogger(login_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bb;
    private javax.swing.JButton bt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel ll;
    private javax.swing.JPasswordField pf1;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}
