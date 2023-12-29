package evoting;

import data.BiometricData;
import data.Nif;
import data.Password;
import data.VotingOption;
import exceptions.*;

/**
 * Internal classes involved in in the exercise of the vote
 */
public class votingKiosk {
    // ??? // The class members
    // ??? // The constructor/s

    // Input events
    public void initVoting() {
        //. . .
    }

    public void setDocument(char opt) {
        //. . .
    }

    public void enterAccount(String login, Password pssw) throws InvalidAccountException {
        //. . .
    }

    public void confirmIdentif(char conf) throws InvalidDNIDocumException {
        //. . .
    }

    public void enterNif(Nif nif) throws NotEnabledException, ConnectException {
        //. . .
    }

    public void initOptionsNavigation() {
        //. . .
    }

    public void consultVotingOption(VotingOption vopt) {
        //. . .
    }

    public void vote() {
        //. . .
    }

    public void confirmVotingOption(char conf) throws ConnectException {
        //. . .
    }

    // Internal operation, not required
    private void finalizeSession() {
        //. . .
    }
    //(...) // Setter methods for injecting dependences and additional methods

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
        // . . .
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
        // . . .
    }

    public void readFingerPrintBiometrics() throws NotEnabledException, HumanBiometricScanningException, BiometricVerificationFailedException, ConnectException {
        // . . .
    }

}
