package bg.contracts;

public interface Manager {
    String createCore(String type, int durability);

    String removeCore(char name);

    String selectCore(char name);

    String attachFragment(String type, String name, int pressureAffection);

    String detachFragment();

    String status();
}
