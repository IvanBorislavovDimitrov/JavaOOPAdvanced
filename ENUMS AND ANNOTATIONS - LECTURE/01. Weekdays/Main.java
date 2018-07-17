import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        WeeklyCalendar weeklyCalendar = new WeeklyCalendar();
        weeklyCalendar.addEntry("Friday", "sleep");
        weeklyCalendar.addEntry("Monday", "sport");

        Iterable<WeeklyEntry> schedule = weeklyCalendar.getWeeklySchedule();
        for (WeeklyEntry weeklyEntry : schedule) {
            System.out.println(weeklyEntry);
        }
    }
}
