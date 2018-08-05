package app;

public class IdIncrementer {

    private static int id = 1;

    public static int getId() {
        return id++;
    }
}
