package neocode.formekouapi.endpoint.rest.controller;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.endpoint.rest.mapper.UserMapper;
import neocode.formekouapi.endpoint.rest.model.User;
import neocode.formekouapi.exception.NotFoundException;
import neocode.formekouapi.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable String userId){
        return mapper.toRest(
                userService.getUserById(userId).orElseThrow(NotFoundException::new
        ));
    }

    @PutMapping("/users")
    User updateProfile(@RequestBody User user){
        return mapper.toRest(userService.updateProfile(mapper.toDomain(user)));
    }
}
