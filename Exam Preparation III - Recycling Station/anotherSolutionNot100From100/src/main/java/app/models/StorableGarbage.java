package app.models;

import app.waste_disposal.annotations.Storable;

@Storable
public class StorableGarbage extends BaseGarbage {

    public StorableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
