package ru.shorokhova.store.core.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shorokhova.store.api.FeedbackDto;
import ru.shorokhova.store.core.entities.Feedback;
import ru.shorokhova.store.core.entities.Product;
import ru.shorokhova.store.core.repositories.FeedbackRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    private final ProductService productService;


    public void addFeedback(FeedbackDto feedbackDto) {

        Feedback feedback = new Feedback();
        feedback.setGrade(feedbackDto.getGrade());
        feedback.setCommentText(feedbackDto.getCommentText());
        feedback.setProduct(productService.findById(feedbackDto.getProductId()).get());
        feedbackRepository.save(feedback);

    }

    public List<Feedback> getProductFeedback(Long productId) {
        return feedbackRepository.findByProductId(productId);
    }
}
