
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Image;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author tisha
 */
public class Configuration extends javax.swing.JFrame {

    /**
     * Creates new form Configuration
     */
    String IP="";
    public Configuration(String ip) {
        initComponents();
      //  setSize(1600,800);
        setVisible(true);
        //setLocation(350,5);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ImageIcon ic=new ImageIcon("src/pics/blue.jpeg");
        Image img=ic.getImage().getScaledInstance(lbb.getWidth(), lbb.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon ic1=new ImageIcon(img);
        lbb.setIcon(ic1);
        IP=ip; 
        GetConfiguration();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lbb = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SYSTEM CONFIGURATION");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(490, 20, 550, 100);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Operating System ::");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(480, 200, 230, 50);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Disk Size ::");
        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(480, 270, 230, 50);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Core is ::");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(480, 480, 230, 50);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Username is ::");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(480, 340, 230, 50);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Max Memory ::");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(480, 410, 230, 50);

        lb5.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        lb5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb5.setText("gkbkbmkk");
        getContentPane().add(lb5);
        lb5.setBounds(870, 480, 290, 50);

        lb1.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb1.setText("gkbkbmkk");
        getContentPane().add(lb1);
        lb1.setBounds(860, 200, 290, 50);

        lb2.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        lb2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb2.setText("gkbkbmkk");
        getContentPane().add(lb2);
        lb2.setBounds(870, 270, 290, 50);

        lb3.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        lb3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb3.setText("gkbkbmkk");
        getContentPane().add(lb3);
        lb3.setBounds(870, 340, 290, 50);

        lb4.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        lb4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb4.setText("gkbkbmkk");
        getContentPane().add(lb4);
        lb4.setBounds(870, 410, 290, 50);
        getContentPane().add(lbb);
        lbb.setBounds(-230, 0, 1830, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents
 void GetConfiguration()
    { try
    {HttpResponse<String>res=Unirest.get("http://"+IP+":9000/GetConfiguration").asString();
    String ans=res.getBody();
        System.out.println(ans);
        StringTokenizer st=new StringTokenizer(ans,";");
        
            String os=st.nextToken();
        lb1.setText(os);
        String ds=st.nextToken();
        lb2.setText(ds);
        String un=st.nextToken();
        lb3.setText(un);
        String mm=st.nextToken();
        lb4.setText(mm);
        String c=st.nextToken();
        lb5.setText(c);
        
              
    }
    catch(Exception ex)
    {ex.printStackTrace();
    }
    }
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
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuration("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lbb;
    // End of variables declaration//GEN-END:variables
}
