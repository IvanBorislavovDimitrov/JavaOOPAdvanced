package bg.manager;

import bg.contracts.Core;
import bg.contracts.Fragment;
import bg.contracts.Manager;
import bg.factories.CoreFactory;
import bg.factories.FragmentFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class ManagerImpl implements Manager {

    private Map<Character, Core> cores;
    private Core core;

    public ManagerImpl() {
        cores = new LinkedHashMap<>();
    }

    @Override
    public String createCore(String type, int durability) {
        Core core = CoreFactory.create(type, durability);
        cores.put(core.getName(), core);

        return String.format("Successfully created Core %c!", core.getName());
    }

    @Override
    public String removeCore(char name) {
        if (!cores.containsKey(name)) {
            throw new IllegalArgumentException(String.format("Failed to remove Core %c!", name));
        }

        Core core = cores.remove(name);
        if (this.core == core) {
            this.core = null;
        }

        return String.format("Successfully removed Core %c!", name);
    }

    @Override
    public String selectCore(char name) {
        if (!cores.containsKey(name)) {
            throw new IllegalArgumentException(String.format("Failed to remove Core %c!", name));
        }
        core = cores.get(name);

        return String.format("Currently selected Core %s!", name);
    }

    @Override
    public String attachFragment(String type, String name, int pressureAffection) {
        Fragment fragment = FragmentFactory.create(name, pressureAffection, type);
        if (core == null) {
            throw new IllegalArgumentException(String.format("Failed to attach Fragment %s!", fragment.getName()));
        }
        core.addFragment(fragment);

        return String.format("Successfully attached Fragment %s to Core %c!",
                fragment.getName(), core.getName());
    }

    @Override
    public String detachFragment() {
        if (core == null) {
            throw new IllegalArgumentException("Failed to detach Fragment!");
        }
        Fragment fragment = core.getFragmentStack().pop();
        return String.format("Successfully detached Fragment %s from Core %c!",
                    fragment.getName(), core.getName());
    }

    @Override
    public String status() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lambda Core Power Plant Status:").append(System.lineSeparator());

        sb.append(String.format("Total Durability: %d",
                cores.values().stream().mapToLong(Core::getDurability).sum())).append(System.lineSeparator());
        sb.append(String.format("Total Cores: %d",
                cores.size())).append(System.lineSeparator());
        sb.append(String.format("Total Fragments: %d",
                cores.values().stream().mapToInt(x -> x.getFragmentStack().size()).sum()));

        cores.values().forEach(x -> sb.append(System.lineSeparator()).append(x));

        return sb.toString().trim();
    }
}
