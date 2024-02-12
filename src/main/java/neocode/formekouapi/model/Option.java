package neocode.formekouapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "\"option\"")
public class Option implements Serializable {
    @Id
    @Column
    private String id;

    @Column
    private String value;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @Column
    private int points;

    @ManyToOne(targetEntity = Question.class)
    @JoinColumn(name = "id_question")
    private Question question;
}
