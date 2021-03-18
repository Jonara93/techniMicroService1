package be.technifutur.mproduit.controllers;

import be.technifutur.mproduit.config.RibbonConfig;
import be.technifutur.mproduit.dtos.ProductDto;
import be.technifutur.mproduit.entities.Product;
import be.technifutur.mproduit.services.ProductService;
import be.technifutur.mproduit.utils.ProductNotFoundException;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
//@CrossOrigin
@RequestMapping(path = "/products")
@RibbonClient(name = "mproduit", configuration = RibbonConfig.class)
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Set<ProductDto> getAllProduct() throws ProductNotFoundException {
        Set<ProductDto> products = productService.getAllProduct();
        if (products.isEmpty()) throw new ProductNotFoundException("Aucun produit disponible à la vente");

        return products;
    }

    @GetMapping(path = "/{id}")
    public ProductDto getById(@PathVariable Integer id) throws ProductNotFoundException {
        ProductDto product = this.productService.getByID(id);
        if (product == null) throw new ProductNotFoundException("Le produit avec l'id " + id + " n'as pas été trouvé");
        return product;
    }

    @PutMapping()
    public void updateProduct(@RequestBody Product product) throws ProductNotFoundException {
        if (product != null) {
            this.productService.update(product);
        } else {
            throw new ProductNotFoundException("pas là");
        }
    }

    @PostMapping
    public void insert(@RequestBody Product product) {
        this.productService.insert(product);
    }

}
