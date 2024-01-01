package services;

import data.Password;
import exceptions.InvalidAccountException;

public class LocalServ implements LocalService {
    @Override
    public void verifyAccount(String login, Password pssw) throws InvalidAccountException {
        if (login == null || pssw == null || pssw.getPassword() == null) {
            throw new InvalidAccountException("Invalid Account.");
        }

        if (!Password.verifyPassword(pssw.getPassword())) throw new InvalidAccountException("Invalid Password.");

        System.out.println("Valid Account.");
    }
}
