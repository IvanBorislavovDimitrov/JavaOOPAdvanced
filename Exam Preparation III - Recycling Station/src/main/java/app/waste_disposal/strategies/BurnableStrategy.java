package app.waste_disposal.strategies;


import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.processing_data.ProcessingDataImpl;

public class BurnableStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energyGained = (garbage.getWeight() * garbage.getVolumePerKg()) * 0.8;
        return new ProcessingDataImpl(energyGained, 0);
    }
}
