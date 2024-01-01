package evoting.biometricdataperipheral;

import data.BiometricData;
import data.Nif;
import exceptions.*;

public interface PassportBiometricReader {
    void validatePassport() throws NotValidPassportException, NotValidPasswordException;

    Nif getNifWithOCR();

    BiometricData getPassportBiometricData() throws PassportBiometricReadingException;
}
