package bg.softuni.commands;

import bg.softuni.contracts.ManagementSystem;

public class EmergencyReportCommand implements Command {
    @Override
    public String execute(ManagementSystem managementSystem, String... params) {
        return managementSystem.emergencyReport();
    }
}
