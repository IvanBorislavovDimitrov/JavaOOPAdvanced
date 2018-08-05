package app.models;

public class Footman extends BasePerson {

    public Footman(String name) {
        super(name);
    }

    @Override
    public String sayWhatIAmDoing() {
        return String.format("Footman %s is panicking!", super.getName());
    }
}
