package app.waste_disposal;

import app.waste_disposal.annotations.Disposable;
import app.waste_disposal.contracts.StrategyHolder;
import app.waste_disposal.contracts.Waste;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class DefaultGarbageProcessorTests {

    private DefaultGarbageProcessor defaultGarbageProcessor;

    @Before
    public void setUp() throws Exception {
        this.defaultGarbageProcessor = new DefaultGarbageProcessor();
    }

    @Test
    public void getStrategyHolder() {
        StrategyHolder strategyHolder = this.defaultGarbageProcessor.getStrategyHolder();
        Assert.assertEquals(strategyHolder.getDisposalStrategies().size(), 0);
    }

    @Test
    public void garbage() {
//        Disposable disposable = Mockito.mock(Disposable.class);
//        Waste waste = Mockito.mock(Waste.class);
//        Mockito.when(waste.getClass().getAnnotation(Disposable.class)).thenReturn(disposable);
    }
}
