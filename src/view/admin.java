package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import java.util.concurrent.Flow;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
        LCon.setLayout(new FlowLayout(FlowLayout.CENTER));
        LCon.setBounds(115,10,850,430);
        LCon.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Dữ liệu",TitledBorder.LEFT, TitledBorder.TOP));
        
        //change thing
        menuHS(LCon);
        
        Con.add(LCon);
        this.add(Con,BorderLayout.CENTER);
        this.setResizable(false);
	    this.setVisible(true);
}

    private static void menuHS(JPanel LCon){
        LCon.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Học  sinh",TitledBorder.LEFT, TitledBorder.TOP));
        //Option
        JLabel gradeLabel = new JLabel("Chọn khối");
        final JCheckBox chk10 = new JCheckBox("10");
        final JCheckBox chk11 = new JCheckBox("11");
        final JCheckBox chk12 = new JCheckBox("12");
        JLabel classLabel = new JLabel("Chọn lớp");
        String[] optionsToChoose = {"--Lớp--", "12A1", "12A2", "12A3", "12A4"};
        JComboBox jComboBox = new JComboBox(optionsToChoose);
        JLabel nameLabel = new JLabel("Họ và tên");
        JTextField nameTxt=new JTextField("");
        nameTxt.setColumns(15);
        JLabel idLabel = new JLabel("Mã học sinh");
        JTextField idTxt=new JTextField("");
        ImageIcon searchIcon=new ImageIcon("search-icon.png");
        JButton search =new JButton(searchIcon);
        search.setPreferredSize(new Dimension(50, 30));
        idTxt.setColumns(15);

        //Table
        String[][] data = {
            { "1", "S'chn T'chai Spock", "11A1", "9.9" , "Tốt", "Tốt"},
        };
        String[] columnNames = { "STT", "Họ và tên", "Lớp" ,"Điểm trung bình","Hạnh kiểm","Học lực"};
        JTable jTable = new JTable(data, columnNames);
        jTable.setPreferredSize(new Dimension(683,300));
        JScrollPane scrollPane = new JScrollPane(jTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(700,300));
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(27);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(90);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(90);
        jTable.getColumnModel().getColumn(5).setPreferredWidth(90);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable.setDefaultRenderer(Object.class, centerRenderer);
        jTable.setDefaultEditor(Object.class, null);

        //add
        LCon.add(gradeLabel);
        LCon.add(chk10);
        LCon.add(chk11);
        LCon.add(chk12);
        LCon.add(classLabel);
        LCon.add(jComboBox);
        LCon.add(nameLabel);
        LCon.add(nameTxt);
        LCon.add(idLabel);
        LCon.add(idTxt);
        LCon.add(search);
        LCon.add(scrollPane, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
	new admin();
    }
}