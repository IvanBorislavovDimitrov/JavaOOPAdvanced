package src.p01_system_resources.greeting_clock;

import src.p01_system_resources.io.Writer;
import src.p01_system_resources.time_provider.TimeProvider;

import java.time.LocalTime;

public class GreetingClock {

    private TimeProvider timeProvider;
    private Writer writer;

    public GreetingClock(TimeProvider timeProvider, Writer writer) {
        this.timeProvider = timeProvider;
        this.writer = writer;
    }

    public void greeting() {
        if (this.timeProvider.getHour() < 12) {
            this.writer.writeLine("Good morning...");
        } else if (this.timeProvider.getHour() < 18) {
            this.writer.writeLine("Good afternoon...");
        } else {
            this.writer.writeLine("Good evening...");
        }
    }
}
