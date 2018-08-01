package src.p02_services;

import src.p02_services.api.NotificationService;
import src.p02_services.impl.EmailNotificationService;
import src.p02_services.impl.SmsNotificationService;

public class Main {

    public static void main(String[] args) {
        NotificationService emailNotificationService = new EmailNotificationService(true);
        NotificationService smsNotificationService = new SmsNotificationService();

        emailNotificationService.sendNotification();

        smsNotificationService.sendNotification();
    }
}
