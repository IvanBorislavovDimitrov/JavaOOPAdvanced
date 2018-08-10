package bg.softuni.models.models.fragments;


import bg.contracts.Fragment;
import bg.softuni.models.enums.FragmentType;

public abstract class BaseFragment implements Fragment {

    private String name;

    private FragmentType type;

    private Integer pressureAffection;

    BaseFragment(String name, Integer pressureAffection, FragmentType fragmentType) {
        this.setName(name);
        this.setPressureAffection(pressureAffection);
        this.setType(fragmentType);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String value) {
        this.name = value;
    }

    @Override
    public FragmentType getType() {
        return this.type;
    }

    void setType(FragmentType value) {
        this.type = value;
    }

    @Override
    public Integer getPressureAffection () {
        return this.pressureAffection;
    }

    protected void setPressureAffection (Integer value) {
        if (value < 0 ) {
            throw new IllegalArgumentException(String.format("Failed to attach Fragment %s!", this.getName()));
        }
        this.pressureAffection = value;
    }

    @Override
    public int hashCode() {
        return this.getPressureAffection().toString().hashCode() + this.getName().hashCode() + this.getPressureAffection();
    }
}
