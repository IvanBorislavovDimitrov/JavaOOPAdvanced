package app.models;


public class King extends BasePerson {

    public King(String name) {
        super(name);
    }

    @Override
    public String sayWhatIAmDoing() {
        return String.format("King %s is under attack!", super.getName());
    }
}
