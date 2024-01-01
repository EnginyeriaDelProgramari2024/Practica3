package services;

import data.Password;
import exceptions.InvalidAccountException;
import exceptions.NotValidPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocalServiceTest {

    private LocalServ ls;
    private Password validPassword;

    @BeforeEach
    public void setUp() throws NotValidPasswordException {
        ls = new LocalServ();
        validPassword = new Password("Password1");
    }

    @Test
    public void verifyAccountException() throws InvalidAccountException {
        assertThrows(InvalidAccountException.class, () -> ls.verifyAccount(null, validPassword));
    }
}