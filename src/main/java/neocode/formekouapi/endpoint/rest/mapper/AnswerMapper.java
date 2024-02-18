package neocode.formekouapi.endpoint.rest.mapper;

import lombok.AllArgsConstructor;
import neocode.formekouapi.endpoint.rest.model.Answer;
import neocode.formekouapi.model.AnswerStatus;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AnswerMapper {
    private UserMapper userMapper;
    private QuestionMapper questionMapper;

    public Answer toRest(neocode.formekouapi.model.Answer answer){
        return Answer.builder()
                .id(answer.getId())
                .points(answer.getPoints())
                .value(answer.getValue())
                .createdAt(answer.getCreatedAt())
                .updatedAt(answer.getUpdatedAt())
                .status(AnswerStatus.valueOf(answer.getStatus()))
                .user(userMapper.toRest(answer.getUser()))
                .question(questionMapper.toRest(answer.getQuestion()))
                .build();
    }
}