package app;

import app.contracts.*;
import app.core.BattlefieldImplementation;
import app.engine.EngineImpl;
import app.factory.ActionFactoryImpl;
import app.factory.SpecialFactoryImpl;
import app.factory.TargetableFactoryImpl;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        ActionFactory actionFactory = new ActionFactoryImpl();
        TargetableFactory targetableFactory = new TargetableFactoryImpl();
        SpecialFactory specialFactory = new SpecialFactoryImpl();
        Battlefield battlefield = new BattlefieldImplementation(writer, targetableFactory, actionFactory, specialFactory);

        Engine engine = new EngineImpl(reader, battlefield);

        engine.run();
    }
}
