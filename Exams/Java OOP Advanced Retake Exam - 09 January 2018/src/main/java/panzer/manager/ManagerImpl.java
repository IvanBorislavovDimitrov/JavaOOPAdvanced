package panzer.manager;

import panzer.contracts.*;
import panzer.core.PanzerBattleOperator;
import panzer.factories.PartFactory;
import panzer.factories.VehicleFactory;
import panzer.models.miscellaneous.VehicleAssembler;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ManagerImpl implements Manager {

    private Map<String, Vehicle> vehicles;
    private Map<String, Vehicle> defeatedVehicles;
    private Map<String, Part> parts;

    public ManagerImpl() {
        this.defeatedVehicles = new LinkedHashMap<>();
        this.vehicles = new LinkedHashMap<>();
        this.parts = new LinkedHashMap<>();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        String type = arguments.get(0);
        String model = arguments.get(1);
        double weight = Double.parseDouble(arguments.get(2));
        BigDecimal price = new BigDecimal(arguments.get(3));
        long attack = Long.parseLong(arguments.get(4));
        long defence = Long.parseLong(arguments.get(5));
        long hitPoints = Long.parseLong(arguments.get(6));
        Assembler assembler = new VehicleAssembler();

        Vehicle vehicle = VehicleFactory.createVehicle(type, model, weight, price, attack, defence, hitPoints, assembler);

        this.vehicles.put(model, vehicle);

        return String.format("Created %s Vehicle - %s", type, model);
    }

    @Override
    public String addPart(List<String> arguments) {
        String vehicleModel = arguments.get(0);
        String type = arguments.get(1);
        String model = arguments.get(2);
        double weight = Double.parseDouble(arguments.get(3));
        BigDecimal price = new BigDecimal(arguments.get(4));
        int additionalParameter = Integer.parseInt(arguments.get(5));

        Part part = PartFactory.create(type, model, weight, price, additionalParameter);
        Vehicle vehicle = this.vehicles.get(vehicleModel);
        this.parts.put(model, part);

        switch (type) {
            case "Arsenal":
                vehicle.addArsenalPart(part);
                break;
            case "Shell":
                vehicle.addShellPart(part);
                break;
            case "Endurance":
                vehicle.addEndurancePart(part);
                break;
        }

        return String.format("Added %s - %s to Vehicle - %s",
                type, model, vehicleModel);
    }

    @Override
    public String inspect(List<String> arguments) {
        Modelable modelable = this.vehicles.get(arguments.get(0));
        if (modelable == null) {
            modelable = this.parts.get(arguments.get(0));
        }

        return modelable.toString();
    }

    @Override
    public String battle(List<String> arguments) {
        BattleOperator battleOperator = new PanzerBattleOperator();

        Vehicle v1 = this.vehicles.get(arguments.get(0));
        Vehicle v2 = this.vehicles.get(arguments.get(1));

        String winner = battleOperator.battle(v1, v2);

        if (v1.getModel().equalsIgnoreCase(winner)) {
            this.vehicles.remove(v2.getModel());
            this.defeatedVehicles.put(v2.getModel(), v2);
        } else {
            this.vehicles.remove(v1.getModel());
            this.defeatedVehicles.put(v1.getModel(), v1);
        }

        return String.format("%s versus %s -> %s Wins! Flawless Victory!",
                v1.getModel(), v2.getModel(), winner);
    }

    @Override
    public String terminate(List<String> arguments) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Remaining Vehicles: %s", this.getRemainingVehiclesInfo())).append(System.lineSeparator());
        sb.append(String.format("Defeated Vehicles: %s", this.getDefeatedVehiclesInfo())).append(System.lineSeparator());
        sb.append(String.format("Currently Used Parts: %d", this.getCurrentlyUsedParts()));

        return sb.toString();
    }

    private int getCurrentlyUsedParts() {
        int size = 0;
        for (Vehicle vehicle : this.vehicles.values()) {
            for (Part part : vehicle.getParts()) {
                size++;
            }
        }

        return size;
    }

    private String getDefeatedVehiclesInfo() {
        return this.defeatedVehicles.values().size() == 0 ? "None" :
                this.defeatedVehicles.values().stream().map(Modelable::getModel).collect(Collectors.joining(", "));
    }

    private String getRemainingVehiclesInfo() {
        return this.vehicles.values().size() == 0 ? "None" :
                this.vehicles.values().stream().map(Modelable::getModel).collect(Collectors.joining(", "));
    }
}
