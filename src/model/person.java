package model;

import java.util.Date;

public class person {
    private String Name;
    private Date biDate;
    private String Address;
    private String Tel;

    public person(){}

    public person(String Name,Date biDate,String Address,String Tel){
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
	private String ID;
    private String classID;

    public student(String Name,Date biDate,String Address,String Tel,String ID,String classID){
        super(Name, biDate, Address, Tel);
        this.ID=ID;
        this.classID=classID;
    }

    public String getID(){
        return ID;
    }

    public void setID(String ID){
        this.ID=ID;
    }

    public String getclassID(){
        return classID;
    }

    public void setName(String classID){
        this.classID=classID;
    }
}

class accquaintances extends person{
    private String Job;
    private String Relation;

    public accquaintances(String Name,Date biDate,String Address,String Tel,String Job,String Relation){
        super(Name, biDate, Address, Tel);
        this.Job=Job;
        this.Relation=Relation;
    }

    public String getJob(){
        return Job;
    }

    public void setJob(String Job){
        this.Job=Job;
    }

    public String getRelation(){
        return Relation;
    }

    public void setRelation(String Relation){
        this.Relation=Relation;
    }
}