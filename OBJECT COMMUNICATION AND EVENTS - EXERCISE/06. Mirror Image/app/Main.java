package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = input.readLine().split("\\s+");
        int power = Integer.parseInt(tokens[1]);

        Wizard wizard = new Wizard(0, tokens[0], power);

        WizardTree wizardTree = new WizardTree(wizard);
        String line;
        while (!"END".equals(line = input.readLine())) {
            tokens = line.split("\\s+");
            switch (tokens[1]) {
                case "FIREBALL":
                    wizardTree.castFireball(Integer.parseInt(tokens[0]));
                    break;
                case "REFLECTION":
                    wizardTree.castReflection(Integer.parseInt(tokens[0]));
                    break;
            }
        }
    }
}
