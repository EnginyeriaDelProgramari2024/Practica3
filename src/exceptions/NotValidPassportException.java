package exceptions;

public class NotValidPassportException extends Exception {
    public NotValidPassportException() {
        super();
    }

    public NotValidPassportException(String message) {
        super(message);
    }

    public NotValidPassportException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidPassportException(Throwable cause) {
        super(cause);
    }

    protected NotValidPassportException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
