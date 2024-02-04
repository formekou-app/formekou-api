package neocode.formekouapi.security;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FirebaseUser {
    private String uid;
    private String email;
}
