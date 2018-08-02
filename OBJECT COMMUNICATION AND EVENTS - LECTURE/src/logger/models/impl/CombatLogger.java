package src.logger.models.impl;

import src.logger.enums.LogType;

public class CombatLogger extends Logger {

    @Override
    public void handle(LogType logType, String message) {
        if (logType.equals(LogType.ATTACK) || logType.equals(LogType.MAGIC)) {
            System.out.println(logType.name() + " : " + message);
        } else {
            super.passToSuccessor(logType, message);
        }
    }
}
