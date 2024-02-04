package neocode.formekouapi.controller;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.model.User;
import neocode.formekouapi.security.FirebaseAuthentication;
import neocode.formekouapi.service.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/whoami")
    public User whoami(FirebaseAuthentication authentication){
        return authentication.getUser();
    }

    @PostMapping("/signup")
    public User signup(FirebaseAuthentication authentication, @RequestBody User userToSave){
        return authService.signup(authentication, userToSave);
    }
}