package app.contracts;

import app.abilities.Ability;

import java.lang.reflect.InvocationTargetException;

public interface SpecialFactory {

    Ability create(String abilityName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;
}
