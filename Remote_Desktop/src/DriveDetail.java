
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Pratham Saroch
 */
public class DriveDetail extends javax.swing.JFrame {
    
    ArrayList<Drive> al = new ArrayList<>();
    mymodel ml = new mymodel();
    
    String name = "";
    String ip = "";
    
    public DriveDetail(String name , String gloip) {
        initComponents();
        ImageIcon ic=new ImageIcon("src/pics/blue.jpeg");
        Image img=ic.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon ic1=new ImageIcon(img);
        lb.setIcon(ic1);
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int w = d.width;
        int h = d.height;
        setSize(w, h);
        
        jTable1.setModel(ml);
        
       this.name = name;// local-global differentiate// global ka sath
        ip = gloip;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        jTable1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = jTable1.getSelectedRow();
                String type = al.get(row).type;
                String name = al.get(row).name;
                if (type.equals("directory")) {
                    DriveDetail obj = new DriveDetail(name, ip);
                    obj.setVisible(true);
                }else{
                    int a = JOptionPane.showConfirmDialog(rootPane, "Do You want to download this file");
                    if (a == JOptionPane.YES_OPTION) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                FileOutputStream fos = null;
                                try {
                                    String filepath = al.get(row).name;
                                    System.out.println(filepath);
                                    HttpResponse<InputStream> HttpResponse = Unirest.get("http://"+ip+":9000/GetResource/" + filepath)
                                            .asBinary();
                                    String filename = filepath.substring(filepath.lastIndexOf("\\"));
                                    System.out.println(filename);
                                    InputStream is = HttpResponse.getBody();
                                    fos = new FileOutputStream(System.getProperty("user.home") + "/Downloads/" + filename);
                                    String downloadfile = System.getProperty("user.home") + "/Downloads/" + filename;
                                    long contentlength = Integer.parseInt(HttpResponse.getHeaders().getFirst("Content-Length"));
                                    byte b[] = new byte[10000];
                                    int r;
                                    long count = 0;
                                    while (true) {
                                        r = is.read(b, 0, 10000);
                                        fos.write(b, 0, r);
                                        count = count + r;
                                        int per = (int) (count * 100 / contentlength);
                                        if (count == contentlength) {
                                            break;
                                        }
                                    }
                                    fos.close();
                                    JOptionPane.showMessageDialog(DriveDetail.this, "file downloaded");
                                    Desktop.getDesktop().open(new File(downloadfile));
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                } finally {
                                    try {
                                        fos.close();
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }

                        }).start();
                    }
                }
            }
        });
        
        getDriveDetail();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Drive Detail");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(600, 20, 320, 100);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(160, 210, 1260, 440);
        getContentPane().add(lb);
        lb.setBounds(0, 0, 1800, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    void getDriveDetail(){
        
        try{
        HttpResponse<String> res = Unirest.get("http://"+ip+":9000/GetDriveDetail").queryString("name",name)
                .asString();
        
        if(res.getStatus() == 200){
            String ans = res.getBody();
                if (ans.equals("download")) {
                    JOptionPane.showConfirmDialog(rootPane, "Do you want to download");
                } else {
                    
//                    JOptionPane.showMessageDialog(this, res);
                    
                    System.out.println(ans);
                    StringTokenizer st = new StringTokenizer(ans, ";;");

                    while (st.hasMoreTokens()) {
                        String row = st.nextToken();
                        StringTokenizer st2 = new StringTokenizer(row, "~~");
                        String name = st2.nextToken();
                        String type = st2.nextToken();
                        al.add(new Drive(name, type));
                    }
                    ml.fireTableDataChanged();
                }
        }
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    class mymodel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public String getColumnName(int column) {
            String col[] = {"Name" , "Type"};
            return col[column];
        }
        
        @Override
        public Object getValueAt(int i, int j) {
            Drive d = al.get(i);
            if(j == 0){
                return d.name;
            }else {
                return d.type;
            }
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
            java.util.logging.Logger.getLogger(DriveDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DriveDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DriveDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DriveDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DriveDetail("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
