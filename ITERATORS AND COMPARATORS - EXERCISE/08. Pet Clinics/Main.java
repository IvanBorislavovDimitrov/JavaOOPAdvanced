import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int commandsCount = Integer.parseInt(input.readLine());
        List<Clinic> clinics = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();
        for (int i = 0; i < commandsCount; i++) {
            String[] commandInfo = input.readLine().split("\\s+");
            switch (commandInfo[0]) {
                case "Create":
                    try {
                        if (commandInfo.length == 4) {
                            clinics.add(new Clinic(commandInfo[2], Integer.parseInt(commandInfo[3])));
                        } else if (commandInfo.length == 5) {
                            pets.add(new Pet(commandInfo[2], Integer.parseInt(commandInfo[3]), commandInfo[4]));
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Add":
                    Pet pet = pets.stream().filter(p -> p.getName().equals(commandInfo[1])).findFirst().get();
                    Clinic clinic = clinics.stream().filter(c -> c.getName().equals(commandInfo[2])).findFirst().get();
                    try {
                        System.out.println(clinic.addPet(pet));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Release":
                    clinic = clinics.stream().filter(c -> c.getName().equals(commandInfo[1])).findFirst().get();
                    try {
                        System.out.println(clinic.release());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasEmptyRooms":
                    clinic = clinics.stream().filter(c -> c.getName().equals(commandInfo[1])).findFirst().get();
                    System.out.println(clinic.hasEmptyRooms());
                    break;
                case "Print":
                    clinic = clinics.stream().filter(c -> c.getName().equals(commandInfo[1])).findFirst().get();
                    if (commandInfo.length == 2) {
                        clinic.print();
                    } else if (commandInfo.length == 3) {
                        clinic.print(Integer.parseInt(commandInfo[2]));
                    }
                    break;
            }
        }

    }
}
