package neocode.formekouapi.endpoint.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User implements Serializable {
    private String id;
    private String email;
    private String lastName;
    private String fistName;
    private String profilePicture;
}
