package cresla.entities.module.base;

import cresla.interfaces.EnergyModule;

public abstract class EnergyModuleImpl extends BaseModule implements EnergyModule {

    private int energyOutput;

    protected EnergyModuleImpl(int energyOutput) {
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }
}
