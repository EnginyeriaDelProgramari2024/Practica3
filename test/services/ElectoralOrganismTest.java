/* --------------------------------------------------------------------------------------------------------------------------
File: ElectoralOrganismTest.java
Package: data
Authors: Guillem Mora Bea
         Roberta Alina Mititelu
         Loana Rodrigues Morais
--------------------------------------------------------------------------------------------------------------------------- */
package services;

import data.Nif;
import exceptions.ConnectException;
import exceptions.InvalidDNIDocumException;
import exceptions.NotEnabledException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElectoralOrganismTest {

    private ElectoralOrganism electoralOrg;

    @BeforeEach
    public void setUp() {
        electoralOrg = new ElectoralOrg();
        // This method is called before each test
        // We can use it to initialize the variables we use in the tests
        // In this case, we don't need to do anything
    }

    @Test
    public void testCanVoteException() throws InvalidDNIDocumException {
        assertThrows(ConnectException.class, () -> electoralOrg.canVote(null));
    }

    @Test
    public void testDisableVoter() throws InvalidDNIDocumException, NotEnabledException, ConnectException {
        assertThrows(ConnectException.class, () -> electoralOrg.disableVoter(null));
        electoralOrg.disableVoter(new Nif("12345678Z"));
        assertThrows(NotEnabledException.class, () -> electoralOrg.disableVoter(new Nif("12345678Z")));
    }
}
