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
        // This method is called before each test
        // We can use it to initialize the variables we use in the tests
        // In this case, we don't need to do anything

        facialBiometricData = new SingleBiometricData();
        fingerprintBiometricData = new SingleBiometricData();
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
