package neocode.formekouapi.service;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import lombok.RequiredArgsConstructor;
import neocode.formekouapi.exception.InternalServerErrorException;
import neocode.formekouapi.exception.UserAlreadyExistException;
import neocode.formekouapi.model.CreateUser;
import neocode.formekouapi.model.User;
import neocode.formekouapi.security.FirebaseAuthentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final FirebaseService firebaseService;

    public User getWhoAmi(FirebaseAuthentication authentication){
        if(!authentication.isRegistered()){
            return userService.saveOrUpdate(authentication.getUser());
        }
        return authentication.getUser();
    }

    public User signup(CreateUser userToSave){
        if(userToSave.getId() != null && userService.getUserById(userToSave.getId()).isPresent()){
            throw new UserAlreadyExistException(
                "User already exist with the email=" + userToSave.getEmail()
            );
        }

        try {
            UserRecord createdUser = firebaseService.createUser(userToSave);
            userToSave.setId(createdUser.getUid());
            return userService.saveOrUpdate(new User(
                userToSave.getId(),
                userToSave.getEmail(),
                userToSave.getLastName(),
                userToSave.getFistName()
            ));
        }catch (FirebaseAuthException error){
            throw new InternalServerErrorException();
        }
    }
}