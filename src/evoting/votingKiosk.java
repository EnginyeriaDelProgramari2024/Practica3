/* --------------------------------------------------------------------------------------------------------------------------
File: votingKiosk.java
Package: data
Authors: Guillem Mora Bea
         Roberta Alina Mititelu
         Loana Rodrigues Morais
--------------------------------------------------------------------------------------------------------------------------- */
package evoting;

import data.*;
import exceptions.*;

/**
 * Class that represents the voting kiosk.
 */
public class votingKiosk {
    //Attributes
    private char document;
    private Nif nif;
    private VotingOption v0;

    private boolean eVoting;
    private boolean fingerprintenabled;
    private static char CONFIRMED = 'Y';
    private static char CANCELED = 'N';

    private int procedure;

    /**
     * Constructor of the class.
     */
    public votingKiosk() {
        this.document = ' ';
        this.nif = null;
        this.v0 = null;
        this.eVoting = false;
        this.procedure = 0;
    }

    /**
     * Method that initializes the voting.
     *
     * @throws ProceduralException if the procedure is not 0
     * @precondition procedure == 0
     * @postcondition procedure == 1
     * @see ProceduralException
     */
    public void initVoting() throws ProceduralException {
        if (procedure != 0) {
            throw new ProceduralException("Wrong procedure");
        }
        eVoting = true;
        System.out.println("EVoting inicialized correctly.");
        this.procedure++;
    }

    /**
     * Method that sets the document.
     *
     * @param opt
     * @throws ProceduralException if the procedure is not 1
     * @precondition procedure == 1
     * @postcondition procedure == 2
     * @see ProceduralException
     */
    public void setDocument(char opt) throws ProceduralException {
        if (procedure != 1) {
            throw new ProceduralException("Wrong procedure");
        }
        this.document = opt;
        System.out.println("Solicita ayuda al personal de soporte.");
        this.procedure++;
    }

    /**
     * Method that enters the account.
     *
     * @param login
     * @param pssw
     * @throws InvalidAccountException if the account is not valid
     * @throws ProceduralException     if the procedure is not 2
     * @precondition procedure == 2
     * @postcondition procedure == 3
     * @see InvalidAccountException
     * @see ProceduralException
     * @see Password
     */
    public void enterAccount(String login, Password pssw) throws InvalidAccountException, ProceduralException {
        if (procedure != 2) {
            throw new ProceduralException("Wrong procedure");
        }
        if (!isValidAccount(login, pssw)) {
            throw new InvalidAccountException("Invalid account");
        }
        System.out.println("Autentification ok");
        this.procedure++;
    }

    /**
     * Method that verifies the account.
     *
     * @param login
     * @param pssw
     * @return true if the account is valid, false otherwise
     * @precondition login != null && pssw != null
     * @postcondition true == isValidAccount(login, pssw)
     * @see Password
     */
    private boolean isValidAccount(String login, Password pssw) {
        return isValidLogin(login) && isValidPassword(pssw);
    }

    /**
     * Method that verifies the login.
     *
     * @param login
     * @return true if the login is valid, false otherwise
     * @precondition login != null
     * @postcondition true == isValidLogin(login)
     * @see Password
     */
    private boolean isValidLogin(String login) {
        return login != null;
    }

    /**
     * Method that verifies the password.
     *
     * @param pssw
     * @return true if the password is valid, false otherwise
     * @precondition pssw != null
     * @postcondition true == isValidPassword(pssw)
     * @see Password
     */
    private boolean isValidPassword(Password pssw) {
        return Password.verifyPassword(pssw.getPassword());
    }

    /**
     * Method that confirms the identification.
     *
     * @param conf
     * @throws InvalidDNIDocumException if the identification is not valid
     * @throws ProceduralException      if the procedure is not 3
     * @precondition procedure == 3
     * @postcondition procedure == 4
     * @see InvalidDNIDocumException
     * @see ProceduralException
     * @see Nif
     */
    public void confirmIdentif(char conf) throws InvalidDNIDocumException, ProceduralException {
        if (procedure != 3) {
            throw new ProceduralException("Wrong procedure");
        }
        if (conf == CONFIRMED) {
            System.out.println("Identification confirmed succesfully.");

        } else {
            throw new InvalidDNIDocumException("Invalid identification.");
        }
        this.procedure++;
    }

