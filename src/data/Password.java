package data;

public class Password {
    // Attributes
    private final String password;

    // Constructor
    public Password(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        this.password = password;
    }

    // Getters
    public String getPassword() {
        return password;
    }
}
