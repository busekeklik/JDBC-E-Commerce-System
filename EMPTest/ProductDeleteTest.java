package EMPTest;

import entity.Product;
import manager.ProductManager;
import java.sql.SQLException;

public class ProductDeleteTest {
    public static void main(String[] args) throws SQLException {
        ProductManager productManager = new ProductManager();
        Product product = new Product();

        boolean deleted = productManager.delete(1);
        System.out.println(deleted ? "Product deleted" : "Product not deleted");
        
    }
}
