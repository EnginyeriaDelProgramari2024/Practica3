package data;

import exceptions.InvalidDNIDocumException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NifTest {

    private Nif validNif;
    private Nif invalidNif;

    @BeforeEach
    public void setUp() {
        // Valid NIF
        try {
            validNif = new Nif("Z34565434");
        } catch (InvalidDNIDocumException e) {
            throw new RuntimeException("Failed to set up valid NIF", e);
        }

        // Invalid NIF
        try {
            invalidNif = new Nif("3456711X");
        } catch (InvalidDNIDocumException e) {
            throw new RuntimeException("Failed to set up invalid NIF", e);
        }
    }

    @Test
    public void testValidNif() {
        assertNotNull(validNif);
        // assertEquals("Z34565434", validNif.validateNif);
    }

    @Test
    public void testInvalidNif() {
        assertNotNull(invalidNif);
    }
}
