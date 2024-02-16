package neocode.formekouapi.endpoint.rest.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import neocode.formekouapi.endpoint.rest.model.Question;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
public class QuestionMapper {
    public Question toRest(neocode.formekouapi.model.Question question){
        return Question.builder()
                .id(question.getId())
                .isRequired(question.isRequired())
                .options(question.getOptions())
                .points(question.getPoints())
                .title(question.getTitle())
                .description(question.getDescription())
                .type(question.getType())
                .build();
    }

    public neocode.formekouapi.model.Question toDomain(Question question){
        return neocode.formekouapi.model.Question.builder()
                .id(question.getId())
                .isRequired(question.isRequired())
                .options(question.getOptions())
                .points(question.getPoints())
                .title(question.getTitle())
                .description(question.getDescription())
                .type(question.getType())
                .build();
    }
}
