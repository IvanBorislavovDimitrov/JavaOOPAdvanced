package app.models.job;

import app.models.interfaces.Employee;

public class Job {

    private String name;
    private int hoursRemaining;
    private Employee employee;

    public Job(String name, int indispensableHours, Employee employee) {
        this.name = name;
        this.hoursRemaining = indispensableHours;
        this.employee = employee;
    }

    public String update() {
        this.hoursRemaining -= this.employee.getWorkHoursPerDay();
        if (this.hoursRemaining <= 0) {
            return String.format("Job %s done!", this.getName());
        }

        return null;
    }

    public String getName() {
        return this.name;
    }

    public int getHoursRemaining() {
        return this.hoursRemaining;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    @Override
    public String toString() {
        return String.format("Job: %s Hours Remaining: %d", this.getName(), this.getHoursRemaining());
    }
}
