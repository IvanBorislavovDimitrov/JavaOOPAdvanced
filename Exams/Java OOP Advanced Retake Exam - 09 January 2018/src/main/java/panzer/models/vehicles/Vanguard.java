package panzer.models.vehicles;

import panzer.contracts.Assembler;

import java.math.BigDecimal;

public class Vanguard extends BaseVehicle {
    public Vanguard(String model, double weight, BigDecimal price, long attack, long defense, long hitPoints, Assembler assembler) {
        super(model, weight * 2, price, attack - attack * 25 / 100, defense + defense * 50 / 100, hitPoints + hitPoints * 75 / 100, assembler);
    }
}
