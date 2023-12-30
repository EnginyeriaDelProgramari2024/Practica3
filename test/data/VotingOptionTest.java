package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VotingOptionTest {
    private VotingOption votingOption;

    @BeforeEach
    public void setUp() {
        votingOption = new VotingOption("PSOE");
    }

    @Test
    public void testGetParty() {
        assert votingOption.getParty().equals("PSOE");
    }

    @Test
    public void testEquals() {
        VotingOption votingOption2 = new VotingOption("PSOE");
        assert votingOption.equals(votingOption2);
    }

    @Test
    public void testHashCode() {
        VotingOption votingOption2 = new VotingOption("PSOE");
        assert votingOption.hashCode() == votingOption2.hashCode();
    }

    @Test
    public void testToString() {
        assert votingOption.toString().equals("Vote option {party='PSOE'}");
    }
}
