package neocode.formekouapi.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import neocode.formekouapi.service.model.FirebaseUser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FirebaseService {
    private final FirebaseAuth firebaseAuth;

    public FirebaseUser getFirebaseUserByToken(String token) throws FirebaseAuthException {
        FirebaseToken firebaseToken = firebaseAuth.verifyIdToken(token);
        return new FirebaseUser(firebaseToken.getUid(), firebaseToken.getEmail());
    }
}
