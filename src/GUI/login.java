package GUI;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import DTO.user;
import BLL.userBLL;

public class login extends JFrame implements ActionListener{
    private userBLL uBLL=new userBLL();
    private JButton logBut;
    private JButton seeBut;
    private ImageIcon icon;
    private ImageIcon icons;
    private JTextField txtAcc;
    private JPasswordField txtPass;
    private GiaoDienHS HSGUI;
    private GiaoVien_GUI GVGUI;
    private admin ADGUI;

    public login() throws IOException{
        this.setTitle("Quản lý học sinh");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.setLayout(null);
        this.setSize(400,250);
        this.setLocationRelativeTo(null);

        //panel login
        JPanel Con=new JPanel();
        Con.setLayout(null);
        Con.setBounds(5,5,380,203);
        Con.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Đăng nhập",TitledBorder.LEFT, TitledBorder.TOP));
        
        //content
        JLabel accName= new JLabel("Đăng nhập");
        accName.setBounds(30,30,80,30);
        txtAcc = new JTextField();
        txtAcc.setBounds(120,35,180,25);
        JLabel accPass= new JLabel("Mật khẩu");
        accPass.setBounds(30,75,80,30);
        txtPass = new JPasswordField();
        txtPass.setEchoChar('*');
        txtPass.setBounds(120,80,180,25);
        icon = new ImageIcon(getClass().getResource("/img/eye.png"));
        icons = new ImageIcon(getClass().getResource("/img/eyeslash.png"));
        seeBut = new JButton(icons);

        seeBut.addActionListener(this);

        seeBut.setBounds(310, 83,20,20);
        logBut=new JButton("Đăng nhập");

        logBut.setBounds(140, 130, 100,30);
        // logBut.addActionListener(this);
        logBut.addActionListener(this);
        //add panel
        Con.add(accName);
        Con.add(txtAcc);
        Con.add(accPass);
        Con.add(txtPass);
        Con.add(seeBut);
        Con.add(logBut);

        //add
        this.add(Con);
        this.setResizable(false);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource( )== seeBut){
            if ( txtPass.getEchoChar() != '*' ) {
                txtPass.setEchoChar('*');
                seeBut.setIcon(icons);
            } else {
                txtPass.setEchoChar((char)0);
                seeBut.setIcon(icon);
            }
        }
        else{
            try{
                String uName=txtAcc.getText();
                String uPass=String.copyValueOf(txtPass.getPassword());
                if(uName.trim().equals("") || uPass.trim().equals("")){
                    JOptionPane.showMessageDialog(this,"Vui lòng nhập đủ thông tin");
                }
                else{
                    user u = new user(uName, uPass);
                    int key=uBLL.checkUser(u);
                    if(key!=-1){
                        JOptionPane.showMessageDialog(this,"Đăng nhập thành công");
                        if(key==0){
                            HSGUI= new GiaoDienHS();
                        }
                        if(key==1){
                            GVGUI=new GiaoVien_GUI();
                        }
                        if(key==2){
                            ADGUI=new admin();
                        }
                        this.setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"Đăng nhập không thành công");   
                    }
                }
            }catch (Exception ex){
                JOptionPane.showMessageDialog(this,"Thông tin không hợp lệ");
            }
        }
    }
}
