package neocode.formekouapi.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import lombok.RequiredArgsConstructor;
import neocode.formekouapi.model.CreateUser;
import neocode.formekouapi.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FirebaseService {
    private final FirebaseAuth firebaseAuth;
    public FirebaseToken getFirebaseUserByToken(String token) throws FirebaseAuthException {
        return firebaseAuth.verifyIdToken(token);
    }

    public UserRecord createUser(CreateUser userToSave) throws FirebaseAuthException {
        UserRecord.CreateRequest createRequest = new UserRecord.CreateRequest();
        return firebaseAuth.createUser(
            createRequest
                .setEmail(userToSave.getEmail())
                .setPassword(userToSave.getPassword())
                .setDisplayName(userToSave.getLastName())
        );
    }
}
