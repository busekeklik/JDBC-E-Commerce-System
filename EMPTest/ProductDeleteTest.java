package EMPTest;

import entity.Product;
import manager.ProductManager;
import java.sql.SQLException;

public class ProductDeleteTest {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Product product = new Product();

        boolean deleted = productManager.delete(product);
    }
}
