package app.waste_disposal.strategies;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.processing_data.ProcessingDataImpl;

public class BurnableGarbageStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energyProduced = garbage.getWeight() * garbage.getVolumePerKg();
        double energyUsed = (garbage.getWeight() * garbage.getVolumePerKg()) * 20 / 100;
        double capitalEarned = 0;
        double capitalUsed = 0;

        double energyBalance = energyProduced - energyUsed;
        double capitalBalance = capitalEarned - capitalUsed;

        return new ProcessingDataImpl(energyBalance, capitalBalance);
    }
}
