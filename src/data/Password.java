/* --------------------------------------------------------------------------------------------------------------------------
File: Password.java
Package: data
Authors: Guillem Mora
         Roberta Alina Mititelu
         Loana Rodrigues Morais
--------------------------------------------------------------------------------------------------------------------------- */

package data;

import exceptions.NotValidPasswordException;


/**
 * Password Class
 *
 */
public class Password {
    private static final int MINLENGTH = 8;
    private final String password;

    /**
     * Constructor
     *
     * @param password password
     * @throws NotValidPasswordException
     */
    public Password(String password) throws NotValidPasswordException {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        if (!verifyPassword(password)) {
            throw new NotValidPasswordException("Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter and one number");
        }
        this.password = password;
    }

    /**
     * Get password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Verify password
     *
     * @param password password
     * @return true -> password.length() > MINLENGTH || 1 uppercase letter - 1 lowercase letter - 1 number
     *         false -> opposite case
     */
    public static boolean verifyPassword(String password) {
        if (password.length() < MINLENGTH) {
            return false;
        }
        if (!password.matches(".*[a-z].*") || !password.matches(".*[A-Z].*") || !password.matches(".*[0-9].*")) {
            return false;
        }
        return true;
    }
}
