package app.factories;

import app.enums.WeaponType;

public final class WeaponFactory {

    private WeaponFactory() { }

    public static WeaponType createWeapon(String weaponType) {
        switch (weaponType) {
            case "AXE":
                return WeaponType.AXE;
            case "SWORD":
                return WeaponType.SWORD;
            case "KNIFE":
                return WeaponType.KNIFE;
        }

        return null;
    }
}
