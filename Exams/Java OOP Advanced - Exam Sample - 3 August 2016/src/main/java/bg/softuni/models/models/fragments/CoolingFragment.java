package bg.softuni.models.models.fragments;


import bg.softuni.models.enums.FragmentType;

public class CoolingFragment extends BaseFragment {

    public CoolingFragment(String name, Integer pressureAffection, FragmentType fragmentType) {
        super(name, pressureAffection * 3, fragmentType);
        this.setType(FragmentType.Cooling);
    }

    @Override
    protected void setPressureAffection(Integer value) {
        super.setPressureAffection(value);
    }
}
