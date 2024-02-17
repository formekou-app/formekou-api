package neocode.formekouapi.endpoint.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class Form {
    private String  id;
    private String title;
    private String description;
    private Instant openedAt;
    private Instant closedAt;
    private Instant updatedAt;
    private boolean allowMultipleChoice;
    private String color;
    private Instant createdAt;
    private List<Question> questions;

    @JsonProperty("isPrivate")
    private boolean isPrivate;
}
