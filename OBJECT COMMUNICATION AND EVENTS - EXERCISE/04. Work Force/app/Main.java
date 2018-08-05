package app;

import app.models.employees.PartTimeEmployee;
import app.models.employees.StandardEmployee;
import app.models.interfaces.Employee;
import app.models.job.Job;
import app.models.job.JobCollection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Map<String, Employee> employeeMap = new HashMap<>();
        JobCollection jobs = new JobCollection();
        while (!"End".equals(line = input.readLine())) {
            String[] tokens = line.split("\\s+");
            switch (tokens[0]) {
                case "StandartEmployee":
                    employeeMap.put(tokens[1], new StandardEmployee(tokens[1]));
                    break;
                case "PartTimeEmployee":
                    employeeMap.put(tokens[1], new PartTimeEmployee(tokens[1]));
                    break;
                case "Job":
                    jobs.add(new Job(tokens[1], Integer.parseInt(tokens[2]), employeeMap.get(tokens[3])));
                    break;
                case "Pass":
                    String passWeek = jobs.passWeek();
                    if (passWeek != null) {
                        System.out.println(passWeek);
                    }
                    break;
                case "Status":
                    if (jobs.status() != null) {
                        System.out.println(jobs.status());
                    }
                    break;
            }
        }
    }
}
