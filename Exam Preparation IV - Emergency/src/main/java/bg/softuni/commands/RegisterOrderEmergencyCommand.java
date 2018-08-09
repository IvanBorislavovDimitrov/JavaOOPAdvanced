package bg.softuni.commands;

import bg.softuni.contracts.ManagementSystem;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

public class RegisterOrderEmergencyCommand implements Command {
    @Override
    public String execute(ManagementSystem managementSystem, String... params) {
        String description = params[0];
        EmergencyLevel emergencyLevel = EmergencyLevel.valueOf(params[1]);
        RegistrationTime registrationTime = new RegistrationTime(params[2]);
        boolean isSpecial = params[3].equalsIgnoreCase("special");

        return managementSystem.registerOrderEmergency(description, emergencyLevel, registrationTime, isSpecial);
    }
}
