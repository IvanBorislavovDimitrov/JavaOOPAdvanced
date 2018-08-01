package src.p04_recharge.models;

import src.p04_recharge.models.interfaces.Rechargeable;

public class Robot extends Worker implements Rechargeable {

    private int capacity;
    private int currentPower;

    public Robot(String id, int capacity) {
        super(id);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentPower() {
        return currentPower;
    }

    public void setCurrentPower(int currentPower) {
        this.currentPower = currentPower;
    }

    @Override
    public void work(int hours) {
        if (hours > this.currentPower) {
            hours = currentPower;
        }

        super.work(hours);
        this.currentPower -= hours;
    }

    @Override
    public void recharge() {
        this.currentPower = this.capacity;
    }
}
