
import java.awt.Image;
import javax.swing.ImageIcon;


public class Start extends javax.swing.JFrame {

    /**
     * Creates new form welcome
     */
    public Start() {
        initComponents();
        ImageIcon ic=new ImageIcon("src/pics/tv.jpg");
        Image img=ic.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon ic1=new ImageIcon(img);
        
        lb.setIcon(ic1);
        ImageIcon ic2=new ImageIcon("src/pics/blue.jpeg");
        Image img1=ic2.getImage().getScaledInstance(uplb.getWidth(), uplb.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon ic3=new ImageIcon(img1);
        
        uplb.setIcon(ic3);
        
        setSize(800,820);
           setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        bt2 = new javax.swing.JButton();
        bt1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        uplb = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Submitted By  :: Tisha Sharma");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb.setBackground(new java.awt.Color(102, 204, 255));
        lb.setText("t");
        getContentPane().add(lb);
        lb.setBounds(50, 70, 690, 470);

        bt2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        bt2.setText("SIGN UP");
        bt2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(430, 620, 190, 70);

        bt1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        bt1.setText("LOGIN");
        bt1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(130, 620, 190, 70);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Submitted By :: Tisha Sharma");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 720, 570, 60);
        getContentPane().add(uplb);
        uplb.setBounds(0, 0, 800, 820);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
   User_sign_up obj2;
   obj2=new User_sign_up();
   obj2.setVisible(true);
   dispose();
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        login_user obj3;
        obj3=new login_user();
        obj3.setVisible(true);
         dispose();
    }//GEN-LAST:event_bt1ActionPerformed

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
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel uplb;
    // End of variables declaration//GEN-END:variables
}
