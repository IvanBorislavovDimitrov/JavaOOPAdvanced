package app.models.employees;

import app.models.interfaces.Employee;

public abstract class BaseEmployee implements Employee {

    private String name;
    private int workHoursPerDay;

    protected BaseEmployee(String name, int workHoursPerDay) {
        this.name = name;
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    public void setWorkHoursPerDay(int workHoursPerDay) {
        this.workHoursPerDay = workHoursPerDay;
    }
}
