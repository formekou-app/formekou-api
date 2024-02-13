package neocode.formekouapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity(name = "option")
public class Option implements Serializable {
    @Id
    @Column
    private String id;

    @Column
    private String value;

    @JsonProperty("isCorrect")
    @Column(name = "is_correct")
    private boolean isCorrect;

    @Column
    private int points;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_question", nullable = false)
    private Question question;
}
