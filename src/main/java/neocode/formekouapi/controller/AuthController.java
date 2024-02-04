package neocode.formekouapi.controller;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.model.User;
import neocode.formekouapi.security.FirebaseAuthentication;
import neocode.formekouapi.service.AuthService;
import neocode.formekouapi.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    @GetMapping("/whoami")
    public User whoami(FirebaseAuthentication authentication){
        if(!authentication.isRegistered()){
            return userService.saveOrUpdate(authentication.getUser());
        }
        return authentication.getUser();
    }

    @PostMapping("/signup")
    public User signup(FirebaseAuthentication authentication, @RequestBody User userToSave){
        return authService.signup(authentication, userToSave);
    }
}