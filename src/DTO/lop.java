package DTO;

public class lop {
    private String ten;
    private String GV;

    public lop(String ten,String GV){
        this.ten=ten;
        this.GV=GV;
    }

    public void setTen(String Ten){
        this.ten=Ten;
    }

    public String getTen(){
        return ten;
    }

    public void setGV(String GV){
        this.GV=GV;
    }

    public String getGV(){
        return GV;
    }   
}
