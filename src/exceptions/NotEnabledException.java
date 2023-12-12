package exceptions;

public class NotEnabledException extends Exception {
    public NotEnabledException() {
        super();
    }

    public NotEnabledException(String message) {
        super(message);
    }

    public NotEnabledException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnabledException(Throwable cause) {
        super(cause);
    }

    protected NotEnabledException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
