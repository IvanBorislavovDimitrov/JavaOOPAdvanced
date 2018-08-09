package bg.softuni.models.emergencies;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

public class PublicOrderEmergency extends BaseEmergency {

    private boolean isSpecial;

    public PublicOrderEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, boolean isSpecial) {
        super(description, emergencyLevel, registrationTime);
        this.isSpecial = isSpecial;
    }

    public boolean isSpecial() {
        return this.isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }
}
