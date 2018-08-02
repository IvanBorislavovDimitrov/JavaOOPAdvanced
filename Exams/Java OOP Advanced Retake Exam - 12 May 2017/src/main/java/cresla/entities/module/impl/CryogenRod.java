package cresla.entities.module.impl;

import cresla.entities.module.base.EnergyModuleImpl;

public class CryogenRod extends EnergyModuleImpl {

    public CryogenRod(int energyOutput) {
        super(energyOutput);
    }

    @Override
    public String toString() {
        return String.format("%s Module - %d\n" +
                        "%s: %d",
                this.getClass().getSimpleName(), this.getId(),
                "Energy Output", this.getEnergyOutput());
    }
}
