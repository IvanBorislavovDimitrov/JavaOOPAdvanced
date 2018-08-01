package src.p05_security_system.models;

import src.p05_security_system.models.interfaces.PinCodeCheckInterface;
import src.p05_security_system.models.interfaces.SecurityCheck;
import src.p05_security_system.models.interfaces.SecurityUI;

public class PinCodeCheck implements SecurityCheck {

    private PinCodeCheckInterface pinCodeCheckInterface;

    public PinCodeCheck(SecurityUI pinCodeCheckInterface) {
        this.pinCodeCheckInterface = pinCodeCheckInterface;
    }

    @Override
    public boolean validateUser() {
        int pin = pinCodeCheckInterface.requestPinCode();

        return isValid(pin);

    }

    private boolean isValid(int pin) {
        return true;
    }
}
