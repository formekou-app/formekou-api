package neocode.formekouapi.endpoint.rest.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
@Builder
public class Option implements Serializable {
    private String id;
    private String value;
    private boolean isCorrect;
    private int points;
}
