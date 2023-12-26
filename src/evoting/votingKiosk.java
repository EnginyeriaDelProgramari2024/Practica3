package evoting;

import data.Nif;
import data.Password;
import data.VotingOption;
import exceptions.*;

/**
 * Internal classes involved in in the exercise of the vote
 */
public class votingKiosk {

    private boolean eVoting;
    private static char CONFIRMED = 'Y';
    // ??? // The class members
    // ??? // The constructor/s

    // Input events
    public void initVoting() {
        eVoting = true;
        System.out.println("EVoting inicialized correctly.");
    }

    public void setDocument(char opt) {
        //. . .
    }

    public void enterAccount(String login, Password pssw) throws InvalidAccountException {
        //. . .
    }

    public void confirmIdentif(char conf) throws InvalidDNIDocumException {
        if (conf == CONFIRMED) {
            System.out.println("Identification confirmed succesfully.");

        } else {
            throw new InvalidDNIDocumException("Invalid identification.");
        }
    }

    public void enterNif(Nif nif) throws NotEnabledException, ConnectException {
        //. . .
    }

    public void initOptionsNavigation() {
        //. . .
    }

    public void consultVotingOption(VotingOption vopt) {

        if (vopt == null) {
            throw new IllegalArgumentException("Voting option cannot be null");

        } else {
            String votingOption = vopt.getParty();
            System.out.println("Consulting voting option.");
            System.out.println("Party: " + votingOption);
        }
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
}
