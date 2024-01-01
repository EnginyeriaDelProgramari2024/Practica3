/* --------------------------------------------------------------------------------------------------------------------------
File: SingleBiometricData.java
Package: data
Authors: Guillem Mora
         Roberta Alina Mititelu
         Loana Rodrigues Morais
--------------------------------------------------------------------------------------------------------------------------- */

package data;


public class SingleBiometricData {
    private byte[] biometricData;
    // Select one of the following: "facial" or "fingerprint"
    private String biometricType;

    public SingleBiometricData(byte[] biometricData, String biometricType) {
        this.biometricData = biometricData;
        this.biometricType = biometricType;
    }


    public SingleBiometricData getFacialBiometricData() {
        if (biometricType.equals("facial")) {
            return this;
        }
        return null;
    }

    public SingleBiometricData getFingerprintBiometricData() {
        if (biometricType.equals("fingerprint")) {
            return this;
        }
        return null;
    }
}
