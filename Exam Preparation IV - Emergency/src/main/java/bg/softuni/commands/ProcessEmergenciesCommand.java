package bg.softuni.commands;

import bg.softuni.contracts.ManagementSystem;

public class ProcessEmergenciesCommand implements Command {
    @Override
    public String execute(ManagementSystem managementSystem, String... params) {
        String type = params[0];

        return managementSystem.processEmergencies(type);
    }
}
