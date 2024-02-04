package neocode.formekouapi.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FirebaseUser {
    private final String uid;
    private final String email;
}
