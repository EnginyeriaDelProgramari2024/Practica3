package services;

public interface LocalService {
    // Solves the login step for the support staff
    void verifyAccount(String login, Password pssw) throws InvalidAccountException;
}
