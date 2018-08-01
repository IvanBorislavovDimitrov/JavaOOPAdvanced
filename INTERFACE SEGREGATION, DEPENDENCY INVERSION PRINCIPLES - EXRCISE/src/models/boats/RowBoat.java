package src.models.boats;

import src.Utility.Validator;
import src.contracts.Race;

public class RowBoat extends Boat {

    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight, false);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        Validator.validatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    public int getOars() {
        return oars;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
//        (Oars * 100) - Boat Weight + Race Ocean Current Speed
        return (this.getOars() * 100D) - super.getWeight() + race.getOceanCurrentSpeed();
    }
}
