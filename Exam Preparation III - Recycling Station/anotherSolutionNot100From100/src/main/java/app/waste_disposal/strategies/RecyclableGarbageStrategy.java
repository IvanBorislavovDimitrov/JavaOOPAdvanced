package app.waste_disposal.strategies;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.processing_data.ProcessingDataImpl;

public class RecyclableGarbageStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energyProduced = 0;
        double energyUsed = (garbage.getWeight() * garbage.getVolumePerKg()) * 50 / 100;
        double capitalEarned = 400 * garbage.getWeight();
        double capitalUsed = 0;

        double energyBalance = energyProduced - energyUsed;
        double capitalBalance = capitalEarned - capitalUsed;

        return new ProcessingDataImpl(energyBalance, capitalBalance);
    }
}
