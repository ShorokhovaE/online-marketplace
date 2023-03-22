package ru.shorokhova.store.core.converters;

import org.springframework.stereotype.Component;
import ru.shorokhova.store.api.FeedbackDto;

import ru.shorokhova.store.core.entities.Feedback;

@Component
public class FeedbackConverter {

    public FeedbackDto entityToDto(Feedback f) {

        return FeedbackDto.builder()
                .commentText(f.getCommentText())
                .grade(f.getGrade())
                .productId(f.getProduct().getId())
                .build();
    }

}
