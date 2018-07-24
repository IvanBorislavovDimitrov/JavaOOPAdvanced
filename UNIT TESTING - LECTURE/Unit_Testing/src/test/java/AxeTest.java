import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import rpg_lab.impl.Axe;
import rpg_lab.impl.Dummy;

public class AxeTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 200;
    private static final int DUMMY_EXPERIENCE = 200;
    private static final int EXPECTED_AXE_DURABILITY = AXE_ATTACK  - 1;
    private static final int BROKEN_AXE_DURABILITY = 0;

    @Test
    public void weapon_losesDurability_afterEachAttack() {
        Axe axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        Dummy dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);

        axe.attack(dummy);

        Assert.assertEquals(EXPECTED_AXE_DURABILITY, axe.getDurabilityPoints());
    }

    @Test
    public void weapon_attackWithBrokenAxe_exceptionExpected() {
        Axe axe = new Axe(AXE_ATTACK, BROKEN_AXE_DURABILITY);
        Dummy dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);

        exception.expect(IllegalStateException.class);
        axe.attack(dummy);
    }
}
