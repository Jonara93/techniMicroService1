package be.technifutur.mproduit.utils;

import be.technifutur.mproduit.entities.Product;
import be.technifutur.mproduit.services.ProductService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductInit implements InitializingBean {

    private final ProductService productService;

    public ProductInit(ProductService productService) {
        this.productService = productService;
    }

    List<Product> products = Arrays.asList(
            Product.builder()
                    .name("Masque FFP2")
                    .price(6.95)
                    .stockQuantity(1000)
                    .build(),
            Product.builder()
                    .name("Gel Hydroalcoolique")
                    .price(4.99)
                    .stockQuantity(250)
                    .build(),
            Product.builder()
                    .name("Gants Latex")
                    .price(3.85)
                    .stockQuantity(500)
                    .build(),
            Product.builder()
                    .name("Dettol")
                    .price(9.95)
                    .stockQuantity(100)
                    .build(),
            Product.builder()
                    .name("Lubrifiant")
                    .price(1.95)
                    .stockQuantity(300)
                    .build()
    );

    @Override
    public void afterPropertiesSet() throws Exception {
        this.products.forEach(this.productService::insert);
    }
}
