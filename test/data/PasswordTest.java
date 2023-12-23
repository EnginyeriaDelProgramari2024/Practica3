package data;

import exceptions.NotValidPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PasswordTest {
    private String validPasswordStr = "Password1";
    private String invalidPasswordStr = "password";

    @BeforeEach
    public void setUp() {
        // This method is called before each test
        // We can use it to initialize the variables we use in the tests
        // In this case, we don't need to do anything
    }

    @Test
    public void testValidPassword() throws NotValidPasswordException {
        Password password = new Password(validPasswordStr);
        assertNotNull(password);
        assertEquals(validPasswordStr, password.getPassword());
    }

    @Test
    public void testInvalidPassword() {
        assertThrows(NotValidPasswordException.class, () -> new Password(invalidPasswordStr));
    }
}
