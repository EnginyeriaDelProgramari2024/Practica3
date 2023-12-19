package data;

public class SingleBiometricData {
    private byte[] biometricKey;

    public SingleBiometricData(byte[] biometricKey) {
        this.biometricKey = biometricKey;
    }

    public byte[] getBiometricKey() {
        return biometricKey;
    }
}
