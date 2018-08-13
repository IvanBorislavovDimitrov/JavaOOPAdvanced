package callofduty.engine;

import callofduty.core.MissionControlImpl;
import callofduty.interfaces.InputReader;
import callofduty.interfaces.MissionControl;
import callofduty.interfaces.MissionManager;
import callofduty.interfaces.OutputWriter;
import callofduty.io.ConsoleReader;
import callofduty.io.ConsoleWriter;
import callofduty.manager.MissionManagerImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private MissionManager missionManager;
    private MissionControl missionControl;

    public Engine(InputReader inputReader, OutputWriter outputWriter, MissionManager missionManager, MissionControl missionControl) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.missionManager = missionManager;
        this.missionControl = missionControl;
    }

    public void run() {
        while (true) {
            String line = this.inputReader.readLine();
            String[] tokens = line.split("\\s+");
            String commandName = tokens[0].toLowerCase();
            List<String> params = Arrays.stream(tokens).skip(1).collect(Collectors.toList());


            try {
                Method method = this.missionManager.getClass().getMethod(commandName, List.class);

                String log = (String) method.invoke(this.missionManager, params);

                this.outputWriter.println(log);

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }


            if ("over".equalsIgnoreCase(line)) {
                break;
            }
        }
    }
}
