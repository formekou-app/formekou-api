package neocode.formekouapi.security;

import com.google.firebase.auth.FirebaseAuthException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import neocode.formekouapi.exception.AccessDeniedException;
import neocode.formekouapi.model.User;
import neocode.formekouapi.service.FirebaseService;
import neocode.formekouapi.service.UserService;
import neocode.formekouapi.service.model.FirebaseUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.io.IOException;

public class FirebaseAuthFilter extends AbstractAuthenticationProcessingFilter {
    private static final String BEARER_PREFIX = "Bearer ";
    private final FirebaseService firebaseService;
    private final UserService userService;

    public static String getFirebaseToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken == null || !bearerToken.startsWith(BEARER_PREFIX)) {
            throw new AccessDeniedException();
        }
        return bearerToken.substring(BEARER_PREFIX.length());
    }

    public FirebaseAuthFilter(RequestMatcher requestMatcher, FirebaseService firebaseService, UserService userService){
        super(requestMatcher);
        this.firebaseService = firebaseService;
        this.userService = userService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException
    {
        String token = FirebaseAuthFilter.getFirebaseToken(request);
        try{
            FirebaseUser firebaseUser =  firebaseService.getFirebaseUserByToken(token);
            User user = userService.getUserById(firebaseUser.getUid());
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(user, token);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return authentication;
        }catch(FirebaseAuthException error){
            throw new AccessDeniedException();
        }
    }
}
