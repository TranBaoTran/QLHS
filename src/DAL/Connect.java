package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import DTO.user;

public class Connect {
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=HS;"
            + "integratedSecurity=true;"
            + "encrypt=true;trustServerCertificate=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "asdasdasd";
    private Connection conn=null;
    private Statement statement;
    private ResultSet result;
    private String Table;
    
    public Connect(){
        try{
            this.getConnection(DB_URL,USER_NAME,PASSWORD);
        } catch (Exception e){
            System.out.println("Không thể kết nối");
        }
    }

    public void getConnection(String dbURL, String userName, String password) throws SQLException{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean checkLogin(user u){
        boolean re=false;
        try{
            PreparedStatement preparedStatement = this.conn.prepareStatement("select * from "+this.Table+" where ma='?' and password='?' ");
            preparedStatement.setString(1,u.getuserName());
            preparedStatement.setString(2,u.getpassword());
            this.result=preparedStatement.executeQuery();
            if(this.result.next()){
                re=true;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return re;
    }

    public void setTable(String Table){
        this.Table=Table;
    }

    public void close(){
        try{
            this.conn.close();
        }
        catch(Exception e){
            System.out.println("Không thể đóng cơ sở dữ liệu");
        }
    }
}
