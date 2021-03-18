package be.technifutur.mproduit.mapper;

import be.technifutur.mproduit.dtos.ProductDto;
import be.technifutur.mproduit.entities.Product;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public ProductDto toProductDto(Product product) {
        return product != null ? ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .stockQuantity(product.getStockQuantity())
                .price(product.getPrice())
                .build() : null;
    }

    public Product toProductEntity(ProductDto productDto) {
        return productDto != null ? Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .stockQuantity(productDto.getStockQuantity())
                .price(productDto.getPrice())
                .build() : null;
    }
}
