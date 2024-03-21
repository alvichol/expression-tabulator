package expression.exceptions;

public class InvalidExprException extends RuntimeException {
    public InvalidExprException(String message) {
        super(message);
    }

    public InvalidExprException(String message, Throwable cause) {
        super(message, cause);
    }
}
