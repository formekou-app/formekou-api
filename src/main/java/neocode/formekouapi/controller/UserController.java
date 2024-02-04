package neocode.formekouapi.controller;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.model.User;
import neocode.formekouapi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }
}
