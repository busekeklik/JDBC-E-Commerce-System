package EMPTest;

import entity.Product;
import manager.ProductManager;
import java.sql.SQLException;

public class ProductUpdateTest {
    public static void main(String[] args) throws SQLException{
        ProductManager productManager = new ProductManager();
        Product product = new Product();

        boolean updated = productManager.update(product);
        System.out.println(updated ? "Product updated" : "Product not updated");
    }
}
