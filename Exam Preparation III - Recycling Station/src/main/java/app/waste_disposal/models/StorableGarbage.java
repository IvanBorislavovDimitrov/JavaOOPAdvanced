package app.waste_disposal.models;

import app.waste_disposal.annotations.Storable;

@Storable
public class StorableGarbage extends BaseWaste {

    public StorableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }

}
