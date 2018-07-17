import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String rankString = input.readLine();
        String powerString = input.readLine();
        Power power = Power.valueOf(powerString);
        Rank rank = Rank.valueOf(rankString);

        Card card = new Card(rank, power);

        String rankString1 = input.readLine();
        String powerString1 = input.readLine();
        Power power1 = Power.valueOf(powerString1);
        Rank rank1 = Rank.valueOf(rankString1);

        Card card1 = new Card(rank1, power1);

        System.out.println(Integer.compare(card.getTotalPower(), card1.getTotalPower()) > 0 ?
            card : card1);
    }
}
