package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[] firstThree = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int numberOfEntities = firstThree[0];
        int numberOfInstitutions = firstThree[1];
        int numberOfChanges = firstThree[2];

        Map<String, Employee> employees = new LinkedHashMap<>();
        Map<String, Company> companies = new LinkedHashMap<>();
        Map<String, Institution> institutions = new LinkedHashMap<>();

        readEntities(input, numberOfEntities, employees, companies);

        addInstitutions(input, numberOfInstitutions, institutions);

        execute(input, numberOfChanges, employees, companies, institutions);

        print(institutions);
    }

    private static void execute(BufferedReader input, int numberOfChanges, Map<String, Employee> employees, Map<String, Company> companies, Map<String, Institution> institutions) throws IOException {
        for (int i = 0; i < numberOfChanges; i++) {
            String[] tokens = input.readLine().split("\\s+");
            String id = tokens[0];
            String field = tokens[1];
            String value = tokens[2];

            if (employees.containsKey(id)) {
                if (field.equals("name")) {
                    String oldValue = employees.get(id).getName();
                    employees.get(id).setName(value);
                    Employee employee = employees.get(id);
                    String msg = String.format("--Employee(ID:%s) changed name(String) from %s to %s",
                            employee.getId(), oldValue, employee.getName());
                    notifyAllInstitutions(institutions, field, msg);
                } else if (field.equals("income")) {
                    int oldIncome = employees.get(id).getIncome();
                    employees.get(id).setIncome(Integer.parseInt(value));
                    Employee employee = employees.get(id);

                    String msg = String.format("--Employee(ID:%s) changed income(int) from %d to %d",
                            employee.getId(), oldIncome, employee.getIncome());

                    notifyAllInstitutions(institutions, field, msg);
                }
            } else if (companies.containsKey(id)) {
                switch (field) {
                    case "name": {
                        Company company = companies.get(id);
                        String oldValue = company.getName();
                        company.setName(value);
                        String msg = String.format("--Company(ID:%s) changed name(String) from %s to %s",
                                id, oldValue, company.getName());
                        notifyAllInstitutions(institutions, field, msg);
                        break;
                    }
                    case "turnover": {
                        Company company = companies.get(id);
                        int oldValue = company.getTurnover();
                        company.setTurnover(Integer.parseInt(value));
                        String msg = String.format("--Company(ID:%s) changed turnover(int) from %d to %d",
                                id, oldValue, company.getTurnover());
                        notifyAllInstitutions(institutions, field, msg);
                        break;
                    }
                    case "revenue": {
                        Company company = companies.get(id);
                        int oldValue = company.getRevenue();
                        company.setRevenue(Integer.parseInt(value));
                        String msg = String.format("--Company(ID:%s) changed revenue(int) from %d to %d",
                                id, oldValue, company.getRevenue());
                        notifyAllInstitutions(institutions, field, msg);
                        break;
                    }
                }
            }
        }
    }

    private static void print(Map<String, Institution> institutions) {
        institutions.forEach((key, value) -> {
            System.out.println(String.format("%s: %d changes registered", value.getName(), value.getChanges().size()));
            value.getChanges().forEach(System.out::println);
        });
    }

    private static void notifyAllInstitutions(Map<String, Institution> institutions, String field, String message) {
        institutions.values().forEach(i -> {
            if (i.getSubjects().contains(field)) {
                i.getChanges().add(message);
            }
        });
    }

    private static void addInstitutions(BufferedReader input, int numberOfInstitutions, Map<String, Institution> institutions) throws IOException {
        for (int i = 0; i < numberOfInstitutions; i++) {
            String[] tokens = input.readLine().split("\\s+");
            String id = tokens[1];
            String name = tokens[2];
            String[] subjects = Arrays.stream(tokens).skip(3).toArray(String[]::new);
            Institution institution = new Institution(id, name);
            institution.getSubjects().addAll(Arrays.asList(subjects));
            institutions.put(id, institution);
        }
    }

    private static void readEntities(BufferedReader input, int numberOfEntities, Map<String, Employee> employees, Map<String, Company> companies) throws IOException {
        for (int i = 0; i < numberOfEntities; i++) {
            String[] tokens = input.readLine().split("\\s+");
            switch (tokens[0]) {
                case "Employee":
                    String id = tokens[1];
                    String name = tokens[2];
                    int income = Integer.parseInt(tokens[3]);
                    Employee employee = new Employee(id, name, income);
                    employees.put(id, employee);
                    break;
                case "Company":
                    id = tokens[1];
                    name = tokens[2];
                    int turnover = Integer.parseInt(tokens[3]);
                    int revenue = Integer.parseInt(tokens[4]);
                    Company company = new Company(id, name, turnover, revenue);
                    companies.put(id, company);
                    break;
            }
        }
    }
}
