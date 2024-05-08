import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
    public static void main(String[] args) throws SQLException{

        String URL = "jdbc:mysql://localhost:3306/devdb"; //3306 is the default port number
        String user="root";
        String password="Manga2342";
        Connection connection = DriverManager.getConnection(URL, user, password);

        String sql = "SELECT * FROM product";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            long productId = resultSet.getLong("productId");
            String productName = resultSet.getString("productName");
            double salesPrice = resultSet.getDouble("salesPrice");
            System.out.println(productId + " " + productName + " " + salesPrice);
        }
        connection.close();
        
    }
}
