package neocode.formekouapi.endpoint.rest.mapper;

import lombok.AllArgsConstructor;
import neocode.formekouapi.endpoint.rest.model.CreateAnswer;
import neocode.formekouapi.model.Answer;
import neocode.formekouapi.service.AuthService;
import neocode.formekouapi.service.QuestionService;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateAnswerMapper {
    private final QuestionService questionService;

    public Answer toDomain(CreateAnswer answer){
        return Answer.builder()
                .id(answer.getId())
                .createdAt(answer.getCreatedAt())
                .updatedAt(answer.getUpdatedAt())
                .status(answer.getStatus().toString())
                .points(answer.getPoints())
                .question(questionService.getQuestionById(answer.getQuestionId()))
                .user(AuthService.getAuthentication().getUser())
                .value(answer.getValue())
                .build();
    }
}
