import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<Person> people = new ArrayList<>();
        while (!"END".equals(line = input.readLine())) {
            String[] personInfo = line.split("\\s+");
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);
            String city = personInfo[2];
            people.add(new Person(name, age, city));
        }
        int index = Integer.parseInt(input.readLine()) - 1;
        Person person = people.get(index);
        long count = people.stream().filter(p -> p.equals(person)).count();
        System.out.println(count == 1 ? "No matches" : count + " " + (people.size() - count) + " " + people.size());
    }
}
