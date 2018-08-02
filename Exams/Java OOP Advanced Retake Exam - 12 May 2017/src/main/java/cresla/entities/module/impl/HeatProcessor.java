package cresla.entities.module.impl;

import cresla.entities.module.base.AbsorbingModuleImpl;

public class HeatProcessor extends AbsorbingModuleImpl {

    public HeatProcessor(int heatAbsorbing) {
        super(heatAbsorbing);
    }

    @Override
    public String toString() {
        return String.format("%s Module - %d\n" +
                        "%s: %d",
                this.getClass().getSimpleName(), this.getId(),
                "Heat Absorbing", this.getHeatAbsorbing());
    }
}
