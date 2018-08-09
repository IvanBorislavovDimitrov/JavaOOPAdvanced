package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

public class WarriorTest {

    private static final int WARRIOR_BASE_STRENGTH = 5;
    private static final int WARRIOR_BASE_DEXTERITY = 4;
    private static final int WARRIOR_BASE_INTELLIGENCE = 1;

    private Targetable warrior;

    @Before
    public void setUp() {
        this.warrior = new Warrior();
    }

    public void test13() {

    }

    @Test
    public void test() {
        this.warrior.setName("Pesho");

        Assert.assertEquals("Pesho", this.warrior.getName());
    }

    @Test
    public void checkDie() {
        this.warrior.takeDamage(1200);

        Assert.assertFalse(this.warrior.isAlive());
    }

    @Test
    public void takeDamage() {
        this.warrior.takeDamage(50);
        Assert.assertEquals(0, this.warrior.getHealth(), 0.1);
    }

    @Test
    public void isAliveTest2() {
        this.warrior.takeDamage(50);
        Assert.assertFalse(this.warrior.isAlive());
    }

    @Test
    public void isAliveTest1() {
        Assert.assertTrue(this.warrior.isAlive());
    }

    @Test
    public void test3() {
        Targetable targetable = Mockito.mock(Targetable.class);
        Mockito.when(targetable.isAlive()).thenReturn(true);
        Mockito.when(targetable.getDamage()).thenReturn(1D);

        Mockito.when(targetable.attack(this.warrior)).thenAnswer(s -> {
            Warrior myWarrior = (Warrior) s.getArguments()[0];
            myWarrior.takeDamage(targetable.getDamage());

            return null;
        });

        targetable.attack(this.warrior);

        Assert.assertEquals(49, this.warrior.getHealth(), 0.1);
    }

    @Test
    public void levelUp() {
        this.warrior.levelUp();

        Assert.assertEquals(WARRIOR_BASE_STRENGTH * 2, ((Hero) this.warrior).getStrength(), 0.1);
        Assert.assertEquals(WARRIOR_BASE_DEXTERITY * 2, ((Hero) this.warrior).getDexterity(), 0.1);
        Assert.assertEquals(WARRIOR_BASE_INTELLIGENCE * 2, ((Hero) this.warrior).getIntelligence(), 0.1);
    }
}
