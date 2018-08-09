package app.waste_disposal.commands;

import app.waste_disposal.container.WasteContainer;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.dto.Info;

import java.util.List;

public class StatusCommand implements Command {

    @Override
    public Info execute(GarbageProcessor garbageProcessor, WasteContainer wasteContainer, List<ProcessingData> processingData, String type, double min, double max, String... params) {
        double energy = 0;
        double capital = 0;

        for (ProcessingData processingDatum : processingData) {
            energy += processingDatum.getEnergyBalance();
            capital += processingDatum.getCapitalBalance();
        }


        return new Info(String.format("Energy: %.2f Capital: %.2f",energy, capital), null);
    }
}
