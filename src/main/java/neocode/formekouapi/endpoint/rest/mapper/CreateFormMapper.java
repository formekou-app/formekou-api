package neocode.formekouapi.endpoint.rest.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import neocode.formekouapi.endpoint.rest.model.CreateForm;
import neocode.formekouapi.endpoint.rest.model.Option;
import neocode.formekouapi.model.Form;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@AllArgsConstructor
@Builder
@Data
public class CreateFormMapper implements Serializable {
    public Form toDomain(CreateForm form){
        return Form.builder()
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

    @Component
    @AllArgsConstructor
    public static class OptionMapper {
        public Option toRest(neocode.formekouapi.model.Option option){
            return Option.builder()
                    .points(option.getPoints())
                    .isCorrect(option.isCorrect())
                    .value(option.getValue())
                    .id(option.getId())
                    .build();
        }

        public neocode.formekouapi.model.Option toDomain(Option option){
            return neocode.formekouapi.model.Option.builder()
                    .points(option.getPoints())
                    .isCorrect(option.isCorrect())
                    .value(option.getValue())
                    .id(option.getId())
                    .build();
        }
    }
}