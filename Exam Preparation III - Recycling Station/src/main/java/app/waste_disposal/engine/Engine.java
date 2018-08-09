package app.waste_disposal.engine;

import app.waste_disposal.commands.Command;
import app.waste_disposal.container.WasteContainer;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.InputReader;
import app.waste_disposal.contracts.OutputWriter;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.dto.Info;
import app.waste_disposal.factories.CommandFactory;

import java.util.ArrayList;
import java.util.List;

public class Engine {

    private GarbageProcessor garbageProcessor;
    private InputReader inputReader;
    private OutputWriter outputWriter;
    private WasteContainer wasteContainer;
    private List<ProcessingData> processingData;

    private double energyBalance;
    private double capitalBalance;
    private String forbiddenType;

    public Engine(GarbageProcessor garbageProcessor, InputReader inputReader, OutputWriter outputWriter, WasteContainer wasteContainer) {
        this.garbageProcessor = garbageProcessor;
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.wasteContainer = wasteContainer;
        this.processingData = new ArrayList<>();
    }

    public void run() {
        while (true) {
            String line = this.inputReader.readLine();

            if (line.equals("TimeToRecycle")) {
                break;
            }

            String[] lineTokens = line.split("\\s+");
            String commandName = lineTokens[0];
            Command command = CommandFactory.create(commandName);

            String[] commandTokens = null;
            if (lineTokens.length > 1) {
                commandTokens = lineTokens[1].split("\\|");
            }

            Info info = command.execute(this.garbageProcessor, this.wasteContainer, this.processingData, this.forbiddenType, this.energyBalance, this.capitalBalance, commandTokens);

            if (info.getTypeOfForbidden() != null) {
                this.forbiddenType = info.getTypeOfForbidden();
                this.energyBalance = info.getEnergyBalance();
                this.capitalBalance = info.getCapotalBalance();
            }

            if (info.getProcessingData() != null) {
                this.processingData.add(info.getProcessingData());
            }
            this.outputWriter.writeLine(info.getLog());
        }
    }
}
