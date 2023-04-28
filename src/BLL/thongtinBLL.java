package BLL;
import DAL.thongtinDAL;
import DTO.thongtin;

public class thongtinBLL {
    thongtinDAL infDAL=new thongtinDAL();
    
    public thongtin getInfo(){
        return infDAL.getData();
    } 
}
