import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Logger {

    private Importance importance;
    private List<Message> messages;

    public Logger(Importance importance) {
        this.messages = new ArrayList<>();
        this.importance = importance;
    }

    public void receiveMessage(Message message) {
        if (message.getImportance().compareTo(this.importance) >= 0) {
            this.messages.add(message);
        }
    }

    public Iterable<Message> getMessages() {
        return Collections.unmodifiableCollection(this.messages);
    }
}
