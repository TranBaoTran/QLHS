package DTO;

import java.util.Date;
import java.util.StringJoiner; 

public class taikhoan {
    private String ma;
    private String ten;
    private String vaitro;
    private String ngaymo;
    private int tinhtrang;

    public taikhoan(){}

    public taikhoan(String ma,String ten,String vaitro,String ngaymo,int tinhtrang){
        this.ma=ma;
        this.ten=ten;
        this.vaitro=vaitro;
        this.ngaymo=ngaymo;
        this.tinhtrang=tinhtrang;
    }

    public String getMa(){
        return ma;
    }

    public void setMa(String ma){
        this.ma=ma;
    }

    public String getTen(){
        return ten;
    }

    public void setTen(String ten){
        this.ten=ten;
    }

    public String getVT(){
        return vaitro;
    }

    public void setVT(String vaitro){
        this.vaitro=vaitro;
    }

    public String getNgaymo(){
        return ngaymo;
    }

    public void setNgaymo(String Ngaymo){
        this.ngaymo=Ngaymo;
    }

    public void setTinhtrang(int tinhtrang){
        this.tinhtrang=tinhtrang;
    }

    public int getTinhtrang(){
        return tinhtrang;
    }
}
