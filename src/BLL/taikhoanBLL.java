package BLL;
import java.util.Vector;

import DAL.taikhoanDAL;
import DTO.taikhoan;

public class taikhoanBLL {
    taikhoanDAL tk=new taikhoanDAL();

    public Vector<taikhoan> getTK(int Jop,String ma,String ten,String start,String end){
        String sql="";
        Vector<taikhoan> ar1;
        Vector<taikhoan> ar2;
        if(Jop==0){
            String sql1="Select TKgiaovien.ma,tenTK,TKgiaovien.tinhtrang,ngaymo from TKgiaovien join giaovien on TKgiaovien.ma=giaovien.ma";
            String tmpGV=extendSQLGV(ma, ten, start, end);
            sql1+=tmpGV+" giaovien.tinhtrang=1 ";
            ar1=tk.getListGV(sql1);
            String sql2="Select TKhocsinh.tenTK,TKhocsinh.tinhtrang,ngaymo from TKhocsinh join hocsinh on TKhocsinh.tenTK=hocsinh.ma";
            String tmpHS=extendSQLHS(ma, ten, start, end);
            sql2+=tmpHS+"hocsinh.tinhtrang=1 ";
            ar2=tk.getListHS(sql2);
        }
        else if(Jop==1){
            sql+="Select TKgiaovien.ma,tenTK,TKgiaovien.tinhtrang,ngaymo from TKgiaovien join giaovien on TKgiaovien.ma=giaovien.ma";
            String tmp=extendSQLGV(ma, ten, start, end);
            sql+=tmp+" giaovien.tinhtrang=1 ";
            return tk.getListGV(sql);
        }
        else{
            sql+="Select TKhocsinh.tenTK,TKhocsinh.tinhtrang,ngaymo from TKhocsinh join hocsinh on TKhocsinh.tenTK=hocsinh.ma";
            String tmp=extendSQLHS(ma, ten, start, end);
            sql+=tmp+"hocsinh.tinhtrang=1 ";
            return tk.getListHS(sql);
        }
        return AddTK(ar1, ar2);
    }

    public String extendSQLGV(String ma,String ten,String start,String end){
        String sql=" where ";
        if(!ma.trim().equals("")){
            sql+="TKgiaovien.ma like '%"+ma+"%' AND ";
        }
        if(!ten.trim().equals("")){
            sql+="tenTK like '%"+ten+"%' AND ";
        }
        if(start!=""){
            sql+="ngaymo >= '"+start+"' AND ";
        }
        if(end!=""){
            sql+="ngaymo <= '"+end+"' AND ";
        }
        return sql;
    }

    public String extendSQLHS(String ma,String ten,String start,String end){
        String sql=" where ";
        if(!ma.trim().equals("")){
            sql+="tenTK like '%"+ma+"%' AND ";
        }
        if(!ten.trim().equals("")){
            sql+="tenTK like '%"+ten+"%' AND ";
        }
        if(start!=""){
            sql+="ngaymo >= '"+start+"' AND ";
        }
        if(end!=""){
            sql+="ngaymo <= '"+end+"' AND ";
        }
        return sql;
    }

    public Vector<taikhoan> AddTK(Vector<taikhoan> arr1,Vector<taikhoan> arr2){
        Vector<taikhoan> tmp=arr1;
        for(int i=0;i<arr2.size();i++){
            tmp.add(arr2.get(i));
        }
        return tmp;
    }

    public String upTT(taikhoan u){
        if(u.getTen().substring(0, 2).equals("HS")){
            tk.setTable("TKhocsinh");
        }
        else{
            tk.setTable("TKgiaovien");
        }
        if(tk.updateTT(u)){
            return "Đã thay đổi thành công";
        }
        else{
            return "Đã có lỗi xảy ra trong quá trình thay đổi.Vui lòng thử lại";
        }
    }
}
