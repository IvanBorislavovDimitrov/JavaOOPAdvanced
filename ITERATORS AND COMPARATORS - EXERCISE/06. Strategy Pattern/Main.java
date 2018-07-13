import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> personByNameSet = new TreeSet<>(new PersonFirstComparator());
        Set<Person> personByAgeSet = new TreeSet<>(new PersonSecondComparatorBasedOnAge());

        int peopleNumber = Integer.parseInt(input.readLine());
        for (int i = 0; i < peopleNumber; i++) {
            String[] persoInfo = input.readLine().split("\\s+");
            Person person = new Person(persoInfo[0], Integer.parseInt(persoInfo[1]));
            personByNameSet.add(person);
            personByAgeSet.add(person);
        }

        personByNameSet.forEach(System.out::println);
        personByAgeSet.forEach(System.out::println);
    }
}
