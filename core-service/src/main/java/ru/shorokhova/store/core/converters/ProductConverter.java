package ru.shorokhova.store.core.converters;

import org.springframework.stereotype.Component;
import ru.shorokhova.store.api.ProductDto;
import ru.shorokhova.store.core.entities.Product;

@Component
public class ProductConverter {
    public ProductDto entityToDto(Product p) {

        return ProductDto.builder()
                .id(p.getId())
                .title(p.getTitle())
                .price(p.getPrice())
                .build();
    }
}
