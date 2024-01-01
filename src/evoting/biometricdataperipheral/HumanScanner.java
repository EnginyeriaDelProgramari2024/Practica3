package evoting.biometricdataperipheral;

import data.SingleBiometricData;
import exceptions.HumanBiometricScanningException;

public class HumanScanner implements HumanBiometricScanner {
    @Override
    public SingleBiometricData scanFaceBiometrics() throws HumanBiometricScanningException {
        if (scanFaceBiometrics().getFacialBiometricData() == null) {
            throw new HumanBiometricScanningException("Face biometrics could not be scanned.");
        }
        return scanFaceBiometrics().getFacialBiometricData();
    }

    @Override
    public SingleBiometricData scanFingerprintBiometrics() throws HumanBiometricScanningException {
        if (scanFingerprintBiometrics().getFingerprintBiometricData() == null) {
            throw new HumanBiometricScanningException("Fingerprint biometrics could not be scanned.");
        }
        return scanFingerprintBiometrics().getFingerprintBiometricData();
    }
}
