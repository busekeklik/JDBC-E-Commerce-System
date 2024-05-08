import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionTest {
    public static void main(String[] args) throws SQLException{ //ClassNotFoundException 
       //just 1 time we need to load the driver and we can remove class.forname because it is deprecated 
        // Class.forName("com.mysql.jdbc.Driver");

        //Server URL
        String URL = "jdbc:mysql://localhost:3306/"; //3306 is the default port number

        //user credentials
        String user="root";
        String password="Manga2342";

        //open connection
        Connection connection = DriverManager.getConnection(URL, user, password);
        System.out.println("Database: " +connection.getMetaData().getDatabaseProductName());

        //we must close connection
        connection.close();
    }
}