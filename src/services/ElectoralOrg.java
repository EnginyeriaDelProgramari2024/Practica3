/* --------------------------------------------------------------------------------------------------------------------------
File: ElectoralOrg.java
Package: data
Authors: Guillem Mora Bea
         Roberta Alina Mititelu
         Loana Rodrigues Morais
--------------------------------------------------------------------------------------------------------------------------- */
package services;

import data.Nif;
import exceptions.ConnectException;
import exceptions.NotEnabledException;

public class ElectoralOrg implements ElectoralOrganism {
    private boolean voted;

    /**
     * Constructor
     */
    public ElectoralOrg() {
        this.voted = false;
    }

    /**
     * Method that checks if the voter can vote
     *
     * @param nif
     * @throws NotEnabledException if the voter can't vote
     * @throws ConnectException    if the connection fails
     */
    @Override
    public void canVote(Nif nif) throws NotEnabledException, ConnectException {

        // From the NIF, it verifies whether the voter meets all the conditions for voting, before proceeding to cast the vote.

        if (nif == null) throw new ConnectException("Nif is null");
        if (nif.getNif() == null) throw new ConnectException("Nif is null");
        if (!Nif.validateNif(nif.getNif())) throw new NotEnabledException("Nif is not enabled");
        if (this.voted) throw new NotEnabledException("Nif is not enabled");

        System.out.println("Nif is enabled");
    }

    /**
     * Method that disables the voter
     *
     * @param nif
     * @throws NotEnabledException if the voter can't vote
     * @throws ConnectException    if the connection fails
     */
    @Override
    public void disableVoter(Nif nif) throws ConnectException, NotEnabledException {

        //From the NIF, it is recorded in the electoral roll that said voter has already exercised the right to vote (the voter is disqualified, thus avoiding the possibility of duplicate votes)
        if (nif == null) throw new ConnectException("Nif is null");
        if (nif.getNif() == null) throw new ConnectException("Nif is null");
        if (!Nif.validateNif(nif.getNif())) throw new NotEnabledException("Nif is not enabled");
        if (this.voted) throw new NotEnabledException("Nif is not enabled");
        this.voted = true;
    }
}
