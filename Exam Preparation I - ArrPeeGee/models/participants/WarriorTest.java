package app.models.participants;

import app.contracts.Targetable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class WarriorTest {

    private Targetable warrior;

    @Before
    public void setUp() {
        this.warrior = new Warrior();
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
    public void levelUp() {
        this.warrior.levelUp();
    }

}
