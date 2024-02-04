package neocode.formekouapi.security;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import neocode.formekouapi.exception.AccessDeniedException;
import neocode.formekouapi.model.User;
import neocode.formekouapi.service.FirebaseService;
import neocode.formekouapi.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

public class FirebaseAuthFilter extends OncePerRequestFilter {
    private static final String BEARER_PREFIX = "Bearer ";
    private final FirebaseService firebaseService;
    private final UserService userService;

    public static String getFirebaseToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken == null || !bearerToken.startsWith(BEARER_PREFIX)) {
            //TODO: handle exception
            //throw new AccessDeniedException();
            return "dummy_token";
        }
        return bearerToken.substring(BEARER_PREFIX.length());
    }

    public FirebaseAuthFilter(FirebaseService firebaseService, UserService userService) {
        this.firebaseService = firebaseService;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = FirebaseAuthFilter.getFirebaseToken(request);
        try{
            FirebaseToken firebaseToken =  firebaseService.getFirebaseUserByToken(token);
            Optional<User> user = userService.getUserById(firebaseToken.getUid());
            FirebaseAuthentication authentication = new FirebaseAuthentication(
                    user.orElse(null),
                    new FirebaseUser(firebaseToken.getUid(), firebaseToken.getEmail()),
                    user.isPresent()
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch(FirebaseAuthException error){
            //TODO: if request matcher then directly throw error
            System.out.println(error);
        }

        filterChain.doFilter(request,response);
    }
}
