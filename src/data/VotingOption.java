package data;

import exceptions.*;

/**
 * Essential data classes
 */
public class VotingOption {
    // The tax identification number in the Spanish state.
    private final String party;

    public VotingOption(String option) {
        this.party = option;
    }

    public String getParty() {
        return party;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VotingOption vO = (VotingOption) o;
        return party.equals(niff.party);
    }

    @Override
    public int hashCode() {
        return party.hashCode();
    }

    @Override
    public String toString() {
        return "Vote option {" + "party='" + party + '\'' + '}';
    }

    private void verifiyBiometricData(BiometricData humanBioD, BiometricData passpBioD) throws BiometricVerificationFailedException {
        //. . .
    }

    private void removeBiometricData() {
        //. . .
    }

    public void grantExplicitConsent(char cons) {
        //. . .
    }

    public void readPassport() throws NotValidPassportException, PassportBiometricReadingException {
        //. . .
    }

    public void readFaceBiometrics() throws HumanBiometricScanningException {
        //. . .
    }

    public void readFingerPrintBiometrics() throws NotEnabledException, HumanBiometricScanningException, BiometricVerificationFailedException, ConnectException {
        //. . .
    }

}
