package evoting;

import data.Nif;
import data.Password;
import data.VotingOption;
import exceptions.*;

/**
 * Internal classes involved in in the exercise of the vote
 */
public class votingKiosk {
    //Attributes
    private char document;
    private Nif nif;
    private VotingOption v0;

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
        this.document = opt;
        System.out.println("VotingKiosk::setDocument: " + opt);
    }

    public void enterAccount(String login, Password pssw) throws InvalidAccountException {
        if (!isValidAccount(login, pssw)) {
            throw new InvalidAccountException("Invalid account");
        }
    }

    private boolean isValidAccount(String login, Password pssw) {
        return isValidLogin(login) && isValidPassword(pssw);
    }

    private boolean isValidLogin(String login) {
        return login != null;
    }

    private boolean isValidPassword(Password pssw) {
        return pssw != null;
    }

    public void confirmIdentif(char conf) throws InvalidDNIDocumException {
        if (conf == CONFIRMED) {
            System.out.println("Identification confirmed succesfully.");

        } else {
            throw new InvalidDNIDocumException("Invalid identification.");
        }
    }

    public void enterNif(Nif nif) throws NotEnabledException, ConnectException {
        this.nif = nif;
    }

    public void initOptionsNavigation() {
        if (!eVoting) {
            System.out.println("Voting has not been initialized.");
        }

        System.out.println("Menús: ");
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
        System.out.println("Are you sure you want to vote for " + v0.getParty() + "?");
        //TODO: Preguntar ProceduralException
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
