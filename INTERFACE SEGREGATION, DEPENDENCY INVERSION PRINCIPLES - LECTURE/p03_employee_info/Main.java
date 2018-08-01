package src.p03_employee_info;

import src.p03_employee_info.api.Client;
import src.p03_employee_info.impl.ConsoleClient;
import src.p03_employee_info.impl.ConsoleFormatter;
import src.p03_employee_info.impl.EmployeeInfoProvider;

public class Main {

    public static void main(String[] args) {
        Client client = new ConsoleClient(new ConsoleFormatter(),new EmployeeInfoProvider());

        client.printEmployeesByName();
    }
}
