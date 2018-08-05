package app;

public class Employee extends Id {

    private String name;
    private int income;

    public Employee(String id) {
        super(id);
    }

    public Employee(String id, String name, int income) {
        super(id);
        this.name = name;
        this.income = income;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIncome() {
        return this.income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}
