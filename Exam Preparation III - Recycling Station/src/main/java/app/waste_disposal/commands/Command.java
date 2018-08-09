package app.waste_disposal.commands;

import app.waste_disposal.container.WasteContainer;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.dto.Info;

import java.util.List;

public interface Command {

    Info execute(GarbageProcessor garbageProcessor, WasteContainer wasteContainer,
                 List<ProcessingData> processingData, String type, double energyBalance, double capitalBalance, String... params);
}
