package panzer.entities.vehicles;

import java.math.BigDecimal;

public class Revenger extends AbstractVehicle {

    public Revenger(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model, weight, price.multiply(new BigDecimal(1.50)), (int) (attack * 2.50), (int) (defense * 0.50), (int) (hitPoints * 0.50));
    }

}
