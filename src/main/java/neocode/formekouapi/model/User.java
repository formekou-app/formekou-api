package neocode.formekouapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity(name="\"user\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {
    @Id
    @Column
    private String id;

    @Column(nullable = false)
    private String email;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name="first_name")
    private String firstName;

    @Column(name = "profile_picture")
    private String profilePicture;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Form> forms;
}