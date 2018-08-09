package app.models.actions;

import app.contracts.Targetable;
import app.models.participants.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class OneVsOneTest {

    private OneVsOne oneVsOne;

    @Before
    public void setUp() throws Exception {
        this.oneVsOne = new OneVsOne();
    }

    @Test
    public void test() {
        Targetable f1 = Mockito.mock(Targetable.class);
        Targetable f2 = Mockito.mock(Targetable.class);

        Mockito.when(f1.getName()).thenReturn("Pesho");
        Mockito.when(f2.getName()).thenReturn("Gosho");

        Mockito.when(f1.isAlive()).thenReturn(true);
        Mockito.when(f2.isAlive()).thenReturn(false);

        Mockito.when(f1.toString()).thenReturn("Name: Pesho | Class: Warrior\n" +
                "  Health: 100.00 | Damage: 28.00\n" +
                "  10 STR | 8 DEX | 2 INT | 400.00 Gold");

        Mockito.when(f1.attack(f2)).thenReturn("Pesho attacked! Gosho has been slain by Pesho.");

        List<Targetable> particicpants = new ArrayList<>() {{
            add(f1);
            add(f2);
        }};

        String s = oneVsOne.executeAction(particicpants);

        String actual =  s + "";

        Assert.assertEquals(actual,  s);
    }

    @Test
    public void test2() {
        Targetable targetable = new Warrior();
        Targetable targetable1 = new Warrior();
        List<Targetable> particicpants = new ArrayList<>() {{
            add(targetable);
            add(targetable1);
        }};


        String s = this.oneVsOne.executeAction(particicpants);
        System.out.println(s);

        String acutl = s + "";

        Assert.assertEquals(acutl, s);
    }
}
