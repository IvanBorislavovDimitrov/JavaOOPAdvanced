package src.models.engines;

import src.Utility.Constants;
import src.Utility.Validator;
import src.contracts.Modelable;

public abstract class BaseEngine implements Modelable {

    private String model;

    private int cachedOutput;

    protected BaseEngine(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setCachedOutput(horsepower, displacement);
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }

    private void setCachedOutput(int horsepower, int displacement) {
        Validator.validatePropertyValue(horsepower, "Horsepower");
        Validator.validatePropertyValue(displacement, "Displacement");

        this.cachedOutput = this.calculateOutput(horsepower, displacement);
    }

    protected abstract int calculateOutput(int horsepower, int displacement);

    @Override
    public String getModel() {
        return this.model;
    }

    public int getCachedOutput() {
        return this.cachedOutput;
    }
}
