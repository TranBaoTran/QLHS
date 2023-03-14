package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import java.util.concurrent.Flow;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class admin extends JFrame
{
    public admin(){
        //Vi tri
        this.setTitle("ADMIN");
	    this.setSize(1000,500);
        this.setLocation(300,100);;
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.setLayout(null);
        
        JPanel Con=new JPanel();
        Con.setLayout(null);
        Con.setBounds(5,5,975,450);
        Con.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Thông tin quản lý",TitledBorder.LEFT, TitledBorder.TOP));
        
        // //Lua chon
        JButton HS=new JButton("Học sinh");
        JButton GV=new JButton("Giáo viên");
        JButton TK=new JButton("Tài khoản");
        HS.setBounds(10,30,100,40);
        GV.setBounds(10,80,100,40);
        TK.setBounds(10,130,100,40);
        Con.add(HS);
        Con.add(GV);
        Con.add(TK);

        //inside panel
        JPanel LCon=new JPanel();
        LCon.setLayout(new FlowLayout(FlowLayout.LEFT));
        LCon.setBounds(115,10,850,430);
        LCon.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Dữ liệu",TitledBorder.LEFT, TitledBorder.TOP));
        
        //change thing
        JLabel gradeLabel = new JLabel("Chọn khối");
        String[] gradeOption= {"--Khối--","10","11","12"};
        JComboBox gradeBox = new JComboBox(gradeOption);
        JLabel classLabel = new JLabel("Chọn lớp");
        String[] optionsToChoose = {"--Lớp--", "12A1", "12A2", "12A3", "12A4"};
        JComboBox jComboBox = new JComboBox(optionsToChoose);
        JLabel nameLabel = new JLabel("Họ và tên");
        JTextField nameTxt=new JTextField("");
        nameTxt.setColumns(15);
        JLabel idLabel = new JLabel("Mã học sinh");
        JTextField idTxt=new JTextField("");
        idTxt.setColumns(15);
        LCon.add(gradeLabel);
        LCon.add(gradeBox);
        LCon.add(classLabel);
        LCon.add(jComboBox);
        LCon.add(nameLabel);
        LCon.add(nameTxt);
        LCon.add(idLabel);
        LCon.add(idTxt);
        
        //Table
        String[][] Data = {};
        String[] columnNames = { "STT", "Họ và tên", "Lớp" };
        JTable jTable = new JTable(Data,columnNames);
        jTable.setSize(400,400);
        LCon.add(jTable);

        Con.add(LCon);
        this.add(Con,BorderLayout.CENTER);
	    this.setVisible(true);
}
    public static void main(String[] args) {
	new admin();
    }
}