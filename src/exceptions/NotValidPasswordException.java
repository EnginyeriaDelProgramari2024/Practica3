package exceptions;

public class NotValidPasswordException extends Throwable {
    public NotValidPasswordException(String s) {
        super(s);
    }
}
