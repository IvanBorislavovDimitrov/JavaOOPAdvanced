package app.models;

public class RoyalGuard extends BasePerson {

    public RoyalGuard(String name) {
        super(name);
    }

    @Override
    public String sayWhatIAmDoing() {
        return String.format("Royal Guard %s is defending!", super.getName());
    }
}
