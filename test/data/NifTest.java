/* --------------------------------------------------------------------------------------------------------------------------
File: NifTest.java
Package: data
Authors: Guillem Mora Bea
         Roberta Alina Mititelu
         Loana Rodrigues Morais
--------------------------------------------------------------------------------------------------------------------------- */
package data;

import exceptions.InvalidDNIDocumException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NifTest {

    private String validNifStr = "12345678Z";
    private String invalidNifStr = "12345678A";

    @BeforeEach
    public void setUp() {
        // This method is called before each test
        // We can use it to initialize the variables we use in the tests
        // In this case, we don't need to do anything
    }

    @Test
    public void testValidNif() throws InvalidDNIDocumException {
        Nif nif = new Nif(validNifStr);
        assertNotNull(nif);
        assertEquals(validNifStr, nif.getNif());
    }

    @Test
    public void testInvalidNif() {
        assertThrows(InvalidDNIDocumException.class, () -> new Nif(invalidNifStr));
    }
}
