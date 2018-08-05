package app.models;

public class RoyalGuard extends BaseServant {

    public RoyalGuard(String name) {
        super(name);
    }

    @Override
    public String sayWhatIAmDoing() {
        return String.format("Royal Guard %s is defending!", super.getName());
    }

    @Override
    public boolean tryKill() {
        this.setAttacks(this.getAttacks() +  1);

        return this.getAttacks() == 3;
    }
}
