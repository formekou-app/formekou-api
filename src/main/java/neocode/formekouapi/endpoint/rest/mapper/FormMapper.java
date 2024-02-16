package neocode.formekouapi.endpoint.rest.mapper;

import lombok.AllArgsConstructor;
import neocode.formekouapi.endpoint.rest.model.Form;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FormMapper {
    private final QuestionMapper questionMapper;

    public Form toRest(neocode.formekouapi.model.Form form) {
        return Form.builder()
                .id(form.getId())
                .title(form.getTitle())
                .description(form.getDescription())
                .isPrivate(form.isPrivate())
                .createdAt(form.getCreatedAt())
                .openedAt(form.getOpenedAt())
                .closedAt(form.getClosedAt())
                .allowMultipleChoice(form.isAllowMultipleChoice())
                .color(form.getColor())
                .questions(
                        form.getQuestions() != null ?
                        form.getQuestions().stream().map(questionMapper::toRest).toList()
                        : null
                )
                .build();
    }

    public neocode.formekouapi.model.Form toDomain(Form form){
        return neocode.formekouapi.model.Form.builder()
                .id(form.getId())
                .title(form.getTitle())
                .description(form.getDescription())
                .isPrivate(form.isPrivate())
                .openedAt(form.getOpenedAt())
                .closedAt(form.getClosedAt())
                .createdAt(form.getCreatedAt())
                .allowMultipleChoice(form.isAllowMultipleChoice())
                .color(form.getColor())
                .build();
    }
}
