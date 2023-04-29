package DAL;
import java.sql.*;
import java.util.concurrent.Exchanger;

import DTO.thongtin;

public class thongtinDAL {
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=HS;"
            + "integratedSecurity=true;"
            + "encrypt=true;trustServerCertificate=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "asdasdasd";
    private Connection conn;

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

    public thongtin getData(){
        thongtin inform=new thongtin();
        if(Open()){
            try{
                String sql="select * from thongtin";
                Statement stmt = this.conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()){
                    String namhoc=rs.getString(1);
                    int HK=rs.getInt(2);
                    String diachi=rs.getString(3);
                    inform.setNamhoc(namhoc);
                    inform.setHocky(HK);
                    inform.setDiachi(diachi);
                }

            }catch(Exception ex){
                ex.printStackTrace();
            }
            finally{
                Close();
            }
        }
        if(inform.getNamhoc()=="" || inform.getHocky()==0){
            inform=null;
            return inform;
        }
        else{
            return inform;
        }
    }

    public int upThongTin(thongtin u){
        int re=1;
        if(Open()){
            try{
                
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
