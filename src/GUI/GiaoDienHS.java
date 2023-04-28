package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

import net.sourceforge.jdatepicker.impl.*;

public class GiaoDienHS extends JFrame
{
public GiaoDienHS() {
	this.setTitle("Quản lí học sinh");
	this.setSize(800,700);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	JPanel jpanel_Ma=new JPanel(null);
	JLabel jlabel_Ma=new JLabel("Mã học sinh:");
	jlabel_Ma.setBounds(10, 8,100,10);
	JTextField jtext_Ma=new JTextField();
	jtext_Ma.setBounds(100, 2, 100, 20);
	JLabel jlabel_name=new JLabel("Họ và tên:"+"");
	jlabel_name.setBounds(10, 45, 100, 15);
	JTextField jtext_name=new JTextField();
	jtext_name.setBounds(80, 40, 100, 20);
	JLabel jlabel_gt=new JLabel("Giới tính:");
	jlabel_gt.setBounds(210, 45, 100, 10);
	JRadioButton jr_nam =new JRadioButton("Nam");
	jr_nam.setBounds(270, 40, 55, 20);
	JRadioButton jr_nu =new JRadioButton("Nữ");
	jr_nu.setBounds(325, 40, 50, 20);

	ButtonGroup bg = new ButtonGroup();
    bg.add(jr_nu);
    bg.add(jr_nam);

	JLabel jlabel_lop=new JLabel("Lớp:");
	jlabel_lop.setBounds(400, 45, 100, 15);
	JTextField jtext_lop=new JTextField();
	jtext_lop.setBounds(450, 40, 60, 20);
	JLabel jlabel_date=new JLabel("Ngày sinh:");
	jlabel_date.setBounds(530, 40, 70, 20);
	JDatePickerImpl jt_date = new JDatePickerImpl(new JDatePanelImpl(new UtilDateModel()));
	jt_date.setBounds(600, 40, 150, 30);

	JLabel jlabel_diachi=new JLabel("Địa chỉ:"+"");
	jlabel_diachi.setBounds(10, 85, 100, 20);
	JTextField jtext_diachi=new JTextField();
	jtext_diachi.setBounds(80, 80, 230, 30);

	JLabel jlabel_ngDamHo=new JLabel("Người giám hộ:"+"");
	jlabel_ngDamHo.setBounds(10, 135, 100, 20);
	JCheckBox jcb_ba=new JCheckBox("Ba");
	jcb_ba.setBounds(100, 135, 50, 20);
	JCheckBox jcb_me=new JCheckBox("Mẹ");
	jcb_me.setBounds(150, 135, 50, 20);
	JCheckBox jcb_khac=new JCheckBox("Khác");
	jcb_khac.setBounds(200, 135, 100, 20);

	JLabel jlabel_vt=new JLabel("Vai trò:");
	jlabel_vt.setBounds(10, 160, 100, 20);
	JTextField jtext_vt=new JTextField();
	jtext_vt.setBounds(80, 160, 50, 20);

	JLabel jlabel_ht=new JLabel("Họ tên:");
	jlabel_ht.setBounds(10, 190, 100, 20);
	JTextField jtext_ht=new JTextField();
	jtext_ht.setBounds(80, 190, 150, 20);
	JLabel jlabel_dc=new JLabel("Địa chỉ:");
	jlabel_dc.setBounds(280, 190, 150, 20);
	JTextField jtext_dc=new JTextField();
	jtext_dc.setBounds(350, 190, 250, 20);

	JLabel jlabel_nn=new JLabel("Nghề nghiệp:");
	jlabel_nn.setBounds(10, 220, 100, 20);
	JTextField jtext_nn=new JTextField();
	jtext_nn.setBounds(90, 220, 130, 20);
	JLabel jlabel_sdt=new JLabel("Số điện thoại:");
	jlabel_sdt.setBounds(250, 220, 150, 20);
	JLabel bDate=new JLabel("Ngày sinh:");
	bDate.setBounds(530, 220, 70, 20);
	JDatePickerImpl boxDate = new JDatePickerImpl(new JDatePanelImpl(new UtilDateModel()));
	boxDate.setBounds(600, 220, 150, 30);
	JTextField jtext_sdt=new JTextField();
	jtext_sdt.setBounds(350, 220, 150, 20);
	
	JLabel jlabel_diem=new JLabel("Bảng điểm:");
	jlabel_diem.setBounds(10, 270, 150, 20);
	JTable jtable=new JTable(10,6);
	jtable.setBounds(10, 300, 790, 180);
//	JTextField jtext_bangdiem=new JTextField();
//	jtext_bangdiem.setBounds(10, 300, 700, 100);
	
	JLabel jlabel_hanhkiem=new JLabel("Hạnh kiểm:");
	jlabel_hanhkiem.setBounds(400, 500, 100, 20);
	JTextField jtext_hanhkiem=new JTextField();
	jtext_hanhkiem.setBounds(470, 500, 50, 20);
	JLabel jlabel_dtb=new JLabel("Điểm trung bình:");
	jlabel_dtb.setBounds(550, 500, 100, 20);
	JTextField jtext_dtb=new JTextField();
	jtext_dtb.setBounds(650, 500, 40, 20);
	JLabel jlabel_rank=new JLabel("Thứ hạng:");
	jlabel_rank.setBounds(400, 530, 100, 20);
	JTextField jtext_rank=new JTextField();
	jtext_rank.setBounds(470, 530, 40, 20);
	JLabel jlabel_XLHL=new JLabel("XLHL:");
	jlabel_XLHL.setBounds(550, 530, 40, 20);
	JTextField jtext_XLHL=new JTextField();
	jtext_XLHL.setBounds(600, 530, 40, 20);
	JLabel jlabel_rankAll=new JLabel("Thứ hạng toàn trường:");
	jlabel_rankAll.setBounds(400, 560, 150, 20);
	JTextField jtext_rankAll=new JTextField();
	jtext_rankAll.setBounds(540, 560, 40, 20);
	JLabel jlabel_off=new JLabel("Số ngày nghỉ: ");
	jlabel_off.setBounds(600, 560, 120, 20);
	JTextField jtext_off=new JTextField();
	jtext_off.setBounds(690, 560, 40, 20);
	
	JLabel jlabel_cophep=new JLabel("Có phép:");
	jlabel_cophep.setBounds(400, 590, 100, 20);
	JTextField jtext_cophep=new JTextField();
	jtext_cophep.setBounds(460, 590, 50, 20);
	JLabel jlabel_kophep=new JLabel("Không phép:");
	jlabel_kophep.setBounds(530, 590, 120, 20);
	JTextField jtext_kophep=new JTextField();
	jtext_kophep.setBounds(630, 590, 50, 20);
	
	JButton jbutton_sua=new JButton("Sửa");
	jbutton_sua.setBounds(680, 620, 60, 20);

	
	jpanel_Ma.add(jlabel_Ma);
	jpanel_Ma.add(jtext_Ma);
	jpanel_Ma.add(jlabel_name);
	jpanel_Ma.add(jtext_name);
	jpanel_Ma.add(jlabel_gt);
	jpanel_Ma.add(jlabel_lop);
	jpanel_Ma.add(jtext_lop);
	jpanel_Ma.add(jlabel_diachi);
	jpanel_Ma.add(jtext_diachi);
	
	jpanel_Ma.add(jlabel_ngDamHo);
	jpanel_Ma.add(jcb_ba);
	jpanel_Ma.add(jcb_me);
	jpanel_Ma.add(jcb_khac);

	jpanel_Ma.add(jlabel_vt);
	jpanel_Ma.add(jtext_vt);

	jpanel_Ma.add(jlabel_ht);
	jpanel_Ma.add(jtext_ht);
	jpanel_Ma.add(jlabel_dc);
	jpanel_Ma.add(jtext_dc);
	jpanel_Ma.add(jlabel_nn);
	jpanel_Ma.add(jtext_nn);
	jpanel_Ma.add(jlabel_sdt);

	jpanel_Ma.add(bDate);
	jpanel_Ma.add(boxDate);

	jpanel_Ma.add(jtext_sdt);
	jpanel_Ma.add(jlabel_diem);
	jpanel_Ma.add(jtable);
//	jpanel_Ma.add(jtext_bangdiem);
	jpanel_Ma.add(jlabel_hanhkiem);
	jpanel_Ma.add(jtext_hanhkiem);
	jpanel_Ma.add(jlabel_dtb);
	jpanel_Ma.add(jtext_dtb);
	jpanel_Ma.add(jlabel_rank);
	jpanel_Ma.add(jtext_rank);
	jpanel_Ma.add(jlabel_XLHL);
	jpanel_Ma.add(jtext_XLHL);
	jpanel_Ma.add(jlabel_rankAll);
	jpanel_Ma.add(jtext_rankAll);
	jpanel_Ma.add(jlabel_off);
	jpanel_Ma.add(jtext_off);
	jpanel_Ma.add(jlabel_cophep);
	jpanel_Ma.add(jtext_cophep);
	jpanel_Ma.add(jlabel_kophep);
	jpanel_Ma.add(jtext_kophep);
	jpanel_Ma.add(jbutton_sua);
	jpanel_Ma.add(jr_nam);
	jpanel_Ma.add(jr_nu);
	jpanel_Ma.add(jlabel_date);
	jpanel_Ma.add(jt_date);
	this.add(jpanel_Ma);
	
	this.setVisible(true);
}
public static void main(String[] args) {
	new GiaoDienHS();
}
}
