package src.p03_employee_info.api;

import src.p03_employee_info.models.Employee;

public interface Formatter {

    String format(Iterable<? extends Employee> employees);
}
