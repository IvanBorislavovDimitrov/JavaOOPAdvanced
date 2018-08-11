
package app.waste_disposal;

import app.models.BurnableImplMock;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.lang.annotation.Annotation;

public class DefaultGarbageProcessorTests {

    private GarbageProcessor garbageProcessor;

    @Before
    public void setUp() throws Exception {
        this.garbageProcessor = new DefaultGarbageProcessor();
    }

    @Test(expected = IllegalArgumentException.class)
    public void expectExceptionDueToTheLackOfAnnotation() {
        Waste waste = Mockito.mock(Waste.class);
        Mockito.when(waste.getWeight()).thenReturn(20D);
        Mockito.when(waste.getVolumePerKg()).thenReturn(20D);
        Mockito.when(waste.getName()).thenReturn("Pesho");

        this.garbageProcessor.processWaste(waste);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ib() {
        Waste waste = new BurnableImplMock();

        this.garbageProcessor.processWaste(waste);
    }
}
