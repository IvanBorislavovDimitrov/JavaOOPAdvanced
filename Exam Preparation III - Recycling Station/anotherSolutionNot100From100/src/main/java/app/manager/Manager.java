package app.manager;

public interface Manager {

    String processGarbage(String... params);

    String status(String... params);

    String changeManagementRequirement(String... params);
}
