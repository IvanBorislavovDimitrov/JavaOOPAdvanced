package app.model;

public interface Person extends Comparable<Person> {

    long getId();

    String getUsername();
}
