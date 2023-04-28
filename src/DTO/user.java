package DTO;

public class user {
    private String userName;
    private String password;

    public user(String userName,String password){
        this.userName=userName;
        this.password=password;
    }

    public String getuserName(){
        return userName;
    }

    public String getpassword(){
        return password;
    }

    public void setuserName(String userName){
        this.userName=userName;
    }

    public void setpassword(String password){
        this.password=password;
    }
}
