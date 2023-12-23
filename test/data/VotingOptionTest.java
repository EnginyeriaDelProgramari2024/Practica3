package data;

import exceptions.InvalidDNIDocumException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VotingOptionTest {
    private VotingOption votingOption;

    @BeforeEach
    public void setUp() throws InvalidDNIDocumException {
        votingOption = new VotingOption("PSOE");
    }

    @Test
    public void testGetParty() {
        assert votingOption.getParty().equals("PSOE");
    }

    @Test
    public void testEquals() throws InvalidDNIDocumException {
        VotingOption votingOption2 = new VotingOption("PSOE");
        assert votingOption.equals(votingOption2);
    }

    @Test
    public void testHashCode() throws InvalidDNIDocumException {
        VotingOption votingOption2 = new VotingOption("PSOE");
        assert votingOption.hashCode() == votingOption2.hashCode();
    }

    @Test
    public void testToString() {
        assert votingOption.toString().equals("Vote option {party='PSOE'}");
    }
}
