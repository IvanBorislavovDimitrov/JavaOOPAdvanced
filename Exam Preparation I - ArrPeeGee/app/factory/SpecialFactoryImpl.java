package app.factory;

import app.abilities.Ability;
import app.contracts.SpecialFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class SpecialFactoryImpl implements SpecialFactory {

    private static final String PATH = "app.abilities.";

    @Override
    public Ability create(String abilityName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Ability> abilityClass = (Class<Ability>) Class.forName(PATH + abilityName);
        Constructor<Ability> abilityConstructor = abilityClass.getDeclaredConstructor();

        Ability ability = abilityConstructor.newInstance();

        return ability;
    }

}
