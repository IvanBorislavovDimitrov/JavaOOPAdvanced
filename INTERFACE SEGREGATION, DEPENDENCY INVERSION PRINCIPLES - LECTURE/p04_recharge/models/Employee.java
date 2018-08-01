package src.p04_recharge.models;

import src.p04_recharge.models.interfaces.Sleeper;

public class Employee extends Worker implements Sleeper {

    public Employee(String id) {
        super(id);
    }

    @Override
    public void sleep() {
        // sleep...
    }
}
