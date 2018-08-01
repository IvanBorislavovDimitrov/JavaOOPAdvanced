package src.p02_services.online_store_order;

import src.p02_services.api.NotificationService;

public class OnlineStoreOrder {

    private NotificationService emailNotification;
    private NotificationService smsNotification;

    public OnlineStoreOrder(NotificationService emailNotificationService, NotificationService smsNotificationService) {
        this.emailNotification = emailNotificationService;
        this.smsNotification = smsNotificationService;
    }

    public void process() {
        if (this.smsNotification.isActive())
            this.smsNotification.sendNotification();

        if (this.emailNotification.isActive())
            this.smsNotification.sendNotification();
    }
}
