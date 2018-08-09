package bg.softuni.commands;

import bg.softuni.contracts.ManagementSystem;

public class RegisterFireServiceCenterCommand implements Command {
    @Override
    public String execute(ManagementSystem managementSystem, String... params) {
        String name = params[0];
        int amountOfEmergencies = Integer.parseInt(params[1]);

        return managementSystem.registerFireServiceCenter(name, amountOfEmergencies);
    }
}
