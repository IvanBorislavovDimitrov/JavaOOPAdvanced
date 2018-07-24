import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.api.Target;
import rpg_lab.api.Weapon;
import rpg_lab.impl.Hero;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class HeroTestWithMocking {

    @Test
    public void attackGainsExperienceIfTargetDie() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target target = Mockito.mock(Target.class);
        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(20);

        Class<?> heroClass = Class.forName("rpg_lab.impl.Hero");
        Hero hero = (Hero) heroClass.getDeclaredConstructor().newInstance();
        Field[] fields = heroClass.getDeclaredFields();
        createHeroInstance(weaponMock, hero, fields);
        hero.attack(target);
        hero.getUnequippedWeapons().add(target.getLoot());

        Assert.assertEquals("Wrong XP", 20, hero.getExperience());
        Assert.assertEquals("Number of loot", 1, hero.getUnequippedWeapons().size());
    }

    @Test
    public void checkForUnequippedItemsCount() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target target = Mockito.mock(Target.class);
        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(20);

        Class<?> heroClass = Class.forName("rpg_lab.impl.Hero");
        Hero hero = (Hero) heroClass.getDeclaredConstructor().newInstance();
        Field[] fields = heroClass.getDeclaredFields();
        createHeroInstance(weaponMock, hero, fields);

        hero.attack(target);
        hero.getUnequippedWeapons().add(target.getLoot());

        Assert.assertEquals("Number of loot", 1, hero.getUnequippedWeapons().size());
    }

    private void createHeroInstance(Weapon weaponMock, Hero hero, Field[] fields) throws IllegalAccessException {
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType().equals(String.class)) {
                field.set(hero, "Hero");
            } else if (field.getType().equals(int.class)) {
                field.set(hero, 0);
            } else if (field.getType().equals(Weapon.class)) {
                field.set(hero, weaponMock);
            }
        }
    }
}
