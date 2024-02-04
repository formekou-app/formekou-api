package neocode.formekouapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Entity(name="\"user\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @Column
    private String id;

    @NonNull
    @Column(nullable = false)
    private String email;

    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name="first_name")
    private String fistName;
}