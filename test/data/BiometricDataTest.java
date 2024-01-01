/* --------------------------------------------------------------------------------------------------------------------------
File: BiometricDataTest.java
Package: data
Authors: Guillem Mora Bea
         Roberta Alina Mititelu
         Loana Rodrigues Morais
--------------------------------------------------------------------------------------------------------------------------- */

package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BiometricDataTest {
    private SingleBiometricData facialBiometricData;
    private SingleBiometricData fingerprintBiometricData;
    private byte[] biometricKey;

    @BeforeEach
    public void setUp() {
        facialBiometricData = new SingleBiometricData(new byte[0], "facial");
        fingerprintBiometricData = new SingleBiometricData(new byte[0], "fingerprint");
        biometricKey = new byte[0];
    }

    @Test
    public void testBiometricData() {
        BiometricData biometricData = new BiometricData(facialBiometricData, fingerprintBiometricData);
        assertNotNull(biometricData);
        assertEquals(facialBiometricData, biometricData.getFacialBiometricData());
        assertEquals(fingerprintBiometricData, biometricData.getFingerprintBiometricData());

        biometricData.SingleBiometricData(biometricKey);
        assertEquals(biometricKey, biometricData.getBiometricKey());
    }
}
