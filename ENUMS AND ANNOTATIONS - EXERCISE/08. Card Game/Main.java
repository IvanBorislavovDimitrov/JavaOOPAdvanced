import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<Rank> deck = new ArrayList<>(Arrays.asList(Rank.values()));
        Player p1 = new Player(input.readLine());
        Player p2 = new Player(input.readLine());
        addCards(input, deck, p1);
        addCards(input, deck, p2);

        printWinner(p1, p2);
    }

    private static void printWinner(Player p1, Player p2) {
        Card p1Card = p1.getBestCardPower();
        Card p2Card = p2.getBestCardPower();

        System.out.println(Integer.compare(p1Card.power(), p2Card.power()) > 0 ?
            String.format("%s wins with %s.", p1.getName(), p1Card.toString()) :
            String.format("%s wins with %s.", p2.getName(), p2Card.toString()));
    }

    private static void addCards(BufferedReader input, List<Rank> deck, Player player) throws IOException {
        while (!player.isFull()) {
            String[] cardInfo = input.readLine().split("\\s+");
            try {
                Rank r1 = Rank.valueOf(cardInfo[0]);
                Suit s1 = Suit.valueOf(cardInfo[2]);
                Rank rank = deck.stream().filter(c -> c.name().equals(cardInfo[0])).findFirst().orElse(null);
                if (rank == null) {
                    throw new IllegalAccessError();
                }
                Suit suit = rank.getSuits().stream().filter(r -> r.name().equals(cardInfo[2])).findFirst().orElse(null);
                if (suit == null) {
                    throw new IllegalAccessError();
                }
                rank.getSuits().removeIf(s -> s.name().equals(cardInfo[2]));

                player.addCard(new Card(rank, suit));
            } catch (IllegalArgumentException e) {
                System.out.println("No such card exists.");
            } catch (IllegalAccessError e) {
                System.out.println("Card is not in the deck.");
            }
        }
    }
}