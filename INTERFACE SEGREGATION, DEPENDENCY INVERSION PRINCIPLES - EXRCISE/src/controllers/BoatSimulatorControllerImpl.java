package src.controllers;

import javafx.util.Pair;
import jdk.jshell.spi.ExecutionControl;
import src.Utility.Constants;
import src.contracts.BoatSimulatorController;
import src.contracts.Race;
import src.database.BoatSimulatorDatabase;
import src.enumeration.EngineType;
import src.exeptions.*;
import src.models.engines.BaseEngine;
import src.models.engines.JetEngine;
import src.models.boats.*;
import src.models.engines.SterndriveEngine;
import src.models.races.RaceImpl;

import java.util.*;

public class BoatSimulatorControllerImpl implements BoatSimulatorController {

    private List<Pair<Double, Boat>> fastestParticipants;
    private BoatSimulatorDatabase database;
    private Race currentRace;

    public BoatSimulatorControllerImpl() {
        this.fastestParticipants = new ArrayList<>();
        this.setDatabase(new BoatSimulatorDatabase());
    }

    @Override
    public BoatSimulatorDatabase getDatabase() {
        return this.database;
    }

    @Override
    public String createBoatEngine(String model, int horsepower, int displacement, String engineType) {
        try {
            return this.createBoatEngine(model, horsepower, displacement, EngineType.valueOf(engineType));
        } catch (DuplicateModelException | ExecutionControl.NotImplementedException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void setDatabase(BoatSimulatorDatabase database) {
        this.database = database;
    }

    @Override
    public Race getCurrentRace() {
        return this.currentRace;
    }

    private String createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException, ExecutionControl.NotImplementedException {
        BaseEngine engine;
        switch (engineType) {
            case JET:
                engine = new JetEngine(model, horsepower, displacement);
                break;
            case STERNDRIVE:
                engine = new SterndriveEngine(model, horsepower, displacement);
                break;
            default:
                return null;
        }

        this.database.addEngine(engine);

        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.", model, horsepower, displacement);
    }

    @Override
    public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        Boat boat = new RowBoat(model, weight, oars);
        this.database.addBoat(boat);
        return String.format("Row boat with model %s registered successfully.", model);
    }

    @Override
    public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        Boat boat = new SailBoat(model, weight, sailEfficiency);
        this.database.getBoats().add(boat);
        return String.format("Sail boat with model %s registered successfully.", model);
    }

    @Override
    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException {
        BaseEngine firstEngine = this.database.getEngines().getItem(firstEngineModel);
        BaseEngine secondEngine = this.database.getEngines().getItem(secondEngineModel);
        Boat boat = new PowerBoat(model, weight, firstEngine, secondEngine);
        this.database.addBoat(boat);
        return String.format("Power boat with model %s registered successfully.", model);
    }

    @Override
    public String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException {
        BaseEngine engine = this.database.getEngines().getItem(engineModel);
        Boat boat = new Yacht(model, weight, engine, cargoWeight);
        this.database.addBoat(boat);
        return String.format("Yacht with model %s registered successfully.", model);
    }

    @Override
    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
        this.validateRaceIsEmpty();
        this.currentRace = new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);

        return String.format(
                "A new race with distance %s meters, wind speed %s m/s and ocean current speed %d m/s has been set.",
                distance, windSpeed, oceanCurrentSpeed);
    }

    @Override
    public String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        Boat boat = this.database.getBoats().getItem(model);
        this.validateRaceIsSet();

        if (!this.currentRace.getAllowsMotorboats() && boat.isMotorBoat()) {
            throw new IllegalArgumentException(Constants.INCORRECT_BOAT_TYPE_MESSAGE);
        }

        this.currentRace.addParticipant(boat);
        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    @Override
    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        this.validateRaceIsSet();
        List<Boat> participants = this.currentRace.getParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.INSUFFICIENT_CONTESTANTS_MESSAGE);
        }

        for (int i = 0; i < 3; i++) {
            this.findFastest(participants);
        }
        String[] places = {"First", "Second", "Third"};
        int cnt = 0;
        StringBuilder result = new StringBuilder();
        for (Pair<Double, Boat> doubleMotorBoatEntry : this.fastestParticipants) {
            result.append(String.format("%s place: %s Model: %s Time: %s%n", places[cnt++],
                    doubleMotorBoatEntry.getValue().getClass().getSimpleName(),
                    doubleMotorBoatEntry.getValue().getModel(),
                    this.isFinished(doubleMotorBoatEntry.getKey())));
        }

        this.currentRace = null;
        this.fastestParticipants = new ArrayList<>();
        return result.toString().trim();
    }

    @Override
    public String getStatistic() {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> boats = new TreeMap<>();
        this.currentRace.getParticipants().forEach(p -> {
            if (!boats.containsKey((p.getClass().getSimpleName()))) {
                boats.put(p.getClass().getSimpleName(), 1);
            } else {
                boats.put(p.getClass().getSimpleName(), boats.get(p.getClass().getSimpleName()) + 1);
            }
        });

        boats.forEach((key, value) -> {
            sb.append(String.format("%s -> %.2f%%", key, (1.0 * value / boats.values().stream()
                    .mapToInt(i -> i).sum()) * 100)).append(System.lineSeparator());
        });

        return sb.toString().trim();
    }

    private String isFinished(Double key) {
        if (key <= 0) {
            return "Did not finish!";
        }

        return String.format("%.2f sec", key);
    }

    private void findFastest(List<Boat> participants) {
        Double bestTime = Double.MAX_VALUE;
        Boat winner = null;
        for (Boat participant : participants) {
            Double speed = participant.calculateRaceSpeed(this.currentRace);
            Double time = this.currentRace.getDistance() / speed;
            if (time < bestTime && time > 0) {
                bestTime = time;
                winner = participant;
            }
        }
        if (winner == null) {
            winner = participants.get(0);
            bestTime = this.currentRace.getDistance() / winner.calculateRaceSpeed(this.currentRace);
        }
        this.fastestParticipants.add(new Pair<>(bestTime, winner));
        participants.remove(winner);
    }

    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NO_SET_RACE_MESSAGE);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RACE_ALREADY_EXISTS_MESSAGE);
        }
    }
}
