package services;

import data.Nif;
import exceptions.ConnectException;
import exceptions.NotEnabledException;

public class ElectoralOrg implements ElectoralOrganism {
    @Override
    public void canVote(Nif nif) throws NotEnabledException, ConnectException {

        // From the NIF, it verifies whether the voter meets all the conditions for voting, before proceeding to cast the vote.

        if (nif == null) throw new ConnectException("Nif is null");
        if (nif.getNif() == null) throw new ConnectException("Nif is null");
        if (!Nif.validateNif(nif.getNif())) throw new NotEnabledException("Nif is not enabled");
    }

    @Override
    public void disableVoter(Nif nif) throws ConnectException, NotEnabledException {

        //From the NIF, it is recorded in the electoral roll that said voter has already exercised the right to vote (the voter is disqualified, thus avoiding the possibility of duplicate votes)

        boolean voted = false;
        if (voted == true) {
            throw new ConnectException("Voter has already voted");
        }
    }
}
