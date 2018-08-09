package app.waste_disposal.commands;

import app.waste_disposal.container.WasteContainer;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.dto.Info;

import java.util.List;

public class ChangeManagementRequirementCommand implements Command {

    @Override
    public Info execute(GarbageProcessor garbageProcessor, WasteContainer wasteContainer, List<ProcessingData> processingData,  String type, double energyBalance, double capitalBalance,String... params) {
        Info info = new Info("Management requirement changed!", null);
        info.setTypeOfForbidden(params[2]);
        info.setEnergyBalance(Double.parseDouble(params[0]));
        info.setCapotalBalance(Double.parseDouble(params[1]));

        return info;
    }
}
