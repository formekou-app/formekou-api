package neocode.formekouapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "answer")
@Data
public class Answer implements Serializable {
    @Id
    @Column
    private String id;

    @Column
    private String value;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "created_at")
    private Instant createdAt;

    private String status;
    private int points;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_question", nullable = false)
    private Question question;
}
