package neocode.formekouapi.controller;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.model.CreateUser;
import neocode.formekouapi.model.User;
import neocode.formekouapi.security.FirebaseAuthentication;
import neocode.formekouapi.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/whoami")
    public User whoami(FirebaseAuthentication authentication){
        return authService.getWhoAmi(authentication);
    }

    @PostMapping("/signup")
    public User signup(@RequestBody CreateUser userToSave){
        return authService.signup(userToSave);
    }
}