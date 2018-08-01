package src.p01_system_resources;

import src.p01_system_resources.greeting_clock.GreetingClock;
import src.p01_system_resources.io.Writer;
import src.p01_system_resources.io.WriterImpl;
import src.p01_system_resources.time_provider.LocalTimeProvider;
import src.p01_system_resources.time_provider.TimeProvider;

public class Main {

    public static void main(String[] args) {
        TimeProvider timeProvider = new LocalTimeProvider();
        Writer writer = new WriterImpl();
        GreetingClock greetingClock = new GreetingClock(timeProvider, writer);

        greetingClock.greeting();
    }
}
