package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=DA;"
            + "integratedSecurity=true;"
            + "encrypt=true;trustServerCertificate=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "asdasdasd";
    
    public static Connection getConnection(String dbURL, String userName, String password) throws SQLException{
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
