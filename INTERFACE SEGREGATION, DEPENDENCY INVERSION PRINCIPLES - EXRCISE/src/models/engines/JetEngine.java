package src.models.engines;

import src.Utility.Constants;
import src.Utility.Validator;
import src.contracts.Modelable;

public class JetEngine extends BaseEngine {

    private static final int MULTIPLIER = 5;

    public JetEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    protected int calculateOutput(int horsepower, int displacement) {
        return (horsepower * MULTIPLIER) + displacement;
    }
}
