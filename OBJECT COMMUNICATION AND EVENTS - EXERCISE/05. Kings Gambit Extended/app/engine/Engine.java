package app.engine;

import app.commands.AttackCommand;
import app.commands.Command;
import app.commands.KillCommand;
import app.kingdom.Kingdom;
import app.models.Footman;
import app.models.King;
import app.models.RoyalGuard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Engine {

    private Kingdom kingdom;

    public void run() throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String kingName = input.readLine();
        String[] royalGuardsNames = input.readLine().split("\\s+");
        String[] footmenNames = input.readLine().split("\\s+");
        this.kingdom = new Kingdom(new King(kingName));
        Arrays.stream(royalGuardsNames).forEach(r -> {
            this.kingdom.addRoyalGuard(new RoyalGuard(r));
        });

        Arrays.stream(footmenNames).forEach(r -> {
            this.kingdom.addFootman(new Footman(r));
        });

        String line;
        while (!"End".equals(line = input.readLine())) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            String name = tokens[1];
            if (command.equals("Attack")) {
                Command attackCommand = new AttackCommand();
                System.out.println(attackCommand.execute(kingdom, name));
            } else if (command.equals("Kill")) {
                Command killCommand = new KillCommand();
                killCommand.execute(kingdom, name);
            }
        }
    }
}
