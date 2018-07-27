package library.impl.layouts;

import library.api.Layout;

public class XmlLayout implements Layout {

    @Override
    public String format(String time, String message, String level) {

        return "<log>" + '\n' +
                "\t<date>" + time + "</date>" + '\n' +
                "\t<level>" + level + "</level>" + '\n' +
                "\t<message>" + message + "</message>" + '\n' + "</log>";
    }
}
