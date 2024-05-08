package Prepared;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import library.DBUtilites;

public class DeleteTest {
    public static void main(String[] args) throws SQLException {
            
        Connection connection = DBUtilites.getConnection();
        String sql = "DELETE FROM product WHERE productId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        // ?
        statement.setLong(1, 35);

        int rowDeleted = statement.executeUpdate();
        System.out.println(rowDeleted + " row has been deleted successfully.");

        connection.close();
    }
}