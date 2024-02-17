package neocode.formekouapi.endpoint.rest.controller;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.endpoint.rest.mapper.UserMapper;
import neocode.formekouapi.endpoint.rest.model.User;
import neocode.formekouapi.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserMapper mapper;

    @GetMapping("/whoami")
    public User whoami(){
        return mapper.toRest(authService.getWhoAmi());
    }
}