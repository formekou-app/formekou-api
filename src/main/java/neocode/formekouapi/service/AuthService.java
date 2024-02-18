package neocode.formekouapi.service;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.model.User;
import neocode.formekouapi.security.FirebaseAuthentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;

    public static FirebaseAuthentication getAuthentication(){
        return (FirebaseAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }


    public User getWhoAmi(){
        FirebaseAuthentication authentication = getAuthentication();
        if(!authentication.isRegistered()){
            return userService.saveOrUpdate(authentication.getUser());
        }
        return authentication.getUser();
    }
}