package src.models.boats;

import src.Utility.Constants;
import src.Utility.Validator;
import src.contracts.Modelable;
import src.contracts.Race;

public abstract class Boat implements Modelable {

    private String model;
    private int weight;
    private boolean isMotorBoat;

    protected Boat(String model, int weight, boolean isMotorBoat) {
        this.model = model;
        this.weight = weight;
        this.isMotorBoat = isMotorBoat;
    }

    public boolean isMotorBoat() {
        return this.isMotorBoat;
    }

    public void setMotorBoat(boolean motorBoat) {
        isMotorBoat = motorBoat;
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_MODEL_LENGTH);
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        Validator.validatePropertyValue(weight, "Weight");
        this.weight = weight;
    }

    public abstract double calculateRaceSpeed(Race race);
}


