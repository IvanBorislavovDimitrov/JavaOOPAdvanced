package cresla.manager;

import cresla.entities.module.base.AbsorbingModuleImpl;
import cresla.entities.module.base.EnergyModuleImpl;
import cresla.entities.reactor.CryoReactor;
import cresla.entities.reactor.HeatReactor;
import cresla.factories.ModuleFactory;
import cresla.factories.ReactorFactory;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    private Map<Integer, Reactor> reactorMap;
    private Map<Integer, Module> moduleMap;

    public ManagerImpl() {
        this.reactorMap = new LinkedHashMap<>();
        this.moduleMap = new LinkedHashMap<>();
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        String reactorType = arguments.get(0);
        int additionalParameter = Integer.parseInt(arguments.get(1));
        int moduleCapacity = Integer.parseInt(arguments.get(2));

        Reactor reactor = ReactorFactory.createReactor(reactorType, additionalParameter, moduleCapacity);

        this.reactorMap.put(reactor.getId(), reactor);

        return String.format("Created %s Reactor - %d", reactorType, reactor.getId());
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorId = Integer.parseInt(arguments.get(0));
        String type = arguments.get(1);
        int additionalParameter = Integer.parseInt(arguments.get(2));

        Module module = ModuleFactory.createModule(type, additionalParameter);
        Reactor reactor = this.reactorMap.get(reactorId);

        if (module instanceof AbsorbingModuleImpl) {
            reactor.addAbsorbingModule((AbsorbingModule) module);
        } else if (module instanceof EnergyModule) {
            reactor.addEnergyModule((EnergyModule) module);
        }
        this.moduleMap.putIfAbsent(module.getId(), module);

        return String.format("Added %s - %d to Reactor - %d", type, module.getId(), reactorId);
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int id = Integer.parseInt(arguments.get(0));
        Identifiable identifiable = this.reactorMap.get(id);
        if (identifiable == null) {
            identifiable = this.moduleMap.get(id);
        }

        return identifiable.toString();
    }

    @Override
    public String exitCommand(List<String> arguments) {
        return String.format("Cryo Reactors: %s\n" +
                        "Heat Reactors: %s\n" +
                        "Energy Modules: %s\n" +
                        "Absorbing Modules: %s\n" +
                        "Total Energy Output: %s\n" +
                        "Total Heat Absorbing: %s",
                this.reactorMap.values().stream().filter(x -> x instanceof CryoReactor).count(),
                this.reactorMap.values().stream().filter(x -> x instanceof HeatReactor).count(),
                this.moduleMap.values().stream().filter(x -> x instanceof EnergyModuleImpl).count(),
                this.moduleMap.values().stream().filter(x -> x instanceof AbsorbingModuleImpl).count(),
                this.reactorMap.values().stream().mapToLong(Reactor::getTotalEnergyOutput).sum(),
                this.reactorMap.values().stream().mapToLong(Reactor::getTotalHeatAbsorbing).sum());
    }
}
