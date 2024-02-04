package neocode.formekouapi.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FirebaseUser {
    private String uid, email;
}
