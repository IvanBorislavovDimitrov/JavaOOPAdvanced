package app.P04_DetailPrinter;

public class Employee implements Person {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
