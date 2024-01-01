package services;

import data.VotingOption;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scrtny implements Scrutiny {

    // Map to store the vote count for each party
    private Map<VotingOption, Integer> voteCount;

    // Counter for null votes, blank votes and total vote count
    private int nullVotes;
    private int blankVotes;
    private int totalVotes;

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

    @Override
    public int getVotesFor(VotingOption vopt) {
        return voteCount.getOrDefault(vopt, 0);
    }

    @Override
    public int getNulls() {
        return nullVotes;
    }

    @Override
    public int getBlanks() {
        return blankVotes;
    }

    @Override
    public int getTotal() {
        return totalVotes;
    }

    @Override
    public void getScrutinyResults() {
        System.out.println("SCRUTINY RESULTS:");
        for (Map.Entry<VotingOption, Integer> entry : voteCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
        System.out.println("Blank votes: " + blankVotes);
        System.out.println("Null votes: " + nullVotes);
        System.out.println("Total votes: " + totalVotes);
    }
}
