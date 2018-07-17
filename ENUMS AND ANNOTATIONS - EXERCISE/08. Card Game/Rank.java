import java.util.ArrayList;
import java.util.List;

public enum Rank {

    ACE(14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private List<Suit> suits;
    private int points;

    Rank(int points) {
        this.suits = new ArrayList<Suit>() {{
            add(Suit.CLUBS);
            add(Suit.HEARTS);
            add(Suit.DIAMONDS);
            add(Suit.SPADES);
        }};
        this.points = points;
    }

    public List<Suit> getSuits() {
        return suits;
    }

    public void setSuits(List<Suit> suits) {
        this.suits = suits;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
