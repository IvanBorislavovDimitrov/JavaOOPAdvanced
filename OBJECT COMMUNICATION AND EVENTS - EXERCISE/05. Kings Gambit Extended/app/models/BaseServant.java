package app.models;

public abstract class BaseServant extends BasePerson {

    private int attacks;

    protected BaseServant(String name) {
        super(name);
        this.attacks = 0;
    }

    public int getAttacks() {
        return this.attacks;
    }

    public void setAttacks(int attacks) {
        this.attacks = attacks;
    }

    public abstract boolean tryKill();
}
