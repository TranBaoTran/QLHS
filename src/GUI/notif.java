package GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class notif extends JOptionPane{
    public static void cantLogName(JFrame container){
        showMessageDialog(container, "Tên đăng nhập không tồn tại");
    }

    public static void cantLogPass(JFrame container){
        showMessageDialog(container,"Nhập sai mật khẩu");
    }

    public static void conData(JFrame container){
        showMessageDialog(container,"Khong thể kết nối đến database");
    }
}
