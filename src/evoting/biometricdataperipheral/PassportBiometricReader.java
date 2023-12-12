package evoting.biometricdataperipheral;

public interface PassportBiometricReader {
    // Perip. for reading passport biometrics
    void validatePassport() throws NotValidPassportException;

    Nif getNifWithOCR();

    BiometricData getPassportBiometricData() throws PassportBiometricReadingException;
}
