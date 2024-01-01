/* --------------------------------------------------------------------------------------------------------------------------
File: PassportReader.java
Package: data
Authors: Guillem Mora Bea
         Roberta Alina Mititelu
         Loana Rodrigues Morais
--------------------------------------------------------------------------------------------------------------------------- */
package evoting.biometricdataperipheral;

import data.BiometricData;
import data.Nif;
import exceptions.NotValidPasswordException;
import exceptions.PassportBiometricReadingException;

/**
 * Class that implements the PassportBiometricReader interface and represents the passport biometric reader.
 */
public class PassportReader implements PassportBiometricReader {

    /**
     * Method that validates the passport.
     */
    @Override
    public void validatePassport() throws NotValidPasswordException {
        if (!isValidPassport() || !isDataIntegrityValid()) {
            throw new NotValidPasswordException("The passport is not valid or contains corrupted data.");
        }
    }

    /**
     * Method that checks if the passport is valid.
     *
     * @return true if the passport is valid, false otherwise.
     */
    private boolean isValidPassport() {
        // TODO: Comprovar que el passaport es valid
        return false;
    }

    /**
     * Method that checks if the data integrity is valid.
     *
     * @return true if the data integrity is valid, false otherwise.
     */
    private boolean isDataIntegrityValid() {
        // TODO: Comprovar que les dades del passaport son correctes
        return false;
    }

    /**
     * Method that gets the NIF with OCR.
     *
     * @return the NIF with OCR.
     */
    @Override
    public Nif getNifWithOCR() {
        // TODO: Agafar el NIF amb OCR
        return null;
    }

    /**
     * Method that gets the passport biometric data.
     *
     * @return the passport biometric data.
     */
    @Override
    public BiometricData getPassportBiometricData() throws PassportBiometricReadingException {
        try {
            BiometricData biometricData = new BiometricData(getPassportBiometricData().getFacialBiometricData(), getPassportBiometricData().getFingerprintBiometricData());
            return biometricData;
        } catch (Exception e) {
            throw new PassportBiometricReadingException("Error reading passport biometric data.");
        }
    }
}
