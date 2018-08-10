package bg.manager;

import bg.contracts.Core;
import bg.contracts.Fragment;
import bg.contracts.Manager;
import bg.softuni.models.collection.LStack;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.NoSuchElementException;

public class ManagerTests {

    @Test
    public void selectCommand() throws Exception {

        Core coreA = Mockito.mock(Core.class);
        Mockito.when(coreA.getName()).thenReturn('A');
        Core coreB = Mockito.mock(Core.class);
        Mockito.when(coreB.getName()).thenReturn('B');
        Manager manager = new ManagerImpl();

        Field coresField = manager.getClass().getDeclaredField("cores");
        coresField.setAccessible(true);

        Map<Character, Core> cores = (Map<Character, Core>) coresField.get(manager);
        cores.put(coreA.getName(), coreA);
        cores.put(coreB.getName(), coreB);

        manager.selectCore('A');

        Field selectedCore = manager.getClass().getDeclaredField("core");
        selectedCore.setAccessible(true);
        Core takenCore = (Core) selectedCore.get(manager);

        Assert.assertEquals(coreA, takenCore);
    }

    @Test
    public void attachFragment() throws Exception {
        Core coreA = Mockito.mock(Core.class);
        Mockito.when(coreA.getName()).thenReturn('A');
        Mockito.when(coreA.getFragmentStack()).thenReturn(new LStack<>());
        Core coreB = Mockito.mock(Core.class);
        Mockito.when(coreB.getName()).thenReturn('B');
        Manager manager = new ManagerImpl();

        Mockito.doAnswer(invocationOnMock -> {
            Fragment fragment = (Fragment) invocationOnMock.getArguments()[0];
            coreA.getFragmentStack().push(fragment);
            return null;
        }).when(coreA).addFragment(Mockito.any(Fragment.class));

        Field coresField = manager.getClass().getDeclaredField("cores");
        coresField.setAccessible(true);

        Map<Character, Core> cores = (Map<Character, Core>) coresField.get(manager);
        cores.put(coreA.getName(), coreA);
        cores.put(coreB.getName(), coreB);

        manager.selectCore('A');

        manager.attachFragment("Cooling", "a12", 200);

        Fragment pop = coreA.getFragmentStack().pop();

        Assert.assertEquals("Cooling", pop.getType().toString());
        Assert.assertEquals("a12", pop.getName());
        Assert.assertEquals(Integer.valueOf(600), pop.getPressureAffection());
    }

    @Test(expected = NoSuchElementException.class)
    public void detachFragmentCommand() {

        Core coreA = Mockito.mock(Core.class);
        Mockito.when(coreA.getName()).thenReturn('A');
        Mockito.when(coreA.getFragmentStack()).thenReturn(new LStack<>());

        coreA.getFragmentStack().pop();
    }

}
