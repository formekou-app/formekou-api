package neocode.formekouapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Entity(name="\"user\"")
@Data
public class User implements Serializable {
    @Id
    @Column
    private String id;

    @Column
    private String email;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="first_name", nullable = true)
    private String fistName;
}