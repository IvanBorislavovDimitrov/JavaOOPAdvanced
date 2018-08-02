package src.logger.models.loggers_interfaces;

import src.logger.enums.LogType;

public interface Handler {

    void handle(LogType logType, String message);

    void setSuccessor(Handler handler);
}
