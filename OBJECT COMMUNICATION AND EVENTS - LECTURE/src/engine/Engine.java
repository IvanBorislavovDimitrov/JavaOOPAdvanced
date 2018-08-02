package src.engine;

import src.command.interfaces.Command;
import src.executor.CommandExecutor;
import src.executor.Executor;
import src.factories.CommandFactory;
import src.groups.Group;
import src.interfaces.AttackGroup;
import src.logger.models.impl.CombatLogger;
import src.logger.models.impl.EventLogger;
import src.logger.models.impl.Logger;
import src.models.api.Attacker;
import src.models.api.Target;
import src.models.impl.Dragon;
import src.models.impl.Warrior;

public class Engine {

    private Logger logger;
    private Executor executor;

    public Engine(Logger logger, Executor executor) {
        this.logger = logger;
        this.executor = executor;
    }

    // Third task
    public void showMediatorPattern() {
        Logger combatLog = new CombatLogger();
        Logger eventLogger = new EventLogger();

        combatLog.setSuccessor(eventLogger);
        AttackGroup group = new Group();
        group.addMember(new Warrior("Warrior", 10, combatLog));
        group.addMember(new Warrior("ElderWarrior", 13, combatLog));

        Target dragon = new Dragon("Dragon", 100, 25, combatLog);

        Executor executor = new CommandExecutor();

        Command groupTarget = CommandFactory.createCommand("GroupTarget", group, dragon);

        Command groupAttack = CommandFactory.createCommand("GroupAttack", group);

        executor.executeCommand(groupTarget);
        executor.executeCommand(groupAttack);
    }

    public void run() {
        Attacker attacker = new Warrior("1", 20, this.logger);
        Target target = new Dragon("2", 10, 200, this.logger);

        String targetCommandString = "Target";
        String attackCommandString = "Attack";

        Command targetCommand = CommandFactory.createCommand(targetCommandString, attacker, target);
        this.executor.executeCommand(targetCommand);

        Command attackCommand = CommandFactory.createCommand(attackCommandString, attacker);
        this.executor.executeCommand(attackCommand);
    }
}
