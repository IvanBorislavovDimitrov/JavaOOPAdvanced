import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String typeOfEnum = input.readLine();
        String log = "";
        switch (typeOfEnum) {
            case "Rank":
                Rank rank = Rank.ACE;
                Annotation annotation = rank.getClass().getAnnotation(CustomAnnotation.class);
                log = String.format("Type = %s, Description = %s",
                        ((CustomAnnotation) annotation).type(), ((CustomAnnotation) annotation).description());
                break;
            case "Suit":
                Suit suit = Suit.CLUBS;
                annotation = suit.getClass().getAnnotation(CustomAnnotation.class);
                log = String.format("Type = %s, Description = %s",
                        ((CustomAnnotation) annotation).type(), ((CustomAnnotation) annotation).description());
                break;
        }

        System.out.println(log);
    }
}
