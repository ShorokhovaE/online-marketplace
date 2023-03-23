package ru.shorokhova.store.api;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FeedbackDto {

    private String commentText;
    private Long productId;
    private int grade;

}
