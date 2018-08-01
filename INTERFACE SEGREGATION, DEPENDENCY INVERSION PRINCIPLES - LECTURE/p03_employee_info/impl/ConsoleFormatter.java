package src.p03_employee_info.impl;

import src.p03_employee_info.api.Formatter;
import src.p03_employee_info.models.Employee;

public class ConsoleFormatter implements Formatter {

    @Override
    public String format(Iterable<? extends Employee> employees) {
        StringBuilder sb = new StringBuilder();
        for (Employee employee : employees) {
            sb.append(employee).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
