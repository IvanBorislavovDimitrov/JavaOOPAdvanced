package cresla.entities.reactor;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;
import cresla.util.IdIncrementer;

import java.lang.reflect.Field;
import java.util.Map;

public abstract class BaseReactor implements Reactor {

    private int id;
    private Container container;

    BaseReactor(int capacity) {
        this.id = IdIncrementer.getId();
        this.container = new ModuleContainer(capacity);
    }

    @Override
    public int getId() {
        return this.id;
    }

    public Container getContainer() {
        return this.container;
    }

    @Override
    @SuppressWarnings("unchecked")
    public int getModuleCount() {
        try {
            Field energyModules = this.getContainer().getClass().getDeclaredField("energyModules");
            energyModules.setAccessible(true);
            Field absorbingModules = this.getContainer().getClass().getDeclaredField("absorbingModules");
            absorbingModules.setAccessible(true);

            Map<Integer, AbsorbingModule> energyModulesMap = (Map<Integer, AbsorbingModule>) energyModules.get(this.getContainer());

            Map<Integer, AbsorbingModule> absorbingModulesMap = (Map<Integer, AbsorbingModule>) absorbingModules
                    .get(this.getContainer());

            return energyModulesMap.size() + absorbingModulesMap.size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.getContainer().addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.getContainer().addAbsorbingModule(absorbingModule);
    }
}
