package app.factory;

import app.contracts.Action;
import app.contracts.ActionFactory;
import app.contracts.Targetable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public final class ActionFactoryImpl implements ActionFactory {

    private static final String PATH = "app.models.actions.";


    @Override
    public Action create(String actionName, String... participantNames) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Action> actionClass = (Class<Action>) Class.forName(PATH + actionName);
        Constructor<Action> constructor = actionClass.getDeclaredConstructor();
        Action action = constructor.newInstance();

        return action;
    }
}
