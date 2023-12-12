package evoting.biometricdataperipheral;

import exceptions.*;

public interface PassportBiometricReader {
    // Perip. for reading passport biometrics
    void validatePassport() throws NotValidPassportException;

    Nif getNifWithOCR();

    BiometricData getPassportBiometricData() throws PassportBiometricReadingException;
}
