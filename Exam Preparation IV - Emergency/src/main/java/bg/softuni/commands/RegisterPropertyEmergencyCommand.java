package bg.softuni.commands;

import bg.softuni.contracts.Emergency;
import bg.softuni.contracts.ManagementSystem;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

public class RegisterPropertyEmergencyCommand implements Command {
    @Override
    public String execute(ManagementSystem managementSystem, String... params) {
        String description = params[0];
        EmergencyLevel emergencyLevel = EmergencyLevel.valueOf(params[1]);
        RegistrationTime registrationTime = new RegistrationTime(params[2]);
        int damage = Integer.parseInt(params[3]);

        return managementSystem.registerPropertyEmergency(description, emergencyLevel, registrationTime, damage);
    }
}
