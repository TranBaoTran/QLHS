package DTO;
import java.util.Date;

public class ConNguoiDTO {

    private String id;
    private String name;
    private String sex;
    private Date dob;
    private String addr;
    private String tel;
    private boolean stat;

    public ConNguoiDTO(){

    }

    public ConNguoiDTO(String id, String name, String sex, Date dob, String addr, String tel, boolean stat){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.dob = dob;
        this.addr = addr;
        this.tel = tel;
        this.stat = stat;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public Date getDob(){
        return dob;
    }
    public void setDob(Date dob){
        this.dob = dob;
    }
    public String getAddr(){
        return addr;
    }
    public void setAddr(String addr){
        this.addr = addr;
    }
    public String getTel(){
        return tel;
    }
    public void setTel(String tel){
        this.tel = tel;
    }
    public boolean getStat(){
        return stat;
    }
    public void setStat(boolean stat){
        this.stat = stat;
    }

}
