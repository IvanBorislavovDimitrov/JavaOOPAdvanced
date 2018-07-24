import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.api.Target;
import rpg_lab.api.Weapon;
import rpg_lab.impl.Hero;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class HeroTestWithoutMocking {

    private Target target;
    private Weapon weapon;

    @Before
    public void createFakeWeapon() {
        this.weapon = new Weapon() {
            private int durabilityPoints = 10;
            private int attackPoints = 10;

            public int getAttackPoints() {
                return this.attackPoints;
            }

            public int getDurabilityPoints() {
                return this.durabilityPoints;
            }

            public void attack(Target target) {
                if (this.durabilityPoints <= 0) {
                    throw new IllegalStateException("Axe is broken.");
                }

                target.takeAttack(this.attackPoints);
                this.durabilityPoints -= 1;
            }
        };
    }

    @Before
    public void createFakeTarget() {
        this.target = new Target() {
            private int health = 10;
            private int experience = 10;

            public int getHealth() {
                return this.health;
            }

            public void takeAttack(int attackPoints) {
                if (this.isDead()) {
                    throw new IllegalStateException("Dummy is dead.");
                }

                this.health -= attackPoints;
            }

            public int giveExperience() {
                if (!this.isDead()) {
                    throw new IllegalStateException("Target is not dead.");
                }

                return this.experience;
            }

            public boolean isDead() {
                return this.health <= 0;
            }

            @Override
            public Weapon getLoot() {
                return null;
            }
        };
    }

    @Test
    public void attackGainsExperienceIfTargetDie() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> heroClass = Class.forName("rpg_lab.impl.Hero");
        Hero hero = (Hero) heroClass.getDeclaredConstructor().newInstance();
        Field[] fields = heroClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType().equals(String.class)) {
                field.set(hero, "Hero");
            } else if (field.getType().equals(int.class)) {
                field.set(hero, 0);
            } else if (field.getType().equals(Weapon.class)) {
                field.set(hero, this.weapon);
            }
        }

        hero.attack(this.target);
        Assert.assertEquals("Wrong XP", 10, hero.getExperience());
    }


}
