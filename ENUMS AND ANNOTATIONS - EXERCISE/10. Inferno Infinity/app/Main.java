package app;

import app.engine.Engine;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        Constructor<Engine> defaultConstructor = Engine.class.getConstructor();
        Engine engine = defaultConstructor.newInstance();

        engine.start();
    }
}
