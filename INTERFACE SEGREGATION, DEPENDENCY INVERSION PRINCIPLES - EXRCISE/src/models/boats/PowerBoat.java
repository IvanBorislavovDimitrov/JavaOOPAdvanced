package src.models.boats;

import src.Utility.Validator;
import src.contracts.Race;
import src.models.engines.BaseEngine;

public class PowerBoat extends Boat {

    private BaseEngine firstEngine;
    private BaseEngine secondEngine;

    public PowerBoat(String model, int weight, BaseEngine firstEngine, BaseEngine secondEngine) {
        super(model, weight, true);
        this.setFirstEngine(firstEngine);
        this.setSecondEngine(secondEngine);
    }

    public BaseEngine getFirstEngine() {
        return this.firstEngine;
    }

    private void setFirstEngine(BaseEngine firstEngine) {
        this.firstEngine = firstEngine;
    }

    public BaseEngine getSecondEngine() {
        return this.secondEngine;
    }

    private void setSecondEngine(BaseEngine secondEngine) {
        this.secondEngine = secondEngine;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
//        (Engine 1 Output + Engine 2 Output) - Boat’s Weight + (Race Ocean Current Speed / 5);
        return (this.firstEngine.getCachedOutput() + this.secondEngine.getCachedOutput()) - this.getWeight() + (race.getOceanCurrentSpeed() / 5D);
    }
}
