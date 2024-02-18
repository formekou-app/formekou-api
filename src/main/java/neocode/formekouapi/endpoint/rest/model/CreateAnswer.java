package neocode.formekouapi.endpoint.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import neocode.formekouapi.model.AnswerStatus;

import java.io.Serializable;
import java.time.Instant;

@Builder
@AllArgsConstructor
@Data
public class CreateAnswer implements Serializable {
    private String id;
    private String value;
    private Instant updatedAt;
    private Instant createdAt;
    private String questionId;
}
