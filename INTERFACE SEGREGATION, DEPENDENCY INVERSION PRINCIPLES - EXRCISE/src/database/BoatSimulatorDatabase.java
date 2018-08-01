package src.database;

import src.contracts.Modelable;
import src.contracts.Repository;
import src.exeptions.DuplicateModelException;
import src.models.boats.Boat;
import src.models.engines.BaseEngine;

public class BoatSimulatorDatabase {

    private Repository<Boat> boats;
    private Repository<BaseEngine> engines;

    public BoatSimulatorDatabase() {
        this.setBoats(new RepositoryImpl<Boat>());
        this.setEngines(new RepositoryImpl<Modelable>());
    }

    public void addBoat(Boat motorBoat) throws DuplicateModelException {
        this.boats.add(motorBoat);
    }

    public void addEngine(BaseEngine baseEngine) throws DuplicateModelException {
        this.engines.add(baseEngine);
    }

    public Repository<Boat> getBoats() {
        return this.boats;
    }

    private void setBoats(Repository<Boat> boats) {
        this.boats = boats;
    }

    public Repository<BaseEngine> getEngines() {
        return this.engines;
    }

    private void setEngines(Repository<BaseEngine> engines) {
        this.engines = engines;
    }
}
