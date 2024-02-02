package neocode.formekouapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Dummy implements Serializable {
    @Id
    @Column
    private String id;

    @Column
    private String name;
}
