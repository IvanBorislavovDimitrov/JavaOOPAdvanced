package app.factory;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.contracts.TargetableFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class ParticipantsFactory implements TargetableFactory {

    private static final String PATH = "app.models.participants.impl.";

    @Override
    public Targetable create(String name, String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Targetable> targetableClass = (Class<Targetable>) Class.forName(PATH + className);
        Constructor<Targetable> targetableConstructor = targetableClass.getDeclaredConstructor();
        Targetable targetable = targetableConstructor.newInstance();

        targetable.setName(name);

        return targetable;
    }
}