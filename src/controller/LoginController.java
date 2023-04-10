package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import model.user;
import view.login;

public class LoginController {
    private login Log;

    public LoginController(login Log){
        this.Log=Log;
        Log.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            user us=Log.getUser();
            if(us.getuserName().substring(0, 2).equals("HS")){
                String check="select * from student where accName='?'";
            }
            if(us.getuserName().substring(0, 2).equals("GV")){

            }
        }
    }
}
