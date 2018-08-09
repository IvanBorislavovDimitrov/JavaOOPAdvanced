package bg.softuni.contracts;

import bg.softuni.collection.EmergencyRegister;

public interface Centre {
    String getName();

    Integer getAmountOfMaximumEmergencies();

    EmergencyRegister getEmergencyRegister();

    boolean isForRetirement();
}
