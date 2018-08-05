package app.models;

public class Footman extends BaseServant {


    public Footman(String name) {
        super(name);
    }

    @Override
    public String sayWhatIAmDoing() {
        return String.format("Footman %s is panicking!", super.getName());
    }

    @Override
    public boolean tryKill() {
        this.setAttacks(this.getAttacks() +  1);

        return this.getAttacks() == 2;
    }
}
