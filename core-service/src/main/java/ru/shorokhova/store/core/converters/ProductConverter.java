package ru.shorokhova.store.core.converters;

import org.springframework.stereotype.Component;
import ru.shorokhova.store.api.FeedbackDto;
import ru.shorokhova.store.api.ProductDto;
import ru.shorokhova.store.core.entities.Product;

import java.util.stream.Collectors;

@Component
public class ProductConverter {

    public ProductDto entityToDto(Product p) {

        return ProductDto.builder()
                .id(p.getId())
                .title(p.getTitle())
                .price(p.getPrice())
                .companyName(p.getCompanyName())
                .quantity(p.getQuantity())
                .description(p.getDescription())
                .feedbacks(p.getFeedback().stream()
                        .map(f -> FeedbackDto.builder()
                                .commentText(f.getCommentText())
                                .grade(f.getGrade())
                                .productId(f.getProduct().getId())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
