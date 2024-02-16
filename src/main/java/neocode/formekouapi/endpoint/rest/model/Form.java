package neocode.formekouapi.endpoint.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import neocode.formekouapi.model.Question;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class Form {
    private String  id;
    private String title;
    private String description;
    private boolean isPrivate;
    private Instant openedAt;
    private Instant closedAt;
    private boolean allowMultipleChoice;
    private String color;
    private Instant createdAt;
    private List<Question> questions;
}
