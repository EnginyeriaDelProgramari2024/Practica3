/* --------------------------------------------------------------------------------------------------------------------------
File: BiometricData.java
Package: data
Authors: Guillem Mora
         Roberta Alina Mititelu
         Loana Rodrigues Morais
--------------------------------------------------------------------------------------------------------------------------- */


package data;


/**
 * BiometricData Class
 *
 */
public class BiometricData {
    private SingleBiometricData facialBiometricData;
    private SingleBiometricData fingerprintBiometricData;
    private byte[] biometricKey;

    /**
     * Constructor
     *
     * @param facialBiometricData facial image
     * @param fingerprintBiometricData finger print
     */
    public BiometricData(SingleBiometricData facialBiometricData, SingleBiometricData fingerprintBiometricData) {
        this.facialBiometricData = facialBiometricData;
        this.fingerprintBiometricData = fingerprintBiometricData;
    }

    /**
     * Return the biometric data from the facial image
     *
     * @return facialBiometricData
     */
    public SingleBiometricData getFacialBiometricData() {
        return facialBiometricData;
    }

    /**
     * Return the biometric data from the finger print
     *
     * @return fingerprintBiometricData
     */
    public SingleBiometricData getFingerprintBiometricData() {
        return fingerprintBiometricData;
    }

    /**
     *
     *
     * @param biometricKey biometricKey
     */
    public void SingleBiometricData(byte[] biometricKey) {
        this.biometricKey = biometricKey;
    }

    /**
     * Return biometric key
     *
     * @return biometricKey
     */
    public byte[] getBiometricKey() {
        return biometricKey;
    }
}
