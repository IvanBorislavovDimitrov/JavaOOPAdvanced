package app.engine;

import app.factories.GarbageFactory;
import app.io.InputReader;
import app.io.OutputWriter;
import app.manager.Manager;
import app.waste_disposal.annotations.Inject;
import app.waste_disposal.contracts.GarbageProcessor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EngineImpl implements Engine {

    @Inject
    private InputReader inputReader;

    @Inject
    private OutputWriter outputWriter;

    @Inject
    private Manager manager;

    @Override
    public void run() {
        while (true) {
            String line = this.inputReader.readLine();
            String[] tokens = line.split("\\s+");
            String commandName = Character.toLowerCase(tokens[0].charAt(0)) + tokens[0].substring(1);

            if ("TimeToRecycle".equalsIgnoreCase(commandName)) {
                break;
            }

            String[] partInfo = null;
            if (tokens.length == 2) {
                partInfo = tokens[1].split("\\|");
            }

            try {
                Method method = this.manager.getClass().getDeclaredMethod(commandName, String[].class);
                method.setAccessible(true);
                String log = (String) method.invoke(this.manager, (Object) partInfo);

                this.outputWriter.writeLine(log);

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }


        }
    }
}
