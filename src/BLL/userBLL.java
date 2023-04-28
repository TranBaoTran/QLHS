package BLL;

import DAL.userDAL;
import DTO.user;

public class userBLL{
    userDAL uDAL=new userDAL();

    public int checkUser(user u){
        int key;
        if(u.getuserName().length()>6){
            return -1;
        }
        if(u.getuserName().substring(0, 2).equals("HS")){
            uDAL.setTable("TKhocsinh");
            uDAL.setCol(2);
            key=0;
        }
        else if(u.getuserName().substring(0, 2).equals("GV")){
            uDAL.setTable("TKgiaovien");
            uDAL.setCol(3);
            key=1;
        }
        else if(u.getuserName().equals("admin")){
            uDAL.setTable("TKgiaovien");
            uDAL.setCol(3);
            key=2;
        }
        else{
            return -1;
        }

        if(uDAL.checkLogin(u)){
            return key;
        }
        else{
            return -1;
        }
    }

    public String upPass(user u){
        if(u.getuserName().substring(0, 2).equals("HS")){
            uDAL.setTable("TKhocsinh");
        }
        else{
            uDAL.setTable("TKgiaovien");
        }
        if(uDAL.updatePass(u)){
            return "Thay đổi thành công";
        }
        else{
            return "Đã có lỗi xảy ra trong quá trình thay đổi.Vui lòng thử lại";
        }
    }
}

