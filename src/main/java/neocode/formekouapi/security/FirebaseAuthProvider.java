package neocode.formekouapi.security;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import neocode.formekouapi.security.model.Principal;
import neocode.formekouapi.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FirebaseAuthProvider extends AbstractUserDetailsAuthenticationProvider {
    private static final String BEARER_PREFIX = "Bearer ";
    private final FirebaseAuth firebaseAuth;
    private final UserService userService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        String bearer = getFirebaseToken(authentication);
        if (bearer == null) {
            throw new UsernameNotFoundException("Bad credentials");
        }

        try{
            FirebaseToken firebaseToken = firebaseAuth.verifyIdToken(bearer);
            return new Principal(bearer, firebaseToken.getUid(), firebaseToken.getEmail());
        }catch(FirebaseAuthException error){
            throw new UsernameNotFoundException("Bad credentials");
        }
    }

    public String getFirebaseToken(UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken){
        Object tokenObject = usernamePasswordAuthenticationToken.getCredentials();
        if (!(tokenObject instanceof String) || !((String) tokenObject).startsWith(BEARER_PREFIX)) {
            return null;
        }
        return ((String) tokenObject).substring(BEARER_PREFIX.length()).trim();
    }

    public static Principal getPrincipal() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        return (Principal) authentication.getPrincipal();
    }
}
