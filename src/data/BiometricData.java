package data;

public class BiometricData {
    private byte[] biometricKey;

    public void SingleBiometricData(byte[] biometricKey) {
        this.biometricKey = biometricKey;
    }

    public byte[] getBiometricKey() {
        return biometricKey;
    }
}
