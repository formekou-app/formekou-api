package neocode.formekouapi.endpoint.rest.controller;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.exception.AccessDeniedException;
import neocode.formekouapi.exception.NotFoundException;
import neocode.formekouapi.model.User;
import neocode.formekouapi.security.FirebaseAuthentication;
import neocode.formekouapi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //TODO
    @GetMapping("/users")
    public List<User> getAllUsers(FirebaseAuthentication authentication){
        throw new AccessDeniedException();
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable String userId){
        return userService.getUserById(userId).orElseThrow(NotFoundException::new);
    }
}
