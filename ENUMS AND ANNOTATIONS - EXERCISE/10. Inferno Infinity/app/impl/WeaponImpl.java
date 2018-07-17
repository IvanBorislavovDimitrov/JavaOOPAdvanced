package app.impl;

import app.annotations.CustomAnnotation;
import app.api.Weapon;
import app.enums.Gem;
import app.enums.WeaponType;

@CustomAnnotation(author = "Pesho", revision = 3, description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers = {"Pesho", "Svetlio"})
public class WeaponImpl implements Comparable<WeaponImpl>, Weapon {

    private String name;
    private WeaponType weaponType;
    private Gem[] gems;

    public WeaponImpl(String name, String weaponType) {
        this.name = name;
        this.weaponType = WeaponType.valueOf(weaponType);
        this.gems = new Gem[this.weaponType.getSockets()];
    }

    @Override
    public int getMinDamage() {
        int damage = this.weaponType.getMinDamage();
        damage += this.getStrength() * 2;
        damage += this.getAgility();
        return damage;
    }

    @Override
    public int getMaxDamage() {
        int damage = this.weaponType.getMaxDamage();
        damage += this.getStrength() * 3;
        damage += this.getAgility() * 4;
        return damage;
    }

    @Override
    public int getStrength() {
        int strength = 0;
        for (Gem gem : this.gems) {
            if (gem != null) {
                strength += gem.getStrength();
            }
        }
        return strength;
    }

    @Override
    public int getAgility() {
        int agility = 0;
        for (Gem gem : this.gems) {
            if (gem != null) {
                agility += gem.getAgility();
            }
        }
        return agility;
    }

    @Override
    public int getVitality() {
        int vitality = 0;
        for (Gem gem : this.gems) {
            if (gem != null) {
                vitality += gem.getVitality();
            }
        }
        return vitality;
    }

    @Override
    public double getItemLevel() {
        return (this.getMinDamage() + this.getMaxDamage()) / 2.0
                + this.getStrength() + this.getAgility() + this.getVitality();
    }

    @Override
    public void addGem(String gemType, int socketIndex) {
        if (socketIndex >= 0 && socketIndex < this.gems.length) {
            Gem gem = Gem.valueOf(gemType);
            this.gems[socketIndex] = gem;
        }
    }

    @Override
    public void removeGem(int socketIndex) {
        if (socketIndex >= 0 && socketIndex < this.gems.length) {
            this.gems[socketIndex] = null;
        }
    }

    @Override
    public int compareTo(WeaponImpl o) {
        return Double.compare(this.getItemLevel(), o.getItemLevel());
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality"
                , this.name, this.getMinDamage(), this.getMaxDamage(), this.getStrength()
                , this.getAgility(), this.getVitality());
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public WeaponType getWeaponType() {
        return this.weaponType;
    }

    @Override
    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public Gem[] getGems() {
        return this.gems;
    }

    @Override
    public void setGems(Gem[] gems) {
        this.gems = gems;
    }
}