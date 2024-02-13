package neocode.formekouapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "question")
public class Question implements Serializable {
    @Id
    @Column
    private String id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column
    private int points;

    @JsonProperty("isRequired")
    @Column(name = "is_required")
    private boolean isRequired;

    @Column
    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @OneToMany(mappedBy = "question")
    private List<Option> options;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_form", nullable = false)
    private Form form;
}
