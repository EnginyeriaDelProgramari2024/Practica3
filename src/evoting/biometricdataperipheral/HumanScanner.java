/* --------------------------------------------------------------------------------------------------------------------------
File: HumanScanner.java
Package: data
Authors: Guillem Mora Bea
         Roberta Alina Mititelu
         Loana Rodrigues Morais
--------------------------------------------------------------------------------------------------------------------------- */
package evoting.biometricdataperipheral;

import data.SingleBiometricData;
import exceptions.HumanBiometricScanningException;

/**
 * Class that implements the HumanBiometricScanner interface and represents the human biometric scanner.
 */
public class HumanScanner implements HumanBiometricScanner {

    /**
     * Method that scans the face biometrics.
     *
     * @return the face biometrics.
     */
    @Override
    public SingleBiometricData scanFaceBiometrics() throws HumanBiometricScanningException {
        if (scanFaceBiometrics().getFacialBiometricData() == null) {
            throw new HumanBiometricScanningException("Face biometrics could not be scanned.");
        }
        return scanFaceBiometrics().getFacialBiometricData();
    }

    /**
     * Method that scans the fingerprint biometrics.
     *
     * @return the fingerprint biometrics.
     */
    @Override
    public SingleBiometricData scanFingerprintBiometrics() throws HumanBiometricScanningException {
        if (scanFingerprintBiometrics().getFingerprintBiometricData() == null) {
            throw new HumanBiometricScanningException("Fingerprint biometrics could not be scanned.");
        }
        return scanFingerprintBiometrics().getFingerprintBiometricData();
    }
}
