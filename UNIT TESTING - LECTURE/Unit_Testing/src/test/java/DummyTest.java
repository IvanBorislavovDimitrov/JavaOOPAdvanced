import org.junit.*;
import org.junit.rules.ExpectedException;
import rpg_lab.impl.Axe;
import rpg_lab.impl.Dummy;

public class DummyTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_EXPERIENCE = 20;
    private static final int EXPECTED_DUMMY_HEALTH = DUMMY_HEALTH - AXE_ATTACK;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void dummy_lossesHealth_ifAttacked() {
        axe.attack(dummy);

        Assert.assertEquals("Dummy does not take damage!", dummy.getHealth(), EXPECTED_DUMMY_HEALTH);
    }

    @Test
    public void deadDummy_throwsException_ifAttacked() {
        axe.attack(dummy);
        axe.attack(dummy);

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Dummy is dead.");
        expectedException.reportMissingExceptionWithMessage("Axe must throw IllegalStateException");
        axe.attack(dummy);
    }

    @Test
    public void deadDummy_giveExperience_afterDead() {
        axe.attack(dummy);
        axe.attack(dummy);

        Assert.assertEquals("Dummy experience not valid!", dummy.giveExperience(), DUMMY_EXPERIENCE);
    }

    @Test
    public void aliveDummy_cannotGiveXP_ifNotDead() {
        axe.attack(dummy);

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Target is not dead.");
        expectedException.reportMissingExceptionWithMessage("Dummy is alive, must be dead to give XP");
        dummy.giveExperience();
    }

}
