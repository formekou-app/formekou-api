package neocode.formekouapi.controller;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.exception.AccessDeniedException;
import neocode.formekouapi.model.User;
import neocode.formekouapi.security.FirebaseAuthentication;
import neocode.formekouapi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(FirebaseAuthentication test){
        throw new AccessDeniedException();
    }
}
