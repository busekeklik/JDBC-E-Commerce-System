package Prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FindTest {
    public static void main(String[] args) throws SQLException{
        
        String URL="jdbc:mysql://localhost:3306/devdb";
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(URL, user, password);

        String sql = "SELECT * FROM product WHERE productId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        // ?
        statement.setLong(1, 4);

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            long productId = resultSet.getLong("productId");
            String productName = resultSet.getString("productName");
            double salesPrice = resultSet.getDouble("salesPrice");
            System.out.printf("%d %s %.2f\n", productId, productName, salesPrice);
        } else {
            System.out.println("Product Id not found");
        }
        connection.close();
    }
}
