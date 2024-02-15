package neocode.formekouapi.security;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import neocode.formekouapi.exception.AccessDeniedException;
import neocode.formekouapi.model.User;
import neocode.formekouapi.service.FirebaseService;
import neocode.formekouapi.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@AllArgsConstructor
public class FirebaseAuthFilter extends OncePerRequestFilter {
    private static final String BEARER_PREFIX = "Bearer ";
    private final FirebaseService firebaseService;
    private final UserService userService;
    private final RequestMatcher filteredMatcher;

    public static String getFirebaseToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken == null || !bearerToken.startsWith(BEARER_PREFIX)) {
            //TODO: Handle to show cool exception
            throw new AccessDeniedException();
        }
        return bearerToken.substring(BEARER_PREFIX.length());
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException
    {
        String token = FirebaseAuthFilter.getFirebaseToken(request);
        try {
            FirebaseToken firebaseToken =  firebaseService.getFirebaseUserByToken(token);
            Optional<User> user = userService.getUserById(firebaseToken.getUid());
            FirebaseAuthentication authentication = new FirebaseAuthentication(
                    user.orElse(User.builder()
                            .id(firebaseToken.getUid())
                            .profilePicture(firebaseToken.getPicture())
                            .email(firebaseToken.getEmail())
                            .lastName(firebaseToken.getName() == null ? firebaseToken.getEmail() : firebaseToken.getName())
                            .build()
                    ),
                    token,
                    user.isPresent()
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request,response);
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return filteredMatcher.matches(request);
    }
}