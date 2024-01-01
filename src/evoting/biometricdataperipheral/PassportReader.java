package evoting.biometricdataperipheral;

import data.BiometricData;
import data.Nif;
import exceptions.NotValidPasswordException;
import exceptions.PassportBiometricReadingException;

public class PassportReader implements PassportBiometricReader {

    @Override
    public void validatePassport() throws NotValidPasswordException {
        if (!isValidPassport() || !isDataIntegrityValid()) {
            throw new NotValidPasswordException("The passport is not valid or contains corrupted data.");
        }
    }

    private boolean isValidPassport() {
        // TODO: Comprovar que el passaport es valid
    }

    private boolean isDataIntegrityValid() {
        // TODO: Comprovar que les dades del passaport son correctes
    }

    @Override
    public Nif getNifWithOCR() {
        // TODO: Agafar el NIF amb OCR
    }

    @Override
    public BiometricData getPassportBiometricData() throws PassportBiometricReadingException {
        try {
            BiometricData biometricData = new BiometricData(getPassportBiometricData().getFacialBiometricData(), getPassportBiometricData().getFingerprintBiometricData());
            return biometricData;
        } catch (Exception e) {
            throw new PassportBiometricReadingException("Error reading passport biometric data.", e);
        }
    }
}
