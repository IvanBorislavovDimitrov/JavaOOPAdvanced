package src.p03_employee_info.impl;

import src.p03_employee_info.api.InfoProvider;
import src.p03_employee_info.models.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeInfoProvider implements InfoProvider {

    private EmployeeDatabase database;

    public EmployeeInfoProvider() {
        this.database = new EmployeeDatabase();
    }

    public List<Employee> getEmployeesByName() {
        return this.database.readEmployees().stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    public Iterable<Employee> getEmployeesBySalary() {
        return this.database.readEmployees().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());
    }
}
