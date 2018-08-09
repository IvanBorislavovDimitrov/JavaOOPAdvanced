package bg.softuni;

import bg.softuni.contracts.InputReader;
import bg.softuni.contracts.ManagementSystem;
import bg.softuni.contracts.OutputWriter;
import bg.softuni.core.EmergencyManagementSystem;
import bg.softuni.engine.Engine;
import bg.softuni.io.ConsoleReader;
import bg.softuni.io.ConsoleWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        InputReader inputReader = new ConsoleReader();
        OutputWriter outputWriter = new ConsoleWriter();
        ManagementSystem managementSystem = new EmergencyManagementSystem();
        Engine engine = new Engine(inputReader, outputWriter , managementSystem);

        engine.run();
    }
}
