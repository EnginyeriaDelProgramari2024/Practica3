/* --------------------------------------------------------------------------------------------------------------------------
File: VotingOption.java
Package: data
Authors: Guillem Mora
         Roberta Alina Mititelu
         Loana Rodrigues Morais
--------------------------------------------------------------------------------------------------------------------------- */

package data;

import exceptions.*;


/**
 * VotingOption Class
 */
public class VotingOption {
    private final String party;

    /**
     * Contructor
     *
     * @param option option
     */
    public VotingOption(String option) {
        this.party = option;
    }

    /**
     * Return party
     *
     * @return party
     */
    public String getParty() {
        return party;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VotingOption vO = (VotingOption) o;
        return party.equals(vO.party);
    }

    @Override
    public int hashCode() {
        return party.hashCode();
    }

    @Override
    public String toString() {
        return "Vote option {" + "party='" + party + '\'' + '}';
    }
}
