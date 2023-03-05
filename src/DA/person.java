package DA;

import java.util.Date;

public class person {
    private String Name;
    private Date biDate;
    private String Address;
    private String Tel;

    public person(){}

    public person(String Name,String ID,Date biDate,String Address,String Tel){
        this.Name=Name;
        this.biDate=biDate;
        this.Address=Address;
        this.Tel=Tel;
    }

    public String getName(){
        return Name;
    }

    public Date getbiDate(){
        return biDate;
    }

    public String getAddress(){
        return Address;
    }

    public String getTel(){
        return Tel;
    }

    public void setName(String Name){
        this.Name=Name;
    }

    public void setbiDate(Date biDate){
        this.biDate=biDate;
    }

    public void setAddress(String Address){
        this.Address=Address;
    }

    public void setTel(String Tel){
        this.Tel=Tel;
    }
}


class student extends person{
	
}
