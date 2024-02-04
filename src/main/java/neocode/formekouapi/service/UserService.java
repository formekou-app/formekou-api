package neocode.formekouapi.service;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.model.User;
import neocode.formekouapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id){
        return userRepository.findById(id);
    }

    public User saveOrUpdate(User toSave){
        return userRepository.save(toSave);
    }
}
