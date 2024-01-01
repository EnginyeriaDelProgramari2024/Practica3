package evoting;

import data.Password;
import exceptions.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class votingKioskTest {
    private static votingKiosk vk;

    @BeforeAll
    public static void setUp() {
        vk = new votingKiosk();
    }

    @Test
    @Order(1)
    public void setDocumentProceduralException() throws ProceduralException {
        assertThrows(ProceduralException.class, () -> vk.setDocument('N'));
        vk.initVoting();
    }

    @Test
    @Order(2)
    public void enterAccountProceduralException() throws ProceduralException {
        assertThrows(ProceduralException.class, () -> vk.enterAccount("Guillem", new Password("12345678aA")));
        vk.setDocument('N');

    }
}
