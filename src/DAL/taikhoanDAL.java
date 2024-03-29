package DAL;

import java.sql.*;
import java.util.Vector;

import DTO.taikhoan;


public class taikhoanDAL {
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
        + "databaseName=HS;"
        + "integratedSecurity=true;"
        + "encrypt=true;trustServerCertificate=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "asdasdasd";
    private Connection conn;
    private String Table;
    private int col;

    public boolean Open(){
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        return true;
    } catch (Exception ex) {
        ex.printStackTrace();
        return false;
    }
    }

    public void Close(){
    try{
        if(conn!=null){
            conn.close();
        }
    }catch (Exception ex) {
        ex.printStackTrace();
    }
    }

    public void setTable(String Table){
        this.Table=Table;
    }

    public Vector<taikhoan> getListGV(String sql){
        Vector<taikhoan> arr = new Vector<taikhoan>();
        if(Open()){
            try{
                Statement stmt = this.conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()){
                    taikhoan tk=new taikhoan();
                    tk.setMa(rs.getString("ma"));
                    tk.setTen(rs.getString("tenTK"));
                    tk.setVT("Giáo viên");
                    tk.setNgaymo(rs.getString("ngaymo"));
                    tk.setTinhtrang(rs.getInt("tinhtrang"));
                    arr.add(tk);
                }
            }catch(Exception ex){
                System.out.println(ex);
            }finally{
                Close();
            }
        } 
        return arr;
    }

    public Vector<taikhoan> getListHS(String sql){
        Vector<taikhoan> arr = new Vector<taikhoan>();
        if(Open()){
            try{
                Statement stmt = this.conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()){
                    taikhoan tk=new taikhoan();
                    tk.setMa(rs.getString("tenTK"));
                    tk.setTen(rs.getString("tenTK"));
                    tk.setVT("Học sinh");
                    tk.setNgaymo(rs.getString("ngaymo"));
                    tk.setTinhtrang(rs.getInt("tinhtrang"));
                    arr.add(tk);
                }
            }catch(Exception ex){
                System.out.println(ex);
            }finally{
                Close();
            }
        } 
        return arr;
    }

    public boolean updateTT(taikhoan u){
        boolean re=false;
        if(Open()){
            try{
                String sql="update "+this.Table+" set tinhtrang=? where tenTK=?";
                PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
                preparedStatement.setInt(1,u.getTinhtrang());
                preparedStatement.setString(2,u.getTen());
                if(preparedStatement.executeUpdate()>0){
                    re=true;
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            finally{
                Close();
            }
        }
        return re;
    }
}
