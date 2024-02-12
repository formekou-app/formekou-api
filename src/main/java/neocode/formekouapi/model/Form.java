package neocode.formekouapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity(name = "\"form\"")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Form implements Serializable {
    @Id
    @Column
    private String  id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column(name = "is_private", nullable = false)
    private boolean isPrivate;

    @Column(name = "opened_at", nullable = false)
    private Instant openedAt;

    @Column(name = "closed_at", nullable = false)
    private Instant closedAt;

    @Column(name = "allow_multiple_choice", nullable = false)
    private boolean allowMultipleChoice;

    @Column
    private String color;

    @OneToMany(targetEntity = "\"question\"")
    private List<Question> questions;
}
