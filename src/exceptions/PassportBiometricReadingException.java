package exceptions;

public class PassportBiometricReadingException extends Exception {
    public PassportBiometricReadingException(String message, Exception e) {
        super(message);
    }
}
