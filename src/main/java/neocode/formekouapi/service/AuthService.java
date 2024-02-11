package neocode.formekouapi.service;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.model.User;
import neocode.formekouapi.security.FirebaseAuthentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final FirebaseService firebaseService;

    public User getWhoAmi(FirebaseAuthentication authentication){
        if(!authentication.isRegistered()){
            return userService.saveOrUpdate(authentication.getUser());
        }
        return authentication.getUser();
    }

    public User signup(User userToSave){
        return userService.saveOrUpdate(userToSave);
    }
}