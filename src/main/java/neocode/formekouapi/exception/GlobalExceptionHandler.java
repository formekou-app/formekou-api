package neocode.formekouapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<String> handleRuntimeException(ApiException error) {
        return new ResponseEntity<>(
                error.getMessage(),
                error.getStatus()
        );
    }
}