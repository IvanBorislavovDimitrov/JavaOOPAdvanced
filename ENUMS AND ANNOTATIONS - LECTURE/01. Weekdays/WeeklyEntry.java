public class WeeklyEntry implements Comparable<WeeklyEntry> {

    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.weekday = Enum.valueOf(Weekday.class, weekday.toUpperCase());
        this.notes = notes;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.weekday.toString(), this.notes);
    }

    @Override
    public int compareTo(WeeklyEntry o) {
        return Integer.compare(this.weekday.ordinal(), o.weekday.ordinal());
    }
}
