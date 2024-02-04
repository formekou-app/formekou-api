package neocode.formekouapi.service;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import neocode.formekouapi.security.FirebaseUser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FirebaseService {
    private final FirebaseAuth firebaseAuth;

    public FirebaseUser getUserByToken(String token) throws FirebaseAuthException {
        FirebaseToken decodedToken = firebaseAuth.verifyIdToken(token);
        return new FirebaseUser(
            decodedToken.getUid(),
            decodedToken.getEmail()
        );
    }
}
