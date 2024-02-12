package neocode.formekouapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "\"question\"")
public class Question {
    @Id
    @Column
    private String id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column
    private int points;

    @Column(name = "is_required")
    private boolean isRequired;

    @Column
    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @OneToMany(targetEntity = "\"option\"")
    private List<Option> options;

    @ManyToOne(targetEntity = "\"form\"")
    @JoinColumn(name = "id_form")
    private Form form;
}
