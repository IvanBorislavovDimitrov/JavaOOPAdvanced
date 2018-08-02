package src.logger.models.impl;

import src.logger.enums.LogType;
import src.logger.models.loggers_interfaces.Handler;

public abstract class Logger implements Handler {

    private Handler successor;

    protected Logger() {
    }

    protected void passToSuccessor(LogType logType, String message) {
        if (this.successor != null) {
            this.successor.handle(logType, message);
        }
    }

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
