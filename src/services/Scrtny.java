package services;

import data.VotingOption;

import java.util.List;

public class Scrtny implements Scrutiny{

    private int totalVotes;
    private int blankVotes;

    public Scrtny() {

        this.totalVotes = 0;
        this.blankVotes = 0;

    }
    @Override
    public void initVoteCount(List<VotingOption> validParties) {

    }

    @Override
    public void scrutinize(VotingOption vopt) {

        // Incorporates the voting option (vopt) in the count of votes.
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
