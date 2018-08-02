package src;

import src.engine.Engine;
import src.executor.CommandExecutor;
import src.executor.Executor;
import src.logger.enums.LogType;
import src.logger.models.impl.CombatLogger;
import src.logger.models.impl.ErrorLogger;
import src.logger.models.impl.EventLogger;
import src.logger.models.impl.Logger;

public class Main {

    public static void main(String[] args) {

        Logger combatLogger = new CombatLogger();
        Logger errorLogger = new ErrorLogger();
        Logger eventLogger = new EventLogger();

        combatLogger.setSuccessor(errorLogger);
        errorLogger.setSuccessor(eventLogger);

        combatLogger.handle(LogType.ATTACK, "some attack");
        combatLogger.handle(LogType.ERROR, "some error");
        combatLogger.handle(LogType.EVENT, "some event");

        Executor executor = new CommandExecutor();
        Engine engine = new Engine(combatLogger, executor);

//        engine.run();

        engine.showMediatorPattern();
    }
}
