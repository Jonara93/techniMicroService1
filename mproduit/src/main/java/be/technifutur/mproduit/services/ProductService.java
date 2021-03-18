package be.technifutur.mproduit.services;

import be.technifutur.mproduit.dtos.ProductDto;
import be.technifutur.mproduit.entities.Product;
import be.technifutur.mproduit.mapper.Mapper;
import be.technifutur.mproduit.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final Mapper mapper;

    public ProductService(ProductRepository productRepository, Mapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public Set<ProductDto> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(mapper::toProductDto)
                .collect(Collectors.toSet())
                ;
    }

    public ProductDto getByID(int id) {

        Optional<Product> product = productRepository.findById(id);

        return product.map(mapper::toProductDto).orElse(null);
    }

    public void insert(Product product) {
        if (product != null)
            productRepository.save(product);
    }

    public void update(Product product) {
        this.productRepository.save(product);
    }
}
