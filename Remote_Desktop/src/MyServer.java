
import com.mashape.unirest.http.*;
import com.vmm.JHTTPServer;
import com.vmm.NanoHTTPD;
import static com.vmm.NanoHTTPD.HTTP_OK;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.sql.*;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class MyServer extends JHTTPServer {

    public MyServer(int port) throws IOException {
        super(port);
        System.out.println("server started");
    }

    @Override
    public NanoHTTPD.Response serve(String uri, String method, Properties header, Properties parms, Properties files) {

        if (uri.equals("/signup")) {
            String username = parms.getProperty("username");
            String email = parms.getProperty("email");
            String password = parms.getProperty("password");
            String phone = parms.getProperty("phone");
            
            System.out.println(username);
            System.out.println(email);
            System.out.println(password);
            System.out.println(phone);
            try {
                ResultSet rs = DBLOADER.executeQuery("select * from users where email = '" + email + "'");
                if (rs.next()) {
                    NanoHTTPD.Response res = new NanoHTTPD.Response(HTTP_OK, "text/plain", "exist");
                    return res;
                } else {
                    //  String photoname = saveFileOnServerWithRandomName(files, parms, "photo", "src/uploads/");
                    rs.moveToInsertRow();

                    rs.updateString("username", username);
                    rs.updateString("email", email);
                    rs.updateString("password", password);
                    rs.updateString("phone", phone);
                    // rs.updateString("photo", "src/uploads/" + photoname);
                    rs.insertRow();
                    NanoHTTPD.Response res = new NanoHTTPD.Response(HTTP_OK, "text/plain", "success");
                    return res;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/getScreenshot")) {
            try {

                System.out.println("Inside Function");

                Robot obj = new Robot();

                BufferedImage bi = obj.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

                File f = new File("src/uploads/black.png");

                ImageIO.write(bi, "PNG", f);

                String path = f.getPath();

                Response res = new Response(HTTP_OK, "text/plain", path);
                return res;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/getResource")) {
            try {
                
                
                uri = uri.substring(1);
                
                
                uri = uri.substring(uri.indexOf("/") + 1);

                Response res = sendCompleteFile(uri);
                return res;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.equals("/mouse-move")) {
            try {
                int x = Integer.parseInt(parms.getProperty("xcoord"));
                int y = Integer.parseInt(parms.getProperty("ycoord"));

                Robot rob = new Robot();
                rob.mouseMove(x, y);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/clickMouse")) {
            try {
                Robot rob = new Robot();
                rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equalsIgnoreCase("/MouseScrollable")) {
            try {
                int scroll = Integer.parseInt(parms.getProperty("scroll"));

                Robot rob = new Robot();
                rob.mouseWheel(scroll);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equalsIgnoreCase("/ClickKey")) {
            try {
                int key = Integer.parseInt(parms.getProperty("key"));
                Robot rob = new Robot();
                rob.keyPress(key);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/ReleaseKey")) {
            try {
                int key = Integer.parseInt(parms.getProperty("key"));
                Robot rob = new Robot();
                rob.keyRelease(key);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.equals("/Shutdown")) {
            try {
                Process process = Runtime.getRuntime().exec("shutdown -s -t 0");

                process.waitFor();

                System.out.println("PC is Shutting down");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.equals("/Sleep")) {
            try {
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("RUNDLL32.EXE powrprof.dll,SetSuspendState 0,1,0");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.equals("/Restart")) {
            try {
                Runtime runtime = Runtime.getRuntime();
                Process proc = runtime.exec("shutdown -r -t 0");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.equals("/SendMessage")) {
            try {
                String ans = parms.getProperty("message");
                JOptionPane.showMessageDialog(null, ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.equalsIgnoreCase("/ShowDrive")) {
            try {

                String ans = "";
                FileSystemView fsv = FileSystemView.getFileSystemView();
                File[] drives = File.listRoots();
                if (drives != null && drives.length > 0) {
                    for (File aDrive : drives) {
                        String type = fsv.getSystemTypeDescription(aDrive);
                        long totalSpace = (((aDrive.getTotalSpace() / 1024) / 1024) / 1024);
                        long freeSpace = (((aDrive.getFreeSpace() / 1024) / 1024) / 1024);
                        String single = aDrive + ";;" + type + ";;" + totalSpace + ";;" + freeSpace + ";;";
                        ans += single + "~~";
                    }
                }
                System.out.println(ans);
                Response res = new Response(HTTP_OK, "text/plain", ans);
                return res;

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equalsIgnoreCase("/GetConfiguration")) {
            try {

                String osname = System.getProperty("os.name");
                long diskSize = new File("/").getTotalSpace();
                String username = System.getProperty("user.name");
                long maxMemory = Runtime.getRuntime().maxMemory();
                long memorySize = ((com.sun.management.OperatingSystemMXBean) ManagementFactory
                        .getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
                int cores = Runtime.getRuntime().availableProcessors();

                String ans = osname + ";" + diskSize + ";" + username + ";" + cores + ";" + memorySize;
                Response res = new Response(HTTP_OK, "text/plain", ans);
                return res;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(uri.equalsIgnoreCase("/GetDriveDetail")){
            try{
                
                String name = parms.getProperty("name");
            File maindir = new File(name);
            if (maindir.exists() && maindir.isDirectory()) {
                File arr[] = maindir.listFiles();
                String ans = "";
                String type;
                for (int i = 0; i < arr.length; i++) {
                    System.out.println(arr[i]);
                    if (arr[i].isDirectory()) {
                        type = "directory";
                    }else{
                        type = "file";
                    }
                    String row = arr[i]+"~~"+type;
                    ans += row + ";;";
                }
                Response res = new Response(HTTP_OK, "text/plain", ans);
                return res;
            } else {
               Response res = new Response(HTTP_OK, "text/plain", "download");
               return res;
            }
            
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }


        return null;
    }
}

// public static void main(String[] args) {
/*  try{
        MyServer obj=new MyServer(9000);
        Thread.sleep(1000000000);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
    }
 *///}

