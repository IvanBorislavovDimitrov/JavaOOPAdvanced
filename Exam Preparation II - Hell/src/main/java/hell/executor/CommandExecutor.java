package hell.executor;

import hell.commands.Command;
import hell.container.Container;

public class CommandExecutor {

    public String execute(Container container, Command command, String... params) {
        return command.execute(container, params);
    }
}