package app.waste_disposal;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.StrategyHolder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DefaultStrategyHolderTests {

    private StrategyHolder defaultStrategyHolder;

    @Before
    public void setUp() throws Exception {
        this.defaultStrategyHolder = new DefaultStrategyHolder();
    }

    @Test
    public void getDisposalStrategies() {
        GarbageDisposalStrategy garbageDisposalStrategy = Mockito.mock(GarbageDisposalStrategy.class);
        this.defaultStrategyHolder.addStrategy(garbageDisposalStrategy.getClass(), garbageDisposalStrategy);

        Assert.assertEquals(1, this.defaultStrategyHolder.getDisposalStrategies().size());
    }

    @Test
    public void addStrategy() {
        GarbageDisposalStrategy garbageDisposalStrategy = Mockito.mock(GarbageDisposalStrategy.class);
        this.defaultStrategyHolder.addStrategy(garbageDisposalStrategy.getClass(), garbageDisposalStrategy);

        GarbageDisposalStrategy copy = this.defaultStrategyHolder.getDisposalStrategies().get(garbageDisposalStrategy.getClass());

        Assert.assertSame(copy, garbageDisposalStrategy);
    }

    @Test
    public void removeStrategy() {
        GarbageDisposalStrategy garbageDisposalStrategy = Mockito.mock(GarbageDisposalStrategy.class);
        this.defaultStrategyHolder.addStrategy(garbageDisposalStrategy.getClass(), garbageDisposalStrategy);

        this.defaultStrategyHolder.removeStrategy(garbageDisposalStrategy.getClass());
        Assert.assertEquals(0, this.defaultStrategyHolder.getDisposalStrategies().size());
    }
}
