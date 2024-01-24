
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.vmm.NanoHTTPD;
import static com.vmm.NanoHTTPD.HTTP_OK;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class connect extends javax.swing.JFrame {

    String IP = "";

    public connect(String ip) {
        initComponents();
//        setSize(500, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // setLocation(350, 100);
        // lb.setBounds(0, 0, 1500, 800);
        IP = ip;
        System.out.println("IP :" + ip);
        capturescreen();
        //        Mouse Motion Listener To Move the mouse
        lb.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                moveMouse(x, y);
            }
        });

//        Mouse Listener To make Mouse Clickable.
        lb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clickMouse();
            }
        });
//        Mouse Wheel Listener To Make The Mouse Scrollable.
        lb.addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int scroll = e.getScrollAmount();
                mouseScrollable(scroll);
            }
        });
        lb.requestFocus();
        lb.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //super.keyPressed(e); 
                int key = e.getKeyCode();
                clickkey(key);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // super.keyReleased(e);
                int key = e.getKeyCode();
                releasekey(key);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        lbb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb.setText("j");
        getContentPane().add(lb);
        lb.setBounds(0, 0, 1240, 810);

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton1.setText("VIEW DRIVES");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1290, 680, 190, 60);

        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton2.setText("SHUTDOWN");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1280, 70, 190, 60);

        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton3.setText("RESTART");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(1280, 190, 190, 60);

        jButton4.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton4.setText("SLEEP");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(1280, 310, 190, 60);

        jButton5.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton5.setText("SEND MESSAGE");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(1280, 440, 190, 60);

        jButton6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton6.setText("GET SYSTEM CONFIGURATION");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(1250, 570, 240, 60);

        lbb.setBackground(new java.awt.Color(0, 0, 0));
        lbb.setOpaque(true);
        getContentPane().add(lbb);
        lbb.setBounds(1240, 0, 260, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Driveview obj1;
        obj1 = new Driveview(IP);
        obj1.setVisible(true);
      

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            HttpResponse<String> res = Unirest.get("http://" + IP + ":9000/Shutdown").asString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            HttpResponse<String> res = Unirest.get("http://" + IP + ":9000/Restart").asString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            HttpResponse<String> res = Unirest.get("http://" + IP + ":9000/Sleep").asString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            String ans = JOptionPane.showInputDialog(this, "write a note");
            HttpResponse<String> res = Unirest.get("http://" + IP + ":9000/SendMessage").queryString("message", ans).asString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Configuration obj = new Configuration(IP);
        obj.setVisible(true);
       
    }//GEN-LAST:event_jButton6ActionPerformed

    public void capturescreen() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("Inside Function");
                        /* new */ System.out.println("http://" + IP + ":9000/getScreenshot");
                        HttpResponse<String> res = Unirest.get("http://" + IP + ":9000/getScreenshot").asString();

                        if (res.getStatus() == 200) {
                            String path = res.getBody();

                            System.out.println("Path : " + path);

                            if (path.length() > 0) {
                                URL url = new URL("http://" + IP + ":9000/getResource/" + path);

                                ImageIcon ic = new ImageIcon(url);

                                Image img = ic.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_SMOOTH);

                                ImageIcon ic2 = new ImageIcon(img);

                                lb.setIcon(ic2);
                            }

                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
    }

    void moveMouse(int x, int y) {
        try {
            HttpResponse<String> res = Unirest.get("http://" + IP + ":9000/mouse-move").queryString("xcoord", x).queryString("ycoord", y).asString();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void clickMouse() {
        try {
            HttpResponse<String> res = Unirest.get("http://" + IP + ":9000/clickMouse").asString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void mouseScrollable(int scroll) {
        try {
            HttpResponse<String> res = Unirest.get("http://" + IP + ":9000/MouseScrollable").queryString("scroll", scroll).asString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void clickkey(int key) {
        try {
            HttpResponse<String> res = Unirest.get("http://" + IP + ":9000/ClickKey").queryString("key", key).asString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void releasekey(int key) {
        try {
            HttpResponse<String> res = Unirest.get("http://" + IP + ":9000/ReleaseKey").queryString("key", key).asString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new connect("").setVisible(true);

            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lbb;
    // End of variables declaration//GEN-END:variables
}
