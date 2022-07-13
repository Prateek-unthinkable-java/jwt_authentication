package developer.prateek.jwt_authentication.exception;

public class BadCredentialException extends RuntimeException{

    String message;

    public BadCredentialException() {}

    public BadCredentialException(String msg) {
        super(msg);
        this.message = msg;
    }
}
