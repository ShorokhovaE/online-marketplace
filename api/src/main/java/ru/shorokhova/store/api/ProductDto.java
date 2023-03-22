package ru.shorokhova.store.api;



import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ProductDto {

    private Long id;

    private String title;

    private BigDecimal price;

    private String description;

    private String companyName;

    private int count;

    private List<FeedbackDto> feedbacks;

}
