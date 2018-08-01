package src.p05_security_system;

import src.p05_security_system.models.KeyCardCheck;
import src.p05_security_system.models.PinCodeCheck;
import src.p05_security_system.models.ScannerUI;
import src.p05_security_system.models.SecurityManager;
import src.p05_security_system.models.interfaces.SecurityCheck;
import src.p05_security_system.models.interfaces.SecurityUI;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        SecurityUI securityUI = new ScannerUI();
        SecurityCheck keyCardCheck = new KeyCardCheck(securityUI);
        SecurityCheck pinCodeCheck = new PinCodeCheck(securityUI);
        SecurityManager manager = new SecurityManager(keyCardCheck, pinCodeCheck);

        manager.check();
    }
}
