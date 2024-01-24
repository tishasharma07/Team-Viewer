
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class Driveview extends javax.swing.JFrame {

    ArrayList<Disk> dk;
    mytablemodel tm;
    String IP = "";

    public Driveview(String ip) {
        IP = ip;
        initComponents();
       // setSize(1600, 800);
        setVisible(true);
        setLocation(350, 5);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ImageIcon ic=new ImageIcon("src/pics/blue.jpeg");
        Image img=ic.getImage().getScaledInstance(lbb.getWidth(), lbb.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon ic1=new ImageIcon(img);
        lbb.setIcon(ic1);
        dk = new ArrayList<>();
        tm = new mytablemodel();
        jt.setModel(tm);
        ShowDrive();
        jt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int r = jt.getSelectedRow();
                connect(r);
            }
        });

    }
    
    void connect(int row){
        String diskname = dk.get(row).diskname;
        
        DriveDetail obj = new DriveDetail(diskname, IP);
        obj.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt = new javax.swing.JTable();
        lbb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DISK DRIVES");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(410, 40, 500, 170);

        jt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Diskname", "Type", "Total_space", "Free_space"
            }
        ));
        jScrollPane1.setViewportView(jt);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(220, 280, 1120, 390);
        getContentPane().add(lbb);
        lbb.setBounds(0, 0, 1600, 960);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ShowDrive() {
        try {
            HttpResponse<String> res = Unirest.get("http://" + IP + ":9000/ShowDrive").asString();
            String ans = res.getBody();
            System.out.println(ans);
            StringTokenizer st = new StringTokenizer(ans, "~~");
            int n = st.countTokens();
            while (n != 0) {
                String token = st.nextToken();
                StringTokenizer s = new StringTokenizer(token, ";;");
                String diskname = s.nextToken();
                String type = s.nextToken();
                String total_space = s.nextToken();
                String free_space = s.nextToken();
                dk.add(new Disk(diskname, type, total_space, free_space));
                n--;
            }
//tm.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
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
            java.util.logging.Logger.getLogger(Driveview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Driveview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Driveview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Driveview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Driveview("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt;
    private javax.swing.JLabel lbb;
    // End of variables declaration//GEN-END:variables

    class mytablemodel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return dk.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int i, int j) {
            Disk d = dk.get(i);
            if (j == 0) {
                return d.diskname;
            } else if (j == 1) {
                return d.type;
            } else if (j == 2) {
                return d.total_space;
            } else {
                return d.free_space;
            }
        }

        @Override
        public String getColumnName(int j) {
            String cols[] = {"Diskname", "Type", "Total_space", "Free_space"};
            return cols[j];
        }

    }
}
