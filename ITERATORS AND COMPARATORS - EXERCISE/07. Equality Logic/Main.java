import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> personTreeSet = new TreeSet<>();
        Set<Person> personHashSet = new HashSet<>();

        int peopleNumber = Integer.parseInt(input.readLine());
        for (int i = 0; i < peopleNumber; i++) {
            String[] personInfo = input.readLine().split("\\s+");
            Person person = new Person(personInfo[0], Integer.parseInt(personInfo[1]));
            personTreeSet.add(person);
            personHashSet.add(person);
        }

        System.out.println(personTreeSet.size());
        System.out.println(personHashSet.size());
    }
}
