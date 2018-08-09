package bg.softuni.contracts;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

public interface ManagementSystem {
    String registerPropertyEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, int damage);

    String registerHealthEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, int casualties);

    String registerOrderEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, boolean isSpecial);

    String registerFireServiceCenter(String name, int amountOfEmergencies);

    String registerMedicalServiceCenter(String name, int amountOfEmergencies);

    String registerPoliceServiceCenter(String name, int amountOfEmergencies);

    String processEmergencies(String type);

    String emergencyReport();
}
