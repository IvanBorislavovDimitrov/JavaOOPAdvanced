package library.controllers;

import library.api.Appender;
import library.enums.ReportLevel;
import library.factories.AppenderFactory;
import library.io.interfaces.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private InputReader inputReader;
    private List<Appender> appenders;

    public Controller(InputReader inputReader) {
        this.appenders = new ArrayList<>();
        this.inputReader = inputReader;
    }

    public void run() {
        int appendersCount = Integer.parseInt(this.inputReader.readLine());
        for (int i = 0; i < appendersCount; i++) {
            String[] tokens = this.inputReader.readLine().split("\\s+");
            ReportLevel reportLevel = tokens.length == 3 ? ReportLevel.valueOf(tokens[2]) : null;
            Appender appender = AppenderFactory.create(tokens[0], tokens[1], reportLevel);

            this.appenders.add(appender);
        }

        String line;
        while (!(line = this.inputReader.readLine()).equals("END")) {
            String[] tokens = line.split("\\|");

            ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
            String time = tokens[1];
            String text = tokens[2];

            for (Appender appender : this.appenders) {
                appender.append(time, text, reportLevel);
            }
        }

        System.out.println("Logger info");
        this.appenders.forEach(System.out::println);
    }
}
