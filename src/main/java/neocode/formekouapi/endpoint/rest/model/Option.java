package neocode.formekouapi.endpoint.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private int points;

    @JsonProperty("isCorrect")
    private boolean isCorrect;
}
