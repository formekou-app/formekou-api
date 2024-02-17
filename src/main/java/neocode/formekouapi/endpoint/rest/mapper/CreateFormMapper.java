package neocode.formekouapi.endpoint.rest.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import neocode.formekouapi.endpoint.rest.model.CreateForm;
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
                .updatedAt(form.getUpdatedAt())
                .allowMultipleChoice(form.isAllowMultipleChoice())
                .color(form.getColor())
                .build();
    }

}