package app.models;

import java.util.ArrayList;
import java.util.List;

public class ClientImpl implements Client {

    private List<String> receivedMessages;

    public ClientImpl() {
        this.receivedMessages = new ArrayList<>();
    }

    @Override
    public String retrieveMessage(String message) {
        this.receivedMessages.add(message);
        System.out.println(message);

        return message;
    }
}
