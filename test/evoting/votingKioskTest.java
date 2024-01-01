package evoting;

import data.Nif;
import data.Party;
import data.Password;
import data.VotingOption;
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

    @Test
    @Order(3)
    public void confirmIdentifProceduralException() throws ProceduralException, NotValidPasswordException, InvalidAccountException {
        assertThrows(ProceduralException.class, () -> vk.confirmIdentif('Y'));
        vk.enterAccount("Guillem", new Password("12345678aA"));
    }

    @Test
    @Order(4)
    public void enterNifProceduralException() throws ProceduralException, NotValidPasswordException, InvalidAccountException, InvalidDNIDocumException {
        assertThrows(ProceduralException.class, () -> vk.enterNif(new Nif("12345678Z")));
        vk.confirmIdentif('Y');
    }

    @Test
    @Order(5)
    public void initOptionsNavigationProceduralException() throws ProceduralException, NotValidPasswordException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException, ConnectException {
        assertThrows(ProceduralException.class, () -> vk.initOptionsNavigation());
        vk.enterNif(new Nif("12345678Z"));
    }

    @Test
    @Order(6)
    public void consultVotingOptionsProceduralException() throws ProceduralException, NotValidPasswordException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException, ConnectException {
        assertThrows(ProceduralException.class, () -> vk.consultVotingOption(new VotingOption("PSOE")));
        vk.initOptionsNavigation();
    }

    @Test
    @Order(7)
    public void voteProceduralException() throws ProceduralException, NotValidPasswordException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException, ConnectException {
        assertThrows(ProceduralException.class, () -> vk.vote());
        vk.consultVotingOption(new VotingOption("PSOE"));
    }

    @Test
    @Order(8)
    public void confirmVotingOptionPorceduralException() throws ProceduralException, NotValidPasswordException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException, ConnectException {
        assertThrows(ProceduralException.class, () -> vk.confirmVotingOption('Y'));
        vk.vote();
    }

    @Test
    @Order(9)
    public void grantExplicitConsentProceduralException() throws NotValidPasswordException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException, ConnectException {
        vk.grantExplicitConsent('Y');

    }

    @Test
    @Order(10)
    public void readPassportTest() throws NotValidPassportException, PassportBiometricReadingException {
        assertThrows(PassportBiometricReadingException.class, () -> vk.readPassport());
        vk.grantExplicitConsent('Y');
    }

    @Test
    @Order(11)
    public void readFaceBiometrics() throws HumanBiometricScanningException, PassportBiometricReadingException, NotValidPassportException {
        assertThrows(HumanBiometricScanningException.class, () -> vk.readFaceBiometrics());
    }

    @Test
    @Order(12)
    public void readFingerPrintBiometrics() throws HumanBiometricScanningException, PassportBiometricReadingException, NotValidPassportException, BiometricVerificationFailedException, NotEnabledException, ConnectException {
        assertThrows(HumanBiometricScanningException.class, () -> vk.readFingerPrintBiometrics());
    }


}