    /**
     * Method that enters the NIF.
     *
     * @param nif
     * @throws NotEnabledException if the voting is not enabled
     * @throws ConnectException    if there is a connection error
     * @throws ProceduralException if the procedure is not 4
     * @precondition procedure == 4
     * @postcondition procedure == 5
     * @see NotEnabledException
     * @see ConnectException
     * @see ProceduralException
     * @see Nif
     */
    public void enterNif(Nif nif) throws NotEnabledException, ConnectException, ProceduralException {
        if (procedure != 4) {
            throw new ProceduralException("Wrong procedure");
        }
        this.nif = nif;
        System.out.println("Nif ok, en proceso de verificación de derecho a voto.");
        this.procedure++;
    }

    /**
     * Method that initializes the options navigation.
     *
     * @throws ProceduralException if the procedure is not 5
     * @precondition procedure == 5
     * @postcondition procedure == 6
     * @see ProceduralException
     * @see Party
     * @see VotingOption
     */
    public void initOptionsNavigation() throws ProceduralException {
        if (procedure != 5) {
            throw new ProceduralException("Wrong procedure");
        }
        if (!eVoting) {
            System.out.println("Voting has not been initialized.");
        }

        System.out.println("Menús: ");

        for (Party p : Party.values()) {
            System.out.println(p);
        }
        System.out.println("Autenticación ok.");
        this.procedure++;
    }

    /**
     * Method that consults the voting option.
     *
     * @param vopt
     * @throws ProceduralException      if the procedure is not 6
     * @throws IllegalArgumentException if the voting option is null
     * @precondition procedure == 6
     * @postcondition procedure == 7
     * @see ProceduralException
     * @see IllegalArgumentException
     * @see VotingOption
     * @see Party
     */
    public void consultVotingOption(VotingOption vopt) throws ProceduralException, IllegalArgumentException {
        if (procedure != 6) {
            throw new ProceduralException("Wrong procedure");
        }
        if (vopt == null) {
            throw new IllegalArgumentException("Voting option cannot be null");

        } else {
            String votingOption = vopt.getParty();
            System.out.println("Consulting voting option.");
            System.out.println("Party: " + votingOption);
        }
        v0 = vopt;
        this.procedure++;
    }

    /**
     * Method that votes.
     *
     * @throws ProceduralException if the procedure is not 7
     * @precondition procedure == 7
     * @postcondition procedure == 8
     * @see ProceduralException if the procedure is not 7
     * @see VotingOption
     * @see Party
     */
    public void vote() throws ProceduralException {
        if (procedure != 7) {
            throw new ProceduralException("Wrong procedure");
        }
        System.out.println("Are you sure you want to vote for " + v0.getParty() + "?");
        this.procedure++;
    }

    /**
     * Method that confirms the voting option.
     *
     * @param conf
     * @throws ConnectException    if there is a connection error
     * @throws ProceduralException if the procedure is not 8
     * @precondition procedure == 8
     * @postcondition procedure == 9
     * @see ConnectException
     * @see ProceduralException
     * @see VotingOption
     * @see Party
     */
    public void confirmVotingOption(char conf) throws ConnectException, ProceduralException {
        if (procedure != 8) {
            throw new ProceduralException("Wrong procedure");
        }
        if (!eVoting) {
            System.out.println("Voting has not been initialized.");
        }

        if (conf == CONFIRMED) {
            System.out.println("Voting option confirmed.");
        } else if (conf == CANCELED) {
            System.out.println("Voting option canceled.");
        } else {
            System.out.println("Error: Invalid confirmation option.");
        }
        this.procedure++;
    }

    // Internal operation, not required
    private void finalizeSession() throws ProceduralException {
        if (procedure != 9) {
            throw new ProceduralException("Wrong procedure");
        }
        procedure = 0;
    }

