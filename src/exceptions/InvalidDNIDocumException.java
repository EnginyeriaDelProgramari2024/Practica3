package exceptions;

public class InvalidDNIDocumException extends Exception {
    public InvalidDNIDocumException() {
        super();
    }

    public InvalidDNIDocumException(String msg) {
        super(msg);
    }
}
