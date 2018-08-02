package cresla.entities.module.base;

import cresla.interfaces.AbsorbingModule;

public abstract class AbsorbingModuleImpl extends BaseModule implements AbsorbingModule {

    private int heatAbsorbing;

    protected AbsorbingModuleImpl(int heatAbsorbing) {
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }
}
