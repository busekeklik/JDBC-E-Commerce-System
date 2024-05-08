package Prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DeleteTest {
    public static void main(String[] args) throws SQLException {
            
        String URL="jdbc:mysql://localhost:3306/devdb";
        String user ="root";
        String password = "Manga2342";
        Connection connection = DriverManager.getConnection(URL, user, password);

        String sql = "DELETE FROM product WHERE productId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        // ?
        statement.setLong(1, 27);

        int rowDeleted = statement.executeUpdate();
        System.out.println(rowDeleted + " row has been deleted successfully.");

        connection.close();
    }
}