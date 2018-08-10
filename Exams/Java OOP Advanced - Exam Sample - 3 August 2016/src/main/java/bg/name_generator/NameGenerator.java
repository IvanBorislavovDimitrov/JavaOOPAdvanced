package bg.name_generator;

public class NameGenerator {

    private static char ch = 'A';

    public static char getName() {
        return ch++;
    }
}
