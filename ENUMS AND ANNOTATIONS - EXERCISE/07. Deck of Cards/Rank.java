public enum Rank {

    ACE(Suit.CLUBS, Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES),
    TWO(Suit.CLUBS, Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES),
    THREE(Suit.CLUBS, Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES),
    FOUR(Suit.CLUBS, Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES),
    FIVE(Suit.CLUBS, Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES),
    SIX(Suit.CLUBS, Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES),
    SEVEN(Suit.CLUBS, Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES),
    EIGHT(Suit.CLUBS, Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES),
    NINE(Suit.CLUBS, Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES),
    TEN(Suit.CLUBS, Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES),
    JACK(Suit.CLUBS, Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES),
    QUEEN(Suit.CLUBS, Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES),
    KING(Suit.CLUBS, Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES);

    private Suit clubs;
    private Suit hearts;
    private Suit diamonds;
    private Suit spades;


    Rank(Suit clubs, Suit hearts, Suit diamonds, Suit spades) {
        this.clubs = clubs;
        this.hearts = hearts;
        this.diamonds = diamonds;
        this.spades = spades;
    }

    public Suit getClubs() {
        return clubs;
    }

    public void setClubs(Suit clubs) {
        this.clubs = clubs;
    }

    public Suit getHearts() {
        return hearts;
    }

    public void setHearts(Suit hearts) {
        this.hearts = hearts;
    }

    public Suit getDiamonds() {
        return diamonds;
    }

    public void setDiamonds(Suit diamonds) {
        this.diamonds = diamonds;
    }

    public Suit getSpades() {
        return spades;
    }

    public void setSpades(Suit spades) {
        this.spades = spades;
    }
}
