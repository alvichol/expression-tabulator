package expression.exceptions;

public class EvalException extends RuntimeException {
    private final EvalExceptionType type;
    public EvalException(String message, EvalExceptionType type) {
        super(message);
        this.type = type;
    }

    public EvalException(String message, EvalExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }

    public EvalExceptionType getType() {
        return type;
    }
}
