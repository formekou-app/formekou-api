package neocode.formekouapi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException{
    private HttpStatus status;
    public ApiException(String message, HttpStatus status) {
        super(message);
    }
}
