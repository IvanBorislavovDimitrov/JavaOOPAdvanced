package bg.factories;

import bg.contracts.Core;
import bg.contracts.Fragment;
import bg.softuni.models.enums.FragmentType;

import java.lang.reflect.InvocationTargetException;

public final class FragmentFactory {

    private FragmentFactory() {

    }

    public static Fragment create(String name, Integer pressureAffection, String type) {
        try {
            if (type.equalsIgnoreCase("Nuclear") || type.equalsIgnoreCase("Cooling")) {
                FragmentType fragmentType = FragmentType.valueOf(type);
                return (Fragment) Class.forName("bg.softuni.models.models.fragments." + type  + "Fragment").getDeclaredConstructor(String .class, Integer.class, FragmentType.class).newInstance(name, pressureAffection, fragmentType);
            }

            throw new IllegalArgumentException(String.format("Failed to attach Fragment %s!", name));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
            throw new IllegalArgumentException(String.format("Failed to attach Fragment %s!", name));
        }
    }
}
