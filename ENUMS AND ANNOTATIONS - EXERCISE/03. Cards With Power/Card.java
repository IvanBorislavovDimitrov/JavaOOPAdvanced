public class Card {

    private Rank rank;
    private Power power;

    public Card(Rank rank, Power power) {
        this.rank = rank;
        this.power = power;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", rank, power, rank.getValue() + power.getValue());
    }
}