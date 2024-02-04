package neocode.formekouapi.service;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.model.User;
import neocode.formekouapi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public User whoami(String token){
        return null;
    }

    public User signup(String token, User userToSave){
        return null;
    }
}