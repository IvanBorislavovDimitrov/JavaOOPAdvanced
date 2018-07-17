import java.util.ArrayList;
import java.util.List;

public class Message {

    private Importance importance;
    private String text;

    public Message(Importance importance, String text) {
        this.importance = importance;
        this.text = text;
    }

    public Importance getImportance() {
        return importance;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.getImportance().name(), this.getText());
    }
}
