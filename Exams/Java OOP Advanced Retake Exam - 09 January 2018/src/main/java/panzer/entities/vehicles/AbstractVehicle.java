package panzer.entities.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

public abstract class AbstractVehicle implements Vehicle {

    private String model;
    private double weight;
    private BigDecimal price;
    private int attack;
    private int defense;
    private int hitPoints;
    private Assembler assembler;

    public AbstractVehicle(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.assembler = new VehicleAssembler();
    }

    @Override
    public double getTotalWeight() {
        return this.weight + this.assembler.getTotalWeight();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.price.add(this.assembler.getTotalPrice());
    }

    @Override
    public long getTotalAttack() {
        return this.attack + this.assembler.getTotalAttackModification();
    }

    @Override
    public long getTotalDefense() {
        return this.defense + this.assembler.getTotalDefenseModification();
    }

    @Override
    public long getTotalHitPoints() {
        return this.hitPoints + this.assembler.getTotalHitPointModification();
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.assembler.addArsenalPart(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.assembler.addShellPart(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.assembler.addEndurancePart(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        try {
            Method getAllParts = this.assembler.getClass().getDeclaredMethod("getAllParts");
            try {
                return (List<Part>) getAllParts.invoke(this.assembler);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %s", this.getClass().getSimpleName(), this.getModel())).append(System.lineSeparator());
        sb.append(String.format("Total Weight: %.3f", this.getTotalWeight()))
                .append(System.lineSeparator());
        sb.append(String.format("Total Price: %.3f", this.getTotalPrice()))
                .append(System.lineSeparator());
        sb.append(String.format("Attack: %d", this.getTotalAttack())).append(System.lineSeparator());
        sb.append(String.format("Defense: %d", this.getTotalDefense())).append(System.lineSeparator());
        sb.append(String.format("HitPoints: %d", this.getTotalHitPoints())).append(System.lineSeparator());
        sb.append("Parts: ");
        StringBuilder parts = new StringBuilder();
        for (Part part : this.getParts()) {
            parts.append(part.getModel()).append(", ");
        }
        if (parts.length() == 0) {
            sb.append("None");
        } else {
            parts.delete(parts.length() - 2, parts.length());
            sb.append(parts);
        }

        return sb.toString();
    }

    protected Assembler getAssembler() {
        return this.assembler;
    }
}
