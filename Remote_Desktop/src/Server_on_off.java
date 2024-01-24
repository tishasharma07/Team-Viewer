
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;




public class Server_on_off extends javax.swing.JFrame {
    MyServer obj;

    public Server_on_off() {
        initComponents();
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        bt.setEnabled(false);
        ImageIcon ic=new ImageIcon("src/pics/server.jpeg");
        Image img=ic.getImage().getScaledInstance(lb.getWidth(),lb.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon ic1=new ImageIcon(img); 
         lb.setIcon(ic1);
        setSize(700,700);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bt = new javax.swing.JButton();
        start_bt = new javax.swing.JButton();
        stop_bt1 = new javax.swing.JButton();
        lb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.blue);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SERVER  ON/OFF");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 20, 460, 90);

        bt.setBackground(new java.awt.Color(51, 102, 255));
        bt.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        bt.setText("Launch Team Viewer ");
        bt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(210, 510, 290, 90);

        start_bt.setBackground(new java.awt.Color(51, 102, 255));
        start_bt.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        start_bt.setText("START");
        start_bt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        start_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_btActionPerformed(evt);
            }
        });
        getContentPane().add(start_bt);
        start_bt.setBounds(210, 190, 290, 90);

        stop_bt1.setBackground(new java.awt.Color(51, 102, 255));
        stop_bt1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        stop_bt1.setText("STOP");
        stop_bt1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        stop_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stop_bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(stop_bt1);
        stop_bt1.setBounds(210, 350, 290, 90);

        lb.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lb);
        lb.setBounds(-20, -20, 780, 740);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void start_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_btActionPerformed
     try{  obj=new MyServer(9000);   
       start_bt.setEnabled(false);
       bt.setEnabled(true);
       
     stop_bt1.setEnabled(true);}
     catch(Exception ex)
     {ex.printStackTrace();
     }
    }//GEN-LAST:event_start_btActionPerformed

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
       Start obj1;
        start_bt.setEnabled(false);
       bt.setEnabled(true);
       stop_bt1.setEnabled(true);
       obj1=new Start();
       obj1.setVisible(true);         
//dispose();
    }//GEN-LAST:event_btActionPerformed

    private void stop_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stop_bt1ActionPerformed
     obj.shutdown();
      start_bt.setEnabled(true);
      stop_bt1.setEnabled(false);
      bt.setEnabled(false);
      
     
    }//GEN-LAST:event_stop_bt1ActionPerformed

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
            java.util.logging.Logger.getLogger(Server_on_off.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server_on_off.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server_on_off.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server_on_off.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server_on_off().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb;
    private javax.swing.JButton start_bt;
    private javax.swing.JButton stop_bt1;
    // End of variables declaration//GEN-END:variables
}
