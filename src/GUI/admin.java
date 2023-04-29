package GUI;

import java.awt.*;
import java.awt.event.*;
import java.lang.ProcessBuilder.Redirect;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.*;
import BLL.taikhoanBLL;
import BLL.thongtinBLL;
import DTO.taikhoan;
import DTO.thongtin;


public class admin extends JFrame
{
    taikhoanBLL tkBLL= new taikhoanBLL();
    Vector<taikhoan> tk;
    thongtinBLL infoBLL=new thongtinBLL();
    thongtin info=infoBLL.getInfo();

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
        JButton CL=new JButton("Lớp");
        JButton NH=new JButton("Năm học");
        HS.setBounds(10,30,100,40);
        GV.setBounds(10,80,100,40);
        TK.setBounds(10,130,100,40);
        CL.setBounds(10,180,100,40);
        NH.setBounds(10,230,100,40);

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
        LCon4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Lớp",TitledBorder.LEFT, TitledBorder.TOP));
        JPanel LCon5=new JPanel();
        LCon5.setLayout(new FlowLayout(FlowLayout.CENTER));
        LCon5.setBounds(115,10,850,430);
        LCon5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Năm học",TitledBorder.LEFT, TitledBorder.TOP));
        
        //change thing
        menuHS(LCon1);
        menuGV(LCon2);
        menuTK(LCon3);
        menuCL(LCon4);
        menuNH(LCon5);

