public enum Power {

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int value;

    Power(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
