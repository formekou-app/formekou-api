package neocode.formekouapi.service;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.model.User;
import neocode.formekouapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> getUserById(String id){
        return userRepository.findById(id);
    }

    public User saveOrUpdate(User toSave){
        return userRepository.save(toSave);
    }

    public User updateProfile(User updatedUser){
        User currentUser = AuthService.getAuthentication().getUser();
        currentUser.setFirstName(updatedUser.getFirstName());
        currentUser.setLastName(updatedUser.getLastName());
        currentUser.setProfilePicture(updatedUser.getProfilePicture());
        return saveOrUpdate(currentUser);
    }
}
