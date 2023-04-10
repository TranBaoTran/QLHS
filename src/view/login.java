package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

import model.user;


public class login extends JFrame{

    private JButton logBut;
    private JTextField txtAcc;
    private JPasswordField txtPass;

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
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/eye.png"));
        ImageIcon icons = new ImageIcon(getClass().getResource("/img/eyeslash.png"));
        JButton seeBut = new JButton(icon);

        seeBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( txtPass.getEchoChar() != '*' ) {
                    txtPass.setEchoChar('*');
                    seeBut.setIcon(icon);
                } else {
                    txtPass.setEchoChar((char)0);
                    seeBut.setIcon(icons);
                }
            }
        });

        seeBut.setBounds(310, 83,20,20);
        logBut=new JButton("Đăng nhập");
        logBut.setBounds(140, 130, 100,30);
        // logBut.addActionListener(this);

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

    public ImageIcon loadIcon(String iconName) throws IOException {
        ClassLoader loader = this.getClass().getClassLoader();
        BufferedImage icon = ImageIO.read(loader.getResourceAsStream(iconName));
        return new ImageIcon(icon);
    }

    public void addLoginListener(ActionListener Listener){
        logBut.addActionListener(Listener);
    }

    public user getUser(){
        return new user(txtAcc.getText(),String.copyValueOf(txtPass.getPassword()));
    }
    public static void main(String args[]) throws IOException{
        new login();
    }
}
