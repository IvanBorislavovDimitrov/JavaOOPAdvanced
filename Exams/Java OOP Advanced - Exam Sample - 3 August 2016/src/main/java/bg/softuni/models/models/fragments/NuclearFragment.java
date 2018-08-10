package bg.softuni.models.models.fragments;


import bg.softuni.models.enums.FragmentType;

public class NuclearFragment extends BaseFragment{

    public NuclearFragment(String name, Integer pressureAffection, FragmentType fragmentType) {
        super(name, pressureAffection * 2, fragmentType);
        this.setType(FragmentType.Nuclear);
    }

    @Override
    public void setPressureAffection(Integer value) {
        super.setPressureAffection(value);
    }
}
