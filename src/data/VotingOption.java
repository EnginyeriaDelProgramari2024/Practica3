/* --------------------------------------------------------------------------------------------------------------------------
File: VotingOption.java
Package: data
Authors: Guillem Mora Bea
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

    /**
     * equals method
     *
     * @param o object
     *          return true if the object is equal to the party
     *          return false if the object is not equal to the party
     *          return false if the object is null
     *          return false if the object is not an instance of VotingOption
     * @return true if the object is equal to the party
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VotingOption vO = (VotingOption) o;
        return party.equals(vO.party);
    }

    /**
     * hashCode method
     *
     * @return party.hashCode()
     */
    @Override
    public int hashCode() {
        return party.hashCode();
    }

    /**
     * toString method
     *
     * @return "Vote option {" + "party='" + party + '\'' + '}'
     */
    @Override
    public String toString() {
        return party;
    }
}
