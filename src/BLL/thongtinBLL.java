package BLL;
import DAL.thongtinDAL;
import DTO.thongtin;

public class thongtinBLL {
    thongtinDAL infDAL=new thongtinDAL();
    
    public thongtin getInfo(){
        return infDAL.getData();
    } 
    
    public int upInfo(thongtin u){
        int key=-2;
        String year[]=u.getNamhoc().split("-");
        String fYear=year[0];
        String lYear=year[1];
        if(fYear.matches("^\\d{4}") && lYear.matches("^\\d{4}")){
            if(Integer.parseInt(lYear)-Integer.parseInt(fYear)==1){
                if(u.getDiachi().matches("[^\\<>=?}{:'$!@#$%^&*+]+")){
                    return 1;
                }
                else{
                    return 0;
                }
            }
            else{
                key=-1;
            }
        }
        else{
            key=-1;
        }
        return key;
    }
}
