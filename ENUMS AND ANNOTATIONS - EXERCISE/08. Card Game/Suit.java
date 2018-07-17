public enum Suit {

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int points;

    Suit(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
