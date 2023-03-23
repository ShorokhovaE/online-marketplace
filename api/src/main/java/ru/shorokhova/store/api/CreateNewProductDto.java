package ru.shorokhova.store.api;


import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
@Getter
public class CreateNewProductDto {
    private String title;
    private BigDecimal price;

    private String description;

    private String companyName;

    private int count;

}
