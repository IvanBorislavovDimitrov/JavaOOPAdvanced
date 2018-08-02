package panzer.manager;

import panzer.contracts.Manager;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.core.PanzerBattleOperator;
import panzer.entities.parts.ArsenalPart;
import panzer.entities.parts.EndurancePart;
import panzer.entities.parts.ShellPart;
import panzer.factories.PartFactory;
import panzer.factories.VehicleFactory;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    private Map<String, Vehicle> perfectVehicles;
    private Map<String, Vehicle> brokenVehicles;
    private Map<String, Part> parts;
    private PanzerBattleOperator panzerBattleOperator;

    public ManagerImpl() {
        this.perfectVehicles = new LinkedHashMap<>();
        this.brokenVehicles = new LinkedHashMap<>();
        this.parts = new LinkedHashMap<>();
        this.panzerBattleOperator = new PanzerBattleOperator();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        String type = arguments.get(0);
        String model = arguments.get(1);
        double weight = Double.parseDouble(arguments.get(2));
        BigDecimal price = new BigDecimal(arguments.get(3));
        int attack = Integer.parseInt(arguments.get(4));
        int defense = Integer.parseInt(arguments.get(5));
        int hitPoints = Integer.parseInt(arguments.get(6));

        Vehicle vehicle = VehicleFactory.createVehicle(type, model, weight, price, attack, defense, hitPoints);

        this.perfectVehicles.put(model, vehicle);

        return String.format("Created %s Vehicle - %s", type, model);
    }

    @Override
    public String addPart(List<String> arguments) {
        String vehicleModel = arguments.get(0);
        String type = arguments.get(1);
        String model = arguments.get(2);
        double weight = Double.parseDouble(arguments.get(3));
        BigDecimal price = new BigDecimal(arguments.get(4));
        int additionalParam = Integer.parseInt(arguments.get(5));

        Part part = PartFactory.createPart(type, model, weight, price, additionalParam);

        assignPartToVehicle(vehicleModel, part);

        this.parts.putIfAbsent(model, part);

        return String.format("Added %s - %s to Vehicle - %s", type, model, vehicleModel);
    }

    @Override
    public String inspect(List<String> arguments) {
        String model = arguments.get(0);
        if (this.perfectVehicles.containsKey(model)) {
            return this.perfectVehicles.get(model).toString();
        }

        return this.parts.get(model).toString();
    }

    @Override
    public String battle(List<String> arguments) {
        Vehicle v1 = this.perfectVehicles.get(arguments.get(0));
        Vehicle v2 = this.perfectVehicles.get(arguments.get(1));
        String winner = this.panzerBattleOperator.battle(v1, v2);
        if (v1.getModel().equals(winner)) {
            this.perfectVehicles.remove(v2.getModel());
            this.brokenVehicles.putIfAbsent(v2.getModel(), v2);
        } else {
            this.perfectVehicles.remove(v1.getModel());
            this.brokenVehicles.putIfAbsent(v1.getModel(), v1);
        }

        return String.format("%s versus %s -> %s Wins! Flawless Victory!", v1.getModel(), v2.getModel(), winner);
    }

    @Override
    public String terminate(List<String> arguments) {
        StringBuilder sb = new StringBuilder();
        sb.append("Remaining Vehicles: ").append(this.perfectVehicles.size() != 0 ?
                String.join(", ", this.perfectVehicles.keySet()) : "None").append(System.lineSeparator());

        sb.append("Defeated Vehicles: ").append(this.brokenVehicles.size() != 0 ?
                String.join(", ", this.brokenVehicles.keySet()) : "None").append(System.lineSeparator());

        long countOfUsedParts = 0;
        for (Map.Entry<String, Vehicle> vehicle : this.perfectVehicles.entrySet()) {
            for (Part part : vehicle.getValue().getParts()) {
                countOfUsedParts++;
            }
        }

        sb.append(String.format("Currently Used Parts: %d", countOfUsedParts));

        return sb.toString();
    }

    private void assignPartToVehicle(String vehicleModel, Part part) {
        Vehicle vehicle = this.perfectVehicles.get(vehicleModel);
        if (part instanceof ArsenalPart) {
            vehicle.addArsenalPart(part);
        } else if (part instanceof EndurancePart) {
            vehicle.addEndurancePart(part);
        } else if (part instanceof ShellPart) {
            vehicle.addShellPart(part);
        }
    }
}
