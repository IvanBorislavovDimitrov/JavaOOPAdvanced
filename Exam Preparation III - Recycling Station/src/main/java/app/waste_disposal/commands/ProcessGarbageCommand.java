package app.waste_disposal.commands;

import app.waste_disposal.container.WasteContainer;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.dto.Info;
import app.waste_disposal.factories.StrategyFactory;
import app.waste_disposal.factories.WasteFactory;

import java.util.List;

public class ProcessGarbageCommand implements Command {

    @Override
    public Info execute(GarbageProcessor garbageProcessor, WasteContainer wasteContainer, List<ProcessingData> processingDatas, String typeto, double energyBalance, double capitalBalance, String... params) {
        String wasteName = params[0];
        double weight = Double.parseDouble(params[1]);
        double volumePerKg = Double.parseDouble(params[2]);
        String type = params[3];

        Waste waste = WasteFactory.create(type, wasteName, weight, volumePerKg);
        GarbageDisposalStrategy garbageDisposalStrategy = StrategyFactory.create(type);

        garbageProcessor.getStrategyHolder().addStrategy(waste.getClass().getAnnotations()[0].annotationType(), garbageDisposalStrategy);

        ProcessingData processingData = garbageProcessor.processWaste(waste);

        if (type.equals(typeto)) {
            if (processingData.getEnergyBalance() < energyBalance || processingData.getCapitalBalance() < capitalBalance) {
                Info info =  new Info("Processing Denied!", null);
                info.setEnergyBalance(energyBalance);
                info.setCapotalBalance(capitalBalance);
                info.setTypeOfForbidden(typeto);

                return info;
            }
        }

        String log = String.format("%.2f kg of %s successfully processed!", weight, wasteName);
        Info info = new Info(log, processingData);

        return info;
    }
}
