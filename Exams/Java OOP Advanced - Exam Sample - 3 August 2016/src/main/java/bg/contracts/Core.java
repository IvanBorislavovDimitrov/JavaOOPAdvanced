package bg.contracts;

public interface Core {
    String getType();

    int getDurability();

    Stack<Fragment> getFragmentStack();

    void addFragment(Fragment fragment);

    char getName();
}
