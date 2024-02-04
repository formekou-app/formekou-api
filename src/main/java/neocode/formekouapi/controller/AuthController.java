package neocode.formekouapi.controller;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.model.User;
import neocode.formekouapi.service.AuthService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/whoami")
    public User whoami(@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        return authService.whoami(token);
    }

    @PostMapping("/signup")
    public User signup(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody User user){
        return authService.signup(token, user);
    }
}