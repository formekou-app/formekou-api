package neocode.formekouapi.service;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.exception.UserAlreadyExistException;
import neocode.formekouapi.model.User;
import neocode.formekouapi.repository.UserRepository;
import neocode.formekouapi.security.FirebaseAuthentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public User whoami(String token){
        return null;
    }

    public User signup(FirebaseAuthentication authentication, User userToSave){
        if(authentication.isRegistered()){
            throw new UserAlreadyExistException(
                    "User already exist with the email=" +
                            authentication.getFirebaseUser().getEmail()
            );
        }
        userToSave.setId(authentication.getFirebaseUser().getUid());
        userToSave.setEmail(authentication.getFirebaseUser().getEmail());
        return userRepository.save(userToSave);
    }
}