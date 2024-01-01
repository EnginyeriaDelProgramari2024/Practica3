/* --------------------------------------------------------------------------------------------------------------------------
File: ScrutinyTest.java
Package: data
Authors: Guillem Mora Bea
         Roberta Alina Mititelu
         Loana Rodrigues Morais
--------------------------------------------------------------------------------------------------------------------------- */
package services;

import data.VotingOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScrutinyTest {
    private Scrtny scrutiny;

    @BeforeEach
    public void setUp() {
        scrutiny = new Scrtny();
    }

    @Test
    public void testInitVoteCount() {
        List<VotingOption> parties = Arrays.asList(new VotingOption("PP"), new VotingOption("PSOE"), new VotingOption("VOX"), new VotingOption("PSP"));

        scrutiny.initVoteCount(parties);

        for (VotingOption party : parties) {
            assertEquals(0, scrutiny.getVotesFor(party));
        }

        assertEquals(0, scrutiny.getNulls());
        assertEquals(0, scrutiny.getBlanks());
        assertEquals(0, scrutiny.getTotal());
    }

    @Test
    public void testScrutinizeValidVote() {
        VotingOption validParty = new VotingOption("Valid party.");

        scrutiny.initVoteCount(Arrays.asList(validParty));

        scrutiny.scrutinize(validParty);

        assertEquals(1, scrutiny.getVotesFor(validParty));
        assertEquals(0, scrutiny.getNulls());
        assertEquals(0, scrutiny.getBlanks());
        assertEquals(1, scrutiny.getTotal());
    }

    @Test
    public void testScrutinizeNullVote() {
        scrutiny.initVoteCount(Arrays.asList(new VotingOption("PSP")));

        scrutiny.scrutinize(null);

        assertEquals(1, scrutiny.getNulls());
        assertEquals(0, scrutiny.getBlanks());
        assertEquals(1, scrutiny.getTotal());
    }

    @Test
    public void testScrutinizedBlankVote() {
        scrutiny.initVoteCount(Arrays.asList(new VotingOption("PP")));

        scrutiny.scrutinize(new VotingOption(""));

        assertEquals(0, scrutiny.getNulls());
        assertEquals(1, scrutiny.getBlanks());
        assertEquals(1, scrutiny.getTotal());
    }

    @Test
    public void testGetScrutinyResults() {
        VotingOption PP = new VotingOption("PP");
        VotingOption PSOE = new VotingOption("PSOE");
        VotingOption VOX = new VotingOption("VOX");
        VotingOption PSP = new VotingOption("PSP");

        scrutiny.initVoteCount(Arrays.asList(PP, PSOE, VOX, PSP));

        scrutiny.scrutinize(PP);
        scrutiny.scrutinize(PSOE);
        scrutiny.scrutinize(VOX);
        scrutiny.scrutinize(PSP);
        scrutiny.scrutinize(null);
        scrutiny.scrutinize(new VotingOption(""));

        PrintStream originalOut = System.out;
        ByteArrayOutputStream console = new ByteArrayOutputStream();
        System.setOut(new PrintStream(console));

        scrutiny.getScrutinyResults();

        System.setOut(originalOut);

        String expected = "SCRUTINY RESULTS:\n" + "PP: 1 votes\n" + "PSOE: 1 votes\n" + "PSP: 1 votes\n" + "VOX: 1 votes\n" + "Blank votes: 1 votes\n" + "Null votes: 1 votes\n" + "Total votes: 6 votes\n";

        assertEquals(expected, console.toString());
    }
}
