package cresla.util;

public class IdIncrementer {

    private static int id = 1;

    public static int getId() {
        return id++;
    }
}
