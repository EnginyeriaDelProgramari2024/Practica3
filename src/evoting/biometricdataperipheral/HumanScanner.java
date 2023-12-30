package evoting.biometricdataperipheral;

import data.SingleBiometricData;
import exceptions.HumanBiometricScanningException;

public class HumanScanner implements HumanBiometricScanner{
    @Override
    public SingleBiometricData scanFaceBiometrics() throws HumanBiometricScanningException {
        return scanFaceBiometrics().getFacialBiometricData();
    }

    @Override
    public SingleBiometricData scanFingerprintBiometrics() throws HumanBiometricScanningException {
        return scanFingerprintBiometrics().getFingerprintBiometricData();
    }
}
