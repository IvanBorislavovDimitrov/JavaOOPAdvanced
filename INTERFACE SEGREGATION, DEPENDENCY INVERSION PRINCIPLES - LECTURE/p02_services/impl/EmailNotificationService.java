package src.p02_services.impl;

import src.p02_services.api.NotificationService;

public class EmailNotificationService implements NotificationService {

    private boolean isActive;

    public EmailNotificationService(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public void sendNotification() {

    }

    public boolean isActive() {
        return this.isActive;
    }
}
