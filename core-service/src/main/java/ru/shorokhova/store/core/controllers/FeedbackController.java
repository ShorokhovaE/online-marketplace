package ru.shorokhova.store.core.controllers;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.shorokhova.store.api.CreateNewProductDto;
import ru.shorokhova.store.api.FeedbackDto;
import ru.shorokhova.store.core.converters.FeedbackConverter;
import ru.shorokhova.store.core.services.FeedbackService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/feedback")
@RequiredArgsConstructor
@Tag(name="Обратная связь", description = "Методы работы с отзывами и оценками на товар")
public class FeedbackController {

    private final FeedbackService feedbackService;
    private final FeedbackConverter feedbackConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addFeedback(@RequestBody FeedbackDto feedbackDto) {
        System.out.println("feedbackDto = " + feedbackDto);
        feedbackService.addFeedback(feedbackDto);
    }

    @GetMapping("/{productId}")
    public List<FeedbackDto> getFeedbackByProductId(@PathVariable @Parameter(description = "Идентификатор продукта", required = true) Long productId) {
        List<FeedbackDto> feedbackDtos = feedbackService.getProductFeedback(productId)
                .stream()
                .map(feedbackConverter::entityToDto)
                .collect(Collectors.toList());
        return feedbackDtos;
    }




}
