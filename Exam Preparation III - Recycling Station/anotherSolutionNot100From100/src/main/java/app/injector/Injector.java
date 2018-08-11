package app.injector;

import app.object_conatiner.Container;
import app.waste_disposal.annotations.Inject;

import java.lang.reflect.Field;

public class Injector {

    public static void inject(Container container, Object toBeInjected) throws IllegalAccessException {
        Field[] containerFields = container.getClass().getDeclaredFields();
        Field[] toBeInjectedFields = toBeInjected.getClass().getDeclaredFields();

        for (Field containerField : containerFields) {
            containerField.setAccessible(true);
            for (Field toBeInjectedField : toBeInjectedFields) {
                toBeInjectedField.setAccessible(true);
                if (toBeInjectedField.isAnnotationPresent(Inject.class) &&
                        containerField.getType().equals(toBeInjectedField.getType())) {

                    Object searchedContainerField = containerField.get(container);
                    toBeInjectedField.set(toBeInjected, searchedContainerField);
                }
            }
        }
    }
}
