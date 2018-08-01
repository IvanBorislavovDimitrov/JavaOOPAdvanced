package src.p04_recharge.models;

import src.p04_recharge.models.interfaces.Rechargeable;

public class RechargeStation {

    public void recharge(Rechargeable rechargeable) {
        rechargeable.recharge();
    }
}
