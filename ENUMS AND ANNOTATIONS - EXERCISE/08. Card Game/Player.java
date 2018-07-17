import java.util.Arrays;

public class Player {

    private String name;
    private Card[] cards;
    private int count;

    public Player(String name) {
        this.name = name;
        this.cards = new Card[5];
    }

    public void addCard(Card card) {
        this.cards[count++] = card;
    }

    public boolean isFull() {
        return count == 5;
    }

    public Card getBestCardPower() {
        Arrays.sort(this.cards);

        return this.cards[0];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
