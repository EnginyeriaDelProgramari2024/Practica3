package data;

import exceptions.NotValidPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PasswordTest {
    private Password validPassword;
    private Password invalidPassword;

    @BeforeEach
    public void setUp() {
        // Valid password
        try {
            validPassword = new Password("");
        } catch (NotValidPasswordException e) {
            throw new RuntimeException("Failed to set up valid password");
        }

        // Invalid password
        try {
            invalidPassword = new Password("");
        } catch (NotValidPasswordException e) {
            throw new RuntimeException("Failed to set up invalid password");
        }
    }

    @Test
    public void testValidPassword() {
        assertNotNull(validPassword);
        assertEquals("", validPassword.getPassword());
    }

    @Test
    public void testInvalidPassword() {
        assertNotNull(invalidPassword);
    }
}
