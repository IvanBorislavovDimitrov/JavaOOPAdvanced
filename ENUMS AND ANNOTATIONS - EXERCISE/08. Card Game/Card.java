public class Card implements Comparable<Card> {

    private Rank rank;

    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(o.power(), this.power());
    }

    public int power() {
        return this.rank.getPoints() + this.suit.getPoints();
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.getRank(), this.getSuit());
    }
}
