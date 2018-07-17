import java.util.*;

public class WeeklyCalendar {

    private Set<WeeklyEntry> entries;

    public WeeklyCalendar() {
        this.entries = new TreeSet<>();
    }

    public void addEntry(String weekday, String notes) {
        WeeklyEntry weeklyEntry = new WeeklyEntry(weekday, notes);
        this.entries.add(weeklyEntry);
    }

    public Iterable<WeeklyEntry> getWeeklySchedule() {
        return this.entries;
    }
}
