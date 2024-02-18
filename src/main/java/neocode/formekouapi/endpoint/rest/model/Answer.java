package neocode.formekouapi.endpoint.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import neocode.formekouapi.model.AnswerStatus;

import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Answer implements Serializable {
    private String id;
    private String value;
    private Instant updatedAt;
    private Instant createdAt;
    private AnswerStatus status;
    private User user;
    private Question question;
    private int points;
}
