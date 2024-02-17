package neocode.formekouapi.endpoint.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import neocode.formekouapi.model.QuestionType;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class Question implements Serializable {
    private String id;
    private String title;
    private String description;
    private int points;
    private QuestionType type;
    private List<Option> options;

    @JsonProperty("isRequired")
    private boolean isRequired;

}