        //
        JPanel cards = new JPanel(new CardLayout());
        cards.setBounds(115,10,850,430);
        cards.add(LCon1, "cardHS");
        cards.add(LCon2, "cardGV");
        cards.add(LCon3, "cardTK");
        cards.add(LCon4, "cardCL");
        cards.add(LCon5, "cardNH");
        
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
        CL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout)(cards.getLayout());
                cardLayout.show(cards, "cardCL");
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
        Con.add(CL);
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

    public void menuTK(JPanel LCon){
        //Option
        JLabel jobLabel = new JLabel("Chức vụ");
        String[] optionsJob = {"--Chức vụ--", "Giáo viên", "Học sinh"};
        JComboBox jobCombo = new JComboBox(optionsJob);
        JLabel idLabel = new JLabel("Mã tài khoản");
        JTextField idTxt=new JTextField("");
        idTxt.setColumns(10);
        JLabel nameLabel = new JLabel("Tên tài khoản");
        JTextField nameTxt=new JTextField("");
        nameTxt.setColumns(10);
        JLabel datLabel = new JLabel("Trong khoảng thời gian : ");
        JLabel startLabel = new JLabel("Bắt đầu");
        // chu y itemevent actionevent
        UtilDateModel model1=new UtilDateModel();
        JDatePanelImpl pane1=new JDatePanelImpl(model1);
        JDatePickerImpl startDate = new JDatePickerImpl(pane1);
        UtilDateModel model2=new UtilDateModel();
        JDatePanelImpl pane2=new JDatePanelImpl(model2);
        JDatePickerImpl endDate = new JDatePickerImpl(pane2);
        JLabel endLabel = new JLabel("Kết thúc");
        ImageIcon icon = new ImageIcon(admin.class.getResource("/img/search.png"));
        JButton search =new JButton(icon);
        search.setPreferredSize(new Dimension(70, 30));

        //Table
        String[][] data = {};
        String[] columnNames = { "STT", "Mã tài khoản","Vai trò","Tên tài khoản","Ngày mở","Tình trạng"};
        DefaultTableModel model=new DefaultTableModel(data, columnNames);
        JTable jTable = new JTable(model);
        jTable.setPreferredSize(new Dimension(633,270));
        jTable.getColumnModel().getColumn(0).setPreferredWidth(27);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(90);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(jTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(650,270));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable.setDefaultRenderer(Object.class, centerRenderer);
        jTable.setDefaultEditor(Object.class, null);

        //action
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int Jop=0;
                String x = jobCombo.getSelectedItem().toString();
                if(x=="--Chức vụ--"){
                    Jop=0;
                }
                if(x=="Giáo viên"){
                    Jop=1;
                }
                if(x=="Học sinh"){
                    Jop=2;
                }
                String id=idTxt.getText();
                String name=nameTxt.getText();
                Date Sdate= (Date) startDate.getModel().getValue();
                Date Edate= (Date) endDate.getModel().getValue();
                String BD="";
                String KT="";
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                if(Sdate!=null){
                    java.util.Date  SD = new java.util.Date(Sdate.getTime());
                    BD = dateFormat.format(SD);
                }
                if(Edate!=null){
                    java.util.Date  ED = new java.util.Date(Edate.getTime());
                    KT = dateFormat.format(ED);
                }
                tk=tkBLL.getTK(Jop,id,name,BD,KT);
                DefaultTableModel md=new DefaultTableModel(data, columnNames);
                for(int i=0;i<tk.size();i++){
                    taikhoan acc=tk.get(i);
                    String ma=acc.getMa();
                    String vaitro=acc.getVT();
                    String ten=acc.getTen();
                    String ngaymo=acc.getNgaymo();
                    String tt="";
                    if(acc.getTinhtrang()==1){
                        tt+="Mở";
                    }
                    else{
                        tt+="Khoá";
                    }
                    Object row[] = {i+1,ma,vaitro,ten,ngaymo,tt};
                    md.addRow(row);
                }
                jTable.setModel(md);
                jTable.setPreferredSize(new Dimension(633,jTable.getRowHeight()*jTable.getRowCount()));
                jTable.getColumnModel().getColumn(0).setPreferredWidth(27);
                jTable.getColumnModel().getColumn(1).setPreferredWidth(120);
                jTable.getColumnModel().getColumn(2).setPreferredWidth(90);
                jTable.getColumnModel().getColumn(3).setPreferredWidth(120);
                jTable.getColumnModel().getColumn(4).setPreferredWidth(120);
            }   
        });
        
        //button
        JPanel butPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        butPanel.setPreferredSize(new Dimension(800,35)); 
        JButton lockButton =new JButton("Khoá");
        JButton editButton =new JButton("Sửa mật khẩu");

        //lock
        lockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int row=jTable.getSelectedRow();
                try{
                    taikhoan tmp=tk.get(row);
                    new changeTK(tmp,search);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Chưa chọn tài khoản.Vui lòng thử lại");
                }
            }
        });

        //edit
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    int row=jTable.getSelectedRow();
                    String ma=jTable.getModel().getValueAt(row,3).toString();
                    new editTK(ma);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Chưa chọn tài khoản.Vui lòng thử lại");
                }
            }
        });

        butPanel.add(lockButton);
        butPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        butPanel.add(editButton);

        //add
        LCon.add(jobLabel);
        LCon.add(jobCombo);
        LCon.add(idLabel);
        LCon.add(idTxt);
        LCon.add(nameLabel);
        LCon.add(nameTxt);
        LCon.add(Box.createRigidArea(new Dimension(200, 0)));
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

    public static void menuCL(JPanel LCon){
        JLabel gradeLabel = new JLabel("Chọn khối");
        final JCheckBox chk10 = new JCheckBox("10");
        final JCheckBox chk11 = new JCheckBox("11");
        final JCheckBox chk12 = new JCheckBox("12");
        JLabel classLabel = new JLabel("Chọn lớp");
        String[] optionsToChoose = {"--Lớp--", "12A1", "12A2", "12A3", "12A4"};
        JComboBox jComboBox = new JComboBox(optionsToChoose);
        ImageIcon icon = new ImageIcon(admin.class.getResource("/img/search.png"));
        JButton search =new JButton(icon);
        JPanel contain=new JPanel(new FlowLayout(FlowLayout.CENTER));
        contain.setPreferredSize(new Dimension(840,365));
        JLabel clName=new JLabel("Lớp :");
        JTextField clTxt=new JTextField("");
        clTxt.setColumns(5);
        JLabel headName=new JLabel("Giáo viên chủ nhiệm :");
        JTextField headTxt=new JTextField("");
        headTxt.setColumns(15);
        JLabel numName=new JLabel("Sỉ số :");
        JTextField numTxt=new JTextField("");
        numTxt.setColumns(3);
        
        JPanel op=new JPanel(new FlowLayout(FlowLayout.LEFT));
        op.setPreferredSize(new Dimension(840,30));

        JLabel DS=new JLabel("Danh sách");
        final JRadioButton chk1 = new JRadioButton("Học sinh");
        final JRadioButton chk2 = new JRadioButton("Giáo viên giảng dạy");
        ButtonGroup bg = new ButtonGroup();
        bg.add(chk1);
        bg.add(chk2);
        op.add(Box.createRigidArea(new Dimension(70,20))); 
        op.add(DS);
        op.add(chk1);
        op.add(chk2);

        chk1.setSelected(true);

        String[][] data = {};
        String[] columnNames = { "STT", "Mã học sinh","Họ và tên", "Giới tính" ,"Điểm trung bình","Hạnh kiểm","Học lực"};
        DefaultTableModel model=new DefaultTableModel(data,columnNames);
        JTable jTable = new JTable(model);
        jTable.setPreferredSize(new Dimension(713,150));
        JScrollPane scrollPane = new JScrollPane(jTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(730,150));
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

        JPanel tk=new JPanel(new FlowLayout(FlowLayout.LEFT));
        tk.setPreferredSize(new Dimension(840,30));

        JLabel SL=new JLabel("Số lượng học sinh đạt học lực: ");
        JLabel Gioi =new JLabel("Giỏi");
        JTextField gTxt= new JTextField(""); 
        gTxt.setColumns(3);
        JLabel Kha =new JLabel("Khá");
        JTextField kTxt= new JTextField("");    
        kTxt.setColumns(3);   
        JLabel TB =new JLabel("Trung bình");
        JTextField tbTxt= new JTextField("");
        tbTxt.setColumns(3);
        JLabel Yeu =new JLabel("Yếu");
        JTextField yTxt= new JTextField("");
        yTxt.setColumns(3);
        JLabel Kem =new JLabel("Kém");
        JTextField kemTxt= new JTextField("");
        kemTxt.setColumns(3);

        tk.add(SL);
        tk.add(Gioi);
        tk.add(gTxt);
        tk.add(Kha);
        tk.add(kTxt);
        tk.add(TB);
        tk.add(tbTxt);
        tk.add(Yeu);
        tk.add(yTxt);
        tk.add(Kem);
        tk.add(kemTxt);

        JPanel dtb=new JPanel(new FlowLayout(FlowLayout.LEFT));
        dtb.setPreferredSize(new Dimension(840,30));

        JLabel dtbALL=new JLabel("Diểm trung bình lớp : ");
        JTextField allTxt= new JTextField("");
        allTxt.setColumns(3);
        JLabel dtbH=new JLabel("Cao nhất : ");
        JTextField hTxt= new JTextField("");
        hTxt.setColumns(3);
        JLabel dtbL=new JLabel("Thấp nhất : ");
        JTextField lTxt= new JTextField("");
        lTxt.setColumns(3);

        dtb.add(dtbALL);
        dtb.add(allTxt);
        dtb.add(Box.createRigidArea(new Dimension(20,30))); 
        dtb.add(dtbH);
        dtb.add(hTxt);
        dtb.add(Box.createRigidArea(new Dimension(20,30))); 
        dtb.add(dtbL);
        dtb.add(lTxt);

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

        contain.add(clName);
        contain.add(clTxt);
        contain.add(headName);
        contain.add(headTxt);
        contain.add(numName);
        contain.add(numTxt);
        contain.add(op);
        contain.add(scrollPane, BorderLayout.CENTER);
        contain.add(tk);
        contain.add(dtb);
        contain.add(Box.createRigidArea(new Dimension(750,35))); 
        contain.add(butPanel);

        LCon.add(gradeLabel);
        LCon.add(chk10);
        LCon.add(chk11);
        LCon.add(chk12);
        LCon.add(classLabel);
        LCon.add(jComboBox);
        LCon.add(search);
        LCon.add(contain);
    }

    public void menuNH(JPanel LCon){
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
        if(info.getHocky()==1){
            chk1.setSelected(true);
            chk2.setEnabled(false);
        }
        else{
            chk2.setSelected(true);
            chk1.setEnabled(false);
        }
        HK.add(chk1);
        HK.add(chk2);
        JPanel NH = new JPanel(new FlowLayout(FlowLayout.LEFT));
        NH.setPreferredSize(new Dimension(700,30));
        NH.add(new JLabel("Năm học :"));
        NH.add(Box.createRigidArea(new Dimension(10, 0)));
        String year[]=info.getNamhoc().split("-");
        JTextField fYear=new JTextField(year[0]);
        fYear.setColumns(5);
        fYear.setEditable(false);
        NH.add(fYear);
        NH.add(new JLabel(" - "));
        JTextField lYear=new JTextField(year[1]);
        lYear.setColumns(5);
        lYear.setEditable(false);
        NH.add(lYear);
        JPanel DC = new JPanel(new FlowLayout(FlowLayout.LEFT));
        DC.setPreferredSize(new Dimension(700,30));
        DC.add(new JLabel("Địa chỉ :"));
        DC.add(Box.createRigidArea(new Dimension(20, 0)));
        JTextField address=new JTextField(info.getDiachi());
        address.setColumns(35);
        address.setEditable(false);
        DC.add(address);

        //button
        JPanel butPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        butPanel.setPreferredSize(new Dimension(800,35)); 
        JButton editButton =new JButton("Sửa");
        JButton saveButton =new JButton("Lưu");
        saveButton.setEnabled(false);

        //action
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(info.getHocky()==1){
                    chk2.setEnabled(true);
                }
                else{
                    chk1.setEnabled(true);
                }
                fYear.setEditable(true);
                lYear.setEditable(true);
                address.setEditable(true);
                saveButton.setEnabled(true);
                editButton.setEnabled(false);
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    int diaRS=JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn lưu");
                    if(diaRS==JOptionPane.YES_OPTION){
                        int HK=0;
                        if(chk1.isSelected()){
                            HK=1;
                        }
                        else{
                            HK=2;
                        }
                        String FY=fYear.getText().trim();
                        String LY=lYear.getText().trim();
                        String fullY=FY+"-"+LY;
                        String AR=address.getText().trim();
                        thongtin n=new thongtin(fullY, HK, AR);
                        if(n.getHocky()==info.getHocky() && n.getNamhoc().equals(info.getNamhoc()) && n.getDiachi().equals(info.getDiachi())){
                            JOptionPane.showMessageDialog(null,"Lưu thành công");
                        }
                        else{
                            int key=infoBLL.upInfo(n);
                            System.out.println(key);   
                        }
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Đã xảy ra lỗi vui lòng thử lại");
                }finally{
                    if(info.getHocky()==1){
                        chk2.setEnabled(false);
                        chk1.setSelected(true);
                        chk1.setEnabled(true);
                    }
                    else{
                        chk1.setEnabled(false);
                        chk2.setSelected(true);
                        chk2.setEnabled(true);
                    }
                    String year[]=info.getNamhoc().split("-");
                    fYear.setText(year[0]);
                    fYear.setEditable(false);
                    lYear.setText(year[1]);
                    lYear.setEditable(false);
                    address.setText(info.getDiachi());
                    address.setEditable(false);
                    editButton.setEnabled(true);
                    saveButton.setEnabled(false);
                }
            }
        });
        //addbutton
        butPanel.add(editButton);
        butPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        butPanel.add(saveButton);
        
        //add
        LCon.add(title);
        LCon.add(HK);
        LCon.add(NH);
        LCon.add(DC);
        LCon.add(Box.createRigidArea(new Dimension(750,220))); 
        LCon.add(butPanel);
    }

    public static void main(String[] args) {
	new admin();
    }
}