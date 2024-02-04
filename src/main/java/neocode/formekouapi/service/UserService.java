package neocode.formekouapi.service;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.exception.NotFoundException;
import neocode.formekouapi.model.User;
import neocode.formekouapi.repository.UserRepository;
import org.springframework.stereotype.Service;

//TODO: send client response instead of throwing runtime exception
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(String id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("User with {id: " + id+ "} is not found"));
    }

    public User getUserByEmail(String email) {
        return userRepository
            .findByEmail(email)
            .orElseThrow(() -> new NotFoundException("User with {email: " + email + "} is not found"));
    }
}
