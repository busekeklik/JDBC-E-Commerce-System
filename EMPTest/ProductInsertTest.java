package EMPTest;

import entity.Product;
import manager.ProductManager;
import java.sql.SQLException;

public class ProductInsertTest {
    public static void main(String[] args) throws SQLException{
        ProductManager productManager = new ProductManager();
        Product product = new Product();
        
        boolean inserted = productManager.insert(product);

        System.out.println(inserted ? "Product inserted" : "Product not inserted");
    }
}
