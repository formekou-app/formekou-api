package neocode.formekouapi.endpoint.rest.mapper;

import lombok.AllArgsConstructor;
import neocode.formekouapi.endpoint.rest.model.User;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {

    public User toRest(neocode.formekouapi.model.User userDomain){
        return User.builder()
                .id(userDomain.getId())
                .email(userDomain.getEmail())
                .lastName(userDomain.getLastName())
                .fistName(userDomain.getFirstName())
                .profilePicture(userDomain.getProfilePicture())
                .build();
    }

    public neocode.formekouapi.model.User toDomain(User userRest){
        return neocode.formekouapi.model.User.builder()
                .id(userRest.getId())
                .email(userRest.getEmail())
                .profilePicture(userRest.getProfilePicture())
                .lastName(userRest.getLastName())
                .firstName(userRest.getFistName())
                .build();
    }
}
