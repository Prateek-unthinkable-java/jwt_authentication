package developer.prateek.jwt_authentication.exception_handler;

import developer.prateek.jwt_authentication.exception.BadCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadCredentialException.class)
    public ResponseEntity<Object> handleBadCredentialsException(BadCredentialException badCredentialException) {
        return new ResponseEntity<>(badCredentialException.getMessage(), HttpStatus.FORBIDDEN);
    }
}
