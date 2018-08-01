package src.p05_security_system.models;

import src.p05_security_system.models.interfaces.SecurityUI;

import java.util.Scanner;

public class ScannerUI implements SecurityUI {

    private Scanner scanner;

    public ScannerUI() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String requestKeyCard() {
        System.out.println("slide your key card");
        return this.scanner.nextLine();
    }

    @Override
    public int requestPinCode() {
        System.out.println("enter your pin code");
        return Integer.parseInt(this.scanner.nextLine());
    }
}
