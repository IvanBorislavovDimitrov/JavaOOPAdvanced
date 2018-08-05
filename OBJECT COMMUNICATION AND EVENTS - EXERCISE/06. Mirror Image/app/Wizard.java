package app;

public class Wizard {

    private int id;
    private String name;
    private int magicalPower;

    public Wizard() {
    }

    public Wizard(int id, String name, int magicalPower) {
        this.id = id;
        this.name = name;
        this.magicalPower = magicalPower;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMagicalPower() {
        return this.magicalPower;
    }

    public void setMagicalPower(int magicalPower) {
        this.magicalPower = magicalPower;
    }

    @Override
    public String toString() {
        return id + "";
    }
}
