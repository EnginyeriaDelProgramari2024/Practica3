package services;

/**
 * External services involved in managing the electoral roll
 */
public interface ElectoralOrganism {
    void canVote(Nif nif) throws NotEnabledException, ConnectException;

    void disableVoter(Nif nif) throws ConnectException;
}
