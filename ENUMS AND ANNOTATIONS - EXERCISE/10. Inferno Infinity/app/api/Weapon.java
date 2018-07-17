package app.api;

import app.enums.Gem;
import app.enums.WeaponType;
import app.impl.WeaponImpl;

public interface Weapon {

    int getMinDamage();

    int getMaxDamage();

    int getStrength();

    int getAgility();

    int getVitality();

    double getItemLevel();

    void addGem(String gemType, int socketIndex);

    void removeGem(int socketIndex);

    int compareTo(WeaponImpl o);

    String toString();

    String getName();

    void setName(String name);

    WeaponType getWeaponType();

    void setWeaponType(WeaponType weaponType);

    Gem[] getGems();

    void setGems(Gem[] gems);
}
