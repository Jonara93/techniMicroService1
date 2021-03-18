package be.technifutur.mproduit.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {
    Integer id;

    String name;

    Double price;

    Integer stockQuantity;
}
