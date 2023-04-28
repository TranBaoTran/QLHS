package GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class main {
    public static void main(String args[]){
        try{
        login LOG=new login();
        }
        catch(Exception e){
            JFrame frame = new JFrame("Lỗi");
            JOptionPane.showMessageDialog(frame,e.getMessage());
        }
    }
}
