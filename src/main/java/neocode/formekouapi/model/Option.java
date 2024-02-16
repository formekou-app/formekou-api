package neocode.formekouapi.model;

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

    @Column(name = "is_correct")
    private boolean isCorrect;

    @Column
    private int points;

    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;
}
