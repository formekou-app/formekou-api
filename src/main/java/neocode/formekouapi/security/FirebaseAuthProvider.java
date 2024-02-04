package neocode.formekouapi.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class FirebaseAuthProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(!supports(authentication.getClass())){
            //FIXME: send error to the client
            //user not connected
            // throw new AccessDeniedException();
        }

        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return FirebaseAuthentication.class.isAssignableFrom(authentication);
    }
}
