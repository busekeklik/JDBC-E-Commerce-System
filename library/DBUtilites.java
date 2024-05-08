package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilites {
    
    public static String URL = "jdbc:mysql://localhost:3306/devdb";
    public static String user = "root";
    public static String password = "Manga2342";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, user, password);
    }
}
