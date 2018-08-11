package app.manager;

import app.factories.GarbageFactory;
import app.factories.StrategyFactory;
import app.waste_disposal.annotations.Inject;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

public class GarbageManager implements Manager {

    private Set<ProcessingData> processingData;
    private double minEnergy;
    private double minCapital;
    private String prohibitedType;

    @Inject
    private GarbageFactory garbageFactory;

    @Inject
    private GarbageProcessor garbageProcessor;

    @Inject
    private StrategyFactory strategyFactory;

    public GarbageManager() {
        this.processingData = new HashSet<>();
    }

    @Override
    public String processGarbage(String... params) {
        String name = params[0];
        double weight = Double.parseDouble(params[1]);
        double volumePerKg = Double.parseDouble(params[2]);
        String type = params[3];

        Waste waste = this.garbageFactory.create(name, weight, volumePerKg, type);

        Annotation annotation = waste.getClass().getAnnotations()[0];

        if (!this.garbageProcessor.getStrategyHolder().getDisposalStrategies().containsKey(annotation.annotationType())) {
            GarbageDisposalStrategy garbageDisposalStrategy = this.strategyFactory.create(type);
            this.garbageProcessor.getStrategyHolder().addStrategy(annotation.annotationType(), garbageDisposalStrategy);
        }

        ProcessingData processingData = this.garbageProcessor.processWaste(waste);

        if (type.equals(this.prohibitedType) && (processingData.getEnergyBalance() < this.minEnergy ||
                processingData.getCapitalBalance() < this.minCapital)) {
            return "Processing Denied!";
        }

        this.processingData.add(processingData);

        return String.format("%.2f kg of %s successfully processed!", weight, name);
    }

    @Override
    public String status(String... params) {
        return String.format("Energy: %.2f Capital: %.2f",
                this.processingData.stream().mapToDouble(p -> p.getEnergyBalance()).sum(),
                this.processingData.stream().mapToDouble(p -> p.getCapitalBalance()).sum());
    }

    @Override
    public String changeManagementRequirement(String... params) {
        double minEnergy = Double.parseDouble(params[0]);
        double minCapitalBalance = Double.parseDouble(params[1]);
        String type = params[2];
        this.minEnergy = minEnergy;
        this.minCapital = minCapitalBalance;
        this.prohibitedType = type;

        return "Management requirement changed!";
    }
}
