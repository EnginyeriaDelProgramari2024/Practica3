package data;

public class BiometricData {
    private SingleBiometricData facialBiometricData;
    private SingleBiometricData fingerprintBiometricData;

    public BiometricData(SingleBiometricData facialBiometricData, SingleBiometricData fingerprintBiometricData) {
        this.facialBiometricData = facialBiometricData;
        this.fingerprintBiometricData = fingerprintBiometricData;
    }

    public SingleBiometricData getFacialBiometricData() {
        return facialBiometricData;
    }

    public SingleBiometricData getFingerprintBiometricData() {
        return fingerprintBiometricData;
    }
}
