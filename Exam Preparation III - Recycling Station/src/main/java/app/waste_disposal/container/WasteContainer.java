package app.waste_disposal.container;

import app.waste_disposal.contracts.Waste;

import java.util.LinkedHashMap;
import java.util.Map;

public class WasteContainer {

    private Map<String, Waste> waste;

    public WasteContainer() {
        this.waste = new LinkedHashMap<>();
    }

    public Waste getWaste(String wasteName) {
        return this.waste.get(wasteName);
    }

    public void addWaste(Waste waste) {
        this.waste.put(waste.getName(), waste);
    }

    public void removeWaste(String wasteName) {
        this.waste.remove(wasteName);
    }
}
