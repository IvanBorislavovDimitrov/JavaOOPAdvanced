package bg.softuni.models.emergencies;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

public class PublicHealthEmergency extends BaseEmergency {

    private int numberOfCasualties;

    public PublicHealthEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, int numberOfCasualties) {
        super(description, emergencyLevel, registrationTime);
        this.numberOfCasualties = numberOfCasualties;
    }

    public int getNumberOfCasualties() {
        return this.numberOfCasualties;
    }

    public void setNumberOfCasualties(int numberOfCasualties) {
        this.numberOfCasualties = numberOfCasualties;
    }
}
