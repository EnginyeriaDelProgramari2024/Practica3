/* --------------------------------------------------------------------------------------------------------------------------
File: LocalServ.java
Package: data
Authors: Guillem Mora Bea
         Roberta Alina Mititelu
         Loana Rodrigues Morais
--------------------------------------------------------------------------------------------------------------------------- */
package services;

import data.Password;
import exceptions.InvalidAccountException;

/**
 * Class that implements the LocalService interface
 */
public class LocalServ implements LocalService {

    /**
     * Method that verifies the account
     *
     * @param login
     * @param pssw
     * @throws InvalidAccountException if the account is invalid
     */
    @Override
    public void verifyAccount(String login, Password pssw) throws InvalidAccountException {
        if (login == null || pssw == null || pssw.getPassword() == null) {
            throw new InvalidAccountException("Invalid Account.");
        }

        if (!Password.verifyPassword(pssw.getPassword())) throw new InvalidAccountException("Invalid Password.");

        System.out.println("Valid Account.");
    }
}
