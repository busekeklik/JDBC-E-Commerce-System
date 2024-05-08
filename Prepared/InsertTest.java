package Prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class InsertTest {
    public static void main(String[] args) throws SQLException{

        String URL = "jdbc:mysql://localhost:3306/devdb"; //3306 is the default port number
        String user="root";
        String password="Manga2342";
        Connection connection = DriverManager.getConnection(URL, user, password);

        String sql = "insert into product(productName, salesPrice) values(?,?)"; // injection -> values('Fridge', 1000)";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        // first ?
        statement.setString(1, "Laptop Computer"); // auto implement so our index is not important

        // second ?
        statement.setDouble(2, 1580);


        int rowInserted = statement.executeUpdate(); // NO SQL
        System.out.println(rowInserted + " row has been inserted successfully.");

        connection.close();
        
    }
}
