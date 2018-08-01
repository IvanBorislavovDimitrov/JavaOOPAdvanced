package src.p03_employee_info.api;

import src.p03_employee_info.models.Employee;

import java.util.List;

public interface InfoProvider {

    Iterable<Employee> getEmployeesBySalary();

    List<Employee> getEmployeesByName();

}
