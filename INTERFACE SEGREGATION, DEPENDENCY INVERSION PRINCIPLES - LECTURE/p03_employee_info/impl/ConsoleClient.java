package src.p03_employee_info.impl;

import src.p03_employee_info.api.Client;
import src.p03_employee_info.api.Formatter;
import src.p03_employee_info.api.InfoProvider;

public class ConsoleClient implements Client {

    private Formatter formatter;
    private InfoProvider infoProvider;

    public ConsoleClient(Formatter formatter, InfoProvider infoProvider) {
        this.formatter = formatter;
        this.infoProvider = infoProvider;
    }

    @Override
    public void printEmployeesByName() {
        String output = formatter.format(this.infoProvider.getEmployeesByName());

        System.out.println(output);
    }
}
