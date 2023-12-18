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
    // ??? // The class members
    // ??? // The constructor/s

    // Input events
    public void initVoting() {
        //. . .
    }

    public void setDocument(char opt) {
        this.document = opt;
        System.out.println("VotingKiosk::setDocument: " + opt);
    }

    public void enterAccount(String login, Password pssw) throws InvalidAccountException {
        //. . .
    }

    public void confirmIdentif(char conf) throws InvalidDNIDocumException {
        //. . .
    }

    public void enterNif(Nif nif) throws NotEnabledException, ConnectException {
        this.nif = nif;
    }

    public void initOptionsNavigation() {
        //. . .
    }

    public void consultVotingOption(VotingOption vopt) {
        //. . .
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
