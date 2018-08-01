package src.models.races;

import src.Utility.Constants;
import src.Utility.Validator;
import src.contracts.Race;
import src.exeptions.DuplicateModelException;
import src.models.boats.Boat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceImpl implements Race {

    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private Boolean allowsMotorBoats;
    private Map<String, Boat> registeredBoats;

    public RaceImpl(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.setWindSpeed(windSpeed);
        this.setOceanCurrentSpeed(oceanCurrentSpeed);
        this.setAllowsMotorBoats(allowsMotorBoats);
        this.registeredBoats = new HashMap<>();
    }

    @Override
    public int getDistance() {
        return distance;
    }

    private void setDistance(int distance) {
        Validator.validatePropertyValue(distance, "Distance");
        this.distance = distance;
    }

    @Override
    public int getWindSpeed() {
        return windSpeed;
    }

    private void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public int getOceanCurrentSpeed() {
        return oceanCurrentSpeed;
    }

    private void setOceanCurrentSpeed(int oceanCurrentSpeed) {
        this.oceanCurrentSpeed = oceanCurrentSpeed;
    }

    @Override
    public Boolean getAllowsMotorboats() {
        return allowsMotorBoats;
    }

    private void setAllowsMotorBoats(Boolean allowsMotorBoats) {
        this.allowsMotorBoats = allowsMotorBoats;
    }

    private Map<String, Boat> getRegisteredBoats() {
        return this.registeredBoats;
    }

    @Override
    public void addParticipant(Boat boat) throws DuplicateModelException {
        if (this.getRegisteredBoats().containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }
        this.registeredBoats.put(boat.getModel(), boat);
    }

    public List<Boat> getParticipants() {
        return new ArrayList<>(this.registeredBoats.values());
    }
}