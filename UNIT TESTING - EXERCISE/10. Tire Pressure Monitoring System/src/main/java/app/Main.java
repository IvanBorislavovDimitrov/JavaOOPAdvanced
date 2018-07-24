package app;

public class Main {

    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        for (int i = 0; i < 1; i++) {
            alarm.check();
            if (!alarm.getAlarmOn() && i == 0) {
                System.out.println("da");
            } else {
                System.out.println("ne");
            }
        }
    }
}
