package src.models.boats;

import src.Utility.Validator;
import src.contracts.Race;
import src.models.engines.BaseEngine;

public class Yacht extends Boat {

    private BaseEngine sterndriveEngine;
    private int cargoWeight;

    public Yacht(String model, int weight, BaseEngine sterndriveEngine, int cargoWeight) {
        super(model, weight, true);
        this.setSterndriveEngine(sterndriveEngine);
        this.setCargoWeight(cargoWeight);
    }

    private void setSterndriveEngine(BaseEngine sterndriveEngine) {
        this.sterndriveEngine = sterndriveEngine;
    }

    public BaseEngine getSterndriveEngine() {
        return this.sterndriveEngine;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.validatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        //Boat Engine Output - (Boat Weight + Cargo Weight) + (Race Ocean Current Speed / 2);
        return this.sterndriveEngine.getCachedOutput() - (this.getWeight() + this.getCargoWeight()) + (race.getOceanCurrentSpeed() / 2D);
    }
}
