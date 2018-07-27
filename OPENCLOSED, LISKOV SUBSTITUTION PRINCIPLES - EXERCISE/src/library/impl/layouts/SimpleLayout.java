package library.impl.layouts;

import library.api.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String time, String message, String level) {
        return time + " - " + level + " - " + message;
    }
}
