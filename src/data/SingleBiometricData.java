/* --------------------------------------------------------------------------------------------------------------------------
File: SingleBiometricData.java
Package: data
Authors: Guillem Mora Bea
         Roberta Alina Mititelu
         Loana Rodrigues Morais
--------------------------------------------------------------------------------------------------------------------------- */
package data;


/**
 * Class that represents a single biometric data.
 */
public class SingleBiometricData {
    private byte[] biometricData;
    private String biometricType;

    /**
     * Constructor of the class.
     *
     * @param biometricData the biometric data
     * @param biometricType the biometric type
     */
    public SingleBiometricData(byte[] biometricData, String biometricType) {
        this.biometricData = biometricData;
        this.biometricType = biometricType;
    }


    /**
     * Gets the biometric data.
     *
     * @return the biometric data
     */
    public SingleBiometricData getFacialBiometricData() {
        if (biometricType.equals("facial")) {
            return this;
        }
        return null;
    }

    /**
     * Gets the biometric data.
     *
     * @return the biometric data
     */
    public SingleBiometricData getFingerprintBiometricData() {
        if (biometricType.equals("fingerprint")) {
            return this;
        }
        return null;
    }
}
