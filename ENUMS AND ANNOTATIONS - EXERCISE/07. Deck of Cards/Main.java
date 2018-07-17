import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            System.out.println(String.format("%s of %s", rank.toString(), rank.getClubs().toString()));
        }
        for (Rank rank : ranks) {
            System.out.println(String.format("%s of %s", rank.toString(), rank.getDiamonds().toString()));
        }
        for (Rank rank : ranks) {
            System.out.println(String.format("%s of %s", rank.toString(), rank.getHearts().toString()));
        }
        for (Rank rank : ranks) {
            System.out.println(String.format("%s of %s", rank.toString(), rank.getSpades().toString()));
        }
    }
}
