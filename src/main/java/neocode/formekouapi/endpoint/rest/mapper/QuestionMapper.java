package neocode.formekouapi.endpoint.rest.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import neocode.formekouapi.endpoint.rest.model.Question;
import neocode.formekouapi.model.QuestionType;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
public class QuestionMapper {
    private final CreateFormMapper.OptionMapper optionMapper;

    public Question toRest(neocode.formekouapi.model.Question question){
        return Question.builder()
                .id(question.getId())
                .isRequired(question.isRequired())
                .points(question.getPoints())
                .title(question.getTitle())
                .description(question.getDescription())
                .type(QuestionType.valueOf(question.getType()))
                .options(question
                        .getOptions()
                        .stream()
                        .map(optionMapper::toRest)
                        .toList()
                )
                .build();
    }

    public neocode.formekouapi.model.Question toDomain(Question question){
        return neocode.formekouapi.model.Question.builder()
                .id(question.getId())
                .isRequired(question.isRequired())
                .points(question.getPoints())
                .title(question.getTitle())
                .description(question.getDescription())
                .type(question.getType().toString())
                .options(question
                        .getOptions()
                        .stream()
                        .map(optionMapper::toDomain)
                        .toList()
                )
                .build();
    }
}
