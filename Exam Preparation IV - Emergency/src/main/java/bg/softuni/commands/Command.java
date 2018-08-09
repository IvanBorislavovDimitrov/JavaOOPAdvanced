package bg.softuni.commands;

import bg.softuni.contracts.ManagementSystem;
import bg.softuni.core.EmergencyManagementSystem;

public interface Command {

    String execute(ManagementSystem managementSystem, String... params);
}
