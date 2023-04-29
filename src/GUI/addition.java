package GUI;

import java.awt.event.*;
import javax.swing.*;

import DTO.taikhoan;
import DTO.user;
import BLL.userBLL;
import BLL.taikhoanBLL;

public class addition {
    
}

class editTK extends JFrame implements ActionListener{
    private JPasswordField pass;
    private JPasswordField txtPass;
    private JTextField name;
    private JButton save;
    private JButton cancel;
    private ImageIcon icon;
    private ImageIcon icons;
    private JButton seeBut1;
    private JButton seeBut2;
    private String TenTK;

    public editTK(String ma){
        this.setTitle("Đổi mật khẩu");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	this.setLayout(null);
        this.setSize(400,280);
        this.setLocationRelativeTo(null);

        TenTK=ma;
        JLabel tk=new JLabel("Tên tài khoản");
        tk.setBounds(20,30,80,30);
        name =new JTextField(ma);
        name.setEditable(false);
        name.setBounds(140,35,80,25);
        JLabel accName= new JLabel("Mật khẩu");
        accName.setBounds(20,75,80,30);
        pass = new JPasswordField();
        pass.setEchoChar('*');
        pass.setBounds(140,80,180,25);
        JLabel accPass= new JLabel("Nhập lại mật khẩu");
        accPass.setBounds(20,115,120,30);
        txtPass = new JPasswordField();
        txtPass.setEchoChar('*');
        txtPass.setBounds(140,120,180,25);
        icon = new ImageIcon(getClass().getResource("/img/eye.png"));
        icons = new ImageIcon(getClass().getResource("/img/eyeslash.png"));
        seeBut1 = new JButton(icons);
        seeBut2 = new JButton(icons);

        seeBut1.addActionListener(this);
        seeBut2.addActionListener(this);

        seeBut1.setBounds(330, 78,20,20);
        seeBut2.setBounds(330, 123,20,20);

        save=new JButton("Lưu");
        save.setBounds(80, 170, 100,30);
        cancel=new JButton("Huỷ");
        cancel.setBounds(210, 170, 100,30);

        save.addActionListener(this);
        cancel.addActionListener(this);

        add(tk);
        add(name);
        add(accName);
        add(pass);
        add(accPass);
        add(txtPass);
        add(seeBut1);
        add(seeBut2);
        add(save);
        add(cancel);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource( )== seeBut1){
            if ( pass.getEchoChar() != '*' ) {
                pass.setEchoChar('*');
                seeBut1.setIcon(icons);
            } else {
                pass.setEchoChar((char)0);
                seeBut1.setIcon(icon);
            }
        }
        if(e.getSource( )== seeBut2){
            if ( txtPass.getEchoChar() != '*' ) {
                txtPass.setEchoChar('*');
                seeBut2.setIcon(icons);
            } else {
                txtPass.setEchoChar((char)0);
                seeBut2.setIcon(icon);
            }
        }
        if(e.getSource()==save){
            try{
                String p1=String.copyValueOf(pass.getPassword());
                String p2=String.copyValueOf(txtPass.getPassword());
                if(p1.trim().equals("") || p2.trim().equals("")){
                    JOptionPane.showMessageDialog(this,"Vui lòng nhập đủ thông tin");
                }
                else if(!p1.trim().equals(p2.trim())){
                    JOptionPane.showMessageDialog(this,"Mật khẩu nhập lại không chính xác");
                }
                else{
                    int diaRS=JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn lưu");
                    if(diaRS==JOptionPane.YES_OPTION){
                        user u=new user(TenTK,p1);
                        userBLL uBLL=new userBLL();
                        JOptionPane.showMessageDialog(this,uBLL.upPass(u));
                    }
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Đã xảy ra lỗi vui lòng thử lại");
            }
        }
        if(e.getSource( )== cancel){
            this.dispose();
        }
    }
}

class changeTK extends JFrame implements ActionListener{
    private JRadioButton ck1;
    private JRadioButton ck2;
    private JButton save;
    private JButton cancel;
    private JTextField name;
    private int key;
    private int k;
    private taikhoan acc;

    public changeTK(taikhoan ma,JButton cl){
        this.setTitle("Khoá tài khoản");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	this.setLayout(null);
        this.setSize(400,250);
        this.setLocationRelativeTo(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                cl.doClick();
            }
        });

        acc=ma;
        JLabel tk=new JLabel("Tên tài khoản");
        tk.setBounds(80,30,80,30);
        name =new JTextField(ma.getTen());
        name.setEditable(false);
        name.setBounds(210,35,80,25);
        ck1=new JRadioButton("Khoá");
        ck1.setBounds(95,80,80,30);
        ck2=new JRadioButton("Mở khoá");
        ck2.setBounds(195,80,80,30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(ck1);
        bg.add(ck2);

        if(ma.getTinhtrang()==0){
            ck1.setSelected(true);
            key=0;
        }
        else{
            ck2.setSelected(true);
            key=1;
        }

        save=new JButton("Lưu");
        save.setBounds(80, 140, 100,30);
        cancel=new JButton("Huỷ");
        cancel.setBounds(210, 140, 100,30);

        save.addActionListener(this);
        cancel.addActionListener(this);

        add(tk);
        add(name);
        add(ck1);
        add(ck2);
        add(save);
        add(cancel);

        this.setResizable(false);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==save){
            try{
                if(ck1.isSelected()){
                    k=0;
                }
                if(ck2.isSelected()){
                    k=1;
                }
                if(key==k){
                    JOptionPane.showMessageDialog(this,"Lưu thành công");
                }
                else{
                    acc.setTinhtrang(k);
                    int diaRS=JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn lưu");
                    if(diaRS==JOptionPane.YES_OPTION){
                        taikhoanBLL tkBLL=new taikhoanBLL();
                        JOptionPane.showMessageDialog(this,tkBLL.upTT(acc));
                    }
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Đã xảy ra lỗi vui lòng thử lại");
            }
        }
        if(e.getSource( )== cancel){
            this.dispose();
        }
    }

}