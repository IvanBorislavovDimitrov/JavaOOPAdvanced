package src.p01_system_resources.time_provider;

import java.time.LocalTime;

public class LocalTimeProvider implements TimeProvider {

    private LocalTime localTime;

    public LocalTimeProvider() {
        this.localTime = LocalTime.now();
    }

    @Override
    public int getHour() {
        return this.localTime.getHour();
    }
}
