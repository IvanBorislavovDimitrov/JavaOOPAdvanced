package app.enums;

public enum WeaponType {

    AXE(5, 10, 4),
    SWORD(4, 6, 3),
    KNIFE(3, 4, 2);

    private int minDamage;
    private int maxDamage;
    private int sockets;

    WeaponType(int minDamage, int maxDamage, int sockets) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.sockets = sockets;
    }


    public int getMinDamage() {
        return this.minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getSockets() {
        return this.sockets;
    }

    public void setSockets(int sockets) {
        this.sockets = sockets;
    }
}
