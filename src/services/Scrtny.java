package services;

import data.VotingOption;

import java.util.List;

public class Scrtny implements Scrutiny{
    @Override
    public void initVoteCount(List<VotingOption> validParties) {

    }

    @Override
    public void scrutinize(VotingOption vopt) {

    }

    @Override
    public int getVotesFor(VotingOption vopt) {
        return 0;
    }

    @Override
    public int getTotal() {

        // Returns the total number of votes counted.
        return totalVotes;

    }

    @Override
    public int getNulls() {
        return 0;
    }

    @Override
    public int getBlanks() {
        // Returns the number of blank votes.
        return blankVotes;
    }

    @Override
    public void getScrutinyResults() {

    }
}
