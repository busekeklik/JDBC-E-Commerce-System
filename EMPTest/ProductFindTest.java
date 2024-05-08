package EMPTest;

import entity.Product;
import manager.ProductManager;
import java.sql.SQLException;

public class ProductFindTest {
    public static void main(String[] args) throws SQLException{
        ProductManager productManager = new ProductManager();
        long productId = 1;
        Product product = productManager.find(productId);

        if(product != null) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Sales Price: " + product.getSalesPrice());
        } else {
            System.out.println("Product not found");
        }
    }
}
