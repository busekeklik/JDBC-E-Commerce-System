package Prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UpdateTest {
    public static void main(String[] args) throws SQLException{

        String URL = "jdbc:mysql://localhost:3306/devdb"; //3306 is the default port number
        String user="root";
        String password="Manga2342";
        Connection connection = DriverManager.getConnection(URL, user, password);

        String sql = "update product set productName=?, salesPrice=? where productId=?"; // injection -> values('Fridge', 1000)";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        // first ?
        statement.setString(1, "Smartphone");

        // second ?
        statement.setDouble(2, 1850);

        // third ?
        statement.setLong(3, 27);


        int rowUpdated = statement.executeUpdate(); // NO SQL
        System.out.println(rowUpdated + " row has been updated successfully.");

        connection.close();
    }
}
