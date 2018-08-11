package app.models;

import app.annotations.RecyclableMock;
import app.waste_disposal.contracts.Waste;

@RecyclableMock
public class BurnableImplMock implements Waste {

    @Override
    public String getName() {
        return "Pesho";
    }

    @Override
    public double getVolumePerKg() {
        return 20;
    }

    @Override
    public double getWeight() {
        return 20;
    }
}
