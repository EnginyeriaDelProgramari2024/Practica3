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

    private byte[] biometricKey;

    public void SingleBiometricData(byte[] biometricKey) {
        this.biometricKey = biometricKey;
    }

    public byte[] getBiometricKey() {
        return biometricKey;
    }

}
