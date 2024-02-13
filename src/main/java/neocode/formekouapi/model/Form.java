package neocode.formekouapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity(name = "form")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
public class Form implements Serializable {
    @Id
    @Column
    private String  id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @JsonProperty("isPrivate")
    @Column(name = "is_private", nullable = false)
    private boolean isPrivate;

    @Column(name = "opened_at", nullable = false)
    private Instant openedAt;

    @Column(name = "closed_at", nullable = false)
    private Instant closedAt;

    @Column(name = "allow_multiple_response", nullable = false)
    private boolean allowMultipleChoice;

    @Column
    private String color;

    @OneToMany(mappedBy = "form")
    private List<Question> questions;
}
