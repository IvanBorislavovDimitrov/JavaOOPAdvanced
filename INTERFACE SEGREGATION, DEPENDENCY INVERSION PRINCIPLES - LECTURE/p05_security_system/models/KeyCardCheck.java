package src.p05_security_system.models;

import src.p05_security_system.models.interfaces.KeyCardCheckInterface;
import src.p05_security_system.models.interfaces.SecurityCheck;
import src.p05_security_system.models.interfaces.SecurityUI;

public class KeyCardCheck implements SecurityCheck {

    private KeyCardCheckInterface keyCardCheckInterface;

    public KeyCardCheck(SecurityUI keyCardCheckInterface) {
        this.keyCardCheckInterface = keyCardCheckInterface;
    }

    @Override
    public boolean validateUser() {
        String code = keyCardCheckInterface.requestKeyCard();

        return isValid(code);

    }

    private boolean isValid(String code) {
        return true;
    }
}
