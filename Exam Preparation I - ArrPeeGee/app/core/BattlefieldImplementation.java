package app.core;

import app.abilities.Ability;
import app.contracts.*;
import app.factory.ActionFactoryImpl;
import app.factory.ParticipantsFactory;
import app.factory.SpecialFactoryImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class BattlefieldImplementation implements Battlefield {

    private Map<String, Targetable> participants;
    private List<Action> executedActions;
    private Writer writer;
    private TargetableFactory targetableFactory;
    private ActionFactory actionFactory;
    private SpecialFactory specialFactory;

    public BattlefieldImplementation(Writer writer) {
        this.executedActions = new ArrayList<>();
        this.participants = new TreeMap<>();
        this.writer = writer;
        this.targetableFactory = new ParticipantsFactory();
        this.actionFactory = new ActionFactoryImpl();
        this.specialFactory = new SpecialFactoryImpl();
    }

    @Override
    public void createAction(String actionName, String... participantNames) {
        try {
            Action action = this.actionFactory.create(actionName, participantNames);
            List<Targetable> actionParticipants = new ArrayList<>();
            for (String participantName : participantNames) {
                if (this.participants.containsKey(participantName)) {
                    actionParticipants.add(this.participants.get(participantName));
                } else {
                    throw new IllegalArgumentException(String.format("%s is not on the battlefield. %s failed.",
                            participantName, actionName));
                }
            }

            String log = action.executeAction(actionParticipants);

            this.executedActions.add(action);
            this.writer.writeLine(log);
            this.checkForDeadParticipants();
        } catch (IllegalArgumentException e) {
            this.writer.writeLine(e.getMessage());
        } catch (Exception e) {
            this.writer.writeLine("Action does not exist.");
        }
    }

    @Override
    public void createParticipant(String name, String className) {

        if (this.participants.containsKey(name)) {
            this.writer.writeLine("Participant with that name already exists.");
            return;
        }

        try {
            Targetable targetable = this.targetableFactory.create(name, className);
            this.participants.put(targetable.getName(), targetable);

            this.writer.writeLine(String.format("%s %s entered the battlefield.", className,  name));
        } catch (Exception e) {
            this.writer.writeLine(e.getMessage());
        }
    }

    @Override
    public void createSpecial(String name, String specialName) {
        try {
            Ability ability = this.specialFactory.create(specialName);
            this.participants.get(name).setSpecial(ability);

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void reportParticipants() {
        if (this.participants.size() < 1) {
            this.writer.writeLine("There are no participants on the battlefield.");
            return;
        }

        for (String name : this.participants.keySet()) {
            this.writer.writeLine(this.participants.get(name).toString());
            this.writer.writeLine("* * * * * * * * * * * * * * * * * * * *");
        }
    }

    @Override
    public void reportActions() {
        if (this.executedActions.size() < 1) {
            this.writer.writeLine("There are no actions on the battlefield.");
            return;
        }

        for (Action executedAction : this.executedActions) {
            this.writer.writeLine(executedAction.getClass().getSimpleName());
        }
    }

    private void checkForDeadParticipants() {
        Map<String, Targetable> aliveParticipants = new TreeMap<>();

        for (String name : this.participants.keySet()) {
            if (!this.participants.get(name).isAlive()) {
                this.writer.writeLine(String.format("%s has been removed from the battlefield.", name));
            } else {
                aliveParticipants.put(name, this.participants.get(name));
            }
        }

        this.participants = aliveParticipants;
    }
}
