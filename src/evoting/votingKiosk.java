package evoting;

import data.*;
import exceptions.*;

/**
 * Internal classes involved in the exercise of the vote
 */

public class votingKiosk {
    //Attributes
    private char document;
    private Nif nif;
    private VotingOption v0;

    private boolean eVoting;
    private static char CONFIRMED = 'Y';
    private static char CANCELED = 'N';

    private int procedure;

    // ??? // The class members
    // ??? // The constructor/s
    public votingKiosk() {
        this.document = ' ';
        this.nif = null;
        this.v0 = null;
        this.eVoting = false;
        this.procedure = 0;
    }

    // Input events
    public void initVoting() throws ProceduralException {
        if (procedure != 0) {
            throw new ProceduralException("Wrong procedure");
        }
        eVoting = true;
        System.out.println("EVoting inicialized correctly.");
        this.procedure++;
    }

    public void setDocument(char opt) throws ProceduralException {
        if (procedure != 1) {
            throw new ProceduralException("Wrong procedure");
        }
        this.document = opt;
        System.out.println("Solicita ayuda al personal de soporte.");
        this.procedure++;
    }

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

    // Función auxiliar para comprobar la validez de la cuenta
    private boolean isValidAccount(String login, Password pssw) {
        return isValidLogin(login) && isValidPassword(pssw);
    }

    // Funciones auxiliares para comprobar la validez del login
    private boolean isValidLogin(String login) {
        return login != null;
    }

    // Funciones auxiliares para comprobar la validez de la contraseña
    private boolean isValidPassword(Password pssw) {
        return Password.verifyPassword(pssw.getPassword());
    }

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

    public void enterNif(Nif nif) throws NotEnabledException, ConnectException, ProceduralException {
        if (procedure != 4) {
            throw new ProceduralException("Wrong procedure");
        }
        this.nif = nif;
        System.out.println("Nif ok, en proceso de verificación de derecho a voto.");
        this.procedure++;
    }

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
        this.procedure++;
    }

    public void vote() throws ProceduralException {
        if (procedure != 7) {
            throw new ProceduralException("Wrong procedure");
        }
        System.out.println("Are you sure you want to vote for " + v0.getParty() + "?");
        this.procedure++;
    }

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

    private void verifiyBiometricData(BiometricData humanBioD, BiometricData passpBioD) throws BiometricVerificationFailedException {
        if (!humanBioD.equals(passpBioD)) {
            throw new BiometricVerificationFailedException("Biometric data does not match");
        } else {
            System.out.println("Biometric data matches");
        }
    }

    private void removeBiometricData() {
        //. . .
    }

    public void grantExplicitConsent(char cons) {
        if (cons == CONFIRMED) {
            System.out.println("Explicit consent has been granted.");

        } else if (cons == CANCELED) {
            System.out.println("Explicit consent has been denied.");

        } else {
            System.out.println("Error: Invalid confirmation option.");
        }
    }

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

    public void readFaceBiometrics() throws HumanBiometricScanningException {
        System.out.println("Can proceed to read face biometrics.");
    }

    public void readFingerPrintBiometrics() throws NotEnabledException, HumanBiometricScanningException, BiometricVerificationFailedException, ConnectException {
        System.out.println("Can proceed to read fingerprint biometrics.");
    }

}
