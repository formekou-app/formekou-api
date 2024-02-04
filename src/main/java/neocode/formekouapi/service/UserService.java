package neocode.formekouapi.service;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.exception.AccessDeniedException;
import neocode.formekouapi.exception.ApiException;
import neocode.formekouapi.model.User;
import neocode.formekouapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(String id){
        return userRepository
                .findById(id)
                .orElseThrow(()->new AccessDeniedException("User not found"));
    }
}
