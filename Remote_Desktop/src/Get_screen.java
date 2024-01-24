
import java.awt.Image;
import javax.swing.ImageIcon;


public class Get_screen extends javax.swing.JFrame {

    public Get_screen() {
        initComponents();
       setSize(800,820);
        setVisible(true);
           setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ImageIcon ic=new ImageIcon("src/pics/blue.jpeg");
        Image img=ic.getImage().getScaledInstance(lb1.getWidth(), lb1.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon ic1=new ImageIcon(img);
        lb1.setIcon(ic1);
        ImageIcon ic3=new ImageIcon("src/pics/back_1.jpeg");
        Image img1=ic3.getImage().getScaledInstance(bb.getWidth(),bb.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon ic4=new ImageIcon(img1);
        bb.setIcon(ic4);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        iptf = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        bb = new javax.swing.JButton();
        lb1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("IP");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 160, 240, 130);

        iptf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iptfActionPerformed(evt);
            }
        });
        getContentPane().add(iptf);
        iptf.setBounds(360, 210, 290, 50);

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jButton1.setText("CONNECT");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(300, 420, 160, 80);

        bb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbActionPerformed(evt);
            }
        });
        getContentPane().add(bb);
        bb.setBounds(30, 30, 110, 80);
        getContentPane().add(lb1);
        lb1.setBounds(0, 0, 800, 820);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String ans=iptf.getText();
        
        connect obj;
obj=new connect(ans);
//setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void iptfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iptfActionPerformed
     
    }//GEN-LAST:event_iptfActionPerformed

    private void bbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbActionPerformed
Welcome obj=new Welcome();
obj.setVisible(true);
dispose();// TODO add your handling code here:
    }//GEN-LAST:event_bbActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Get_screen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bb;
    private javax.swing.JTextField iptf;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb1;
    // End of variables declaration//GEN-END:variables
}
