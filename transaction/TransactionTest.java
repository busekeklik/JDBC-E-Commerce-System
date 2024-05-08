package transaction;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionTest {
    public static void main(String[] args) throws SQLException{
        String URL = "jdbc:mysql://localhost:3306/employees_database";
        String user = "root";
        String password = "Manga2342";
        Connection connection = DriverManager.getConnection(URL, user, password);

        connection.setAutoCommit(false);

        String sql = "INSERT INTO Product(productName, salesPrice) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        //1st ?
        statement.setString(1, "Laptop");
        //2nd ?
        statement.setDouble(2, 1000.0);

        int rowInserted = statement.executeUpdate();
        System.out.println("Row inserted: " + rowInserted);

        //2nd insert
        sql = "INSERT INTO Product(productName, salesPrice) VALUES (?, ?)";
        PreparedStatement statement2 = connection.prepareStatement(sql);

        //1st ?
        statement2.setString(1, "Mobile");
        //2nd ?
        statement2.setDouble(2, 500.0);

        rowInserted = statement2.executeUpdate();
        System.out.println("Row inserted: " + rowInserted);

        //3rd insert
        sql = "INSERT INTO Product(productName, salesPrice) VALUES (?, ?)";
        PreparedStatement statement3 = connection.prepareStatement(sql);

        //1st ?
        statement3.setString(1, "Tablet");
        //2nd ?
        statement3.setDouble(2, 300.0);

        rowInserted = statement3.executeUpdate();
        System.out.println("Row inserted: " + rowInserted);

        connection.rollback();
        connection.close();
    }
}
