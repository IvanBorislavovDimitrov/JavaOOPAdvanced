package hell.commands;

import hell.container.Container;

public interface Command {

    String execute(Container container, String... params);
}
