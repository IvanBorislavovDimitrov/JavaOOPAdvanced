package src.models.boats;

import src.Utility.Constants;
import src.contracts.Race;

public class SailBoat extends Boat {

    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight, false);
        this.setSailEfficiency(sailEfficiency);
    }

    public int getSailEfficiency() {
        return sailEfficiency;
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException(Constants.INCORRECT_SAIL_EFFICIENCY_MESSAGE);
        }
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
//        (Race Wind Speed * (Boat Sail Efficiency / 100)) – Boat’s Weight + (Race Ocean Current Speed / 2)
        return (race.getWindSpeed() * (this.getSailEfficiency() / 100D)) - super.getWeight() + (race.getOceanCurrentSpeed() / 2D);
    }
}