    /**
     * Method that verifies the biometric data.
     *
     * @param humanBioD
     * @param passpBioD
     * @throws BiometricVerificationFailedException if the biometric data does not match
     * @precondition humanBioD != null && passpBioD != null
     * @postcondition true == humanBioD.equals(passpBioD)
     * @see BiometricVerificationFailedException
     * @see BiometricData
     */
    private void verifiyBiometricData(BiometricData humanBioD, BiometricData passpBioD) throws BiometricVerificationFailedException {
        if (!humanBioD.equals(passpBioD)) {
            throw new BiometricVerificationFailedException("Biometric data does not match");
        } else {
            System.out.println("Biometric data matches");
        }
    }

    /**
     * Method that removes the biometric data.
     */
    private void removeBiometricData() {
        //. . .
    }

    /**
     * Method that grants the explicit consent.
     *
     * @param cons
     * @precondition cons == CONFIRMED || cons == CANCELED
     * @postcondition cons == CONFIRMED || cons == CANCELED
     */
    public void grantExplicitConsent(char cons) {
        if (cons == CONFIRMED) {
            System.out.println("Explicit consent has been granted.");

        } else if (cons == CANCELED) {
            System.out.println("Explicit consent has been denied.");

        } else {
            System.out.println("Error: Invalid confirmation option.");
        }
    }

    /**
     * Method that reads the passport.
     *
     * @throws NotValidPassportException         if the passport is not valid
     * @throws PassportBiometricReadingException if the biometric data could not be read
     */
    public void readPassport() throws NotValidPassportException, PassportBiometricReadingException {
        // evento para indicar al sistema que puede proceder con la validación y lectura de los datos del pasaporte.
        System.out.println("Reading passport");
        if (Math.random() < 0.5) {
            throw new NotValidPassportException("Passport is not valid");
        } else if (Math.random() < 0.5) {
            throw new PassportBiometricReadingException("Passport biometric data could not be read");
        } else {
            System.out.println("Passport read");
        }
    }

    /**
     * Method that reads the face biometrics.
     *
     * @throws HumanBiometricScanningException if the biometric data could not be read
     */
    public void readFaceBiometrics() throws HumanBiometricScanningException {
        // evento para indicar al sistema que puede proceder con la validación y lectura de los datos biométricos del rostro.
        System.out.println("Reading face biometrics");
        if (Math.random() < 0.5) {
            throw new HumanBiometricScanningException("Face biometric data could not be read");
        } else {
            System.out.println("Face biometrics read");
        }
    }

    /**
     * Method that reads the fingerprint biometrics.
     *
     * @throws NotEnabledException                  if the biometric data could not be read
     * @throws HumanBiometricScanningException      if the biometric data could not be read
     * @throws BiometricVerificationFailedException if the biometric data does not match
     * @throws ConnectException                     if there is a connection error
     * @precondition fingerprintenabled == true
     * @postcondition true == fingerprintenabled
     * @see NotEnabledException
     * @see HumanBiometricScanningException
     * @see BiometricVerificationFailedException
     * @see ConnectException
     */
    public void readFingerPrintBiometrics() throws NotEnabledException, HumanBiometricScanningException, BiometricVerificationFailedException, ConnectException {
        if (!fingerprintenabled) {
            throw new NotEnabledException("Fingerprint is not enabled");
        }
        verifiyBiometricData(new BiometricData(new SingleBiometricData(new byte[0], "facial"), new SingleBiometricData(new byte[0], "fingerprint")), new BiometricData(new SingleBiometricData(new byte[0], "facial"), new SingleBiometricData(new byte[0], "fingerprint")));

        // evento para indicar al sistema que puede proceder con la validación y lectura de los datos biométricos de la huella dactilar.
        System.out.println("Reading fingerprint biometrics");
        if (Math.random() < 0.5) {
            throw new HumanBiometricScanningException("Fingerprint biometric data could not be read");
        } else {
            System.out.println("Fingerprint biometrics read");
        }
    }

}
