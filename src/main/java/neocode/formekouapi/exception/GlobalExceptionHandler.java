package neocode.formekouapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiErrorResponse> handleRuntimeException(ApiException error) {
        return new ResponseEntity<>(
                new ApiErrorResponse(error.getMessage(), error.getStatus()),
                error.getStatus()
        );
    }
}
