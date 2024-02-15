package neocode.formekouapi.endpoint.rest.mapper;

import neocode.formekouapi.endpoint.rest.model.Form;
import org.springframework.stereotype.Component;

@Component
public class FormMapper {
    public Form toRest(neocode.formekouapi.model.Form form) {
        return Form.builder()
                .id(form.getId())
                .title(form.getTitle())
                .description(form.getDescription())
                .isPrivate(form.isPrivate())
                .openedAt(form.getOpenedAt())
                .closedAt(form.getClosedAt())
                .allowMultipleChoice(form.isAllowMultipleChoice())
                .color(form.getColor())
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
                .allowMultipleChoice(form.isAllowMultipleChoice())
                .color(form.getColor())
                .build();
    }
}
