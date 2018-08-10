package bg.softuni.models.models.cores;

import bg.contracts.Core;
import bg.contracts.Fragment;
import bg.contracts.Stack;
import bg.name_generator.NameGenerator;
import bg.softuni.models.collection.LStack;
import bg.softuni.models.models.fragments.CoolingFragment;
import bg.softuni.models.models.fragments.NuclearFragment;

public abstract class BaseCore implements Core {

    private char name;

    private String type;

    private int durability;

    private Stack<Fragment> fragmentStack;

    protected BaseCore(String type, int durability) {
        this.name = NameGenerator.getName();
        this.setType(type);
        this.setDurability(durability);
        this.fragmentStack = new LStack<>();
    }

    @Override
    public String getType() {
        return this.type;
    }

    private void setType(String type) {
        this.type = type;
    }

    @Override
    public int getDurability() {
        int durability = this.durability;

        if (getTotalDurabilityFromStack() > 0) {
            durability -= getTotalDurabilityFromStack();
        }

        return durability;
    }

    @Override
    public Stack<Fragment> getFragmentStack() {
        return this.fragmentStack;
    }

    @Override
    public void addFragment(Fragment fragment) {
        this.fragmentStack.push(fragment);
    }

    private void setDurability(int durability) {
        if (durability < 0) {
            throw new IllegalArgumentException("Failed to create Core!");
        }
        this.durability = durability;
    }

    @Override
    public char getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("Core %s:\n" +
                "####Durability: %d\n" +
                "####Status: %s", getName(), getDurability(), getTotalDurabilityFromStack() > 0 ? "CRITICAL" : "NORMAL");
    }

    private int getTotalDurabilityFromStack() {
        int durability = 0;
        for (Fragment fragment : fragmentStack) {
            if (fragment instanceof NuclearFragment) {
                durability += fragment.getPressureAffection();
            } else if (fragment instanceof CoolingFragment) {
                durability -= fragment.getPressureAffection();
            }
        }

        return durability;
    }
}
