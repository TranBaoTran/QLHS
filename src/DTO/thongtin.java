package DTO;

public class thongtin {
    private String namhoc;
    private int hocky=0;
    private String diachi;
    
    public thongtin(){}

    public thongtin(String namhoc,int hocky,String diachi){
        this.namhoc=namhoc;
        this.hocky=hocky;
        this.diachi=diachi;
    }

    public void setNamhoc(String namhoc){
        this.namhoc=namhoc;
    }

    public String getNamhoc(){
        return this.namhoc;
    }    

    public void setHocky(int HK){
        this.hocky=HK;
    }

    public int getHocky(){
        return this.hocky;
    }

    public void setDiachi(String diachi){
        this.diachi=diachi;
    }

    public String getDiachi(){
        return this.diachi;
    }  
}
