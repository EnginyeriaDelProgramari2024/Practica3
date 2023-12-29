package services;

import data.Nif;
import exceptions.ConnectException;
import exceptions.NotEnabledException;

public class ElectoralOrg implements ElectoralOrganism {
    @Override
    public void canVote(Nif nif) throws NotEnabledException, ConnectException {

        if(nif == null) throw new ConnectException("Nif is null");
        if(nif.getNif() == null) throw new ConnectException("Nif is null");
        if(nif.getNif().length() != 9) throw new ConnectException("Nif is not valid");

    }

    @Override
    public void disableVoter(Nif nif) throws ConnectException {

    }
}
