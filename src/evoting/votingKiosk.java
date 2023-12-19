package evoting;

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
}
