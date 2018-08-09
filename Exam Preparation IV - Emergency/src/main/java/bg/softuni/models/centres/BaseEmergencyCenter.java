package bg.softuni.models.centres;

import bg.softuni.collection.EmergencyRegister;
import bg.softuni.contracts.Centre;

public abstract class BaseEmergencyCenter implements Centre {

    private String name;

    private Integer amountOfMaximumEmergencies;

    private EmergencyRegister emergencyRegister;

    protected BaseEmergencyCenter(String name, Integer amountOfMaximumEmergencies) {
        this.setName(name);
        this.setAmountOfMaximumEmergencies(amountOfMaximumEmergencies);
        this.emergencyRegister = new EmergencyRegister();
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getAmountOfMaximumEmergencies() {
        return amountOfMaximumEmergencies;
    }

    private void setAmountOfMaximumEmergencies(Integer amountOfMaximumEmergencies) {
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
    }

    @Override
    public EmergencyRegister getEmergencyRegister() {
        return this.emergencyRegister;
    }

    @Override
    public boolean isForRetirement() {
        return this.emergencyRegister.getCurrentSize().equals(this.amountOfMaximumEmergencies);
    }
}
