package app.waste_disposal.strategies;


import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.processing_data.ProcessingDataImpl;

public class RecyclableStrategy implements GarbageDisposalStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double usedEnergy = (garbage.getWeight() * garbage.getVolumePerKg()) / 2;
        double income = garbage.getWeight() * 400;
        return new ProcessingDataImpl(0 - usedEnergy, income);
    }
}
