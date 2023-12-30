package data;


import exceptions.NotValidPasswordException;

public class Password {

    private final int MINLENGTH = 8;
  
    // Attributes
    private final String password;

    // Constructor
    public Password(String password) throws NotValidPasswordException {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        if (!verifyPassword(password)) {
            throw new NotValidPasswordException("Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter and one number");
        }
        this.password = password;
    }

    // Getters
    public String getPassword() {
        return password;
    }

    // Methods
    private boolean verifyPassword(String password) {
        if (password.length() < MINLENGTH) {
            return false;
        }
        if (!password.matches(".*[a-z].*") || !password.matches(".*[A-Z].*") || !password.matches(".*[0-9].*")) {
            return false;
        }
        return true;
    }
}
