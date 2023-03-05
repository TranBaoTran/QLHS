package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class conn {
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=DA;"
            + "integratedSecurity=true;"
            + "encrypt=true;trustServerCertificate=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "asdasdasd";

    public conn(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean addStudent(){
        return false;
    }
}
