import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertTest {
    public static void main(String[] args) throws SQLException{

        String URL = "jdbc:mysql://localhost:3306/devdb"; //3306 is the default port number
        String user="root";
        String password="Manga2342";
        Connection connection = DriverManager.getConnection(URL, user, password);

        String sql = "insert into product(productName, salesPrice) values('Fridge', 1000)";
        java.sql.Statement statement = connection.createStatement();

        int rowInserted = statement.executeUpdate(sql);
        System.out.println(rowInserted + " row has been inserted successfully.");

        connection.close();
        
    }
}
