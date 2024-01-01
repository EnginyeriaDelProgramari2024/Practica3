/* --------------------------------------------------------------------------------------------------------------------------
File: SingleBiometricDataTest.java
Package: data
Authors: Guillem Mora Bea
         Roberta Alina Mititelu
         Loana Rodrigues Morais
--------------------------------------------------------------------------------------------------------------------------- */

package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SingleBiometricDataTest {
    private byte[] biometricData;
    private String facialType;
    private String fingerprintType;

    @BeforeEach
    public void setUp() {
        biometricData = new byte[0];
        facialType = "facial";
        fingerprintType = "fingerprint";
    }

    @Test
    public void testFacialBiometricData() {
        SingleBiometricData facialBiometricData = new SingleBiometricData(biometricData, facialType);
        assertNotNull(facialBiometricData);
        assertEquals(facialBiometricData, facialBiometricData.getFacialBiometricData());
        assertNull(facialBiometricData.getFingerprintBiometricData());
    }

    @Test
    public void testFingerprintBiometricData() {
        SingleBiometricData fingerprintBiometricData = new SingleBiometricData(biometricData, fingerprintType);
        assertNotNull(fingerprintBiometricData);
        assertEquals(fingerprintBiometricData, fingerprintBiometricData.getFingerprintBiometricData());
        assertNull(fingerprintBiometricData.getFacialBiometricData());
    }
}
