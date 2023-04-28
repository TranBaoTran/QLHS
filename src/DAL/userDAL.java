package DAL;
import java.sql.*;
import DTO.user;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class userDAL{
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

    public void setCol(int col){
        this.col=col;
    }

    public boolean checkLogin(user u){
        boolean re=false;
        if(Open()){
            try{
                String hash="";
                String sql="select * from "+this.Table+" where tenTK=? and tinhtrang=1";
                PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
                preparedStatement.setString(1,u.getuserName());
                ResultSet result=preparedStatement.executeQuery();
                while(result.next()){
                    hash = result.getString(this.col);
                }
                boolean valuate = BCrypt.checkpw(u.getpassword(),hash);
                if(valuate){
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

    public boolean updatePass(user u){
        boolean re=false;
        if(Open()){
            try{
                String sql="update "+this.Table+" set matkhau=? where tenTK=?";
                System.out.println(sql);
                PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
                String hash = BCrypt.hashpw(u.getpassword(), BCrypt.gensalt(12));
                preparedStatement.setString(1,hash);
                preparedStatement.setString(2,u.getuserName());
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