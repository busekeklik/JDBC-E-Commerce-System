package manager;

import entity.Product;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import library.DBUtilites;

public class ProductManager {
    //responsible for CRUD operations

    public boolean insert(Product product) throws SQLException {
        //insert a new product into the database
        Connection connection = DBUtilites.getConnection();

        String sql = "INSERT INTO product (productName, salesPrice) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, product.getProductName());
        statement.setDouble(2, product.getSalesPrice());

        int rows = statement.executeUpdate();
        connection.close();

        return rows == 1 ? true : false;
    }

    public Product find(long productId) throws SQLException {
        //find a product by its id
        Product product = null;
        Connection connection = DBUtilites.getConnection();

        String sql = "SELECT * FROM product WHERE productId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setLong(1, productId);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            product = new Product();
            product.setProductId(resultSet.getLong("productId"));
            product.setProductName(resultSet.getString("productName"));
            product.setSalesPrice(resultSet.getDouble("salesPrice"));
        }

        connection.close();
        return product;
    }

    public boolean update(Product product) throws SQLException {
        //update an existing product
        Connection connection = DBUtilites.getConnection();

        String sql = "UPDATE product SET productName = ?, salesPrice = ? WHERE productId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, product.getProductName());
        statement.setDouble(2, product.getSalesPrice());
        statement.setLong(3, product.getProductId());

        int rows = statement.executeUpdate();
        connection.close();

        return rows == 1 ? true : false;
    }
}
