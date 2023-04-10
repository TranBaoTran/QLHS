package view;

//import java.awt.*;
import javax.swing.*;
//import java.util.Scanner;
import javax.swing.table.DefaultTableCellRenderer;

public class GiaoVien_GUI extends JFrame {
	private JPanel p1, p2;
	private JTabbedPane tab = new JTabbedPane();
	private int key = 0;
    private String cls[] = {"","10A1","10A2","10A3","11A1","11A2","11A3","12A1","12A2","12A3",};

	public GiaoVien_GUI() {
		setTitle("Giáo viên");
		
		p1 = new JPanel(null);
        //p1.setBorder(BorderFactory.createTitledBorder(""));
        
		tab.setBounds(0,0,700,540);
		tab.add("Lớp học",p1);
		
		if (key == 0) {
			CN_Tab();
		}
		
		JLabel code = new JLabel("Mã giáo viên:");
		code.setBounds(20, 20, 100, 20);
        JTextField txt_code = new JTextField("02122004");
        txt_code.setBounds(120,20,180,20);
        txt_code.setEditable(false);
		p1.add(code);
        p1.add(txt_code);
		
		JLabel name = new JLabel("Họ tên:");
		name.setBounds(20,60,50,20);
        JTextField txt_name = new JTextField("Tun Văn Từn");
        txt_name.setBounds(120,60,180,20);
		p1.add(name);
        p1.add(txt_name);
		
		JLabel sex = new JLabel("Giới tính:");
		sex.setBounds(340,60,60,20);
        JCheckBox cbox_female = new JCheckBox("Nữ");
        JCheckBox cbox_male = new JCheckBox("Nam");
        JCheckBox cbox_else = new JCheckBox("Khác");
        cbox_female.setBounds(500,60,60,20);
        cbox_male.setBounds(426,60,60,20);
        cbox_else.setBounds(560,60,60,20);
        p1.add(cbox_male);
        p1.add(cbox_female);
        p1.add(cbox_else);
        p1.add(sex);

        JLabel addr = new JLabel("Địa chỉ:");
        addr.setBounds(20,100,50,20);
        JTextField txt_addr = new JTextField("ShangHai");
        txt_addr.setBounds(120,100,180,20);
        p1.add(addr);
        p1.add(txt_addr);

        JLabel phone = new JLabel("Số điện thoại:");
        phone.setBounds(340,100,100,20);
        JTextField txt_phone = new JTextField("0336514***");
        txt_phone.setBounds(430,100,180,20);
        p1.add(phone);
        p1.add(txt_phone);

        JLabel sub = new JLabel("Môn giảng dạy:");
        sub.setBounds(20,140,130,20);
        JTextField txt_sub = new JTextField("Đoán xem");
        txt_sub.setBounds(120,140,180,20);
        txt_sub.setEditable(false);
        p1.add(sub);
        p1.add(txt_sub);

        JLabel clss = new JLabel("Lớp:");
        clss.setBounds(340,140,50,20);
        p1.add(clss);
        JComboBox<String> cbclss = new JComboBox<>(cls);
        cbclss.setBounds(430,140,70,20);
        p1.add(cbclss);
        
        String data[][] = {{"1","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"},{"2","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"},{"3","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"},{"4","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"},{"5","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"},{"6","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"},{"7","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"},{"8","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"},{"9","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"},{"10","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"},{"11","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"},{"12","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"},{"13","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"},{"14","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"},{"15","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"},{"16","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"},{"17","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"},};
        String column[] = {"STT","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II","Học kỳ","Tổng kết"}; 
        JTable tb = new JTable(data,column);
        tb.setBounds(20,180,640,230);
        //tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tb.getColumnModel().getColumn(0).setPreferredWidth(35);
        tb.getColumnModel().getColumn(1).setPreferredWidth(150);
        tb.getColumnModel().getColumn(2).setPreferredWidth(40);
        tb.getColumnModel().getColumn(3).setPreferredWidth(60);
        tb.getColumnModel().getColumn(4).setPreferredWidth(60);
        tb.getColumnModel().getColumn(5).setPreferredWidth(60);
        tb.getColumnModel().getColumn(6).setPreferredWidth(60);
        tb.getColumnModel().getColumn(7).setPreferredWidth(60);
        tb.getColumnModel().getColumn(8).setPreferredWidth(60);
        tb.getColumnModel().getColumn(9).setPreferredWidth(60);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tb.setDefaultRenderer(Object.class, centerRenderer);
        
        JScrollPane sp = new JScrollPane(tb);
        sp.setBounds(20, 180, 640, 230);
        p1.add(sp);

        JButton bt_save = new JButton("Lưu");
        bt_save.setBounds(520,430,60,20);
        p1.add(bt_save);
        JButton bt_cancel = new JButton("Hủy");
        bt_cancel.setBounds(600,430,60,20);
        p1.add(bt_cancel);
		
		getContentPane().add(tab);
        setSize(700,540);
		setLocationRelativeTo(null);
        setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void CN_Tab() {
		p2 = new JPanel(null);
		tab.add("Chủ Nhiệm",p2);

        JLabel cls = new JLabel("Lớp:");
        cls.setBounds(20,20,50,20);
        p2.add(cls);
        JTextField txt_cls = new JTextField();
        txt_cls.setBounds(100,20,80,20);
        txt_cls.setEditable(false);
        p2.add(txt_cls);

        JLabel sl = new JLabel("Sỉ số:");
        sl.setBounds(20,60,70,20);
        p2.add(sl);
        JTextField txt_sl = new JTextField();
        txt_sl.setBounds(100,60,50,20);
        txt_sl.setEditable(false);
        p2.add(txt_sl);

        JLabel name = new JLabel("Giáo viên chủ nhiệm:");
		name.setBounds(270,20,150,20);
        JTextField txt_name = new JTextField("Tun Văn Từn");
        txt_name.setBounds(410,20,180,20);
        txt_name.setEditable(false);
		p2.add(name);
        p2.add(txt_name);

        JLabel code = new JLabel("Mã giáo viên:");
		code.setBounds(270, 60, 100, 20);
        JTextField txt_code = new JTextField("02122004");
        txt_code.setBounds(410,60,180,20);
        txt_code.setEditable(false);
		p2.add(code);
        p2.add(txt_code);

        JLabel list = new JLabel("Danh sách học sinh:");
        list.setBounds(20,100,150,20);
        p2.add(list);

        String data[][] = {{"1","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II"},{"2","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II"},{"3","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II"},{"4","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II"},{"5","Họ tên","Lớp","Miệng","15 phút I","15 phút II","1 Tiết I","1 Tiết II"},{"6","Họ tên","Giới tính","Vắng (P)","Vắng (KP)","Hạnh kiểm","Điểm TB","XLHL"},{"7","Họ tên","Giới tính","Vắng (P)","Vắng (KP)","Hạnh kiểm","Điểm TB","XLHL"},{"8","Họ tên","Giới tính","Vắng (P)","Vắng (KP)","Hạnh kiểm","Điểm TB","XLHL"},{"9","Họ tên","Giới tính","Vắng (P)","Vắng (KP)","Hạnh kiểm","Điểm TB","XLHL"},{"10","Họ tên","Giới tính","Vắng (P)","Vắng (KP)","Hạnh kiểm","Điểm TB","XLHL"},{"11","Họ tên","Giới tính","Vắng (P)","Vắng (KP)","Hạnh kiểm","Điểm TB","XLHL"},{"12","Họ tên","Giới tính","Vắng (P)","Vắng (KP)","Hạnh kiểm","Điểm TB","XLHL"}};
        String column[] = {"STT","Họ tên","Giới tính","Vắng (P)","Vắng (KP)","Hạnh kiểm","Điểm TB","XLHL"}; 
        JTable tb = new JTable(data,column);
        tb.setBounds(20,140,640,200);
        //tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tb.getColumnModel().getColumn(0).setPreferredWidth(35);
        tb.getColumnModel().getColumn(1).setPreferredWidth(190);
        tb.getColumnModel().getColumn(2).setPreferredWidth(70);
        tb.getColumnModel().getColumn(3).setPreferredWidth(70);
        tb.getColumnModel().getColumn(4).setPreferredWidth(70);
        tb.getColumnModel().getColumn(5).setPreferredWidth(70);
        tb.getColumnModel().getColumn(6).setPreferredWidth(70);
        tb.getColumnModel().getColumn(7).setPreferredWidth(70);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tb.setDefaultRenderer(Object.class, centerRenderer);
        
        JScrollPane sp = new JScrollPane(tb);
        sp.setBounds(20, 140, 640, 190);
        p2.add(sp);

        JLabel hk = new JLabel("Xếp loại hạnh kiểm:");
        hk.setBounds(20,350,150,20);
        p2.add(hk);
        JLabel hkt = new JLabel("Tổt:");
        hkt.setBounds(190,350,50,20);
        JTextField txt_hkt = new JTextField();
        txt_hkt.setBounds(220,350,30,20);
        txt_hkt.setEditable(false);
        JLabel hkk = new JLabel("Khá:");
        hkk.setBounds(300,350,50,20);
        JTextField txt_hkk = new JTextField();
        txt_hkk.setBounds(330,350,30,20);
        txt_hkk.setEditable(false);
        JLabel hktb = new JLabel("Trung bình:");
        hktb.setBounds(410,350,80,20);
        JTextField txt_hktb = new JTextField();
        txt_hktb.setBounds(483,350,30,20);
        txt_hktb.setEditable(false);
        JLabel hky = new JLabel("Yếu:");
        hky.setBounds(570,350,50,20);
        JTextField txt_hky = new JTextField();
        txt_hky.setBounds(605,350,30,20);
        txt_hky.setEditable(false);
        p2.add(hkt);
        p2.add(txt_hkt);
        p2.add(hkk);
        p2.add(txt_hkk);
        p2.add(hktb);
        p2.add(txt_hktb);
        p2.add(hky);
        p2.add(txt_hky);

        JLabel hl = new JLabel("Xếp loại học lực:");
        hl.setBounds(20,390,150,20);
        JLabel hlg = new JLabel("Giỏi:");
        hlg.setBounds(150,390,50,20);
        JTextField txt_hlg = new JTextField();
        txt_hlg.setBounds(180,390,30,20);
        txt_hlg.setEditable(false);
        JLabel hlk = new JLabel("Khá:");
        hlk.setBounds(240,390,50,20);
        JTextField txt_hlk = new JTextField();
        txt_hlk.setBounds(270,390,30,20);
        txt_hlk.setEditable(false);
        JLabel hltb = new JLabel("Trung bình:");
        hltb.setBounds(335,390,80,20);
        JTextField txt_hltb = new JTextField();
        txt_hltb.setBounds(405,390,30,20);
        txt_hltb.setEditable(false);
        JLabel hly = new JLabel("Yếu:");
        hly.setBounds(475,390,50,20);
        JTextField txt_hly = new JTextField();
        txt_hly.setBounds(505,390,30,20);
        txt_hly.setEditable(false);
        JLabel hlke = new JLabel("Kém");
        hlke.setBounds(570,390,50,20);
        JTextField txt_hlke = new JTextField();
        txt_hlke.setBounds(600,390,30,20);
        txt_hlke.setEditable(false);
        p2.add(hlg);
        p2.add(txt_hlg);
        p2.add(hlk);
        p2.add(txt_hlk);
        p2.add(hltb);
        p2.add(txt_hltb);
        p2.add(hly);
        p2.add(txt_hly);
        p2.add(hlke);
        p2.add(txt_hlke);
        p2.add(hl);

        JButton bt_save = new JButton("Lưu");
        bt_save.setBounds(520,430,60,20);
        p2.add(bt_save);
        JButton bt_cancel = new JButton("Hủy");
        bt_cancel.setBounds(600,430,60,20);
        p2.add(bt_cancel);
	}

    public static void main(String args[]){
        new GiaoVien_GUI();
    }
}
