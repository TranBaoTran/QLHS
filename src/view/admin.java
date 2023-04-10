package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

import net.sourceforge.jdatepicker.impl.*;

public class admin extends JFrame
{
    public admin(){
        //Vi tri
        this.setTitle("ADMIN");
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
        JButton NH=new JButton("Năm học");
        HS.setBounds(10,30,100,40);
        GV.setBounds(10,80,100,40);
        TK.setBounds(10,130,100,40);
        NH.setBounds(10,180,100,40);

        //inside panel
        JPanel LCon1=new JPanel();
        LCon1.setLayout(new FlowLayout(FlowLayout.CENTER));
        LCon1.setBounds(115,10,850,430);
        LCon1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Học sinh",TitledBorder.LEFT, TitledBorder.TOP));
        JPanel LCon2=new JPanel();
        LCon2.setLayout(new FlowLayout(FlowLayout.CENTER));
        LCon2.setBounds(115,10,850,430);
        LCon2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Giáo viên",TitledBorder.LEFT, TitledBorder.TOP));
        JPanel LCon3=new JPanel();
        LCon3.setLayout(new FlowLayout(FlowLayout.CENTER));
        LCon3.setBounds(115,10,850,430);
        LCon3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Tài khoản",TitledBorder.LEFT, TitledBorder.TOP));
        JPanel LCon4=new JPanel();
        LCon4.setLayout(new FlowLayout(FlowLayout.CENTER));
        LCon4.setBounds(115,10,850,430);
        LCon4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Năm học",TitledBorder.LEFT, TitledBorder.TOP));
        
        //change thing
        menuHS(LCon1);
        menuGV(LCon2);
        menuTK(LCon3);
        menuNH(LCon4);

        //
        JPanel cards = new JPanel(new CardLayout());
        cards.setBounds(115,10,850,430);
        cards.add(LCon1, "cardHS");
        cards.add(LCon2, "cardGV");
        cards.add(LCon3, "cardTK");
        cards.add(LCon4, "cardNH");
        
        //
        HS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout)(cards.getLayout());
                cardLayout.show(cards, "cardHS");
            }
        });
        GV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout)(cards.getLayout());
                cardLayout.show(cards, "cardGV");
            }
        });
        TK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout)(cards.getLayout());
                cardLayout.show(cards, "cardTK");
            }
        });
        NH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout)(cards.getLayout());
                cardLayout.show(cards, "cardNH");
            }
        });
        
        //
        Con.add(HS);
        Con.add(GV);
        Con.add(TK);
        Con.add(NH);
        Con.add(cards);
        // Con.add(LCon4);
        this.setSize(1000,500);
        this.add(Con,BorderLayout.CENTER);
        this.setResizable(false);
	    this.setVisible(true);
}
    private static void menuHS(JPanel LCon){
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
        ImageIcon icon = new ImageIcon(admin.class.getResource("/img/search.png"));
        JButton search =new JButton(icon);
        search.setPreferredSize(new Dimension(55, 30));
        idTxt.setColumns(15);

        //Table
        String[][] data = {
            { "1", "HS001","S'chn T'chai Spock", "11A1", "9.9" , "Tốt", "Tốt"},
        };
        String[] columnNames = { "STT", "Mã học sinh","Họ và tên", "Lớp" ,"Điểm trung bình","Hạnh kiểm","Học lực"};
        JTable jTable = new JTable(data, columnNames);
        jTable.setPreferredSize(new Dimension(713,300));
        JScrollPane scrollPane = new JScrollPane(jTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(730,300));
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(27);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(90);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(5).setPreferredWidth(90);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable.setDefaultRenderer(Object.class, centerRenderer);
        jTable.setDefaultEditor(Object.class, null);

        //button
        JPanel butPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        butPanel.setPreferredSize(new Dimension(800,35)); 
        JButton addButton =new JButton("Thêm");
        JButton editButton =new JButton("Sửa");
        JButton eraButton =new JButton("Xoá");
        butPanel.add(addButton);
        butPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        butPanel.add(editButton);
        butPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        butPanel.add(eraButton);

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
        LCon.add(Box.createRigidArea(new Dimension(750,20))); 
        LCon.add(butPanel);
    }

    private static void menuGV(JPanel LCon){
        //Option
        JLabel subLabel = new JLabel("Môn");
        String[] optionsSub = {"--Môn--", "Toán", "Lý", "Hoá", "Văn", "Anh", "Sinh", "Sử", "Địa", "GDCD", "Thể dục", "Tin học", "Công nghệ", "GDQP"};
        JComboBox subCombo = new JComboBox(optionsSub);
        JLabel classLabel = new JLabel("Lớp");
        String[] optionsClass = {"--Lớp--", "12A1", "12A2", "12A3", "12A4"};
        JComboBox classCombo = new JComboBox(optionsClass);
        JLabel nameLabel = new JLabel("Họ và tên");
        JTextField nameTxt=new JTextField("");
        nameTxt.setColumns(15);
        JLabel idLabel = new JLabel("Mã giáo viên");
        JTextField idTxt=new JTextField("");
        idTxt.setColumns(15);
        ImageIcon icon = new ImageIcon(admin.class.getResource("/img/search.png"));
        JButton search =new JButton(icon);
        search.setPreferredSize(new Dimension(70, 30));

        //Table
        String[][] data = {
            { "1", "GV001","Christopher Pike", "Văn", "10A1" , "6666666666"},
        };
        String[] columnNames = { "STT", "Mã giáo viên","Họ và tên", "Môn" ,"Lớp chủ nhiệm","Số điện thoại"};
        JTable jTable = new JTable(data, columnNames);
        jTable.setPreferredSize(new Dimension(713,300));
        JScrollPane scrollPane = new JScrollPane(jTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(730,300));
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(27);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(90);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(120);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable.setDefaultRenderer(Object.class, centerRenderer);
        jTable.setDefaultEditor(Object.class, null);

        //button
        JPanel butPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        butPanel.setPreferredSize(new Dimension(800,35)); 
        JButton addButton =new JButton("Thêm");
        JButton editButton =new JButton("Sửa");
        JButton eraButton =new JButton("Xoá");
        butPanel.add(addButton);
        butPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        butPanel.add(editButton);
        butPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        butPanel.add(eraButton);

        //add
        LCon.add(subLabel);
        LCon.add(subCombo);
        LCon.add(classLabel);
        LCon.add(classCombo);
        LCon.add(nameLabel);
        LCon.add(nameTxt);
        LCon.add(idLabel);
        LCon.add(idTxt);
        LCon.add(search);
        LCon.add(scrollPane, BorderLayout.CENTER);
        LCon.add(Box.createRigidArea(new Dimension(750,20))); 
        LCon.add(butPanel);
    }

    public static void menuTK(JPanel LCon){
        //Option
        JLabel jobLabel = new JLabel("Chức vụ");
        String[] optionsJob = {"--Chức vụ--", "Giáo viên", "Học sinh"};
        JComboBox jobCombo = new JComboBox(optionsJob);
        JLabel classLabel = new JLabel("Lớp");
        String[] optionsClass = {"--Lớp--", "12A1", "12A2", "12A3", "12A4"};
        JComboBox classCombo = new JComboBox(optionsClass);
        JLabel idLabel = new JLabel("Mã tài khoản");
        JTextField idTxt=new JTextField("");
        idTxt.setColumns(10);
        JLabel nameLabel = new JLabel("Tên tài khoản");
        JTextField nameTxt=new JTextField("");
        nameTxt.setColumns(10);
        JLabel datLabel = new JLabel("Trong khoảng thời gian : ");
        JLabel startLabel = new JLabel("Bắt đầu");
        // chu y itemevent actionevent
        JDatePickerImpl startDate = new JDatePickerImpl(new JDatePanelImpl(new UtilDateModel()));
        JDatePickerImpl endDate = new JDatePickerImpl(new JDatePanelImpl(new UtilDateModel()));
        JLabel endLabel = new JLabel("Kết thúc");
        ImageIcon icon = new ImageIcon(admin.class.getResource("/img/search.png"));
        JButton search =new JButton(icon);
        search.setPreferredSize(new Dimension(70, 30));

        //Table
        String[][] data = {
            { "1", "GV001","Giáo viên","pikenotdie","2-2-2254","Mở"},
        };
        String[] columnNames = { "STT", "Mã tài khoản","Vai trò","Tên tài khoản","Ngày mở","Tình trạng"};
        JTable jTable = new JTable(data, columnNames);
        jTable.setPreferredSize(new Dimension(633,270));
        JScrollPane scrollPane = new JScrollPane(jTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(650,270));
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(27);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(5).setPreferredWidth(90);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable.setDefaultRenderer(Object.class, centerRenderer);
        jTable.setDefaultEditor(Object.class, null);
        
        //button
        JPanel butPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        butPanel.setPreferredSize(new Dimension(800,35)); 
        JButton addButton =new JButton("Thêm");
        JButton editButton =new JButton("Sửa");
        JButton eraButton =new JButton("Xoá");
        butPanel.add(addButton);
        butPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        butPanel.add(editButton);
        butPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        butPanel.add(eraButton);

        //add
        LCon.add(jobLabel);
        LCon.add(jobCombo);
        LCon.add(classLabel);
        LCon.add(classCombo);
        LCon.add(idLabel);
        LCon.add(idTxt);
        LCon.add(nameLabel);
        LCon.add(nameTxt);
        LCon.add(Box.createRigidArea(new Dimension(70, 0)));
        LCon.add(datLabel);
        LCon.add(Box.createRigidArea(new Dimension(20, 0)));
        LCon.add(startLabel);
        LCon.add(startDate);
        LCon.add(endLabel);
        LCon.add(endDate);
        LCon.add(search);
        LCon.add(scrollPane, BorderLayout.CENTER);
        LCon.add(Box.createRigidArea(new Dimension(750,20))); 
        LCon.add(butPanel);
    }

    public static void menuNH(JPanel LCon){
        //changeable
        JPanel title = new JPanel(new FlowLayout(FlowLayout.CENTER));
        title.setPreferredSize(new Dimension(830,20));
        title.add(new JLabel("THÔNG TIN STARFLEET ACADEMY"));
        JPanel HK = new JPanel(new FlowLayout(FlowLayout.LEFT));
        HK.setPreferredSize(new Dimension(700,30));
        HK.add(new JLabel("Học kỳ :"));
        HK.add(Box.createRigidArea(new Dimension(10, 0)));
        final JRadioButton chk1 = new JRadioButton("Học kỳ 1");
        final JRadioButton chk2 = new JRadioButton("Học kỳ 2");
        ButtonGroup bg = new ButtonGroup();
        bg.add(chk1);
        bg.add(chk2);
        HK.add(chk1);
        HK.add(chk2);
        JPanel NH = new JPanel(new FlowLayout(FlowLayout.LEFT));
        NH.setPreferredSize(new Dimension(700,30));
        NH.add(new JLabel("Năm học :"));
        NH.setPreferredSize(new Dimension(700,30));
        NH.add(Box.createRigidArea(new Dimension(10, 0)));
        JTextField fYear=new JTextField("");
        fYear.setColumns(5);
        NH.add(fYear);
        NH.add(new JLabel(" - "));
        JTextField lYear=new JTextField("");
        lYear.setColumns(5);
        NH.add(lYear);
        JPanel DC = new JPanel(new FlowLayout(FlowLayout.LEFT));
        DC.setPreferredSize(new Dimension(700,30));
        DC.add(new JLabel("Địa chỉ :"));
        DC.add(Box.createRigidArea(new Dimension(20, 0)));
        JTextField address=new JTextField("");
        address.setColumns(30);
        DC.add(address);
        JPanel DS = new JPanel(new FlowLayout(FlowLayout.LEFT));
        DS.setPreferredSize(new Dimension(700,40));
        DS.add(new JLabel("Danh sách lớp :"));
        String[] optionsClass = {"--Lớp--", "12A1", "12A2", "12A3", "12A4"};
        JComboBox classCombo = new JComboBox(optionsClass);
        DS.add(classCombo);
        JButton add= new JButton("Thêm");
        JButton era = new JButton("Xoá");
        DS.add(Box.createRigidArea(new Dimension(5, 0)));
        DS.add(add);
        DS.add(Box.createRigidArea(new Dimension(5, 0)));
        DS.add(era);

        //button
        JPanel butPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        butPanel.setPreferredSize(new Dimension(800,35)); 
        JButton addButton =new JButton("Lưu");
        JButton editButton =new JButton("Huỷ");
        butPanel.add(addButton);
        butPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        butPanel.add(editButton);
        
        //add
        LCon.add(title);
        LCon.add(HK);
        LCon.add(NH);
        LCon.add(DC);
        LCon.add(DS);
        LCon.add(Box.createRigidArea(new Dimension(750,180))); 
        LCon.add(butPanel);
    }

    public static void main(String[] args) {
	new admin();
    }
}