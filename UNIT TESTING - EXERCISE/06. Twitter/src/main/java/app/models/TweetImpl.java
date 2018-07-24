package app.models;

import java.util.List;
import java.util.Random;

public class TweetImpl implements Tweet {

    private static final List<String> messages = List.of("I didn't understand the problem", "It's probably wrong", "Damn son");
    private static int index = 0;

    @Override
    public String sendMessage() {
        return messages.get(index);
    }
}
