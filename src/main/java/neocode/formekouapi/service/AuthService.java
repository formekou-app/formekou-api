package neocode.formekouapi.service;

import com.google.firebase.auth.FirebaseAuthException;
import lombok.RequiredArgsConstructor;
import neocode.formekouapi.model.User;
import neocode.formekouapi.repository.UserRepository;
import neocode.formekouapi.security.FirebaseUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final FirebaseService firebaseService;
    private final String TOKEN_TYPE = "Bearer ";

    private String getBearerToken(String token){
        if(token == null || !token.startsWith(TOKEN_TYPE))
            return "";
        return token.substring(7);
    }

    public User whoami(String token){
        String bearerToken = getBearerToken(token);
        if(bearerToken.isEmpty())
            return null;

        try {
            FirebaseUser firebaseUser = firebaseService.getUserByToken(bearerToken);
            System.out.println("User connected with " + firebaseUser.getEmail());
            Optional<User> connectedUser = userRepository.findById(firebaseUser.getUid());

            if(connectedUser.isPresent()){
                return connectedUser.get();
            }
            System.out.println("Error, user not regirstred no database");
            return null;
        } catch (FirebaseAuthException e) {
            System.out.println("User not found");
            return null;
        }
    }

    public User signup(String token, User userToSave){
        String bearerToken = getBearerToken(token);

        if(bearerToken.isEmpty())
            return null;
        try {
            FirebaseUser firebaseUser = firebaseService.getUserByToken(bearerToken);
            userToSave.setId(firebaseUser.getUid());
            userToSave.setEmail(firebaseUser.getEmail());

            return userRepository.save(userToSave);
        } catch (FirebaseAuthException e) {
            System.out.println("Invalid token");
            return null;
        }
    }
}