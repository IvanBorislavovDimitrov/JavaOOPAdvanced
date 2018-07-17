package app.engine;

import app.annotations.CustomAnnotation;
import app.impl.WeaponImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Engine {

    private static final String END_COMMAND = "END";

    private BufferedReader input;
    private List<WeaponImpl> weapons;

    public Engine() {
        this.input = new BufferedReader(new InputStreamReader(System.in));
        this.weapons = new ArrayList<>();
    }

    public void start() throws IOException {
        String line;
        while (!END_COMMAND.equals(line = this.input.readLine())) {
            String[] tokens = line.split(";");
            String command = tokens[0];
            CustomAnnotation customAnnotation = WeaponImpl.class.getAnnotation(CustomAnnotation.class);
            switch (command) {
                case "Create":
                    String weaponType = tokens[1];
                    String weaponName = tokens[2];
                    this.weapons.add(new WeaponImpl(weaponName, weaponType));
                    break;
                case "Add":
                    weaponName = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    String gemType = tokens[3];
                    WeaponImpl weapon = this.weapons.stream().filter(w -> w.getName().equals(weaponName)).findAny().get();
                    weapon.addGem(gemType, index);
                    break;
                case "Remove":
                    weaponName = tokens[1];
                    index = Integer.parseInt(tokens[2]);
                    weapon = this.weapons.stream().filter(w -> w.getName().equals(weaponName)).findAny().get();
                    weapon.removeGem(index);
                    break;
                case "Print":
                    weaponName = tokens[1];
                    weapon = this.weapons.stream().filter(w -> w.getName().equals(weaponName)).findAny().get();
                    System.out.println(weapon);
                    break;
                case "Compare":
                    WeaponImpl w1 = this.weapons.stream().filter(w -> w.getName().equals(tokens[1])).findAny().get();
                    WeaponImpl w2 = this.weapons.stream().filter(w -> w.getName().equals(tokens[2])).findAny().get();
                    WeaponImpl greaterWeapon = w1.compareTo(w2) > 0 ? w1 : w2;
                    System.out.printf("%s (Item Level: %.1f)%n", greaterWeapon, greaterWeapon.getItemLevel());
                    break;
                case "Author":
                    System.out.println(String.format("Author: %s", customAnnotation.author()));
                    break;
                case "Revision":
                    System.out.println(String.format("Revision: %d", customAnnotation.revision()));
                    break;
                case "Description":
                    System.out.println(String.format("Class description: %s", customAnnotation.description()));
                    break;
                case "Reviewers":
                    System.out.println(String.format("Reviewers: %s",
                            String.join(", ", customAnnotation.reviewers())));
                    break;
            }
        }
    }
}
