package services;

import data.Password;
import exceptions.InvalidAccountException;
import exceptions.NotValidPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocalServiceTest {

    private LocalServ ls;
    private Password invalidPassword;

    @BeforeEach
    public void setUp() throws NotValidPasswordException {
        ls = new LocalServ();
        invalidPassword = new Password("lolo123");
    }

    @Test
    public void verifyAccountException() throws InvalidAccountException {
        assertThrows(InvalidAccountException.class, () -> ls.verifyAccount(null, null));
    }

    @Test
    public void verifyAccountException1() throws InvalidAccountException {
        assertThrows(InvalidAccountException.class, () -> ls.verifyAccount(null, invalidPassword));
    }
}

