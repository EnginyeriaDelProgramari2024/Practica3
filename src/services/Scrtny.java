/* --------------------------------------------------------------------------------------------------------------------------
File: Scrtny.java
Package: data
Authors: Guillem Mora Bea
         Roberta Alina Mititelu
         Loana Rodrigues Morais
--------------------------------------------------------------------------------------------------------------------------- */
package services;

import data.VotingOption;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that implements the Scrutiny interface.
 * It is used to count the votes for each party and the null and blank votes.
 */
public class Scrtny implements Scrutiny {

    // Map to store the vote count for each party
    private Map<VotingOption, Integer> voteCount;

    // Counter for null votes, blank votes and total vote count
    private int nullVotes;
    private int blankVotes;
    private int totalVotes;

    /**
     * Method to initialize the vote count for each party.
     *
     * @param validParties list of valid parties
     */
    @Override
    public void initVoteCount(List<VotingOption> validParties) {
        voteCount = new HashMap<>();
        for (VotingOption party : validParties) {
            voteCount.put(party, 0);
        }
        nullVotes = 0;
        blankVotes = 0;
        totalVotes = 0;
    }

    /**
     * Method to scrutinize a vote.
     *
     * @param vopt the voting option
     */
    @Override
    public void scrutinize(VotingOption vopt) {
        if (voteCount.containsKey(vopt)) {
            voteCount.put(vopt, voteCount.get(vopt) + 1);
        } else if (vopt == null) {
            nullVotes++;
        } else {
            blankVotes++;
        }
        totalVotes++;
    }

    /**
     * Method to get the vote count for a party.
     *
     * @param vopt the voting option
     * @return the vote count for the party
     */
    @Override
    public int getVotesFor(VotingOption vopt) {
        return voteCount.getOrDefault(vopt, 0);
    }

    /**
     * Method to get the number of null votes.
     *
     * @return the number of null votes
     */
    @Override
    public int getNulls() {
        return nullVotes;
    }

    /**
     * Method to get the number of blank votes.
     *
     * @return the number of blank votes
     */
    @Override
    public int getBlanks() {
        return blankVotes;
    }

    /**
     * Method to get the total number of votes.
     *
     * @return the total number of votes
     */
    @Override
    public int getTotal() {
        return totalVotes;
    }

    /**
     * Method to get the scrutiny results.
     */
    @Override
    public void getScrutinyResults() {
        System.out.println("SCRUTINY RESULTS:");
        for (Map.Entry<VotingOption, Integer> entry : voteCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
        System.out.println("Blank votes: " + blankVotes + " votes");
        System.out.println("Null votes: " + nullVotes + " votes");
        System.out.println("Total votes: " + totalVotes + " votes");
    }
}
